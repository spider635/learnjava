package demo.datetime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterDemo {

	public static void main(String[] args) {

		ZonedDateTime zdt = ZonedDateTime.now();
		var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
		System.out.println(formatter.format(zdt));

		var zhFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
		System.out.println(zhFormatter.format(zdt));

		var usFormatter = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
		System.out.println(usFormatter.format(zdt));

		var ldt1 = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ISO_DATE.format(ldt1));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ldt1));

	}

}
