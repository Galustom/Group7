package hu.iit.uni.miskolc.swtest.dao;

import hu.iit.uni.miskolc.swtest.dao.exceptions.PasswordEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.UsernameEntryNotFoundException;

public interface LoginDao {

    /**
     * Search User
     * @param username
     * @return
     * @throws UsernameEntryNotFoundException
     */
    boolean searchUsername(String username) throws UsernameEntryNotFoundException;

    /**
     * Search Password
     * @param password
     * @return
     * @throws PasswordEntryNotFoundException
     */
    boolean readPassword(String password) throws PasswordEntryNotFoundException;
}
