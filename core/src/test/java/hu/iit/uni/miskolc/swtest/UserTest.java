package hu.iit.uni.miskolc.swtest;

import hu.iit.uni.miskolc.swtest.model.User;
import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;
import hu.iit.uni.miskolc.swtest.model.exceptions.PasswordIsEmptyException;
import hu.iit.uni.miskolc.swtest.model.exceptions.UsernameIsEmptyException;
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
        this.user = new User(this.id, this.username, this.password);
    }

    @Test
    public void testConstructorLegalValues() {
        try {
            new User(this.id, this.username, this.password);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorIllegalValues() {
        try {
            new User(this.id, null, null);
            new User(this.id, "", null);
            new User(this.id, null, "");
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
        assertEquals(this.password, this.user.getPassword());
    }

    @Test
    public void testSetID() throws IdNotValidException {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test(expected = IdNotValidException.class)
    public void testSetInvalidID() throws IdNotValidException {
        user.setId(-1);
    }

    @Test
    public void testSetUsername() throws UsernameIsEmptyException {
        user.setUsername("testName");
        assertEquals("testName", user.getUsername());
    }

    @Test(expected = UsernameIsEmptyException.class)
    public void testSetEmptyUsername() throws UsernameIsEmptyException {
        user.setUsername("");
    }

    @Test
    public void testSetPassword() throws PasswordIsEmptyException {
        user.setPassword("pass");
        assertEquals("pass", user.getPassword());
    }

    @Test(expected = PasswordIsEmptyException.class)
    public void testSetEmptyPassword() throws PasswordIsEmptyException {
        user.setPassword("");
    }
}
