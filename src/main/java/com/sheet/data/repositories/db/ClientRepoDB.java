package com.sheet.data.repositories.db;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;


import com.sheet.data.entities.Client;
import com.sheet.data.repositories.RepositoryDBImpl;
import com.sheet.data.repositories.interfaces.ClientInterf;

public class ClientRepoDB extends RepositoryDBImpl<Client> implements ClientInterf {

    public ClientRepoDB() {
        this.open();
    }

    @Override
    public void add(Client client) {
        String req = String.format("INSERT INTO clients (name, email, phone, addresse) VALUES ('%s', '%s', '%s', '%s')", client.getName(), client.getEmail(), client.getPhone(), client.getAddress());
        executeUpdate(req);
    }

    @Override
    public void remove(Client object) {
        String req = String.format("DELETE FROM clients WHERE name = '%s'", object.getName());
        executeUpdate(req);
    }

    @Override
    public void set(List<Client> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Client> getAll() {

        List<Client> clients = new ArrayList<Client>();
         String req = "Select * from client";
        try {
            ResultSet rs = executeSelect(req);
            while (rs.next()) {
                Client client = new Client(rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("addresse"));
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }

    @Override
    public Client getClient(String name) {
        String req = String.format("Select * from client where name = '%s'", name);
        try {
            ResultSet rs = executeSelect(req);
            if (rs.next()) {
                return new  Client(rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("addresse"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

   
    
}
