package org.xpande.core.utils;

import org.compiere.model.*;

import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades de impuestos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/26/17.
 */
public final class TaxUtils {


    /***
     * Obtiene y retorna ultimo impuesto creado y asociado a una determinada categoria de impuesto recibido.
     * Xpande. Created by Gabriel Vila on 7/26/17.
     * @param ctx
     * @param cTaxCategoryID
     * @param trxName
     * @return
     */
    public static MTax getLastTaxByCategory(Properties ctx, int cTaxCategoryID, String trxName){

        String whereClause = X_C_Tax.COLUMNNAME_C_TaxCategory_ID + " =" + cTaxCategoryID;

        MTax model = new Query(ctx, I_C_Tax.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).setOrderBy(" Created Desc ").first();

        return model;
    }


    /***
     * Obtiene y retorna impuesto por defecto asociado a una determinada categoria de impuesto recibido.
     * Xpande. Created by Gabriel Vila on 4/22/19.
     * @param ctx
     * @param cTaxCategoryID
     * @param trxName
     * @return
     */
    public static MTax getDefaultTaxByCategory(Properties ctx, int cTaxCategoryID, String trxName){

        String whereClause = X_C_Tax.COLUMNNAME_C_TaxCategory_ID + " =" + cTaxCategoryID +
                " AND " + X_C_Tax.COLUMNNAME_IsDefault + " ='Y' ";

        MTax model = new Query(ctx, I_C_Tax.Table_Name, whereClause, trxName).setOnlyActiveRecords(true).setOrderBy(" Created Desc ").first();

        return model;
    }


    /***
     * Metodo para validar RUT de socio de negocio.
     * Xpande. Created by Gabriel Vila on 8/19/17.
     * @param rut
     * @return
     */
    public static boolean validateRUT(String rut){

        boolean value = true;

        try {

            // Obtengo pais para validacion (por defecto Uruguay = 336)
            int taxID_CountryValidator = MSysConfig.getIntValue("Z_TaxID_Country_Validation", 336);

            // Si debo validar para Ecuador
            if (taxID_CountryValidator == 171){
                return TaxUtilsEcuador.validateRUT(rut);
            }

            // Saco ultimo digito al RUT recibido
            String digitoVerificadorRUT = rut.substring(rut.length()-1);
            String rutAux = rut.substring(0, rut.length()-1);

            int[] digitos = new int[rutAux.length()];
            int factor = 2, suma = 0, modulo = 0, digitoVerificador = -1;

            int total = digitos.length-1;

            for (int i = total; i >= 0 ; i--) {
                digitos[i] = Integer.parseInt("" + rutAux.charAt(i));
                suma = suma + (digitos[i]*factor);
                factor = factor==9 ? 2 : (factor+1);
            }

            // Calculo el modulo 11 de la suma
            modulo = suma % 11;

            digitoVerificador = 11 - modulo;

            if(digitoVerificador == 11) digitoVerificador = 0;

            if(digitoVerificador == 10) digitoVerificador = 1;

            if (digitoVerificador != Integer.parseInt(digitoVerificadorRUT)){
                value = false;
            }

        }
        catch (Exception e) {
            value = false;
        }

        return value;
    }


    /***
     * Metodo para validar C.I. de socio de negocio.
     * @param ci
     * @return
     */
    public static boolean validateCI(String ci) {

        // Obtengo pais para validacion (por defecto Uruguay = 336)
        int taxID_CountryValidator = MSysConfig.getIntValue("Z_TaxID_Country_Validation", 336);

        // Si debo validar para Ecuador
        if (taxID_CountryValidator == 171){
            return TaxUtilsEcuador.validateCI(ci);
        }

        if(ci.length() != 7 && ci.length() != 8){
            return false;
        }else{
            try{
                Integer.parseInt(ci);
            }catch (NumberFormatException e){
                return false;
            }
        }

        int digVerificador = Integer.parseInt((ci.charAt(ci.length() - 1)) + "" ) ;
        int[] factores;
        if(ci.length() == 7){ // CI viejas
            factores = new int[]{9, 8, 7, 6, 3, 4};
        }else{
            factores = new int[]{2, 9, 8, 7, 6, 3, 4};
        }


        int suma = 0;
        for(int i=0; i<ci.length()-1; i++ ){
            int digito = Integer.parseInt(ci.charAt(i) + "" ) ;
            suma += digito * factores[ i ];
        }

        int resto = suma % 10;
        int checkdigit = 10 - resto;

        if(checkdigit == 10){
            return (digVerificador == 0);
        }else {
            return (checkdigit == digVerificador) ;
        }

    }

}
