package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroTax extends X_Z_DataFiltroTax{

    public MZDataFiltroTax(Properties ctx, int Z_DataFiltroTax_ID, String trxName) {
        super(ctx, Z_DataFiltroTax_ID, trxName);
    }

    public MZDataFiltroTax(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
