package uni.eszterhazy.framework.development.dao;

import uni.eszterhazy.framework.development.dao.exceptions.BookAlreadyExistsException;
import uni.eszterhazy.framework.development.dao.exceptions.BookNotFoundException;
import uni.eszterhazy.framework.development.model.Author;
import uni.eszterhazy.framework.development.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class BookMemoryDAO implements BookDAO{

    private Collection<Book> database;

    public BookMemoryDAO(Collection<Book> database) {
        this.database = database;
    }

    public BookMemoryDAO() {
        this.database = Arrays.asList(
                new Book("isbn0","title0", new HashSet<Author>()),
                new Book("isbn1","title1", new HashSet<Author>())
        );
    }

    @Override
    public void createBook(Book book) throws BookAlreadyExistsException {
        if(this.database.contains(book)){
            throw new BookAlreadyExistsException();
        }
        this.database.add(book);
    }

    @Override
    public Collection<Book> readAllBooks() {
        return new ArrayList<>(this.database);
    }

    @Override
    public void updateBook(Book book) throws BookNotFoundException {

    }

    @Override
    public void deleteBook(Book book) throws BookNotFoundException {

    }
}
