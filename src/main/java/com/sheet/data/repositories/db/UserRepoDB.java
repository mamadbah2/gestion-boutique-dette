package com.sheet.data.repositories.db;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.RepositoryDBImpl;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserRepoDB extends RepositoryDBImpl<User> implements UserInterf {
    @Override
    public void add(User object) {
        String req = String.format("INSERT INTO user (login, firstname, lastname, active, roleId, clientId) VALUES (%s, %s, %s, %d, %d, %d)", object.getLogin(), object.getFirstname(), object.getLastname(), object.isActive(), object.getRole2().getId(), object.getClient().getId());
        executeUpdate(req);
    }

    @Override
    public void remove(User object) {
        String req = String.format("DELETE FROM dette WHERE date = '%s'", object.getDate());
        executeUpdate(req);
    }

    @Override
    public void set(List<User> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<User> getAll() {
        List<User> dettes = new ArrayList<User>();
        String req = "Select * from dette";
        try {
            ResultSet rs = executeSelect(req);
            while (rs.next()) {
                User dette = new User(rs.getString("date"), rs.getDouble("montant"), rs.getString("description"), rs.getInt("clientId"));
                dettes.add(dette);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dettes;
    }

    @Override
    public User getUser(String date) {
        String req = String.format("Select * from dette where date = '%s'", date);
        try {
            ResultSet rs = executeSelect(req);
            if (rs.next()) {
                return new User(rs.getString("date"), rs.getDouble("montant"), rs.getString("description"), rs.getInt("clientId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
