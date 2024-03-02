package fundamentals.practise.dateandtime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LocalDateSamples {

    public static void main(String[] args) {
//		System.out.println("Today's date: " + LocalDate.now());
//		System.out.println("Today's date MM/dd/yyyy: " + localDateAsString(LocalDate.now()));
//		System.out.println("Specified date: " + LocalDate.of(2000, 1, 1));
//		System.out.println("Specified date MM/dd/yyyy: " + localDateAsString(LocalDate.of(2000, 1, 1)));
        //Greg to LocalDate
//		GregorianCalendar cal = new GregorianCalendar(2001, Calendar.MARCH, 15);
//		System.out.println(localDateAsString(localDateFromGregCalendar(cal)));
//		//LocalDate to Greg
        LocalDate locDate = LocalDate.of(2000, 1, 1);
        GregorianCalendar calendar = gregorianCalendarFromLocalDate(locDate);
        Date d = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy",Locale.US);
        System.out.println(formatter.format(d));
    }
    ///// LocalDate <--> String conversions
    public static final String DATE_PATTERN = "MM/dd/yyyy";
    public static LocalDate localDateForString(String date) {  //pattern: "MM/dd/yyyy"
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static String localDateAsString(LocalDate date) {  //pattern: "MM/dd/yyyy"
        return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }



    //// LocalDate <--> GregorianCalendar conversions
    public static LocalDate localDateFromGregCalendar(GregorianCalendar cal) {
        return LocalDate.of(cal.get(Calendar.YEAR), 1+cal.get(Calendar.MONTH),
                cal.get(Calendar.DATE));
    }

    public static GregorianCalendar gregorianCalendarFromLocalDate(LocalDate locDate) {
        return new GregorianCalendar(locDate.getYear(), locDate.getMonth().getValue()-1, locDate.getDayOfMonth());
    }


}
