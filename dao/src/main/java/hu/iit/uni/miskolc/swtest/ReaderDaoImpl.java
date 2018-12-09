package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.ReaderDao;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static hu.iit.uni.miskolc.swtest.BookDaoImpl.ReadAllBook;
import static hu.iit.uni.miskolc.swtest.RequestDaoImpl.ReadAllRequest;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public Collection<Book> ListBooks() {
        List<String[]> stringBooks = ReadAllBook();
        List<Book> Books = new ArrayList<>();
        for (int i=0; i<stringBooks.size(); i++){
            Books.add(new Book(
                    Integer.parseInt(stringBooks.get(i)[0]),
                    stringBooks.get(i)[1],
                    stringBooks.get(i)[2],
                    stringBooks.get(i)[3],
                    stringBooks.get(i)[4],
                    stringBooks.get(i)[5],
                    Integer.parseInt(stringBooks.get(i)[6]),
                    Integer.parseInt(stringBooks.get(i)[7])
            ));
        }
        return Books;
    }

    @Override
    public Collection<Book> ListAvailableBooks() {
        List<String[]> stringBooks = ReadAllBook();
        List<Book> Books = new ArrayList<>();
        List<Book> AvailableBooks = new ArrayList<>();
        for (int i=0; i<stringBooks.size(); i++){
            Books.add(new Book(
                    Integer.parseInt(stringBooks.get(i)[0]),
                    stringBooks.get(i)[1],
                    stringBooks.get(i)[2],
                    stringBooks.get(i)[3],
                    stringBooks.get(i)[4],
                    stringBooks.get(i)[5],
                    Integer.parseInt(stringBooks.get(i)[6]),
                    Integer.parseInt(stringBooks.get(i)[7])
            ));
        }

        for (Book bookItem : Books) {
            if (bookItem.getAvailable()>0)
            {AvailableBooks.add(bookItem);}
        }
        
        return AvailableBooks;
    }

    @Override
    public void RequestBook(Request request, Book book, Reader reader) {
        //TODO IMPLEMENT THIS
        Request newRequest = new Request(request.getId(), book.getId(),reader.getId());
    }

    @Override
    public Collection<Book> ListBorrowings(Reader reader) {
        return reader.getBorrowings().getBorrowedBooks();
    }
}
