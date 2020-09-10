package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUser() {
        System.out.println("动态工厂方法...");
        return new UserDaoImpl();
    }
}
