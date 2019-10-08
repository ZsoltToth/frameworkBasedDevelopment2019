package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.api.ProductQueryService;
import hu.uni.eszterhazy.framework.api.ProductQueryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean(name = "productQueryService")
    public ProductQueryService productQueryService(){
        return new ProductQueryServiceImpl();
    }
}
