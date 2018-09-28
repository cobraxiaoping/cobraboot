package com.cobra.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;


/**  
 * @ClassName: DateUtils  
 * @Description: 日期处理工具类  
 * @author: cobra  
 * @date: 2018年9月28日  
 * @version: v1.0
 */  
public class DateUtils {
	
	  

	/**YMD_HMS:年月日时分秒格式*/
	public static String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
	/**YMD:年月日格式*/
	public static String YMD = "yyyy-MM-dd";

	/**  
	 * @Method: formateDate  
	 * @Description: 根据日期格式转换日期
	 * @param: @param date
	 * @param: @param formate
	 * @param: @return
	 * @return: String
	 * @throws  
	 */  
	public static String formateDate(Date date, String formate) {
		if (StringUtils.isEmpty(date) || StringUtils.isEmpty(formate)) {
			return null;
		}
		if (!YMD_HMS.equals(formate) && !YMD.equals(formate)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		String format = sdf.format(date);
		return format;
	}

	/**  
	 * @Method: getCurrentDate_YMD  
	 * @Description: 获取当前日期的年月日格式
	 * @param: @return
	 * @return: String
	 * @throws  
	 */  
	public static String getCurrentDate_YMD() {
		Date date = new Date();
		return formateDate(date, YMD);
	}

	/**  
	 * @Method: getCurrentDate_YMDHMS  
	 * @Description: 获取当前日期的年月日时分秒格式
	 * @param: @return
	 * @return: String
	 * @throws  
	 */  
	public static String getCurrentDate_YMDHMS() {
		Date date = new Date();
		return formateDate(date, YMD_HMS);
	}
}
