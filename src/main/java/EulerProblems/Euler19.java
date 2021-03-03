package EulerProblems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Euler19 {

    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd";
        int counter = 0;


        for(int y = 1901; y<=2000; y++){
            for(int m=1;m<=12;m++){
                SimpleDateFormat sfd = new SimpleDateFormat(pattern);
                String year = (new Integer(y)).toString();
                String month = (new Integer(m)).toString();
                if(m<10) month = "0" + month;
                try {
                    Date date = sfd.parse(year+"-"+month+"-01");
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                    if(dayOfWeek == 1) {
                        System.out.println(c.getTime());
                        counter++;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(counter);
    }

}
