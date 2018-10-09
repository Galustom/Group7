package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

public class Librarian extends User {

    private Collection<Book> requests;

    public Librarian(int id, String username, String password, Collection<Book> requests) {
        super(id, username, password);
        this.requests = requests;
    }

    public Collection<Book> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "requests=" + requests +
                '}';
    }
}
