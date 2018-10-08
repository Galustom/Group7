package hu.iit.uni.miskolc.swtest.model;

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

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BookList=" + BookList +
                '}';
    }
}
