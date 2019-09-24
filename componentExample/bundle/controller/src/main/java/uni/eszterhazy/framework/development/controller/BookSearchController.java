package uni.eszterhazy.framework.development.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uni.eszterhazy.framework.development.api.SearchService;
import uni.eszterhazy.framework.development.model.Book;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class BookSearchController {

    private SearchService searchService;

    public BookSearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/books", produces = "application/json")
    @ResponseBody
    public Collection<BookDTO> listBooks(){
        Collection<BookDTO> result = new ArrayList<BookDTO>();
        for(Book book : searchService.listAllBooks()){
            BookDTO dto = new BookDTO();
            dto.setIsbn(book.getIsbn());
            dto.setTitle(book.getTitle());
            result.add(dto);
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }
}
