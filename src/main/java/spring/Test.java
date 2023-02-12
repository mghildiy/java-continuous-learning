package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.beans.UserDAO;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);

        var userDAO = ac.getBean(UserDAO.class);
        System.out.println(userDAO.getUser());
    }
}
