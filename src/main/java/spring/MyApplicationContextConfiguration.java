package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.beans.AnotherDummyDataSource;
import spring.beans.DataSource;
import spring.beans.DummyDataSource;

@Configuration
@ComponentScan
public class MyApplicationContextConfiguration {

    //@Bean
    public DataSource dummyDataSource() {  // (2)
        DataSource dataSource = new DummyDataSource();
        return dataSource;
    }

    @Bean
    public DataSource anotherDummyDataSource() {  // (2)
        DataSource dataSource = new AnotherDummyDataSource();
        return dataSource;
    }
}
