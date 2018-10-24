package fr.ul.miage.bibliotheque.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

	public static Date localDateToDate(LocalDate localDate) {
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		return Date.from(instant);
	}
	
	public static LocalDate dateToLocalDate(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

}
