package Day40;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SubOrder
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 13:33
 **/

public class SubOrder extends Order<Integer> { //SubOrder：不再是泛型类

    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
