package com.example.config;

import com.example.entity.SetEventRequest;
import com.example.entity.SetEventResponse;
import com.example.entity.Status;
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
    public SetEventResponse getCountry(@RequestPayload SetEventRequest request)
    {
        SetEventResponse response = new SetEventResponse();
        response.setName(request.getName());

        try
        {
            dbHelper.saveEvent(request.getName());
            response.setStatus(Status.SUCCESFULL);
        }
        catch (DataAccessException e)
        {
            response.setError(e.getClass().getName());
            response.setStatus(Status.FAIL);
        }

        return response;
    }
}