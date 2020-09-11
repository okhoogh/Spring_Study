package factory;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUser() {
        System.out.println("动态工厂方法...");
        return new UserDaoImpl();
    }
}
