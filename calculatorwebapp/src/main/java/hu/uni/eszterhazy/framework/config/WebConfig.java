package hu.uni.eszterhazy.framework.config;

import hu.uni.eszterhazy.framework.api.Calculator;
import hu.uni.eszterhazy.framework.api.CalculatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Calculator calculator(){
        return new CalculatorImpl();
    }
}
