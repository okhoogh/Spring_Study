package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUser() {
        System.out.println("静态工厂方法...");
        return new UserDaoImpl();
    }
}
