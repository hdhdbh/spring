package aopdemo;

import aopdemo.entity.User;
import aopdemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("apodemo.xml");
        User user = new User("凤姐", "123456");
        UserService s = (UserService) ctx.getBean("userService");
        s.addUser(user);
    }
}
