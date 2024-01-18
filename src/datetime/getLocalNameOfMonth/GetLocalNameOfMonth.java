package datetime.getLocalNameOfMonth;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GetLocalNameOfMonth {
    public static void getLocalNameOfMonth(String lang, int number) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "LLLL", new Locale(lang));
        GregorianCalendar calendar = new GregorianCalendar(
                number, number - 1, number);
        System.out.println(
                dateFormat.format(calendar.getTime()).toLowerCase());
    }
}