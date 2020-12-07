package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroAcct extends X_Z_DataFiltroAcct{

    public MZDataFiltroAcct(Properties ctx, int Z_DataFiltroAcct_ID, String trxName) {
        super(ctx, Z_DataFiltroAcct_ID, trxName);
    }

    public MZDataFiltroAcct(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
