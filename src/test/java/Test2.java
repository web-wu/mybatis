import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxx.mybatis_protice.dao.OrderMapper;
import com.wxx.mybatis_protice.dao.UserDao;
import com.wxx.mybatis_protice.entity.Order;
import com.wxx.mybatis_protice.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test2 {
    private User user = new User();
    private Order order = new Order();

    @Test
    public void getUserList() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();

        PageHelper.startPage(2, 2);
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.getUserList();

        for (User user1 : userList) {
            System.out.println(user1);
        }

        PageInfo<User> pageInfo = new PageInfo<>(userList);

        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        sqlSession.close();
    }

    @Test
    public void addUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);


        user.setUsername("kkkkk");
        user.setPassword("111111");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.addUser(user);

        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void getUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);


        user.setUsername("kkkkk");
        user.setPassword("111111");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUser(this.user);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        int[] ids = {2, 5, 7};
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUserById(ids);

        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void addOrder() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        order.setId(4);
        order.setOrdertime("2021-05-24");
        order.setTotal(5000.0);

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int i = orderMapper.addOrder(order);

        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void getOrder() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.getOrderList();
        for (Order order1 : orders) {
            System.out.println(order1);
        }
        sqlSession.close();
    }

    @Test
    public void getUSerInfor() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userInfo = userDao.getUserInfo();
        for (User user1 : userInfo) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
}
