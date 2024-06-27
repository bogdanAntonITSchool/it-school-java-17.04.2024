package datetime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Paris"));

        // the format is yyyy-MM-dd
        System.out.println(date);

        // the format is yyyy-MM-dd'T'HH:mm:ss.SSS
        System.out.println(time);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(date.format(dtf));

        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yy HH:mm");
        System.out.println(time.format(dtfTime));

        DateTimeFormatter secondDtf = DateTimeFormatter.ofPattern("MM/yyyy/EE");

        System.out.print("Please type in a valid date: ");
        String stringDate = new Scanner(System.in).nextLine();

        LocalDate secondDate = LocalDate.parse(stringDate, dtf);
        System.out.println(secondDate.format(secondDtf));

        Date oldDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(oldDate));

        // Convert java.util.Date to java.sql.Date
        java.util.Date oldOldDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(oldOldDate.getTime());

        System.out.println(sqlDate);

        // Convert java.sql.Date to java.util.Date
        java.util.Date thirdDate = sqlDate;
        System.out.println(thirdDate);

        // Example of java.sql.Timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp1 = Timestamp.valueOf("2021-12-31 23:59:59");

        SimpleDateFormat newSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        LocalDateTime ldt = LocalDateTime.now();
        // Extracting LocalDate from LocalDateTime
        LocalTime localTime = ldt.toLocalTime();
        System.out.println(localTime);

        System.out.println(timestamp);
        System.out.println(newSdf.format(timestamp));

        // Convert string to LocalDateTime
        String s = "2023-08-15 14:30:00";
        DateTimeFormatter newDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, newDtf);
        System.out.println(parse);

        // Convert Date to LocalDate
        Date lastDate = new Date();
        LocalDate localDate = lastDate.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        // Convert Date to LocalDate second approach
        LocalDate date1 = LocalDate.ofInstant(lastDate.toInstant(), ZoneId.systemDefault());

        System.out.println(localDate);

        // Convert LocalDateTime to Date
        LocalDateTime newLdt = LocalDateTime.now();
        Date date2 = Date.from(newLdt.atZone(ZoneId.systemDefault()).toInstant());

        LocalDate ld = LocalDate.now();
        LocalDate ld1 = LocalDate.of(2021, 12, 31);

        // Get days between two dates
        ChronoUnit.DAYS.between(ld, ld1);
    }
}
