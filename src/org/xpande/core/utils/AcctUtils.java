package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MClient;
import org.compiere.model.X_Fact_Acct;
import org.compiere.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades contables para Retail.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 8/28/18.
 */
public final class AcctUtils {

    /***
     * Elimina un asiento contable.
     * Xpande. Created by Gabriel Vila on 11/14/18
     * @param adTableID
     * @param recordID
     * @param trxName
     */
    public static void deleteFact(int adTableID, int recordID, String trxName){

        String action = "";

        try{

            action = " DELETE FROM " + X_Fact_Acct.Table_Name +
                     " WHERE " + X_Fact_Acct.COLUMNNAME_AD_Table_ID + "=" + adTableID +
                     " AND " + X_Fact_Acct.COLUMNNAME_Record_ID + "=" + recordID;
            DB.executeUpdateEx(action, trxName);

        }
        catch (Exception e) {
            throw new AdempiereException(e);
        }
    }

}
