package task4;

import java.time.Month;

public class MonthsOfYear {

    static int getMonthNumber(Month month) {
        int monthNumber = 0;
        if (month == null) {
            return 0;
        }
        switch (month) {
            case JANUARY -> monthNumber = 1;
            case FEBRUARY -> monthNumber = 2;
            case MARCH -> monthNumber = 3;
            case APRIL -> monthNumber = 4;
            case MAY -> monthNumber = 5;
            case JUNE -> monthNumber = 6;
            case JULY -> monthNumber = 7;
            case AUGUST -> monthNumber = 8;
            case SEPTEMBER -> monthNumber = 9;
            case OCTOBER -> monthNumber = 10;
            case NOVEMBER -> monthNumber = 11;
            case DECEMBER -> monthNumber = 12;
        }
        return monthNumber;
    }
}