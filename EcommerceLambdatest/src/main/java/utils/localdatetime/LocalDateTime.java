package utils.localdatetime;

import java.time.format.DateTimeFormatter;

public class LocalDateTime {

    public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return java.time.LocalDateTime.now().format(formatter);
    }
}