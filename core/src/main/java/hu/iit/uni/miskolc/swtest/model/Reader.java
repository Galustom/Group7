package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

public class Reader {

    private int id;
    private String username;
    private String password;
    private Collection<Book> borrowings;

    public Reader(int id, String username, String password, Collection<Book> borrowings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.borrowings = borrowings;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<Book> getBorrowings() {
        return borrowings;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", borrowings=" + borrowings +
                '}';
    }
}
