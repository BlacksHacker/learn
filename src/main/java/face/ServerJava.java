package face;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServerJava {

    public void caculate(String timeFormat, String dateStr) throws ParseException {
      int day = getDayWeek(timeFormat, dateStr);
    }

    public static void main(String[] args) {
        try {
            ServerJava serverJava = new ServerJava();
            serverJava.caculate("yyyy-MM-dd HH:mm:ss", "2019-07-09 10:00:00");
            serverJava.test(0, 0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getDayWeek(String timeFormat, String dateStr) throws ParseException{
        DateFormat format = new SimpleDateFormat(timeFormat);
        Date date = format.parse(dateStr);
        System.out.println(new Date());
        Calendar cat = Calendar.getInstance();
        cat.setTime(new Date());
        return cat.get(Calendar.DAY_OF_WEEK) - 1 ;

    }
    public void getWorkScope() throws ParseException{
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        List<String> timeList = new ArrayList<>();
        List<Integer> hourList = new ArrayList<>();
        timeList.add("09:00:00");
        timeList.add("12:00:00");
        timeList.add("14:00:00");
        timeList.add("18:00:00");
        timeList.add("20:00:00");
        timeList.add("23:00:00");
        for(int i = 0; i < timeList.size();){
          Long timesecond = format.parse(timeList.get(i + 1)).getTime() - format.parse(timeList.get(i)).getTime();
          hourList.add((int)(timesecond/3600000));
            i = i + 2;
        }
    }

    public void test(int serveceTime, int week, List<int> hourList){
        int count = 0;
        for(int i = 0; i < hourList.size(); i ++){
            count = count + hourList.get(i);
        }
        int day = serveceTime/count;
        if (day > 0){
            int hour = serveceTime - count * day;
        }else {

        }
    }

}
