package demo1;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Classname StringBufferBuildTest
 * @Description TODO
 * @Date 2021/2/21 16:58
 * @Created by ruler
 */
public class StringBufferBuildTest {
    public static void main(String[] args){
//        StringBuffer b = new StringBuffer("asd123");
//        StringBuilder b2 = new StringBuilder("111");
//        b.append("aaa");
//        System.out.println(b);
//
//        b2.append(11121212);
//        System.out.println(b2);

//        long l = System.currentTimeMillis();
//        System.out.println(l);

//        Date date = new Date();
//        System.out.println(date.toString());
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date1 = new Date();
//
//        System.out.println(date1.toString());

//        Date data = new Date();
//
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat();
//
//
//        String s =sdf.format(data);
//        System.out.println(s);

//        Calendar ca = Calendar.getInstance();
//        int i = ca.get(Calendar.DAY_OF_MONTH);
//        int i1 = ca.get(Calendar.DAY_OF_YEAR);
//
//
//        System.out.println(i1);


//        Date d = new Date();
//        System.out.println(d);
//
//        LocalDate ld = LocalDate.now();
//        System.out.println(ld);
//
//        LocalTime lt = LocalTime.now();
//        System.out.println(lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str1 = df.format(ldt);
        System.out.println(str1);




    }


}



