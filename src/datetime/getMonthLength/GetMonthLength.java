package datetime.getMonthLength;

import java.time.LocalDate;

public class GetMonthLength {
    public static void getMonthLength(int month) {
        LocalDate date = LocalDate.now().withMonth(month);
        int result = date.getMonth().length(date.isLeapYear());
        System.out.println(result);
    }

}