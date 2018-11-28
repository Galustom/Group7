package hu.iit.uni.miskolc.swtest.model;

import hu.iit.uni.miskolc.swtest.exceptions.RequestsAreNullException;

import java.util.Collection;
import java.util.Objects;

public class Librarian extends User {

    private Collection<Request> requests;

    public Librarian(int id, String username, String password, Collection<Request> requests) {
        super(id, username, password);
        this.requests = requests;
    }

    public Collection<Request> getRequests() {
        return requests;
    }

    public void setRequests(Collection<Request> requests) throws RequestsAreNullException {
        if (requests == null)
            throw new RequestsAreNullException();
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "requests=" + requests +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return requests.equals(librarian.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requests);
    }
}
