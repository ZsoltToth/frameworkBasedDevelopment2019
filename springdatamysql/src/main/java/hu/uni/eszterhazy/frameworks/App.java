package hu.uni.eszterhazy.frameworks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository){
        return (args) ->{
//        productRepository.save(new Product("Teapot", 1.5));
            System.out.println(productRepository.findAll());
        };
    }
}
