package simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class T1185_一周中的第几天 {
    @Test
    public void test() {
        String s = dayOfTheWeek(31, 8, 2019);
        System.out.println(s);
    }
    public String dayOfTheWeek(int day, int month, int year) {
        int totalDay = 0;

        String[] result = {"Thursday", "Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday"};

        List<Integer> list = Arrays.asList(1,3,5,7,8,10,12);
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) totalDay += 366;
            else totalDay += 365;
        }

        for (int i = 1; i < month; i++) {
            if (i == 2) {
                totalDay += isLeapYear(year) ? 29 : 28;
                continue;
            }

            if (list.contains(i)) totalDay += 31;
            else totalDay += 30;
        }

        totalDay += day;

        return result[totalDay % 7];
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
