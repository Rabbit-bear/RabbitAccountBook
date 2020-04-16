package Service.Function;
/*
生成日期字符串
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMaker {
    static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    public static String getDate(){
        String date= sdf.format(new Date());
        return date;
    }
}
