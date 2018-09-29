package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;

/**
 * Clase de métodos staticos referidos a funcionalidades de secuencias.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/31/17.
 */
public final class SequenceUtils {

    /***
     * Obtiene siguiente secuencia para Secuenciales que no tienen Tabla asociada.
     * Xpande. Created by Gabriel Vila on 7/31/17.
     * @param trxName
     * @param sequenceName
     * @return
     */
    public static int getNextID_NoTable(String trxName, String sequenceName){

        int value = -1;
        String sql = "";

        try{

            sql = " select ad_sequence_id from ad_sequence where lower(name)='" + sequenceName.toLowerCase().trim() + "' ";
            int adSequenceID = DB.getSQLValueEx(null, sql);

            sql = " select nextid (" + adSequenceID + ", 'N') ";
            value = DB.getSQLValueEx(trxName, sql);

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return value;
    }

}
