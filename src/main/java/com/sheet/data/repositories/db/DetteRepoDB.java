package com.sheet.data.repositories.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.sheet.core.database.DatabaseImpl;
import com.sheet.data.entities.Client;
import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.interfaces.DetteInterf;

public class DetteRepoDB extends DatabaseImpl implements DetteInterf {

    public DetteRepoDB() {
        try {
            this.getConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void add(Dette object) {
        String req = String.format("INSERT INTO dette (date, montant, description, clientId) VALUES ('%s', %f, '%s')", object.getDate(), object.getMontant(), object.getDescription(), object.getClient().getId());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void remove(Dette object) {
        String req = String.format("DELETE FROM dette WHERE date = '%s'", object.getDate());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void set(List<Dette> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Dette> getAll() {
        List<Dette> dettes = new ArrayList<>();
        String req = "Select * from dette";
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                dettes.add(this.convertToObject(rs));
            }
        } catch (SQLException e) {
        }

        return dettes;
    }

    @Override
    public Dette getDette(String date) {
        String req = String.format("Select * from dette where date = '%s'", date);
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                Dette dette = this.convertToObject(rs);
                return dette;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public Dette convertToObject(ResultSet rs) {
        try {
        return new Dette(rs.getString("date"), rs.getDouble("montant"), rs.getString("description"), rs.getInt("clientId"));
        } catch (SQLException e) {
        }
        return null;
    }

}
