package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date toDate(String datetype,String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(datetype);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String DateToStr(String datetype,Date date) {
		return new SimpleDateFormat(datetype).format(date);
	}
}
