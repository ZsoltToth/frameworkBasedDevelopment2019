package hu.uni.eszterhazy.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{

    @Autowired
    private ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
//        System.out.println( "Hello World!" );
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(context);
//        for (String beanName :context.getBeanDefinitionNames()){
//            System.out.println(beanName + " => " + context.getBean(beanName).getClass().getName());
//        }
        System.out.println(context.getBean("welcome"));
    }
}
