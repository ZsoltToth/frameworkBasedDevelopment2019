package uni.eszterhazy.framework.development.model;

import java.util.Set;

public class Book {

    private String isbn;
    private String title;
    private Set<Author> authors;

    public Book(String isbn, String title, Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
