package uni.eszterhazy.framework.development.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.framework.development.controller.BookSearchController;
import uni.eszterhazy.framework.development.dao.BookMemoryDAO;
import uni.eszterhazy.framework.development.service.SearchServiceImpl;

@Configuration
public class BookWebAppConfig {

    @Bean(name = "bookSearchController")
    public BookSearchController bookSearchController(){
        return new BookSearchController(
                new SearchServiceImpl(
                        new BookMemoryDAO()
                ));
    }
}
