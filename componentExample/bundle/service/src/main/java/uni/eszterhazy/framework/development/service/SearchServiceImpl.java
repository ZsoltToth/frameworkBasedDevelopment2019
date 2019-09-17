package uni.eszterhazy.framework.development.service;

import uni.eszterhazy.framework.development.api.SearchService;
import uni.eszterhazy.framework.development.api.exceptions.BookNotFoundException;
import uni.eszterhazy.framework.development.dao.BookDAO;
import uni.eszterhazy.framework.development.model.Author;
import uni.eszterhazy.framework.development.model.Book;

import java.util.ArrayList;
import java.util.Collection;

public class SearchServiceImpl implements SearchService {


    private BookDAO bookDAO;

    public SearchServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Collection<Book> listAllBooks() {
        return bookDAO.readAllBooks();
    }

    @Override
    public Collection<Book> listBooksOfAuthor(Author author) {
        Collection<Book> result = new ArrayList<Book>();
        for(Book book : bookDAO.readAllBooks()){
            if(book.getAuthors().contains(author)){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public Book findBookByISBN(String isbn) throws BookNotFoundException {
        for(Book book : bookDAO.readAllBooks()){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        throw new BookNotFoundException("No book was found with "+isbn+" isbn number");
    }
}
