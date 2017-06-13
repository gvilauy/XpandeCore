package org.xpande.core.model;

import org.compiere.model.*;
import org.compiere.util.DB;

/**
 * ModelValidator para funciones del Core.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 6/7/17.
 */
public class ValidatorCore implements ModelValidator {

    private int adClientID = 0;

    @Override
    public void initialize(ModelValidationEngine engine, MClient client) {

        // Guardo compañia
        if (client != null){
            this.adClientID = client.get_ID();
        }

        // DB Validations
        engine.addModelChange(I_M_Product.Table_Name, this);

    }

    @Override
    public int getAD_Client_ID() {
        return this.adClientID;
    }

    @Override
    public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
        return null;
    }

    @Override
    public String modelChange(PO po, int type) throws Exception {

        if (po.get_TableName().equalsIgnoreCase(I_M_Product.Table_Name)){
            return modelChange((MProduct) po, type);
        }

        return null;
    }

    @Override
    public String docValidate(PO po, int timing) {
        return null;
    }


    /***
     * Validaciones para el modelo de Producto.
     * @param model
     * @param type
     * @return
     * @throws Exception
     */
    public String modelChange(MProduct model, int type) throws Exception {

        String mensaje = null;
        String sql = "", whereClause = "";
        int contador = 0;

        if ((type == ModelValidator.TYPE_BEFORE_NEW) || (type == ModelValidator.TYPE_BEFORE_CHANGE)){

            // Valido codigo único de producto
            if (model.get_ID() > 0){
                whereClause = " and m_product_id !=" + model.get_ID();
            }

            sql = " select count(*) from m_product where lower(value) ='" + model.getValue().trim().toLowerCase() + "' " + whereClause;
            contador = DB.getSQLValueEx(model.get_TrxName(), sql);
            if (contador > 0){
                return "Ya existe un producto definido en el sistema con este código";
            }

            // Codigo de barra sin espacios al final
            model.setValue(model.getValue().trim());

            // Me aseguro nombre y descripcion de producto en mayúsculas
            if (model.getName() != null){
                model.setName(model.getName().toUpperCase().trim());
            }

            if (model.getDescription() != null){
                model.setDescription(model.getDescription().toUpperCase().trim());
            }
        }

        return mensaje;

    }

}
