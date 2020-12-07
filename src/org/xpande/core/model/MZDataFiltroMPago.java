package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroMPago extends X_Z_DataFiltroMPago{

    public MZDataFiltroMPago(Properties ctx, int Z_DataFiltroMPago_ID, String trxName) {
        super(ctx, Z_DataFiltroMPago_ID, trxName);
    }

    public MZDataFiltroMPago(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
