package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.ReaderDaoInterface;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.Reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static hu.iit.uni.miskolc.swtest.BookDaoImpl.ReadAllBook;

public class ReaderDaoImpl implements ReaderDaoInterface {

    @Override
    public Collection<Book> listBooks() {
        List<String[]> StringBooks = ReadAllBook();
        List<Book> Books = new ArrayList<>();
        for (int i=0; i<StringBooks.size(); i++){
            Books.add(new Book(
                    Integer.parseInt(StringBooks.get(i)[0]),
                    StringBooks.get(i)[1],
                    StringBooks.get(i)[2],
                    StringBooks.get(i)[3],
                    StringBooks.get(i)[4],
                    StringBooks.get(i)[5],
                    Integer.parseInt(StringBooks.get(i)[6]),
                    Integer.parseInt(StringBooks.get(i)[7])
            ));
        }
        return Books;
    }

    @Override
    public Collection<Book> listAvailableBooks() {
        List<String[]> StringBooks = ReadAllBook();
        List<Book> Books = new ArrayList<>();
        List<Book> AvailableBooks = new ArrayList<>();
        for (int i=0; i<StringBooks.size(); i++){
            Books.add(new Book(
                    Integer.parseInt(StringBooks.get(i)[0]),
                    StringBooks.get(i)[1],
                    StringBooks.get(i)[2],
                    StringBooks.get(i)[3],
                    StringBooks.get(i)[4],
                    StringBooks.get(i)[5],
                    Integer.parseInt(StringBooks.get(i)[6]),
                    Integer.parseInt(StringBooks.get(i)[7])
            ));
        }

        for (Book bookItem : Books) {
            if (bookItem.getAvailable()>0)
            {AvailableBooks.add(bookItem);}
        }
        
        return AvailableBooks;
    }

    @Override
    public void requestBook(Book book) {

    }

    @Override
    public Collection<Book> listBorrowings(Reader reader) {
        return null;
    }
}
