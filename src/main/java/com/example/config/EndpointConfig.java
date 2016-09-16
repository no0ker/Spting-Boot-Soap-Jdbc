package com.example.config;

import com.example.entity.*;
import com.example.hibernate.configs.Something;
import com.example.hibernate.configs.SomethingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EndpointConfig
{
    private static final String NAMESPACE_URI = "https://github.com/no0ker/MyExampleVer2Application";

    private DbHelper dbHelper;
    private SomethingDAO somethingDAO;

    @Autowired
    public EndpointConfig(DbHelper dbHelper, SomethingDAO somethingDAO)
    {
        this.dbHelper = dbHelper;
        this.somethingDAO = somethingDAO;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setEventRequest")
    @ResponsePayload
    public SetEventResponse eventsProcessor(@RequestPayload SetEventRequest request)
    {
        SetEventResponse response = new SetEventResponse();
        response.setName(request.getName());
        String eventName = request.getName();

        try{
            dbHelper.saveEvent(eventName);
        } catch (DataAccessException e){
            StatusContainer statusContainer = new StatusContainer();
            statusContainer.setStatus(Status.FAIL);
            statusContainer.setError(e.getClass().getName());
            response.getStatus().add(statusContainer);
            return response;
        }

        for(Thing thing : request.getThings()){
            try
            {
                Something something = new Something();
                something.setValue1(thing.getValue1());
                something.setValue2(thing.getValue2());

                somethingDAO.save(something);

                StatusContainer statusContainer = new StatusContainer();
                statusContainer.setStatus(Status.SUCCESFULL);
                response.getStatus().add(statusContainer);
            }
            catch (DataAccessException e)
            {
                StatusContainer statusContainer = new StatusContainer();
                statusContainer.setStatus(Status.FAIL);
                statusContainer.setError(e.getClass().getName());
                response.getStatus().add(statusContainer);
            }
        }
        return response;
    }
}