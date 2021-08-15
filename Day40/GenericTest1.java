package Day40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenericTest1
 * @Description: 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 13:23
 **/

public class GenericTest1 {
    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order<String> order = new Order<>("orderAA", 1001, "order:AA");
        order.setOrderT("AA:hello");
    }

    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //泛型不同的引用不能相互赋值
//        list1 = list2;
    }

    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
