package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.UserMapper;
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

//    @After
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

        end();
    }

    @Test
    public void test2() {
        User user = mapper.findById(8);
        System.out.println(user);
    }

    @Test
    public void test3() {
        // 设置分页相关参数      当前页  +  每页显示的条数
        PageHelper.startPage(1, 3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        // 获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示条数:" + pageInfo.getPageSize());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("上一页:" + pageInfo.getPrePage());
        System.out.println("下一页:" + pageInfo.getNextPage());
        System.out.println("是否是第一页:" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());
    }
}
