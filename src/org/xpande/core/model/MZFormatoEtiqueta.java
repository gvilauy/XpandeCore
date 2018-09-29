package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo de formato de etiqueta.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/12/17.
 */
public class MZFormatoEtiqueta extends X_Z_FormatoEtiqueta {

    public MZFormatoEtiqueta(Properties ctx, int Z_FormatoEtiqueta_ID, String trxName) {
        super(ctx, Z_FormatoEtiqueta_ID, trxName);
    }

    public MZFormatoEtiqueta(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
