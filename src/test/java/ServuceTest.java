import cn.baizhi.entity.User;
import cn.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServuceTest {

    @Test
    public void serviceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService us = (UserService) context.getBean("userService");
        List<User> users = us.selectAll(new User(null, null, null, null));
        for (User user : users) {
            System.out.println(user);
        }
    }
}
