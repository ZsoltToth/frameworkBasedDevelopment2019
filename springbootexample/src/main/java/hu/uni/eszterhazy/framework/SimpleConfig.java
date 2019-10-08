package hu.uni.eszterhazy.framework;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SimpleConfig {

    @Bean
    public String wellcome(){
        return "Hello World";
    }
}
