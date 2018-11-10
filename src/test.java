import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class test {


    public static void main(String[] args){
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime);

        LocalDate localDate= LocalDate.now();
        System.out.println(localDate);

        Date date=new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
        String nowTime;
        nowTime= df.format(date);
        System.out.println(nowTime);

        LocalDate firstMondayOf2015 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOf2015);

        test3();
    }


    public static void test3() {
        Calendar calendar = Calendar.getInstance();
        // 假设求6月的最后一天
        int currentMonth = 6;
        // 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
        // 1
        int nowMonth= calendar.get(Calendar.MONTH);
        System.out.println(nowMonth);
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

        int month=calendar.get(Calendar.MONTH);
        System.out.println(month);
        calendar.add(Calendar.DATE, -1);

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("6月份的最后一天为" + day + "号");
    }
}

