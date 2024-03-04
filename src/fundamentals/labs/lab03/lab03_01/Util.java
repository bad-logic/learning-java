package fundamentals.labs.lab03.lab03_01;

import java.text.DateFormat;
import java.util.Date;

public class Util {
    public static String dateAsString(Date d) {
        DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
        return f.format(d);
    }

}
