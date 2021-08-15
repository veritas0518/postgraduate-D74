package Day40.exercise;

/**
 * @ClassName: MyDate
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/3 15:00
 **/

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate m) {
        //比较年
        int minusYear = this.getYear() - m.getYear();
        if (minusYear != 0) {
            return minusYear;
        }

        //比较月
        int minusMonth = this.getMonth() - m.getMonth();
        if (minusMonth != 0) {
            return minusMonth;
        }

        //比较日
        return this.getDay() - m.getDay();
    }
}

