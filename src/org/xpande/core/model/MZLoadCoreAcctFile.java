package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo de linea para carga de plan de cuentas.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 9/19/20.
 */
public class MZLoadCoreAcctFile extends X_Z_LoadCoreAcctFile {

    public MZLoadCoreAcctFile(Properties ctx, int Z_LoadCoreAcctFile_ID, String trxName) {
        super(ctx, Z_LoadCoreAcctFile_ID, trxName);
    }

    public MZLoadCoreAcctFile(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
