package com.jack.service.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 
 * @ClassName: DateUtils
 * @Description: parse String to Date
 * @author lksoulman
 * @date 2018年6月1日 下午3:03:54
 */
public class DateConvertUtils {

    private static SimpleDateFormat sdf;
    private static SimpleDateFormat sdf2;

    static {
        sdf = new SimpleDateFormat("yy MM dd HH:mm:ss.SSS");
        sdf.setLenient(false);
        sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }


    public static void main(String[] args) {

        String dateStr1 = "2018/05/03";
        String dateStr2 = "2018-05-03";
        String dateStr3 = "2018 05 03";
        String dateStr4 = "2018-5-3";
        String dateStr5 = "2018/5/3";
        String dateStr6 = "2018 5 3";
        String dateStr7 = "18 5 3";

        // String dateStr8 = "05/03/2018";
        // String dateStr9 = "05-03-2018";

        String dateStr21 = "2018/05/03 16:00:00.000";
        String dateStr22 = "2018/05/03 16:00:00.0";
        String dateStr23 = "2018/05/03 16:00:00";
        String dateStr24 = "2018/05/03 16:00:0";
        String dateStr25 = "2018/05/03 16:0:0";
        String dateStr26 = "2018/05/03 16:00";
        String dateStr27 = "2018/05/03 16:0";
        
        String dateStr31 = "2018-05-03 16:00:00.000";
        String dateStr32 = "2018-05-03 16:00:00.0";
        String dateStr33 = "2018-05-03 16:00:00";
        String dateStr34 = "2018-05-03 16:00:0";
        String dateStr35 = "2018-05-03 16:0:0";
        String dateStr36 = "2018-05-03 16:00";
        String dateStr37 = "2018-05-03 16:0";
        
        String dateStr41 = "2018 05 03 16:00:00.000";
        String dateStr42 = "2018 05 03 16:00:00.0";
        String dateStr43 = "2018 05 03 16:00:00";
        String dateStr44 = "2018 05 03 16:00:0";
        String dateStr45 = "2018 05 03 16:0:0";
        String dateStr46 = "2018 05 03 16:00";
        String dateStr47 = "2018 05 03 16:0";
        
        String dateStr51 = "2018-5-3 16:00:00.000";
        String dateStr52 = "2018-5-3 16:00:00.0";
        String dateStr53 = "2018-5-3 16:00:00";
        String dateStr54 = "2018-5-3 16:00:0";
        String dateStr55 = "2018-5-3 16:0:0";
        String dateStr56 = "2018-5-3 16:00";
        String dateStr57 = "2018-5-3 16:0";
        
        String dateStr61 = "2018/5/3 16:00:00.000";
        String dateStr62 = "2018/5/3 16:00:00.0";
        String dateStr63 = "2018/5/3 16:00:00";
        String dateStr64 = "2018/5/3 16:00:0";
        String dateStr65 = "2018/5/3 16:0:0";
        String dateStr66 = "2018/5/3 16:00";
        String dateStr67 = "2018/5/3 16:0";
        
        String dateStr71 = "2018 5 3 16:00:00.000";
        String dateStr72 = "2018 5 3 16:00:00.0";
        String dateStr73 = "2018 5 3 16:00:00";
        String dateStr74 = "2018 5 3 16:00:0";
        String dateStr75 = "2018 5 3 16:0:0";
        String dateStr76 = "2018 5 3 16:00";
        String dateStr77 = "2018 5 3 16:0";
        
        String dateStr81 = "18 5 3 16:00:00.000";
        String dateStr82 = "18 5 3 16:00:00.0";
        String dateStr83 = "18 5 3 16:00:00";
        String dateStr84 = "18 5 3 16:00:0";
        String dateStr85 = "18 5 3 16:0:0";
        String dateStr86 = "18 5 3 16:00";
        String dateStr87 = "18 5 3 16:0";

        try {
            Date date1 = parse(dateStr1);
            System.out.println(dateStr1 + "=>" + sdf2.format(date1));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr1 + "失败");
        }

