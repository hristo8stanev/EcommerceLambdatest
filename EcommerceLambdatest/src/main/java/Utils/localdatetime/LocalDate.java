package Utils.localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate {

    public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
    }
}