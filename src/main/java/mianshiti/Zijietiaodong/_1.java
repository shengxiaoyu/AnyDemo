package mianshiti.Zijietiaodong;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author 13314
 * @date 2019/6/30
 * @time 20:07
 * @Description
 */
public class _1 {
    public static void cal(String[] births) throws ParseException {
        Calendar today = new GregorianCalendar() ;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        for(String birth:births){
            Calendar day = new GregorianCalendar() ;
            day.setTime(dateFormat.parse(birth));
            day.add(Calendar.YEAR,18);
            if(day.compareTo(today)<0)
                System.out.println((today.getTimeInMillis() - day.getTimeInMillis()) / (1000 * 60 * 60 * 24));
            else
                day.add(Calendar.YEAR,-18);
                System.out.println(-1);
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in) ;
        int n = in.nextInt() ;
        in.nextLine() ;
        String[] births = new String[n] ;
        int i = 0 ;

        while(in.hasNextLine()){
            births[i++] = in.nextLine() ;
        }
        cal(births);
    }
}
