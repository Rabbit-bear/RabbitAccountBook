package Test;

import Service.Function.DateMaker;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTest {
    public static void main(String[] args) {
//        System.out.println();
//        try {
//            Date date1 = DateMaker.getDate(DateMaker.getDate());
//            Date date2 = DateMaker.getDate("2020-4-17");
//            System.out.println((date2.getTime()-date1.getTime()>0));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Pattern pattern = Pattern.compile("\\d+\\.?\\d+");
        Matcher matcher = pattern.matcher("999");
        System.out.println("9".matches("\\d+(\\.\\d)?"));

    }
}
