package org.xpande.core.utils;

import org.compiere.model.I_M_PriceList;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.model.X_M_PriceList;

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

}
