import com.wxx.mybatis_protice.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Test {

    @org.junit.Test
    public void test1() throws IOException {
        User user = new User();
//        user.setId(1);
        user.setUsername("张三");
        user.setPassword("111111");

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        int i = sqlSession.insert("entityMapper.addUser", user);

        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        int i = sqlSession.delete("entityMapper.delUser", 1);

        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test2() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("111111");

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        int i = sqlSession.update("entityMapper.updateUser", user);

        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        List<User> userList = sqlSession.selectList("entityMapper.findAll");

        System.out.println(userList);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test5() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        User user = sqlSession.selectOne("entityMapper.findOne", 3);

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
