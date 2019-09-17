package uni.eszterhazy.framework.development.api;

import uni.eszterhazy.framework.development.api.exceptions.BookNotFoundException;
import uni.eszterhazy.framework.development.model.Author;
import uni.eszterhazy.framework.development.model.Book;

import java.util.Collection;

public interface SearchService {

    Collection<Book> listAllBooks();
    Collection<Book> listBooksOfAuthor(Author author);

    Book findBookByISBN(String isbn) throws BookNotFoundException;
}
