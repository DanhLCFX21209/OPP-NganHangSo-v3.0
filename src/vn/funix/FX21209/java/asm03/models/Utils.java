package vn.funix.FX21209.java.asm03.models;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public String getDivider() {
        return "+----------+--------------------+----------+";
    }

    public String getDatetime() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = datetime.format(formatter);
        return formattedDateTime;
    }

    public String formatBalance(double balance) {
        return String.format("%,d", (long) balance);
    }
}
