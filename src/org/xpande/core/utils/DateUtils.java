package org.xpande.core.utils;

import java.util.Date;
import java.util.Calendar;

/**
 * Clase de métodos staticos referidos a funcionalidades de fechas.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 10/6/17.
 */
public final class DateUtils {

    /***
     * Suma dias a un Date recibido.
     * Xpande. Created by Gabriel Vila on 10/6/17.
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
