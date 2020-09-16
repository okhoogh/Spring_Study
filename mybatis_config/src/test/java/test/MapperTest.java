package test;

import dao.UserMapper;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {
    private static InputStream resourceAsStream;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    private static UserMapper mapper;

    @Before
    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void end() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {
        // 执行保存
        User user = new User();
        user.setUsername("amy");
        user.setPassword("996");
        user.setBirthday(new Date());

        mapper.save(user);
    }

    @Test
    public void test2() {
        User user = mapper.findById(8);
        System.out.println(user);
    }
}
