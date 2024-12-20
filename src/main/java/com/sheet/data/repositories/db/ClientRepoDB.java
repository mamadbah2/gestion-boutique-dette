package com.sheet.data.repositories.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sheet.core.database.DatabaseImpl;
import com.sheet.data.entities.Client;
import com.sheet.data.repositories.interfaces.ClientInterf;

public class ClientRepoDB extends DatabaseImpl implements ClientInterf {

    public ClientRepoDB() {
        try {
            this.getConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void add(Client client) {
        String req = String.format("INSERT INTO clients (name, email, phone, addresse) VALUES ('%s', '%s', '%s', '%s')",
                client.getName(), client.getEmail(), client.getPhone(), client.getAddress());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void remove(Client object) {
        String req = String.format("DELETE FROM clients WHERE name = '%s'", object.getName());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void set(List<Client> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();

        String req = "Select * from client";
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                clients.add(this.convertToObject(rs));
            }
        } catch (SQLException e) {
        }

        return clients;
    }

    @Override
    public Client getClient(String name) {
        String req = String.format("Select * from client where name = '%s'", name);
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                Client client = this.convertToObject(rs);
                return client;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public Client convertToObject(ResultSet rs) {
        try {
            return new Client(rs.getString("name"), rs.getString("email"), rs.getString("phone"),
                    rs.getString("addresse"));
        } catch (SQLException e) {
        }
        return null;
    }

}
