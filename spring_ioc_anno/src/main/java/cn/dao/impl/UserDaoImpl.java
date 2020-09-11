package cn.dao.impl;

import cn.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userdao" class="cn.dao.impl.UserDaoImpl"></bean>
//@Component("userdao")
@Repository("userdao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
