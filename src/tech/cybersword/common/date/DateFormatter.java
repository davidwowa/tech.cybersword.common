package tech.cybersword.common.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

	public String formatedDateFrom(Date date) {
		return formatter.format(date);
	}
}