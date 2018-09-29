package org.xpande.core.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * Modelo para asociar una lista de precios a un socio de negocio.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 6/14/17.
 */
public class MZSocioListaPrecio extends X_Z_SocioListaPrecio {

    public MZSocioListaPrecio(Properties ctx, int Z_SocioListaPrecio_ID, String trxName) {
        super(ctx, Z_SocioListaPrecio_ID, trxName);
    }

    public MZSocioListaPrecio(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }


    /***
     * Obtiene y retorna modelo segun id de cliente y id de moneda recibidos.
     * Xpande. Created by Gabriel Vila on 6/14/17.
     * @param ctx
     * @param cBPartnerID
     * @param cCurrencyID
     * @param trxName
     * @return
     */
    public static MZSocioListaPrecio getByPartnerCurrency(Properties ctx, int cBPartnerID, int cCurrencyID, String trxName){

        String whereClause = X_Z_SocioListaPrecio.COLUMNNAME_C_BPartner_ID + " =" + cBPartnerID +
                " AND " + X_Z_SocioListaPrecio.COLUMNNAME_C_Currency_ID + " =" + cCurrencyID;

        MZSocioListaPrecio model = new Query(ctx, I_Z_SocioListaPrecio.Table_Name, whereClause, trxName).first();

        return model;

    }

    /***
     * Obtiene y retorna lista de modelos para un determinado socio de negocio recibido.
     * Xpande. Created by Gabriel Vila on 6/26/17.
     * @param ctx
     * @param cBPartnerID
     * @param trxName
     * @return
     */
    public static List<MZSocioListaPrecio> getByPartner(Properties ctx, int cBPartnerID, String trxName){

        String whereClause = X_Z_SocioListaPrecio.COLUMNNAME_C_BPartner_ID + " =" + cBPartnerID;

        List<MZSocioListaPrecio> lines = new Query(ctx, I_Z_SocioListaPrecio.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).list();

        return lines;

    }
}
