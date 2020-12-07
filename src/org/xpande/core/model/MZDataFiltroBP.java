package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroBP extends X_Z_DataFiltroBP{

    public MZDataFiltroBP(Properties ctx, int Z_DataFiltroBP_ID, String trxName) {
        super(ctx, Z_DataFiltroBP_ID, trxName);
    }

    public MZDataFiltroBP(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
