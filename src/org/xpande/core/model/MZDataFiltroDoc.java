package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltroDoc extends X_Z_DataFiltroDoc{

    public MZDataFiltroDoc(Properties ctx, int Z_DataFiltroDoc_ID, String trxName) {
        super(ctx, Z_DataFiltroDoc_ID, trxName);
    }

    public MZDataFiltroDoc(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
