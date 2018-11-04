package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class UserTest {

    private User user;
    private int id = 4556;
    private String username = "alamuszinyuszi";
    private String password = "password";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        this.user = new User(this.id,this.username,this.password);
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new User(this.id,this.username,this.password);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public  void testConstructorIllegalValues() {
        try {
            new User(this.id,null,null);
            new User(this.id,"",null);
            new User(this.id,null,"");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetID() {
        assertEquals(this.id, this.user.getId());
    }

    @Test
    public void testGetUsername() {
        assertEquals(this.username, this.user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals(this.password,this.user.getPassword());
    }
}
