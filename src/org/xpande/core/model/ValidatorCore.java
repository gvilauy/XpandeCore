package org.xpande.core.model;

import org.compiere.model.*;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxGroup;
import org.xpande.core.utils.TaxUtils;

import java.math.BigDecimal;

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
        //engine.addModelChange(I_C_Conversion_Rate.Table_Name, this);
        engine.addModelChange(I_C_BPartner.Table_Name, this);

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
        /*
        else if (po.get_TableName().equalsIgnoreCase(I_C_Conversion_Rate.Table_Name)){
            return modelChange((MConversionRate) po, type);
        }
        */
        else if (po.get_TableName().equalsIgnoreCase(I_C_BPartner.Table_Name)){
            return modelChange((MBPartner) po, type);
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

            if (model.getValue() != null){
                sql = " select count(*) from m_product where lower(value) ='" + model.getValue().trim().toLowerCase() + "' " + whereClause;
                contador = DB.getSQLValueEx(model.get_TrxName(), sql);
                if (contador > 0){
                    return "Ya existe un producto definido en el sistema con este código";
                }

                // Codigo interno sin espacios al final
                model.setValue(model.getValue().trim());
            }

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


    /***
     * Validaciones para el modelo de Socio de Negocio.
     * Xpande. Created by Gabriel Vila on 8/19/17.
     * @param model
     * @param type
     * @return
     * @throws Exception
     */
    public String modelChange(MBPartner model, int type) throws Exception {

        String mensaje = null;
        String sql = "", whereClause = "";
        int contador = 0;

        if ((type == ModelValidator.TYPE_BEFORE_NEW) || (type == ModelValidator.TYPE_BEFORE_CHANGE)){

            // Valido codigo único de socio de negocio
            if (model.get_ID() > 0){
                whereClause = " and c_bpartner_id !=" + model.get_ID();
            }

            if (model.getValue() != null){
                sql = " select count(*) from c_bpartner where lower(value) ='" + model.getValue().trim().toLowerCase() + "' " + whereClause;
                contador = DB.getSQLValueEx(model.get_TrxName(), sql);
                if (contador > 0){
                    return "Ya existe un Socio de Negocio definido en el sistema con este código";
                }

                // Codigo interno sin espacios al final
                model.setValue(model.getValue().trim());
            }

            // Me aseguro razón social y nombre fantasía de socio de negocio en mayúsculas
            if (model.getName() != null){
                model.setName(model.getName().toUpperCase().trim());
            }

            if (model.getName2() != null){
                model.setName2(model.getName2().toUpperCase().trim());
            }

            // Validaciones de numero de identificación
            if (model.getTaxID() != null){
               model.setTaxID(model.getTaxID().trim());
               if (!model.getTaxID().equalsIgnoreCase("")){

                   // Valido Número de identificación único
                   sql = " select count(*) from c_bpartner where lower(taxid) ='" + model.getTaxID().toLowerCase() + "' " + whereClause;
                   contador = DB.getSQLValueEx(model.get_TrxName(), sql);
                   if (contador > 0){
                       return "Ya existe un Socio de Negocio definido en el sistema con este Número de Identificación";
                   }

                   // Valido RUT o C.I.
                   if (model.getC_TaxGroup_ID() > 0){
                       X_C_TaxGroup taxGroup = (X_C_TaxGroup) model.getC_TaxGroup();
                       if (taxGroup.getValue().equalsIgnoreCase("RUT")){
                           if (!TaxUtils.validateRUT(model.getTaxID())){
                               return "El RUT ingresado NO es válido, no cumple con los requisitos de DGI.";
                           }
                       }
                       else if (taxGroup.getValue().equalsIgnoreCase("CI")){
                           if (!TaxUtils.validateCI(model.getTaxID())){
                               return "La Cédula de Identidad ingresada NO es válida.";
                           }
                       }

                   }
               }
            }
        }

        return mensaje;

    }


    /***
     * Validaciones para el modelo de tasas de cambio.
     * @param model
     * @param type
     * @return
     * @throws Exception
     */
    public String modelChange(MConversionRate model, int type) throws Exception {

        String mensaje = null;

        /*
        if (type == ModelValidator.TYPE_AFTER_NEW){

            if (!model.get_ValueAsBoolean("IsManualRecord")) return mensaje;

            // Inserto nuevo registro de tasa con la conversión inversa a la ingresada.
            // Esto se debe a que ADempiere requiere cargar tasa en ambos sentidos.
            MConversionRate conversionRate = new MConversionRate(model.getCtx(), 0, model.get_TrxName());
            conversionRate.setAD_Org_ID(model.getAD_Org_ID());
            conversionRate.setC_Currency_ID(model.getC_Currency_ID_To());
            conversionRate.setC_Currency_ID_To(model.getC_Currency_ID());
            conversionRate.setValidFrom(model.getValidFrom());
            conversionRate.setValidTo(model.getValidTo());
            conversionRate.setMultiplyRate(model.getDivideRate());
            conversionRate.setDivideRate(model.getMultiplyRate());
            conversionRate.setC_ConversionType_ID(model.getC_ConversionType_ID());
            conversionRate.set_ValueOfColumn("IsManualRecord", false);
            conversionRate.saveEx();

            // Como el metodo MConversionRate.setMultiplyRate() tiene cuentas y deja una precision grande en el numero,
            // Tengo que actualizarlo por base de datos
            String action = " update c_conversion_rate set multiplyrate =" + model.getDivideRate() +
                    " where c_conversion_rate_id =" + conversionRate.get_ID();
            DB.executeUpdateEx(action, model.get_TrxName());
        }
        else if (type == ModelValidator.TYPE_AFTER_CHANGE){

            if (!model.get_ValueAsBoolean("IsManualRecord")) return mensaje;

            // Me aseguro que la tasa inversa también se actualice
            String whereClause = X_C_Conversion_Rate.COLUMNNAME_AD_Client_ID + " =" + model.getAD_Client_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_AD_Org_ID + " =" + model.getAD_Org_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_Currency_ID + " =" + model.getC_Currency_ID_To() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_Currency_ID_To + " =" + model.getC_Currency_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_ValidFrom + " ='" + model.getValidFrom() + "'" +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_ValidTo + " ='" + model.getValidTo() + "'" +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_ConversionType_ID + " =" + model.getC_ConversionType_ID();

            int[] ratesID = MConversionRate.getAllIDs(I_C_Conversion_Rate.Table_Name, whereClause, model.get_TrxName());
            if (ratesID.length > 0){
                MConversionRate conversionRate = new MConversionRate(model.getCtx(), ratesID[0], model.get_TrxName());
                conversionRate.setMultiplyRate(model.getDivideRate());
                conversionRate.setDivideRate(model.getMultiplyRate());
                conversionRate.saveEx();

                // Como el metodo MConversionRate.setMultiplyRate() tiene cuentas y deja una precision grande en el numero,
                // Tengo que actualizarlo por base de datos
                String action = " update c_conversion_rate set multiplyrate =" + model.getDivideRate() +
                        " where c_conversion_rate_id =" + conversionRate.get_ID();
                DB.executeUpdateEx(action, model.get_TrxName());

            }
        }
        else if (type == ModelValidator.TYPE_AFTER_DELETE){

            if (!model.get_ValueAsBoolean("IsManualRecord")) return mensaje;

            // Me aseguro que la tasa inversa también se actualice
            String whereClause = X_C_Conversion_Rate.COLUMNNAME_AD_Client_ID + " =" + model.getAD_Client_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_AD_Org_ID + " =" + model.getAD_Org_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_Currency_ID + " =" + model.getC_Currency_ID_To() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_Currency_ID_To + " =" + model.getC_Currency_ID() +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_ValidFrom + " ='" + model.getValidFrom() + "'" +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_ValidTo + " ='" + model.getValidTo() + "'" +
                    " AND " + X_C_Conversion_Rate.COLUMNNAME_C_ConversionType_ID + " =" + model.getC_ConversionType_ID();

            int[] ratesID = MConversionRate.getAllIDs(I_C_Conversion_Rate.Table_Name, whereClause, model.get_TrxName());
            if (ratesID.length > 0){
                MConversionRate conversionRate = new MConversionRate(model.getCtx(), ratesID[0], model.get_TrxName());
                conversionRate.deleteEx(true);
            }
        }

        */

        return mensaje;

    }

}
