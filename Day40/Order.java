package Day40;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Order
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 13:18
 **/

public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
        //编译不通过
//        T[] arr = new Object[10];

        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //静态方法中不能使用类的泛型。
    //因为泛型是在对象的实例化的时候才有用的，而静态早于对象的创建
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    //异常类不能声明为泛型
    public void show() {
        //编译不通过
//        try {
//
//        }catch (T t){
//
//        }
    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非在实例化类时确定的
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
