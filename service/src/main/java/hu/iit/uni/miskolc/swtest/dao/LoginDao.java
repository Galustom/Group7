package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.dao.exceptions.PasswordEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.UsernameEntryNotFoundException;

public interface LoginDao {

    boolean searchUsername(String username) throws UsernameEntryNotFoundException;
    boolean readPassword(String password) throws PasswordEntryNotFoundException;
}
