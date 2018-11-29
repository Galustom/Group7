package hu.iit.uni.miskolc.swtest.model;

import hu.iit.uni.miskolc.swtest.model.exceptions.IdNotValidException;
import hu.iit.uni.miskolc.swtest.model.exceptions.PasswordIsEmptyException;
import hu.iit.uni.miskolc.swtest.model.exceptions.UsernameIsEmptyException;

public class User {

    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) throws IdNotValidException {
        if (id <= 0)
            throw new IdNotValidException();
        this.id = id;
    }

    public void setUsername(String username) throws UsernameIsEmptyException {
        if (username.equals(""))
            throw new UsernameIsEmptyException();
        this.username = username;
    }

    public void setPassword(String password) throws PasswordIsEmptyException {
        if (password.equals(""))
            throw new PasswordIsEmptyException();
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
