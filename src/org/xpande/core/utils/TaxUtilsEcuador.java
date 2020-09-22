package org.xpande.core.utils;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Clase de métodos staticos referidos a funcionalidades de impuestos para Ecuador.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 9/21/20.
 */
public final class TaxUtilsEcuador {

    /***
     * Metodo para validar RUT de socio de negocio.
     * Xpande. Created by Gabriel Vila on 8/19/17.
     * @param rut
     * @return
     */
    public static boolean validateRUT(String rut){

        try {
            if ((rut == null) || (rut.trim().equalsIgnoreCase(""))){
                return false;
            }
            if (!NumberUtils.isDigits(rut)) {
                return false;
            }
            if (rut.length() != 13) {
                return false;
            }

            // Valida codigo provincia
            String codProvincia = rut.substring(0, 2);
            if (Integer.parseInt(codProvincia) < 0 || Integer.parseInt(codProvincia) > 24) {
                return false;
            }

            // Valida tercer digito
            String tercerDigito = String.valueOf(rut.charAt(2));
            if (Integer.parseInt(tercerDigito) != 9) {
                return false;
            }

            // Valida codigo de establecimiento
            String codEstablecimiento = rut.substring(10, 13);
            if (Integer.parseInt(codEstablecimiento) < 1) {
                return false;
            }

            // Algoritmo modulo 11
            String digitosIniciales = rut.substring(0, 9);
            int digitoVerificador = Integer.parseInt(String.valueOf(rut.charAt(9)));
            Integer [] arrayCoeficientes = new Integer[]{4, 3, 2, 7, 6, 5, 4, 3, 2};
            Integer [] digitosInicialesTMP = new Integer[digitosIniciales.length()];
            int indice=0;
            for(char valorPosicion: digitosIniciales.toCharArray()){
                digitosInicialesTMP[indice] = NumberUtils.createInteger(String.valueOf(valorPosicion));
                indice++;
            }
            int total = 0;
            int key = 0;
            for(Integer valorPosicion: digitosInicialesTMP){
                if(key<arrayCoeficientes.length){
                    valorPosicion = (digitosInicialesTMP[key] * arrayCoeficientes[key] );

                    if (valorPosicion >= 10) {
                        char[] valorPosicionSplit = String.valueOf(valorPosicion).toCharArray();
                        valorPosicion = (Integer.parseInt(String.valueOf(valorPosicionSplit[0]))) + (Integer.parseInt(String.valueOf(valorPosicionSplit[1])));
                        System.out.println(valorPosicion);
                    }
                    total = total + valorPosicion;
                }

                key++;
            }

            int residuo =  total % 11;
            int resultado;

            if (residuo == 0) {
                resultado = 0;
            } else {
                resultado = (11 - residuo);
            }

            if (resultado != digitoVerificador) {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }


    /***
     * Metodo para validar C.I. de socio de negocio.
     * @param ci
     * @return
     */
    public static boolean validateCI(String ci) {

        try {
            if ((ci == null) || (ci.trim().equalsIgnoreCase(""))){
                return false;
            }
            if (!NumberUtils.isDigits(ci)) {
                return false;
            }
            if (ci.length() != 10) {
                return false;
            }

            // Valida codigo provincia
            String codProvincia = ci.substring(0, 2);
            if (Integer.parseInt(codProvincia) < 0 || Integer.parseInt(codProvincia) > 24) {
                return false;
            }

            // Valida tercer digito
            String tercerDigito = String.valueOf(ci.charAt(2));
            if (Integer.parseInt(tercerDigito) != 9) {
                return false;
            }

            // Algoritmo modulo 10
            String digitosIniciales = ci;
            int digitoVerificador = Integer.parseInt(String.valueOf(ci.charAt(9)));
            Integer [] arrayCoeficientes = new Integer[]{2,1,2,1,2,1,2,1,2};

            Integer [] digitosInicialesTMP = new Integer[digitosIniciales.length()];
            int indice=0;
            for(char valorPosicion: digitosIniciales.toCharArray()){
                digitosInicialesTMP[indice] = NumberUtils.createInteger(String.valueOf(valorPosicion));
                indice++;
            }

            int total = 0;
            int key = 0;
            for(Integer valorPosicion: digitosInicialesTMP){
                if(key<arrayCoeficientes.length){
                    valorPosicion = (digitosInicialesTMP[key] * arrayCoeficientes[key] );

                    if (valorPosicion >= 10) {
                        char[] valorPosicionSplit = String.valueOf(valorPosicion).toCharArray();
                        valorPosicion = (Integer.parseInt(String.valueOf(valorPosicionSplit[0]))) + (Integer.parseInt(String.valueOf(valorPosicionSplit[1])));

                    }
                    total = total + valorPosicion;
                }

                key++;
            }
            int residuo =  total % 10;
            int resultado ;

            if (residuo == 0) {
                resultado = 0;
            } else {
                resultado = 10 - residuo;
            }

            if (resultado != digitoVerificador) {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

}
