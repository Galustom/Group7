package hu.iit.uni.miskolc.swtest.model;

import java.util.Collection;

public class Librarian extends User {

    private Collection<Request> requests;

    public Librarian(int id, String username, String password, Collection<Request> requests) {
        super(id, username, password);
        this.requests = requests;
    }

    public Collection<Request> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "requests=" + requests +
                '}';
    }
}
