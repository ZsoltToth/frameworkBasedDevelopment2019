package hu.uni.eszterhazy.framework.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public String welcome(){
        return "Hello World";
    }
}
