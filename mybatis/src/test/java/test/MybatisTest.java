package test;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     * select
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：命名空间 + id
        List<User> list = sqlSession.selectList("userMapper.findAll");
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
    }

    /**
     * insert
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：命名空间 + id

        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");

        sqlSession.insert("userMapper.save", user);

        // mybatis执行更新操作 提交事务
        sqlSession.commit();
        // 为什么id会加2，因为提交事务之前已经insert一次，id已自增过一次

        // 释放资源
        sqlSession.close();
    }

    /**
     * update
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：命名空间 + id

        User user = new User();
        user.setId(6);
        user.setUsername("lucy");
        user.setPassword("123");

        sqlSession.update("userMapper.update", user);

        // mybatis执行更新操作 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    /**
     * delete
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：命名空间 + id

        sqlSession.delete("userMapper.delUser", 6);

        // mybatis执行更新操作 提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    /**
     * select by id
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：命名空间 + id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        System.out.println(user);

        // 释放资源
        sqlSession.close();
    }
}
