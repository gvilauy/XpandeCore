package org.xpande.core.utils;

import org.compiere.util.Env;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

    /***
     * Formatea numero recibido según separadores decimales y de miles recibidos.
     * Xpande. Created by Gabriel Vila on 7/12/17.
     * @param value
     * @param pattern
     * @param decimalSeparator
     * @param groupingSeparator
     * @return
     */
    public static String formatSeparators(BigDecimal value, String pattern, String decimalSeparator, String groupingSeparator) {

        if(value == null) value = Env.ZERO;

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator(decimalSeparator.charAt(0));
        otherSymbols.setGroupingSeparator(groupingSeparator.charAt(0));
        DecimalFormat df = new DecimalFormat(pattern, otherSymbols);

        return df.format(value);

    }

}
