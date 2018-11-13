package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.RequestDao;
import hu.iit.uni.miskolc.swtest.model.Request;
import hu.iit.uni.miskolc.swtest.dao.exceptions.RequestEntryAlreadyAddedException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class RequestDaoImpl implements RequestDao {

    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); //String format for conversion

    @Override
    public Collection<Request> readRequests() {
        List<String[]> StringRequests = ReadAllRequest();
        List<Request> Requests = new ArrayList<>();
        try {
            for (int i = 0; i < StringRequests.size(); i++) {
                Requests.add(new Request(
                        Integer.parseInt(StringRequests.get(i)[0]),
                        Integer.parseInt(StringRequests.get(i)[1]),
                        Integer.parseInt(StringRequests.get(i)[2]),
                        format.parse(StringRequests.get(i)[3]),
                        Boolean.parseBoolean(StringRequests.get(i)[4]),
                        Integer.parseInt(StringRequests.get(i)[5]),
                        format.parse(StringRequests.get(i)[6]),
                        Boolean.parseBoolean(StringRequests.get(i)[7]),
                        Boolean.parseBoolean(StringRequests.get(i)[8])
                ));
            }
        }
        catch (Exception e)
        {}
        return Requests;
    }

    @Override
    public void createRequest(Request request) throws RequestEntryAlreadyAddedException {
        List<String[]> StringRequests = ReadAllRequest();
        List<Request> Requests = new ArrayList<>();
        try {
            for (int i = 0; i < StringRequests.size(); i++) {
                Requests.add(new Request(
                        Integer.parseInt(StringRequests.get(i)[0]),
                        Integer.parseInt(StringRequests.get(i)[1]),
                        Integer.parseInt(StringRequests.get(i)[2]),
                        format.parse(StringRequests.get(i)[3]),
                        Boolean.parseBoolean(StringRequests.get(i)[4]),
                        Integer.parseInt(StringRequests.get(i)[5]),
                        format.parse(StringRequests.get(i)[6]),
                        Boolean.parseBoolean(StringRequests.get(i)[7]),
                        Boolean.parseBoolean(StringRequests.get(i)[8])
                ));
            }

            for (int i = 0; i < Requests.size(); i++){
                if(Requests.get(i).getId()==request.getId()){
                    throw new RequestEntryAlreadyAddedException();
                }
            }

            Requests.add(request);
            StringRequests.add(new String[]{
                    Integer.toString(request.getId()),
                    Integer.toString(request.getBookId()),
                    Integer.toString(request.getReaderId()),
                    format.format(request.getRequestDate()),
                    String.valueOf(request.isApprove()),
                    Integer.toString(request.getApprovalLibrarianId()),
                    format.format(request.getDeadline()),
                    String.valueOf(request.isReturned()),
                    String.valueOf(request.isActive())
            });
            WriteAllRequest(StringRequests);
        }
        catch (Exception e)
        {}
    }

    public static List<String[]> ReadAllRequest() {
        List<String[]> Requests = new ArrayList<>();
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("StoredRequests.xml");
            NodeList nodeList = dom.getElementsByTagName("request");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String[] currentRequest = new String[9];

                currentRequest[0] = element.getElementsByTagName("id").item(0).getTextContent();
                currentRequest[1] = element.getElementsByTagName("bookId").item(0).getTextContent();
                currentRequest[2] = element.getElementsByTagName("readerId").item(0).getTextContent();
                currentRequest[3] = element.getElementsByTagName("requestDate").item(0).getTextContent();
                currentRequest[4] = element.getElementsByTagName("approve").item(0).getTextContent();
                currentRequest[5] = element.getElementsByTagName("approvalLibrarianId").item(0).getTextContent();
                currentRequest[6] = element.getElementsByTagName("deadline").item(0).getTextContent();
                currentRequest[7] = element.getElementsByTagName("returned").item(0).getTextContent();
                currentRequest[8] = element.getElementsByTagName("active").item(0).getTextContent();

                Requests.add(currentRequest);
            }
        } catch (ParserConfigurationException pce) {
            //Determine what to do here!
        } catch (SAXException se) {
            //Determine what to do here!
        } catch (IOException ioe) {
            //Determine what to do here!
        }
        return Requests;
    }

    private static void WriteAllRequest(List<String[]> Requests) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rooroot = dom.createElement("requests");

            for (int i = 0; i < Requests.size(); i++) {
                Element rootEle = dom.createElement("request");
                Element e = null;
                e = dom.createElement("id");
                e.appendChild(dom.createTextNode(Requests.get(i)[0]));
                rootEle.appendChild(e);
                e = dom.createElement("bookId");
                e.appendChild(dom.createTextNode(Requests.get(i)[1]));
                rootEle.appendChild(e);
                e = dom.createElement("readerId");
                e.appendChild(dom.createTextNode(Requests.get(i)[2]));
                rootEle.appendChild(e);
                e = dom.createElement("requestDate");
                e.appendChild(dom.createTextNode(Requests.get(i)[3]));
                rootEle.appendChild(e);
                e = dom.createElement("approve");
                e.appendChild(dom.createTextNode(Requests.get(i)[4]));
                rootEle.appendChild(e);
                e = dom.createElement("approvalLibrarianId");
                e.appendChild(dom.createTextNode(Requests.get(i)[5]));
                rootEle.appendChild(e);
                e = dom.createElement("deadline");
                e.appendChild(dom.createTextNode(Requests.get(i)[6]));
                rootEle.appendChild(e);
                e = dom.createElement("returned");
                e.appendChild(dom.createTextNode(Requests.get(i)[7]));
                rootEle.appendChild(e);
                e = dom.createElement("active");
                e.appendChild(dom.createTextNode(Requests.get(i)[8]));
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
                FileOutputStream fos = new FileOutputStream("StoredRequests.xml");
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

    @Override
    public  Request GetRequest(final int requestId) {
        Collection<Request> Requests = readRequests();

        Request request = Requests.stream().filter((req)-> req.getId() == requestId).findFirst().orElse(null);


        return request ;
    }
}
