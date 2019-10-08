package hu.uni.eszterhazy.framework.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SimpleConfig {

    @Bean
    public String welcome(){
        return "Hello World -- Simple Configuration";
    }
}
