package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroProd extends X_Z_DataFiltroProd{

    public MZDataFiltroProd(Properties ctx, int Z_DataFiltroProd_ID, String trxName) {
        super(ctx, Z_DataFiltroProd_ID, trxName);
    }

    public MZDataFiltroProd(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
