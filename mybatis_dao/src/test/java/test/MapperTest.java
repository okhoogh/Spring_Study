package test;

import dao.UserMapper;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void test1() {
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
//        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);

        List<User> users = mapper.findByIds(ids);
        System.out.println(users);
    }
}
