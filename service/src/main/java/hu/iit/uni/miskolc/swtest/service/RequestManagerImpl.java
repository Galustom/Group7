package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.RequestDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;
import java.util.Date;

public class RequestManagerImpl implements RequestManager {

    private RequestDao requestDao;
    @Override
    public void setRequest(Book book, Reader reader) {

    }

    @Override
    public void approve(int requestId, Date date) {
        Request requestBook = requestDao.GetRequest(requestId);
        requestBook.setApprove(true);
        requestBook.setApprovalLibrarianId(1); //Need to implement getCurrentLibrarian()
    }

    @Override
    public void setRequestedBooks(Collection<Book> requestedBooks) {
    }
}
