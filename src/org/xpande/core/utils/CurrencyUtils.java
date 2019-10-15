package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.*;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades de monedas y tasas de cambio.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 8/2/17.
 */
public final class CurrencyUtils {


    /***
     * Obtiene y retorna tasa de cambio en moneda del esquema contable si es recibida por parametro.
     * Xpande. Created by Gabriel Vila on 8/2/17.
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param cCurrencyFrom
     * @param cCurrencyTo
     * @param convertType
     * @param dateRate
     * @param trxName
     * @return
     */
    public static BigDecimal getCurrencyRateToAcctSchemaCurrency(Properties ctx, int adClientID, int adOrgID, int cCurrencyFrom, int cCurrencyTo,
                                                   int convertType, Timestamp dateRate, String trxName){

        BigDecimal currencyRate = null;

        try{

            MAcctSchema schema = MClient.get(ctx, adClientID).getAcctSchema();

            // Si moneda en la cual desplegar tasa es la misma del schema.
            if (schema.getC_Currency_ID() == cCurrencyTo){
                currencyRate = MConversionRate.getRate(cCurrencyFrom, cCurrencyTo, dateRate, convertType, adClientID, adOrgID);
            }
            else{
                // Sino la doy vuelta.
                currencyRate = MConversionRate.getRate(cCurrencyTo, cCurrencyFrom, dateRate, convertType, adClientID, adOrgID);
            }
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return currencyRate;
    }

    /**
     * Obtiene tasa de cambio multiplicadora desde una moneda hacia Unidades Indexadas en determinada fecha recibida.
     * Xpande. Created by Gabriel Vila on 8/2/17.
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param cCurrencyFrom
     * @param convertType
     * @param dateRate
     * @param trxName
     * @return
     */
    public static BigDecimal getMultiplyRateToUnidadIndexada(Properties ctx, int adClientID, int adOrgID, int cCurrencyFrom, int convertType, Timestamp dateRate, String trxName){

        BigDecimal multiplyRate = null;

        try{

            MCurrency currency = MCurrency.get(ctx, "UNI");
            if ((currency == null) || (currency.get_ID() <= 0)){
                throw new AdempiereException("No se encuentra definida la moneda: Unidad Indexada");
            }

            multiplyRate = MConversionRate.getRate(cCurrencyFrom, currency.get_ID(), dateRate, convertType, adClientID, adOrgID);
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return multiplyRate;
    }


    /***
     * Obtiene tasa de cambio multiplicadora entre dos monedas. Si ninguna de las monedas recibidas es igual a la moneda
     * de la compañia recibida, se calcula una tasa de cambio arbitraje.
     * Xpande. Created by Gabriel Vila on 1/26/18.
     * @param ctx
     * @param adClientID
     * @param adOrgID
     * @param cCurrencyFrom
     * @param cCurrencyTo
     * @param convertType
     * @param dateRate
     * @param trxName
     * @return
     */
    public static BigDecimal getCurrencyRate(Properties ctx, int adClientID, int adOrgID, int cCurrencyFrom, int cCurrencyTo,
                                             int convertType, Timestamp dateRate, String trxName){

        BigDecimal currencyRate = null;

        try{

            // Si ambas monedas son iguales, la tasa de cambio es uno.
            if (cCurrencyFrom == cCurrencyTo) return Env.ONE;

            MAcctSchema schema = MClient.get(ctx, adClientID).getAcctSchema();

            // Si alguna de las monedas recibidas es igual a la moneda de la compañia
            if ((cCurrencyFrom == schema.getC_Currency_ID()) || (cCurrencyTo == schema.getC_Currency_ID())){
                // Retorno tasa de cambio según calculo para moneda de la compañia.
                return CurrencyUtils.getCurrencyRateToAcctSchemaCurrency(ctx, adClientID, adOrgID, cCurrencyFrom, cCurrencyTo, convertType, dateRate, trxName);
            }

            // Ambas monedas son distintas a la moneda de la compañia, tengo que obtener un arbitraje de conversión desde moneda origen a moneda destino.

            // Obtengo tasa de cambio desde moneda origen a moneda de la compañia
            BigDecimal rateFrom = CurrencyUtils.getCurrencyRateToAcctSchemaCurrency(ctx, adClientID, adOrgID, cCurrencyFrom, schema.getC_Currency_ID(), convertType, dateRate, trxName);

            // Obtengo tasa de cambio desde moneda destino a moneda de la compañia
            BigDecimal rateTo = CurrencyUtils.getCurrencyRateToAcctSchemaCurrency(ctx, adClientID, adOrgID, cCurrencyTo, schema.getC_Currency_ID(), convertType, dateRate, trxName);

            if (rateTo == null) rateTo = Env.ZERO;
            if (rateFrom == null) rateFrom = Env.ZERO;

            if (rateFrom.compareTo(Env.ZERO) <= 0){
                return currencyRate;
            }

            currencyRate = rateTo.divide(rateFrom, 6, RoundingMode.HALF_UP);

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return currencyRate;
    }

}
