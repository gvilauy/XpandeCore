package org.xpande.core.utils;

import org.compiere.model.I_C_Tax;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.model.X_C_Tax;

import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades de impuestos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/26/17.
 */
public final class TaxUtils {


    /***
     * Obtiene y retorna ultimo impuesto creado y asociado a una determinada categoria de impuesto recibido.
     * Xpande. Created by Gabriel Vila on 7/26/17.
     * @param ctx
     * @param cTaxCategoryID
     * @param trxName
     * @return
     */
    public static MTax getLastTaxByCategory(Properties ctx, int cTaxCategoryID, String trxName){

        String whereClause = X_C_Tax.COLUMNNAME_C_TaxCategory_ID + " =" + cTaxCategoryID;

        MTax model = new Query(ctx, I_C_Tax.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).setOrderBy(" Created Desc ").first();

        return model;
    }
}
