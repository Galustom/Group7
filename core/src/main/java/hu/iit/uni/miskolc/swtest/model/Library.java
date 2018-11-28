package hu.iit.uni.miskolc.swtest.model;

import hu.iit.uni.miskolc.swtest.exceptions.BookListNullException;
import hu.iit.uni.miskolc.swtest.exceptions.IdNotValidException;
import hu.iit.uni.miskolc.swtest.exceptions.NameIsEmptyException;

import java.util.Collection;

public class Library {

    private int id;
    private String name;
    private Collection<Book> BookList;

    public Library(int id, String name, Collection<Book> bookList) {
        this.id = id;
        this.name = name;
        BookList = bookList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getBookList() {
        return BookList;
    }

    public void setId(int id) throws IdNotValidException {
        if (id <= 0)
            throw new IdNotValidException();
        this.id = id;
    }

    public void setName(String name) throws NameIsEmptyException {
        if (name.equals(""))
            throw new NameIsEmptyException();
        this.name = name;
    }

    public void setBookList(Collection<Book> bookList) throws BookListNullException {
        if (bookList == null)
            throw new BookListNullException();
        BookList = bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BookList=" + BookList +
                '}';
    }
}
