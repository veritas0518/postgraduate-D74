package Day40.exercise;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ClassName: EmployeeTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/3 15:06
 * @Version:
 **/

public class EmployeeTest {

    //问题一：使用自然排序
    @Test
    public void test1() {
        //jdk 7新特性：类型推断
        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    //问题二：按生日日期的先后排序
    @Test
    public void test2() {

        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }

            //使用泛型之前的写法
            //            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//
//                    MyDate b1 = e1.getBirthday();
//                    MyDate b2 = e2.getBirthday();
//
//                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if (minusMonth != 0) {
//                        return minusMonth;
//                    }
//
//                    //比较日
//                    return b1.getDay() - b2.getDay();
//
//                } else {
//                    throw new RuntimeException("传入的数据类型有误");
//                }
//            }
        });

        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
