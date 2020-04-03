package com.zyp.carweb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
    public static final String DATE_SMALL_STR = "yyyy-MM-dd";
    public static final String DATE_HOUR_STR = "yyyyMMddHH";

    //取某天零点的函数，参数是Date（某天）
    public static Date getStartTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    //获取当月最后一天
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat(DATE_SMALL_STR);
        return df.format(new Date());
    }

    public static String format(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }


    public static Date parse(String dateStr, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDateTimeString(Date d, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        if (d == null) {
            return null;
        }
        String s = dateFormat.format(d);
        return s;
    }

    public static long getDifferSeconds(String time) {
        long date = new Date().getTime();
        Date ti = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ti = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long i = date - ti.getTime();
        return i;

    }

    public static Date plusDay2(int num){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        d = ca.getTime();
       return d;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDate());
    }
}
