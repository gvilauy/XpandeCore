package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo de lineas de carga masiva de socios de negocio.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/23/20.
 */
public class MZLoadCoreBPFile extends X_Z_LoadCoreBPFile{

    public MZLoadCoreBPFile(Properties ctx, int Z_LoadCoreBPFile_ID, String trxName) {
        super(ctx, Z_LoadCoreBPFile_ID, trxName);
    }

    public MZLoadCoreBPFile(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