        try {  
            Date date2 = parse(dateStr2);
            System.out.println(dateStr2 + "=>" + sdf2.format(date2));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr2 + "失败");
        }

        try {
            Date date3 = parse(dateStr3);
            System.out.println(dateStr3 + "=>" + sdf2.format(date3));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr3 + "失败");
        }

        try {
            Date date4 = parse(dateStr4);
            System.out.println(dateStr4 + "=>" + sdf2.format(date4));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr4 + "失败");
        }

        try {
            Date date5 = parse(dateStr5);
            System.out.println(dateStr5 + "=>" + sdf2.format(date5));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr5 + "失败");
        }

        try {
            Date date6 = parse(dateStr6);
            System.out.println(dateStr6 + "=>" + sdf2.format(date6));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr6 + "失败");
        }

        try {
            Date date7 = parse(dateStr7);
            System.out.println(dateStr7 + "=>" + sdf2.format(date7));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr7 + "失败");
        }

        // try {
        // Date date8 = parse(dateStr8);
        // System.out.println(dateStr8 + "=>" + simpleDateFormat_Global.format(date8));
        // } catch (Exception e) {
        // System.out.println("解析：" + dateStr8 + "失败");
        // }

        try {
            Date date21 = parse(dateStr21);
            System.out.println(dateStr21 + "=>" + sdf2.format(date21));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr21 + "失败");
        }

        try {
            Date date22 = parse(dateStr22);
            System.out.println(dateStr22 + "=>" + sdf2.format(date22));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr22 + "失败");
        }

        try {
            Date date23 = parse(dateStr23);
            System.out.println(dateStr23 + "=>" + sdf2.format(date23));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr23 + "失败");
        }

        try {
            Date date24 = parse(dateStr24);
            System.out.println(dateStr24 + "=>" + sdf2.format(date24));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr24 + "失败");
        }

        try {
            Date date25 = parse(dateStr25);
            System.out.println(dateStr25 + "=>" + sdf2.format(date25));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr25 + "失败");
        }

        try {
            Date date26 = parse(dateStr26);
            System.out.println(dateStr26 + "=>" + sdf2.format(date26));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr26 + "失败");
        }
        try {
            Date date27 = parse(dateStr27);
            System.out.println(dateStr27 + "=>" + sdf2.format(date27));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr27 + "失败");
        }
        
        try {
            Date date31 = parse(dateStr31);
            System.out.println(dateStr31 + "=>" + sdf2.format(date31));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr31 + "失败");
        }

        try {
            Date date32 = parse(dateStr32);
            System.out.println(dateStr32 + "=>" + sdf2.format(date32));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr32 + "失败");
        }

        try {
            Date date33 = parse(dateStr33);
            System.out.println(dateStr33 + "=>" + sdf2.format(date33));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr33 + "失败");
        }

        try {
            Date date34 = parse(dateStr34);
            System.out.println(dateStr34 + "=>" + sdf2.format(date34));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr34 + "失败");
        }

        try {
            Date date35 = parse(dateStr35);
            System.out.println(dateStr35 + "=>" + sdf2.format(date35));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr35 + "失败");
        }

        try {
            Date date36 = parse(dateStr36);
            System.out.println(dateStr36 + "=>" + sdf2.format(date36));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr36 + "失败");
        }
        try {
            Date date37 = parse(dateStr37);
            System.out.println(dateStr37 + "=>" + sdf2.format(date37));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr37 + "失败");
        }
        
        try {
            Date date41 = parse(dateStr41);
            System.out.println(dateStr41 + "=>" + sdf2.format(date41));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr41 + "失败");
        }

        try {
            Date date42 = parse(dateStr42);
            System.out.println(dateStr42 + "=>" + sdf2.format(date42));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr42 + "失败");
        }

        try {
            Date date43 = parse(dateStr43);
            System.out.println(dateStr43 + "=>" + sdf2.format(date43));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr43 + "失败");
        }

        try {
            Date date44 = parse(dateStr44);
            System.out.println(dateStr44 + "=>" + sdf2.format(date44));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr44 + "失败");
        }

        try {
            Date date45 = parse(dateStr45);
            System.out.println(dateStr45 + "=>" + sdf2.format(date45));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr45 + "失败");
        }

        try {
            Date date46 = parse(dateStr46);
            System.out.println(dateStr46 + "=>" + sdf2.format(date46));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr46 + "失败");
        }
        try {
            Date date47 = parse(dateStr47);
            System.out.println(dateStr47 + "=>" + sdf2.format(date47));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr47 + "失败");
        }
        
        try {
            Date date51 = parse(dateStr51);
            System.out.println(dateStr51 + "=>" + sdf2.format(date51));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr51 + "失败");
        }

        try {
            Date date52 = parse(dateStr52);
            System.out.println(dateStr52 + "=>" + sdf2.format(date52));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr52 + "失败");
        }

        try {
            Date date53 = parse(dateStr53);
            System.out.println(dateStr53 + "=>" + sdf2.format(date53));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr53 + "失败");
        }

        try {
            Date date54 = parse(dateStr54);
            System.out.println(dateStr54 + "=>" + sdf2.format(date54));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr54 + "失败");
        }

        try {
            Date date55 = parse(dateStr55);
            System.out.println(dateStr55 + "=>" + sdf2.format(date55));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr55 + "失败");
        }

        try {
            Date date56 = parse(dateStr56);
            System.out.println(dateStr56 + "=>" + sdf2.format(date56));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr56 + "失败");
        }
        try {
            Date date57 = parse(dateStr57);
            System.out.println(dateStr57 + "=>" + sdf2.format(date57));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr57 + "失败");
        }
        
        try {
            Date date61 = parse(dateStr61);
            System.out.println(dateStr61 + "=>" + sdf2.format(date61));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr61 + "失败");
        }

        try {
            Date date62 = parse(dateStr62);
            System.out.println(dateStr62 + "=>" + sdf2.format(date62));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr62 + "失败");
        }

        try {
            Date date63 = parse(dateStr63);
            System.out.println(dateStr63 + "=>" + sdf2.format(date63));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr63 + "失败");
        }

        try {
            Date date64 = parse(dateStr64);
            System.out.println(dateStr64 + "=>" + sdf2.format(date64));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr64 + "失败");
        }

        try {
            Date date65 = parse(dateStr65);
            System.out.println(dateStr65 + "=>" + sdf2.format(date65));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr65 + "失败");
        }

        try {
            Date date66 = parse(dateStr66);
            System.out.println(dateStr66 + "=>" + sdf2.format(date66));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr66 + "失败");
        }
        try {
            Date date67 = parse(dateStr67);
            System.out.println(dateStr67 + "=>" + sdf2.format(date67));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr67 + "失败");
        }
        
        try {
            Date date71 = parse(dateStr71);
            System.out.println(dateStr71 + "=>" + sdf2.format(date71));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr71 + "失败");
        }

        try {
            Date date72 = parse(dateStr72);
            System.out.println(dateStr72 + "=>" + sdf2.format(date72));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr72 + "失败");
        }

        try {
            Date date73 = parse(dateStr73);
            System.out.println(dateStr73 + "=>" + sdf2.format(date73));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr73 + "失败");
        }

        try {
            Date date74 = parse(dateStr74);
            System.out.println(dateStr74 + "=>" + sdf2.format(date74));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr74 + "失败");
        }

        try {
            Date date75 = parse(dateStr75);
            System.out.println(dateStr75 + "=>" + sdf2.format(date75));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr75 + "失败");
        }

        try {
            Date date76 = parse(dateStr76);
            System.out.println(dateStr76 + "=>" + sdf2.format(date76));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr76 + "失败");
        }
        try {
            Date date77 = parse(dateStr77);
            System.out.println(dateStr77 + "=>" + sdf2.format(date77));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr77 + "失败");
        }
        
        try {
            Date date81 = parse(dateStr81);
            System.out.println(dateStr81 + "=>" + sdf2.format(date81));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr81 + "失败");
        }

        try {
            Date date82 = parse(dateStr82);
            System.out.println(dateStr82 + "=>" + sdf2.format(date82));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr82 + "失败");
        }

        try {
            Date date83 = parse(dateStr83);
            System.out.println(dateStr83 + "=>" + sdf2.format(date83));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr83 + "失败");
        }

        try {
            Date date84 = parse(dateStr84);
            System.out.println(dateStr84 + "=>" + sdf2.format(date84));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr84 + "失败");
        }

        try {
            Date date85 = parse(dateStr85);
            System.out.println(dateStr85 + "=>" + sdf2.format(date85));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr85 + "失败");
        }

        try {
            Date date86 = parse(dateStr86);
            System.out.println(dateStr86 + "=>" + sdf2.format(date86));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr86 + "失败");
        }
        try {
            Date date87 = parse(dateStr87);
            System.out.println(dateStr87 + "=>" + sdf2.format(date87));
        } catch (Exception e) {
            System.out.println("解析：" + dateStr87 + "失败");
        }
    }

    private static int getIndex(String date) {
        int lastIndex = -1, currIndex = 0, count = 0;
        while (count < 3) {
            currIndex = date.indexOf(" ", currIndex);

            if (currIndex == -1) {
                break;
            }

            if (currIndex > lastIndex) {
                lastIndex = currIndex;
                currIndex++;
            }
            count++;
        }

        return lastIndex;
    }

    public static Date parse(String strDateTime) throws Exception {

        if (StringUtils.isEmpty(strDateTime))
            return null;

        String strDateTime1 = strDateTime.trim();
        if (strDateTime1.length() > 24)
            return null;

        String strDateTime2 = replaceDelimiter(strDateTime1);
        if (strDateTime2 == null)
            return null;

        if (strDateTime2.length() < 24) {
            if (strDateTime2.indexOf(":") > -1) {
                if (strDateTime2.indexOf(" ") > -1) {
                    strDateTime2 = complete(strDateTime2);
                } else {
                    strDateTime2 = DateFormatUtils.format(new Date(), "yyyy MM dd") + " "
                            + completeTime(strDateTime2);
                }
            } else {
                if (strDateTime2.length() <= 10) {
                    strDateTime2 = completeDate(strDateTime2) + " 00:00:00.000";
                }
            }
        }

        return sdf.parse(strDateTime2);
    }

    private static String complete(String strDateTime) throws Exception {
        int index = getIndex(strDateTime);
        String datePart, timePart, completeDatetime;
        if (index > 0) {
            datePart = strDateTime.substring(0, index);
            datePart = completeDate(datePart);
            timePart = strDateTime.substring(index + 1, strDateTime.length());
            timePart = completeTime(timePart);
        } else {
            datePart = completeDate(strDateTime);
            timePart = "00:00:00.000";
        }
        completeDatetime = datePart + " " + timePart;
        return completeDatetime;
    }

    private static String completeDate(String datePart) {

        return datePart;
    }

    private static String completeTime(String timePart) throws Exception {
        if (StringUtils.isEmpty(timePart))
            return new String("00:00:00.000");

        if (timePart.length() >= 12)
            return timePart;

        return doCompleteTime(timePart);
    }

    /**
     * 
     * @Title: doCompleteTime
     * @Description: complete hour:minute:second.millsecond
     * @param @param timePart
     * @return String
     * @author lksoulman
     * @throws @date 2018年6月4日 下午2:25:51
     */
    private static String doCompleteTime(String timePart) throws Exception {
        String[] timeParts = StringUtils.split(timePart, ":");
        if (timeParts == null || timeParts.length < 2 || timeParts.length > 3)
            return timePart;

        StringBuilder stringBuilder = new StringBuilder();
        // complete hour
        if (timeParts[0].length() < 2) {
            stringBuilder.append("0").append(timeParts[0]);
        } else {
            stringBuilder.append(timeParts[0]);
        }
        stringBuilder.append(":");

        // complete minute
        if (timeParts[1].length() < 2) {
            stringBuilder.append("0").append(timeParts[1]);
        } else {
            stringBuilder.append(timeParts[1]);
        }
        stringBuilder.append(":");

        // complete second
        if (timeParts.length > 2) {
            String[] seconds = StringUtils.split(timeParts[2], ".");
            if (seconds[0].length() < 2) {
                stringBuilder.append("0").append(seconds[0]);
            } else {
                stringBuilder.append(seconds[0]);
            }

            if (seconds.length > 1) {
                if (seconds[1].length() > 2) {
                    stringBuilder.append(".").append(seconds[1]);
                } else if (seconds[1].length() > 1) {
                    stringBuilder.append(".0").append(seconds[1]);
                } else {
                    stringBuilder.append(".00").append(seconds[1]);
                }
            } else {
                stringBuilder.append(".000");
            }

        } else {
            stringBuilder.append("00.000");
        }

        return stringBuilder.toString();
    }

    /**
     * 
     * @Title: replaceDate
     * @Description:
     * @param strSource
     * @return String
     * @author lksoulman
     * @throws @date 2018年6月5日 下午1:46:14
     */
    private static String replaceDelimiter(String strSource) {
        return StringUtils.replace(StringUtils.replace(strSource, "-", " "), "/", " ");
    }
}
