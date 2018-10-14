package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.BookEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.model.Book;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl implements BookDaoInterface{

    @Override
    public void createBook(Book book) throws BookEntryAlreadyAddedException {
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

        if(Books.contains(book)){
            throw new BookEntryAlreadyAddedException();
        }
        else{
            Books.add(book);
            StringBooks.add(new String[]{
                    Integer.toString(book.getId()),
                    book.getName(),
                    book.getGenre(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getIsbn(),
                    Integer.toString(book.getQuantity()),
                    Integer.toString(book.getAvailable())
            });
            WriteAllBook(StringBooks);
        }
    }

    @Override
    public Collection<Book> readBooks() {
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
    public void updateBook(Book book) throws BookEntryNotFoundException {

    }

    @Override
    public void deleteBook(Book book) throws BookEntryNotFoundException {

    }

    private static List<String[]> ReadAllBook() {
        List<String[]> Books = null;
        String id, name, genre, author, publisher, isbn, quantity, available;
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("StoredBooks.xml");
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

                Books.add(currentBook);
            }
        } catch (ParserConfigurationException pce) {
            //Determine what to do here!
        } catch (SAXException se) {
            //Determine what to do here!
        } catch (IOException ioe) {
            //Determine what to do here!
        }

        return Books;
    }

    private static void WriteAllBook(List<String[]> Books) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rooroot = dom.createElement("books");

            for (int i = 0; i < Books.size(); i++) {
                Element rootEle = dom.createElement("book");
                Element e = null;
                e = dom.createElement("id");
                e.appendChild(dom.createTextNode(Books.get(i)[0]));
                rootEle.appendChild(e);
                e = dom.createElement("name");
                e.appendChild(dom.createTextNode(Books.get(i)[1]));
                rootEle.appendChild(e);
                e = dom.createElement("genre");
                e.appendChild(dom.createTextNode(Books.get(i)[2]));
                rootEle.appendChild(e);
                e = dom.createElement("author");
                e.appendChild(dom.createTextNode(Books.get(i)[3]));
                rootEle.appendChild(e);
                e = dom.createElement("publisher");
                e.appendChild(dom.createTextNode(Books.get(i)[4]));
                rootEle.appendChild(e);
                e = dom.createElement("isbn");
                e.appendChild(dom.createTextNode(Books.get(i)[5]));
                rootEle.appendChild(e);
                e = dom.createElement("quantity");
                e.appendChild(dom.createTextNode(Books.get(i)[6]));
                rootEle.appendChild(e);
                e = dom.createElement("available");
                e.appendChild(dom.createTextNode(Books.get(i)[7]));
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
                tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream("StoredBooks.xml")));
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
