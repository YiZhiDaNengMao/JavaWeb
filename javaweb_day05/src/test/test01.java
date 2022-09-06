package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test01 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String now = sdf.format(date);
        System.out.println(now);
    }
}
