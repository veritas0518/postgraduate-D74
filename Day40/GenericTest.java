package Day40;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: GenericTest
 * @Description: 泛型的使用
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 11:13
 * @Version: 1.0
 *
 *  1.jdk 5.0新增的特性
 *
 *  2.在集合中使用泛型
 *    总结：
 *    ①集合接口或集合类在jdk 5.0时都修改为带泛型的结构
 *    ②在实例化集合类时可以指明具体的泛型类型
 *    ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如：方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化时泛型的类型
 *      比如：add(E e) ---> 实例化以后：add(Integer e)
 *    ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，用包装类去替换
 *    ⑤如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型
 *
 *  3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见GenericTest1.java
 *
 **/

public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //问题一：类型不安全
        list.add("Tom");

        for (Object score : list) {

            //问题二：强转时，可能出现ClassCastException
            int stuScore = (int) score;

            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);

        //编译时就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一
//        for (Integer score : list) {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型之前的情况：以HashMap为例
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 12);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        //这里的Map.Entry是因为Entry是定义在Map接口中的一个子接口，而要调用Entry接口就必须要Map.一下
        Set<Map.Entry<String, Integer>> entry = map.entrySet();  //泛型的嵌套
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "--->" + value);
        }
    }
}
