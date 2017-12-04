package www.hughwang.me.springbootlearning.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hughwang
 * @date 2017/12/4 14:41
 */

public class DateUtil {

    public static String FORMAT_PATTERN_YYYY_MM_dd = "YYYY-MM-dd";

    public static String FORMAT_PATTERN_YYYY_MM_dd_HH_mm_ss = "YYYY-MM-dd HH:mm:ss";

    /**
     * 获取当前 date 对象
     * @return
     */
    public static Date getDate(){
        return new Date();
    }

    /**
     * 获取当前时间的标准格式输出 YYYY-MM-dd HH:mm:ss
     * @return
     */
    public static String currentFormatted(){
     return dateFormat(FORMAT_PATTERN_YYYY_MM_dd_HH_mm_ss).format(getDate());
    }

    /**
     * 通用日期格式对象
     * @param pattern
     * @return
     */
    private static SimpleDateFormat dateFormat(String pattern){
        return new SimpleDateFormat(pattern);
    }

}
