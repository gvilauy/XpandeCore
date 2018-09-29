package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo para gestionar relaciones entre cabezales de documentos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 10/27/17.
 */
public class MZDocReference extends X_Z_DocReference {

    public MZDocReference(Properties ctx, int Z_DocReference_ID, String trxName) {
        super(ctx, Z_DocReference_ID, trxName);
    }

    public MZDocReference(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
