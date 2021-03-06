package Day40;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: GenericTest3
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 15:12
 *
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 **/

public class GenericTest3 {
    /*
    1.泛型在继承方面的体现

      虽然类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系。

        补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1() {
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2不具有子父类关系
//        list1 = list2;

        /*
        反证法：
        假设list1 = list2
           list1.add(123);导致混入非String的数据，出错

         */
        show(list1);
        show1(list2);
    }

    public void show1(List<String> list) {

    }

    public void show(List<Object> list) {

    }

    @Test
    public void test2() {
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
    }

    /*
    2.通配符的使用
        通配符：?

        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     */

    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加:对于list<?>就不能向其内部添加数据
        //除了添加null之外
        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用
        ? extend A:表示类型必须是A或者A的子类
                G<? extends A> 可以作为G<A> 和G<B>的父类的，其中B是A的子类 <=
        ? super A:表示类型必须是A或者A的父类
                G<? super A> 可以作为G<A> 和G<B>的父类的，其中B是A的父类 >=

     */
    @Test
    public void test4() {
        //注意！！子类可以赋值给父类，但父类不能赋值给子类
        Student s1 = new Student();
        Person P1 = (Person) s1;
        P1.PersonEat();
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1  = list5;

//       list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;
        //注意！！！！两种都是写上限
        Person p = list1.get(0);
        Object o = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);

        list2 = list4;
        Object object = list2.get(0);
        //编译不通过
//        Person person = list2.get(0);

        //写入数据:
        //编译不通过
//        list1.add(new Student());

        //可以放Person和Person的子类
        list2.add(new Person());
        list2.add(new Student());
        //编译不通过
//        list2.add(new Object());

    }
}
