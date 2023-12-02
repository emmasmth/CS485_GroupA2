package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.dao.ClientDAO;
import edu.loyola.cs485.model.entity.Client;

import java.util.List;

public class ClientService {

    public void createNewClient(String name, String email, String strDob)
            throws Exception{
        Client c = new Client();
        c.setName( name );
        c.setEmail( email );
        //c.setDob();

        ClientDAO dao = new ClientDAO();
        dao.create( c );

    }

    public List<Client> getClients() throws Exception{
        ClientDAO dao = new ClientDAO();
        return dao.list();
    }

    public void delete(Client c) throws Exception {
        if(c!=null) {
            ClientDAO dao = new ClientDAO();
            dao.delete(c);
        }
    }
}
