package com.sheet.data.repositories.db;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;


import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.RepositoryDBImpl;
import com.sheet.data.repositories.interfaces.DetteInterf;

public class DetteRepoDB extends RepositoryDBImpl<Dette> implements DetteInterf {

    @Override
    public void add(Dette object) {
        String req = String.format("INSERT INTO dette (date, montant, description, clientId) VALUES ('%s', %f, '%s')", object.getDate(), object.getMontant(), object.getDescription(), object.getClient().getId());
        executeUpdate(req);
    }

    @Override
    public void remove(Dette object) {
        String req = String.format("DELETE FROM dette WHERE date = '%s'", object.getDate());
        executeUpdate(req);
    }

    @Override
    public void set(List<Dette> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Dette> getAll() {
        List<Dette> dettes = new ArrayList<Dette>();
        String req = "Select * from dette";
        try {
            ResultSet rs = executeSelect(req);
            while (rs.next()) {
                Dette dette = new Dette(rs.getString("date"), rs.getDouble("montant"), rs.getString("description"), rs.getInt("clientId"));
                dettes.add(dette);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dettes;
    }

    @Override
    public Dette getDette(String date) {
        String req = String.format("Select * from dette where date = '%s'", date);
        try {
            ResultSet rs = executeSelect(req);
            if (rs.next()) {
                return new Dette(rs.getString("date"), rs.getDouble("montant"), rs.getString("description"), rs.getInt("clientId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
