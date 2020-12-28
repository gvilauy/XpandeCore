package org.xpande.core.utils;

import org.compiere.util.Env;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 8/16/17.
 */
public class NumberToString {

    int counter=0;
    String value="";

    public String getStringOfBigDecimal(BigDecimal amount){

        String value ="";

        int parteEntera = amount.intValue();

        value = this.getStringOfNumber(parteEntera);

        BigDecimal fraccion = amount.subtract(new BigDecimal(parteEntera)).setScale(2, RoundingMode.HALF_UP);

        String strFrac = "";
        if (fraccion.compareTo(Env.ZERO) != 0){
            strFrac = fraccion.toString().trim();
            int pos = strFrac.indexOf(".");
            if (pos > 0){
                strFrac = strFrac.substring(pos+1);
            }

            value = value + " con " + strFrac + "/100";
        }

        return value;
    }

    public String getStringOfNumber(int num){

        this.counter = num;

        String result = this.convertir(num);

        // Si el numero termina en 1, debo poner el liter UNO en vez del literal UN
        String numero = String.valueOf(num);
        if ((!numero.endsWith("11")) && (!numero.endsWith("111")) && (!numero.endsWith("1111"))){
            if (numero.endsWith("1")){
                result = result.substring(0, result.length() - 2) + "UNO";
            }
        }
        return result;
    }

    private String convertir(int _counter){

        if(_counter >99999999)
            return "CIEN MILLONES";

        switch(_counter){
            case 0: return "CERO";
            case 1: return "UN"; //UNO
            case 2: return "DOS";
            case 3: return "TRES";
            case 4: return "CUATRO";
            case 5: return "CINCO";
            case 6: return "SEIS";
            case 7: return "SIETE";
            case 8: return "OCHO";
            case 9: return "NUEVE";
            case 10: return "DIEZ";
            case 11: return "ONCE";
            case 12: return "DOCE";
            case 13: return "TRECE";
            case 14: return "CATORCE";
            case 15: return "QUINCE";
            case 20: return "VEINTE";
            case 30: return "TREINTA";
            case 40: return "CUARENTA";
            case 50: return "CINCUENTA";
            case 60: return "SESENTA";
            case 70: return "SETENTA";
            case 80: return "OCHENTA";
            case 90: return "NOVENTA";
            case 100: return "CIEN";
            case 200: return "DOSCIENTOS";
            case 300: return "TRESCIENTOS";
            case 400: return "CUATROCIENTOS";
            case 500: return "QUINIENTOS";
            case 600: return "SEISCIENTOS";
            case 700: return "SETECIENTOS";
            case 800: return "OCHOCIENTOS";
            case 900: return "NOVECIENTOS";
            case 1000: return "MIL";
            case 1000000: return "UN MILLON";
        }
        if(_counter<20){
            return "DIECI"+ convertir(_counter-10);
        }
        if(_counter<30){
            return "VEINTI" + convertir(_counter-20);
        }
        if(_counter<100){
            return convertir( (int)(_counter/10)*10 ) + " Y " + convertir(_counter%10);
        }
        if(_counter<200){
            return "CIENTO " + convertir( _counter - 100 );
        }
        if(_counter<1000){
            return convertir( (int)(_counter/100)*100 ) + " " + convertir(_counter%100);
        }
        if(_counter<2000){
            return "MIL " + convertir( _counter % 1000 );
        }
        if(_counter<1000000){
            String var="";
            var = convertir((int)(_counter/1000)) + " MIL" ;
            if(_counter % 1000!=0){
                var += " " + convertir(_counter % 1000);
            }
            return var;
        }
        if(_counter<2000000){
            return "UN MILLON " + convertir( _counter % 1000000 );
        }
        if(_counter >= 2000000 && _counter<100000000){
            String var="";
            var = convertir((int)(_counter/1000000)) + " MILLONES" ;
            if(_counter % 1000000!=0){
                var += " " + convertir(_counter % 1000000);
            }
            return var;
        }
        return "";
    }

}
