import java.time.*;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate a = LocalDate.parse(date1);
        LocalDate b = LocalDate.parse(date2);
        return (int)Math.abs(java.time.temporal.ChronoUnit.DAYS.between(a, b));
    }
}
