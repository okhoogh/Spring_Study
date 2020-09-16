package service;

import dao.UserMapper;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceDemo {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 查询所有User
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> all = mapper.findAll();
//        System.out.println(all);

        // 根据id进行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
    }
}
