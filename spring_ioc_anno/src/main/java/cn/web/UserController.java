package cn.web;

import cn.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.service.UserService;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
//        app.close();
    }
}
