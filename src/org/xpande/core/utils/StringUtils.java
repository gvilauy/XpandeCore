package org.xpande.core.utils;

/**
 * Clase de métodos staticos referidos a utilidades varias para documento.s
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/4/17.
 */
public final class StringUtils {

    /***
     * Verifica que un determinado string recibido, tenga solo letras.
     * @param token
     * @return
     */
    public static boolean cadenaSoloLetras(String token){

        if ((token == null) || (token.trim().equalsIgnoreCase(""))){
            return false;
        }

        for(int i = 0; i <= token.length()-1; i++){
            char pos = token.charAt(i);
            if(!Character.isLetter(pos)){
                return false;
            }
        }

        return true;
    }

}
