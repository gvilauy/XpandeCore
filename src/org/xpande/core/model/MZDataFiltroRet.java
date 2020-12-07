package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroRet extends X_Z_DataFiltroRet{

    public MZDataFiltroRet(Properties ctx, int Z_DataFiltroRet_ID, String trxName) {
        super(ctx, Z_DataFiltroRet_ID, trxName);
    }

    public MZDataFiltroRet(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
