package org.xpande.core.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo para gestionar información de actividad de documentos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 10/30/17.
 */
public class MZActividadDocumento extends X_Z_ActividadDocumento {

    public MZActividadDocumento(Properties ctx, int Z_ActividadDocumento_ID, String trxName) {
        super(ctx, Z_ActividadDocumento_ID, trxName);
    }

    public MZActividadDocumento(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }

    /***
     * Obtiene y retorna modelo según tabla y registo.
     * Xpande. Created by Gabriel Vila on 10/30/17.
     * @param ctx
     * @param adTableID
     * @param recordID
     * @param trxName
     * @return
     */
    public static MZActividadDocumento getByTableRecord(Properties ctx, int adTableID, int recordID, String trxName){

        String whereClause = X_Z_ActividadDocumento.COLUMNNAME_AD_Table_ID + " =" + adTableID +
                " AND " + X_Z_ActividadDocumento.COLUMNNAME_Record_ID + " =" + recordID;

        MZActividadDocumento model = new Query(ctx, I_Z_ActividadDocumento.Table_Name, whereClause, trxName).first();

        return model;
    }
}
