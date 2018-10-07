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
    public boolean authUsername(String username) {
        try {
            if (loginDao.searchUsername(username)){
                return true;
            }else {
                return false;
            }
        }catch (UsernameEntryNotFoundException e){
            return false;
        }
    }

    @Override
    public boolean authPassword(String password) {
        try {
            if (loginDao.readPassword(password)) {
                return true;
            }else {
                return false;
            }
            }catch (PasswordEntryNotFoundException e){
                return false;
            }
        }
    }
