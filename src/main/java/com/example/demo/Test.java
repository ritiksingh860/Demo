package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String pattern = "^[A-Za-z0-9 _-]*$";
        String str = "Test_";
        System.out.println(Pattern.matches(pattern,str));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter dtfm = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println(dtfm.format(now));
        
        Integer month = Integer.valueOf(dtfm.format(now).toString())-1 ==0 ? 12 : Integer.valueOf(dtfm.format(now).toString())-1;
        Integer year =  Integer.valueOf(dtfm.format(now).toString())-1 ==0 ?  Integer.valueOf(dtf.format(now).toString())-1 : Integer.valueOf(dtf.format(now).toString());
//        YearMonth yearMonth = YearMonth.of( 2015, 1 );  // January of 2015.
        YearMonth yearMonth = YearMonth.of( Integer.valueOf(dtf.format(now).toString()), Integer.valueOf(dtfm.format(now).toString())-1 );  // January of 2015.
        LocalDate firstOfMonth = yearMonth.atDay( 1 );
        LocalDate last = yearMonth.atEndOfMonth();
        System.out.println(firstOfMonth);
        System.out.println(last);

    }
}
