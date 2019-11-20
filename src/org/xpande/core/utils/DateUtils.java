package org.xpande.core.utils;

import org.adempiere.exceptions.AdempiereException;

import java.sql.Time;
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

    /***
     * Convierte string en formato dd/MM/yyyy a Timestamp
     * Xpande. Created by Gabriel Vila on 12/15/17.
     * @param str_date
     * @param separador
     * @return
     */
    public static Timestamp convertStringToTimestamp_ddMMyyyy(String str_date, String separador) {

        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd" + separador + "MM" + separador + "yyyy");
            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    /***
     * Convierte string en formato yyyy-MM-dd a Timestamp
     * Xpande. Created by Gabriel Vila on 11/20/19.
     * @param str_date
     * @param separador
     * @return
     */
    public static Timestamp convertStringToTimestamp_yyyyMMdd(String str_date, String separador) {

        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy" + separador + "MM" + separador + "dd");
            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }


    /***
     * Recibe un fecha TimeStamp y le setea la hora recibida.
     * Xpande. Created by Gabriel Vila on 1/14/19.
     * @param fechaTS
     * @param hour
     * @param minutes
     * @param seconds
     * @param milliseconds
     * @return
     */
    public static Timestamp getTSManualHour(Timestamp fechaTS, int hour, int minutes, int seconds, int milliseconds){

        Timestamp fechaHoraTS = fechaTS;

        try{

            //Time time = new Time(System.currentTimeMillis());
            Time time = new Time(fechaTS.getTime());

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time.getTime());
            cal.set(Calendar.HOUR_OF_DAY, hour);
            cal.set(Calendar.MINUTE, minutes);
            cal.set(Calendar.SECOND, seconds);
            cal.set(Calendar.MILLISECOND, milliseconds);

            fechaHoraTS.setTime(cal.getTimeInMillis());
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return fechaHoraTS;
    }


    /***
     * Convierte fecha en formato String: YYYYMMssHHmmss a TimeStamp.
     * Xpande. Created by Gabriel Vila on 2/11/19.
     * @param str_date
     * @return
     */
    public static Timestamp convertStringToTimestamp_YYYYMMddHHMMss(String str_date){

        Timestamp value = null;

        try{

            if (str_date.length() == 14){

                String anio = str_date.substring(0, 4);
                String mes = str_date.substring(4,6);
                String dia = str_date.substring(6,8);
                String hra = str_date.substring(8,10);
                String min = str_date.substring(10,12);
                String seg = str_date.substring(12,14);

               value = Timestamp.valueOf(anio + "-" + mes + "-" + dia + " " + hra + ":" + min + ":" + seg);
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return value;
    }

    public static boolean isInRange(Timestamp dateSource, Timestamp startDate, Timestamp endDate){

        boolean value = false;

        try{
            if (dateSource.equals(startDate)){
                return true;
            }

            if (dateSource.equals(endDate)){
                return true;
            }

            if (dateSource.after(startDate) && dateSource.before(endDate)){
                return true;
            }
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return value;
    }

}
