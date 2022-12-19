package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.*;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades de listas de precio y versiones.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 6/15/17.
 */
public final class PriceListUtils {

    /***
     * Obtiene lista de precios para una determinada organización recibida.
     * Xpande. Created by Gabriel Vila on 7/21/17.
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param cCurrencyID
     * @param isSOPriceList
     * @param valueListaEspcial
     * @param trxName
     * @return
     */
    public static MPriceList getPriceListByOrg(Properties ctx, int adClientID, int adOrgID, int cCurrencyID, boolean isSOPriceList,
                                               String valueListaEspcial, String trxName) {

        String whereClause = X_M_PriceList.COLUMNNAME_AD_Client_ID + " =" + adClientID +
                " AND " + X_M_PriceList.COLUMNNAME_AD_Org_ID + " =" + adOrgID +
                " AND " + X_M_PriceList.COLUMNNAME_C_Currency_ID + " =" + cCurrencyID +
                " AND " + X_M_PriceList.COLUMNNAME_IsSOPriceList + " ='" + ((isSOPriceList) ? 'Y':'N') + "'";

        if ((valueListaEspcial != null) && (!valueListaEspcial.trim().equalsIgnoreCase(""))){
            whereClause += " AND " + X_M_PriceList.COLUMNNAME_M_PriceList_ID + " IN " +
                    " (select max(m_pricelist_id) as m_pricelist_id from z_comconfigplistesp " +
                    " where lower(value) ='" + valueListaEspcial.toLowerCase().trim() + "' and isactive='Y') ";
        }

        MPriceList model = new Query(ctx, I_M_PriceList.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).first();

        return model;
    }

    /***
     * Obtiene lista de precios para una determinada organización recibida.
     * Xpande. Created by Gabriel Vila on 2/16/21.
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param cCurrencyID
     * @param isSOPriceList
     * @param onlyActives
     * @param trxName
     * @return
     */
    public static MPriceList getPriceListByOrg(Properties ctx, int adClientID, int adOrgID, int cCurrencyID, boolean isSOPriceList,
                                               boolean onlyActives, String trxName) {

        String whereClause = X_M_PriceList.COLUMNNAME_AD_Client_ID + " =" + adClientID +
                " AND " + X_M_PriceList.COLUMNNAME_AD_Org_ID + " =" + adOrgID +
                " AND " + X_M_PriceList.COLUMNNAME_C_Currency_ID + " =" + cCurrencyID +
                " AND " + X_M_PriceList.COLUMNNAME_IsSOPriceList + " ='" + ((isSOPriceList) ? 'Y':'N') + "'";

        MPriceList model = new Query(ctx, I_M_PriceList.Table_Name, whereClause, trxName).setOnlyActiveRecords(onlyActives).first();

        return model;
    }

    /**
     * Obtiene y retorna versión de lista de precios que contiene a un determinado producto.
     * Tanane. Created by Gabriel Vila on 2022-12-01
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param mProductID
     * @param validFrom
     * @param isSOPriceList
     * @param trxName
     * @return
     */
    public static MPriceListVersion getPriceListVersion(Properties ctx, int adClientID, int adOrgID, int mProductID,
                                                        Timestamp validFrom, boolean isSOPriceList, String trxName) {

        MPriceListVersion plVersion = null;
        String sql;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            sql = " select pp.m_pricelist_version_id " +
                    " from m_productprice pp " +
                    " inner join m_pricelist_version plv on pp.m_pricelist_version_id = plv.m_pricelist_version_id " +
                    " inner join m_pricelist pl on plv.m_pricelist_id = pl.m_pricelist_id " +
                    " where pl.ad_client_id =" + adClientID +
                    " and pl.ad_org_id =" + adOrgID +
                    " and pl.issopricelist ='Y' " +
                    " and pl.isactive ='Y' " +
                    " and plv.validfrom <='" + validFrom + "' " +
                    " and plv.isactive='Y' " +
                    " and pp.m_product_id =" + mProductID +
                    " and pp.isactive ='Y' " +
                    " order by plv.validfrom desc ";

            pstmt = DB.prepareStatement(sql, trxName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                plVersion = new MPriceListVersion(ctx, rs.getInt("m_pricelist_version_id"), trxName);
            }
        }
        catch (Exception e) {
            throw new AdempiereException(e);
        }
        finally {
            DB.close(rs, pstmt);
            rs = null;
            pstmt = null;
        }
        return plVersion;
    }

    /**
     * Retorna precio convertido para producto según unidad de medida recibida.
     * Tanane. Created by Gabriel Vila on 2021-08-27
     * @param ctx
     * @param mProductID
     * @param cUomToID
     * @param qtyPrice
     * @param stdPrecision
     * @return
     */
    public static BigDecimal convertPriceFrom(Properties ctx, int mProductID, int cUomToID, BigDecimal qtyPrice, int stdPrecision) {
        //	No conversion
        if (qtyPrice == null || qtyPrice.compareTo(Env.ZERO)==0  || cUomToID == 0|| mProductID == 0)
        {
            return qtyPrice;
        }

        BigDecimal retValue = MUOMConversion.getProductRateFrom (ctx, mProductID, cUomToID);
        if (retValue != null)
        {
            if (Env.ONE.compareTo(retValue) == 0)
                return qtyPrice;
            MUOM uom = MUOM.get (ctx, cUomToID);
            if (uom != null)
                return retValue.multiply(qtyPrice).setScale(stdPrecision, RoundingMode.HALF_UP);
            return retValue.multiply(qtyPrice);
        }
        return null;
    }

}
