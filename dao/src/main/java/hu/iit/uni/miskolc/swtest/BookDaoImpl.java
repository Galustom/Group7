package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.BookDao;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;
import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public void createBook(Book book) throws BookEntryAlreadyAddedException {
        Collection<Book> books = readAllBook();
        List<String> bookIsbns = new ArrayList<>();

        for (Book currentBook : books) {
            bookIsbns.add(currentBook.getIsbn());
        }
        if (bookIsbns.contains(book.getIsbn())) {
            throw new BookEntryAlreadyAddedException();
        }
        books.add(book);

        writeAllBook(books);
    }

    @Override
    public Collection<Book> readBooks() {
        Collection<Book> books =  readAllBook();

        return books;
    }

    @Override
    public void updateBook(Book book) throws BookEntryNotFoundException, IdNotValidException {
        Collection<Book> books = readAllBook();

        Book currentBook = books.stream().filter((Book)->book.getIsbn()==book.getIsbn()).findFirst().orElse(null);
        if (currentBook!=null)
        {
            book.setId(currentBook.getId());
            books.remove(currentBook);
            books.add(book);

            writeAllBook(books);
        }
        else{
            throw new BookEntryNotFoundException();
        }
    }

    @Override
    public void deleteBook(Book book) throws BookEntryNotFoundException {
        Collection<Book> books = new ArrayList<>();

        if(!books.contains(book)){
            throw new BookEntryNotFoundException();
        }
        else {
            books.remove(book);
        }
        writeAllBook(books);
    }

    /**
     * Return with a Collection of books
     * @return Return with a Collection of books
     */
    public static Collection<Book> readAllBook() {
        List<String[]> stringBooks = new ArrayList<>();
        //Start of Current
        List<Book> books = new ArrayList<>();
        //End of Current
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            InputStream is = new FileInputStream("StoredBooks.xml");
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(is);
            NodeList nodeList = dom.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String[] currentBook = new String[8];
                currentBook[0] = element.getElementsByTagName("id").item(0).getTextContent();
                currentBook[1] = element.getElementsByTagName("name").item(0).getTextContent();
                currentBook[2] = element.getElementsByTagName("genre").item(0).getTextContent();
                currentBook[3] = element.getElementsByTagName("author").item(0).getTextContent();
                currentBook[4] = element.getElementsByTagName("publisher").item(0).getTextContent();
                currentBook[5] = element.getElementsByTagName("isbn").item(0).getTextContent();
                currentBook[6] = element.getElementsByTagName("quantity").item(0).getTextContent();
                currentBook[7] = element.getElementsByTagName("available").item(0).getTextContent();

                stringBooks.add(currentBook);
            }
            // Start of Current modification
            for (int i=0; i<stringBooks.size(); i++){
                books.add(new Book(
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
            //End of Current modification
        } catch (ParserConfigurationException pce) {
            //Determine what to do here!
        } catch (SAXException se) {
            //Determine what to do here!
        } catch (IOException ioe) {
            //Determine what to do here!
        }

        return books;
    }

    /**
     * Write the whole XML with the new Books
     * @param books
     */
    private static void writeAllBook(Collection<Book> books) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rooroot = dom.createElement("books");

            for (Book book: books) {
                Element rootEle = dom.createElement("book");
                Element e = null;
                e = dom.createElement("id");
                e.appendChild(dom.createTextNode(""+book.getId()));
                e = dom.createElement("name");
                e.appendChild(dom.createTextNode(book.getGenre()));
                e = dom.createElement("author");
                e.appendChild(dom.createTextNode(book.getAuthor()));
                e = dom.createElement("publisher");
                e.appendChild(dom.createTextNode(book.getPublisher()));
                e = dom.createElement("isbn");
                e.appendChild(dom.createTextNode(book.getIsbn()));
                e = dom.createElement("quantity");
                e.appendChild(dom.createTextNode(""+book.getQuantity()));
                e = dom.createElement("available");
                e.appendChild(dom.createTextNode(""+book.getAvailable()));
                rootEle.appendChild(e);
                rooroot.appendChild(rootEle);
            }
            dom.appendChild(rooroot);
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-2");
                tr.setOutputProperty("{http://xml.apache.org/xslt} indent-amount", "4");
                FileOutputStream fos = new FileOutputStream("StoredBooks.xml");
                tr.transform(new DOMSource(dom), new StreamResult(fos));
                fos.close();
            } catch (TransformerException te) {
                //Determine what to do here!
            } catch (IOException ioe) {
                //Determine what to do here!
            }
        } catch (ParserConfigurationException pce) {
            //Determine what to do here!
        }

    }


}
