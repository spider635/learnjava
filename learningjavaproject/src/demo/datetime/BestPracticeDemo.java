package demo.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BestPracticeDemo {

	public static void main(String[] args) {

		// 旧API转新API

		// Date -> Instant:
		Instant ins1 = new Date().toInstant();
		System.out.println(ins1);

		// Calendar -> Instant -> ZonedDateTime:
		Calendar calendar = Calendar.getInstance();
		Instant ins2 = calendar.toInstant();
		ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
		System.out.println(zdt);

		// 新API转旧API
		// ZonedDateTime -> long:
		ZonedDateTime zdt1 = ZonedDateTime.now();
		long ts = zdt1.toEpochSecond() * 1000;

		// long -> Date:
		Date date = new Date(ts);
		System.out.println(date);

		// long -> Calendar:
		Calendar calendar1 = Calendar.getInstance();
		calendar1.clear();
		calendar1.setTimeZone(TimeZone.getTimeZone(zdt1.getZone().getId()));
		calendar1.setTimeInMillis(zdt1.toEpochSecond() * 1000);
		System.out.println(calendar1);

		long ts1 = 1574208900000L;
		System.out.println(timestampToString(ts1, Locale.CHINA, "Asia/Shanghai"));
		System.out.println(timestampToString(ts1, Locale.US, "America/New_York"));

	}

	static String timestampToString(long epochMilli, Locale lo, String zoneId) {
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
	}

}
