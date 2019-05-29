package by.it.simanovich.at02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TryGetDate {


    public static void main(String[] args) {

        String dataWithFormat = getCurrentDate();
        System.out.println(dataWithFormat);
//        LocalDate now = LocalDate.now();
//        now.
//        LocalDate.parse()
//        for (String split: dataWithFormat.split("/")
//             ) {
//            System.out.println(split);


        }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }


}

