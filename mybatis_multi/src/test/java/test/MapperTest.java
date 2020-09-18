package test;

import domain.Order;
import domain.User;
import mapper.OrderMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperTest {
    private static InputStream resourceAsStream;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    private static OrderMapper orderMapper;
    private static UserMapper userMapper;

    @Before
    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void end() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void test2() {
        List<User> userList = userMapper.findUserAndOrderAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() {
        List<User> userList = userMapper.findUserAndRoleAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
