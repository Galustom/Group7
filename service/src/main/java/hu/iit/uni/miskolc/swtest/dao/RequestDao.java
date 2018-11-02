package hu.iit.uni.miskolc.swtest.dao;


import hu.iit.uni.miskolc.swtest.dao.exceptions.RequestEntryAlreadyAddedException;
import hu.iit.uni.miskolc.swtest.model.Request;

import java.util.Collection;
import java.util.*;

public interface RequestDao {

    Request GetRequest(int requestId);

    Collection<Request> readRequests();

    public void createRequest(Request request)throws RequestEntryAlreadyAddedException;

}
