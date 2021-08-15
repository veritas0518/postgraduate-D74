package Day40.DAO;

import org.junit.Test;

import java.util.List;

/**
 * @ClassName: DAOTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/5 14:49
 **/

public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> forList = dao.getForList(10);


        StudentDAO dao1 = new StudentDAO();
        Student student = dao1.getIndex(1);
    }
}
