package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private DataSource dataSource;

    /*Autowired annotation not required for constructor based DI post spring 4.2*/
    public UserDAO(@Autowired DataSource ds) {
        this.dataSource = ds;
    }

    public String getUser() {
        return this.dataSource.get();
    }
}
