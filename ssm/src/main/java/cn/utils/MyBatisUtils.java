package cn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
//    private static SqlSessionFactory sessionFactory;
//
//    static {
//        InputStream resourceAsStream = null;
//        try {
//            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//    }
//
//    public static SqlSession getSqlSession() {
//        return sessionFactory.openSession();
//    }
}
