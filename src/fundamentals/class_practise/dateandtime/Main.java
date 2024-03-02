package fundamentals.class_practise.dateandtime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date date = dateFromLocalDate(LocalDate.of(1970, 1, 1));
        long numHours = date.getTime()/(1000*60*60);

        // output numHours to the console
        System.out.println(numHours);
    }

    public static Date dateFromLocalDate(LocalDate localDate) {

        // GregorianCalendar cal =  new GregorianCalendar(localDate.getYear(),localDate.getMonth().getValue() - 1,localDate.getDayOfMonth());
        return new Date(localDate.getYear(),localDate.getMonth().getValue() - 1,localDate.getDayOfMonth());

    }
}