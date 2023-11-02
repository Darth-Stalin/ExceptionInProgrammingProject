package home.work.exception;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ParseDate {
    static Date parsebdate(String str){

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String formatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);
    }

}
