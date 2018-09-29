package org.xpande.core.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    /***
     * Convierte string en formato dd/MM/yyyy a Timestamp
     * Xpande. Created by Gabriel Vila on 12/15/17.
     * @param str_date
     * @return
     */
    public static Timestamp convertStringToTimestamp_ddMMyyyy(String str_date) {

        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
}
