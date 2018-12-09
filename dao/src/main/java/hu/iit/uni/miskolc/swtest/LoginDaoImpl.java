package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.dao.LoginDao;
import hu.iit.uni.miskolc.swtest.dao.exceptions.PasswordEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.UsernameEntryNotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean searchUsername(String username) throws UsernameEntryNotFoundException {
        List<String[]> stringUsers = readAllUser();

        for (int i=0; i<stringUsers.size(); i++)
        {
            if(stringUsers.get(i)[1].equals(username))
            {
                return true;
            }
        }

        throw new UsernameEntryNotFoundException();
    }

    @Override
    public boolean readPassword(String password) throws PasswordEntryNotFoundException
    {
        List<String[]> stringUsers = readAllUser();

        for (int i=0; i<stringUsers.size(); i++)
        {
            if(stringUsers.get(i)[2].equals(password))
            {
                return true;
            }
        }

        throw new PasswordEntryNotFoundException();
    }

    private static List<String[]> readAllUser()
    {
        List<String[]> users = new ArrayList<>();
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("StoredUsers.xml");
            NodeList nodeList = dom.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String[] currentUser = new String[3];

                currentUser[0] = element.getElementsByTagName("id").item(0).getTextContent();
                currentUser[1] = element.getElementsByTagName("username").item(0).getTextContent();
                currentUser[2] = element.getElementsByTagName("password").item(0).getTextContent();

                users.add(currentUser);
            }
        } catch (ParserConfigurationException pce)
        {
            //Determine what to do here!
        } catch (SAXException se)
        {
            //Determine what to do here!
        } catch (IOException ioe)
        {
            //Determine what to do here!
        }

        return users;
    }
}
