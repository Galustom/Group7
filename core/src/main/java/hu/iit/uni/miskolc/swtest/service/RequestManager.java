package hu.iit.uni.miskolc.swtest.service;
import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.*;
import java.util.Date;
import java.util.Collection;

public interface RequestManager {

    public void setRequest(Book book, Reader reader);

    public void approve (int requestId, Date date);

    public void setRequestedBooks(Collection<Book> requestedBooks);
}
