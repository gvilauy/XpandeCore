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

    public static MPriceList getPriceListByOrg(Properties ctx, int adClientID, int adOrgID, int cCurrencyID, boolean isSOPriceList, String trxName) {

        String whereClause = X_M_PriceList.COLUMNNAME_AD_Client_ID + " =" + adClientID +
                " AND " + X_M_PriceList.COLUMNNAME_AD_Org_ID + " =" + adOrgID +
                " AND " + X_M_PriceList.COLUMNNAME_C_Currency_ID + " =" + cCurrencyID +
                " AND " + X_M_PriceList.COLUMNNAME_IsSOPriceList + " ='" + ((isSOPriceList) ? 'Y':'N') + "'";

        MPriceList model = new Query(ctx, I_M_PriceList.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).first();

        return model;
    }

}
