package hu.uni.eszterhazy.framework;

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
//        System.out.println( "Hello World!" );
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository){
        return (args) -> {
            System.out.println("Hello");
            customerRepository.save(new Customer("John", "Doe"));
            customerRepository.save(new Customer("Jane", "Doe"));

            System.out.println(customerRepository.findAll());
        };
    }
}
