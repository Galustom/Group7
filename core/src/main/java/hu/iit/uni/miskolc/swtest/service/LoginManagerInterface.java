package hu.iit.uni.miskolc.swtest.service;

public interface LoginManagerInterface {

    boolean authUsername(String username);
    boolean authPassword(String password);
}
