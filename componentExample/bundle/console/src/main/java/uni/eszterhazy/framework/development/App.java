package uni.eszterhazy.framework.development;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uni.eszterhazy.framework.development.controller.BookSearchController;

import java.io.Console;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConsoleAppConfiguration.class);
        System.out.println( "Hello World!" );
        BookSearchController controller = (BookSearchController) context.getBean("bookSearchController");
        System.out.println(controller.listBooks());
    }
}
