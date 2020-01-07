package challenges;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateFormat {
    public static boolean isValidDate(String dateString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("MMM-d-yyyy");

        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws ParseException {
        boolean result = isValidDate("Jun-1-1990");
        System.out.println(result);

        Date dt = new java.util.Date("Jun-71-193390");
        System.out.println(dt);
    }
}
