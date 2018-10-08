package hu.iit.uni.miskolc.swtest.service;

import hu.iit.uni.miskolc.swtest.dao.LoginDaoInterface;
import hu.iit.uni.miskolc.swtest.dao.exceptions.PasswordEntryNotFoundException;
import hu.iit.uni.miskolc.swtest.dao.exceptions.UsernameEntryNotFoundException;

public class LoginManagerImpl implements LoginManagerInterface {

    LoginDaoInterface loginDao;

    public LoginManagerImpl(LoginDaoInterface loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public boolean authenticate(String username, String password) {
        try{
            loginDao.searchUsername(username);
            loginDao.readPassword(password);
            return true;
        }catch (UsernameEntryNotFoundException e){
            return false;
        }catch (PasswordEntryNotFoundException ex){
            return false;
        }
    }
}
