package com.yihukurama.lcontroler.control.util;

import android.annotation.SuppressLint;

import com.yihukurama.lcontroler.LControlerApplication;
import com.yihukurama.lcontroler.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class TimeUtil {
	
	public final static String FORMAT_YEAR = "yyyy";
	public final static String FORMAT_MONTH_DAY = "MM月dd日";
	
	public final static String FORMAT_DATE = "yyyy-MM-dd";
	public final static String FORMAT_TIME = "HH:mm";
	public final static String FORMAT_MONTH_DAY_TIME = "MM月dd日 HH:mm";
	
	public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";
	public final static String FORMAT_DATE1_TIME = "yyyy/MM/dd HH:mm";
	public final static String FORMAT_DATE_TIME_SECOND = "yyyy/MM/dd HH:mm:ss";
	
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private static final int YEAR = 365 * 24 * 60 * 60;// 年
	private static final int MONTH = 30 * 24 * 60 * 60;// 月
	private static final int DAY = 24 * 60 * 60;// 天
	private static final int HOUR = 60 * 60;// 小时
	private static final int MINUTE = 60;// 分钟

	/**
	 * 根据时间戳获取描述性时间，如3分钟前，1天前
	 * 
	 * @param timestamp
	 *            时间戳 单位为毫秒
	 * @return 时间字符串
	 */
	public static String getDescriptionTimeFromTimestamp(long timestamp) {
		long currentTime = System.currentTimeMillis();
		long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
		System.out.println("timeGap: " + timeGap);
		String timeStr = null;
		if (timeGap > YEAR) {
			timeStr = timeGap / YEAR + LControlerApplication.getContext().getResources().getString(R.string.time_year);
		} else if (timeGap > MONTH) {
			timeStr = timeGap / MONTH + LControlerApplication.getContext().getResources().getString(R.string.time_mon);
		} else if (timeGap > DAY) {// 1天以上
			timeStr = timeGap / DAY + LControlerApplication.getContext().getResources().getString(R.string.time_day);
		} else if (timeGap > HOUR) {// 1小时-24小时
			timeStr = timeGap / HOUR + LControlerApplication.getContext().getResources().getString(R.string.time_hour);
		} else if (timeGap > MINUTE) {// 1分钟-59分钟
			timeStr = timeGap / MINUTE + LControlerApplication.getContext().getResources().getString(R.string.time_min);
		} else {// 1秒钟-59秒钟
			timeStr = "刚刚";
		}
		return timeStr;
	}

	/**
	 * 获取当前日期的指定格式的字符串
	 * 
	 * @param format
	 *            指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
	 * @return
	 */
	public static String getCurrentTime(String format) {
		if (format == null || format.trim().equals("")) {
			sdf.applyPattern(FORMAT_DATE_TIME);
		} else {
			sdf.applyPattern(format);
		}
		return sdf.format(new Date());
	}

	/**
	 * 
	 * @param data 类型转换为String类型
	 * @param formatType 格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
 	public static String dateToString(Date data, String formatType) {
 		return new SimpleDateFormat(formatType).format(data);
 	}
 
 	/**
 	 *  long类型转换为String类型
 	 * @param currentTime 要转换的long类型的时间
 	 * @param formatType 要转换的string类型的时间格式
 	 * @return
 	 */
 	public static String longToString(long currentTime, String formatType){
 		String strTime="";
		Date date = longToDate(currentTime, formatType);// long类型转成Date类型
		System.out.println("currentTime:"+currentTime+"date:"+date);
		strTime = dateToString(date, formatType); // date类型转成String 
		System.out.println("strTime:"+strTime);
 		return strTime;
 	}
 
 	/**
 	 *  string类型转换为date类型
 	 * @param strTime 的时间格式必须要与formatType的时间格式相同
 	 * @param formatType 要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒，
 	 * @return
 	 */
 	public static Date stringToDate(String strTime, String formatType){
 		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
 		Date date = null;
 		try {
			date = formatter.parse(strTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return date;
 	}
 
 	/**
 	 *  long转换为Date类型
 	 * @param currentTime 要转换的long类型的时间
 	 * @param formatType 要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
 	 * @return
 	 */
 	public static Date longToDate(long currentTime, String formatType){
 		Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
 		String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
 		Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
 		return date;
 	}
 
 	/**
 	 *  string类型转换为long类型
 	 * @param strTime 要转换的String类型的时间
 	 * @param formatType 时间格式
 	 * @return
 	 */
 	public static long stringToLong(String strTime, String formatType){
 		Date date = stringToDate(strTime, formatType); // String类型转成date类型
 		if (date == null) {
 			return 0;
 		} else {
 			long currentTime = dateToLong(date); // date类型转成long类型
 			return currentTime;
 		}
 	}
 
 	/**
 	 *  date类型转换为long类型
 	 * @param date 要转换的date类型的时间
 	 * @return
 	 */
 	public static long dateToLong(Date date) {
 		return date.getTime();
 	}
	 	
	public static String getTime(long time) {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_MONTH_DAY_TIME);
		return format.format(new Date(time));
	}

	public static String getHourAndMin(long time) {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_TIME);
		return format.format(new Date(time));
	}

	/** 获取聊天时间：因为sdk的时间默认到秒故应该乘1000
	  * @Title: getChatTime
	  * @Description: TODO
	  * @param @param timesamp
	  * @param @return 
	  * @return String
	  * @throws
	  */
	public static String getChatTime(long timesamp) {
		//long clearTime = timesamp*1000;
		long clearTime = timesamp;
		String result = "";
		long currentTime = System.currentTimeMillis();
		long todayTime_0 = longToDate(currentTime,FORMAT_DATE).getTime();
		if(clearTime >= todayTime_0 && (clearTime-todayTime_0)/1000<=DAY)
			result = getHourAndMin(clearTime);
		else if(clearTime < todayTime_0 && (todayTime_0-clearTime)/1000<=DAY)
			result = LControlerApplication.getContext().getResources().getString(R.string.time_yesterday) + getHourAndMin(clearTime);
		else if(clearTime < todayTime_0 && (todayTime_0-clearTime)/1000<=(DAY*2))
			result = LControlerApplication.getContext().getResources().getString(R.string.time_day_beforeyesterday) + getHourAndMin(clearTime);
		else
			result = getTime(clearTime);

		return result;
	}

	public static boolean isCloseEnough(long thistime,long lasttime){
		if((thistime/1000-lasttime/1000)>60)
			return true;
		return false;
	}

	/** 时间戳转日期时间字符串，当日期为今天时隐藏日期
	 */
	public static String changeTime(long timesamp) {
		//long clearTime = timesamp*1000;
		long clearTime = timesamp;
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Date today = new Date(System.currentTimeMillis());
		Date otherDay = new Date(clearTime);
		int temp = Integer.parseInt(sdf.format(today))
				- Integer.parseInt(sdf.format(otherDay));

		switch (temp) {
			case 0:
				result = getHourAndMin(clearTime);
				break;
			default:
				result = getTime(clearTime);
				break;
		}

		return result;
	}
}