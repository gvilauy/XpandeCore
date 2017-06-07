package org.xpande.core.model;

import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.Msg;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo para codigos de barra asociados a productos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 6/7/17.
 */
public class MZProductoUPC extends X_Z_ProductoUPC {

    public MZProductoUPC(Properties ctx, int Z_ProductoUPC_ID, String trxName) {
        super(ctx, Z_ProductoUPC_ID, trxName);
    }

    public MZProductoUPC(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }

    @Override
    protected boolean beforeSave(boolean newRecord) {

        // Valido que no haya codigos de barras duplicados
        MZProductoUPC pupc = MZProductoUPC.getByUPC(this.getCtx(), this.getUPC(), null);
        if ((pupc != null) && (pupc.get_ID() != this.get_ID())){
            MProduct prod = (MProduct)pupc.getM_Product();
            log.saveError("Error", "El Código de Barras ingresado ya existe asociado al producto: " +
                    prod.getValue() + " - " + prod.getName());
            return false;
        }

        return true;
    }


    /***
     * Obtiene y retorna modelo segun codigo de barras recibido.
     * Xpande. Created by Gabriel Vila on 6/7/17.
     * @param ctx
     * @param upc
     * @param trxName
     * @return
     */
    public static MZProductoUPC getByUPC(Properties ctx, String upc, String trxName){

        String whereClause = X_Z_ProductoUPC.COLUMNNAME_UPC + "='" + upc + "'";

        MZProductoUPC model = new Query(ctx, I_Z_ProductoUPC.Table_Name, whereClause, trxName).first();

        return model;
    }

}
