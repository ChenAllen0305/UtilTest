package AOP;

import AOP.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: run
 * @Author
 * @Date: 2021/4/8
 */
public class run {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("proxyFactoryBean");
        userService.selectUser();
    }
}
