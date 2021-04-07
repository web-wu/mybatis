import com.wxx.mybatis_protice.dao.UserMapperAnno;
import com.wxx.mybatis_protice.entity.Order;
import com.wxx.mybatis_protice.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test3 {
    private UserMapperAnno mapperAnno;
    private User user = new User();

    @Before
    public void beforeLoad() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapperAnno = sqlSession.getMapper(UserMapperAnno.class);
    }

    @Test
    public void test1() {
        user.setUsername("王二麻子");
        user.setPassword("abcdefg");
        mapperAnno.addUser(user);
    }

    @Test
    public void test2() {
        mapperAnno.delUser(9);
    }

    @Test
    public void test3() {
        user.setId(10);
        user.setUsername("独孤求败");
        user.setPassword("999999");
        mapperAnno.updateUser(user);
    }

    @Test
    public void test4() {
        User user = mapperAnno.findOne(10);
        System.out.println(user);
    }

    @Test
    public void test5() {
        List<User> users = mapperAnno.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test6() {
        List<Order> orders = mapperAnno.orderInfo();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void test7() {
        List<User> userList = mapperAnno.userAndOrder();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test8() {
        List<User> userList = mapperAnno.userAndRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
