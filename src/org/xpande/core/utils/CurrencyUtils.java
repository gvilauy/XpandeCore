package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Clase de métodos staticos referidos a funcionalidades de monedas y tasas de cambio.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 8/2/17.
 */
public final class CurrencyUtils {


    /***
     * Obtiene y retorna tasa de cambio en moneda del squema contable si es recibida por parametro.
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

}
