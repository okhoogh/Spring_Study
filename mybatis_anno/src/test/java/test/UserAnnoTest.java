package test;

import domain.User;
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
import java.util.Date;
import java.util.List;

public class UserAnnoTest {

    private static UserMapper userMapper;
    private static SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void end() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("987654");
        userMapper.save(user);
    }

    @Test
    public void testSelect1() {
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testSelect2() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        userMapper.delete(3);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        user.setPassword("987654");
        user.setBirthday(new Date());
        userMapper.update(user);
    }
}