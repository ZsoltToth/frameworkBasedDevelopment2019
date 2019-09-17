package uni.eszterhazy.framework.development.dao;

import uni.eszterhazy.framework.development.dao.exceptions.BookAlreadyExistsException;
import uni.eszterhazy.framework.development.dao.exceptions.BookNotFoundException;
import uni.eszterhazy.framework.development.model.Book;

import java.util.Collection;

public interface BookDAO {

    void createBook(Book book) throws BookAlreadyExistsException;

    Collection<Book> readAllBooks();

    void updateBook(Book book) throws BookNotFoundException;

    void deleteBook(Book book) throws BookNotFoundException;
}
