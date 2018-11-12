package hu.iit.uni.miskolc.swtest.model;

import java.util.Objects;

public class Book {

    private int id;
    private String name;
    private String genre;
    private String author;
    private String publisher;
    private String isbn;
    private int quantity;
    private int available;

    public Book(int id, String name, String genre, String author, String publisher, String isbn, int quantity, int available) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.quantity = quantity;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                ", available=" + available +
                '}';
    }

    public Boolean validate(){
        return getAvailable() >= 0 && getQuantity() >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                quantity == book.quantity &&
                available == book.available &&
                name.equals(book.name) &&
                genre.equals(book.genre) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher) &&
                isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, author, publisher, isbn, quantity, available);
    }
}
