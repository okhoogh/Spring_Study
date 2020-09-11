package cn.service.impl;

import cn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import cn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userservice" class="cn.cn.service.impl.UserServiceImpl">
//@Component
@Service
//@Scope("singleton")
@Scope("prototype")
public class UserServiceImpl implements UserService {
//    @Autowired  // 按照数据类型从Spring容器中进行匹配的(可以单独使用)
//    @Qualifier("userdao")   // 按照id值从容器中进行匹配的但是主要此处@Qualifier结合(必须和@Autowired一起使用)
    @Resource(name = "userdao") //@Resource相当于@Qualifier + @Autowired
    private UserDao userDao;

    @Value("${jdbc.driver}")
    private String driver;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("UserService对象初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserService对象销毁...");
    }
}
