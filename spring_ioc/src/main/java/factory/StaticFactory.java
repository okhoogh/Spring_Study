package factory;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUser() {
        System.out.println("静态工厂方法...");
        return new UserDaoImpl();
    }
}
