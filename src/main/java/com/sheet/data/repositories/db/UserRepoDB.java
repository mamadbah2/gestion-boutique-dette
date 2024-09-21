package com.sheet.data.repositories.db;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.RepositoryDBImpl;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserRepoDB extends RepositoryDBImpl<User> implements UserInterf {

    public UserRepoDB() {
        this.open();
    }

    @Override
    public void add(User object) {
        String req = String.format("INSERT INTO user (login, firstname, lastname, active, roleId, clientId) VALUES (%s, %s, %s, %b, 1, %d)", object.getLogin(), object.getFirstname(), object.getLastname(), object.isActive(), object.getClient().getId());
        executeUpdate(req);
    }

    @Override
    public void remove(User object) {
        String req = String.format("DELETE FROM user WHERE login = '%s'", object.getLogin());
        executeUpdate(req);
    }

    @Override
    public void set(List<User> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        String req = "Select * from user";
        try {
            ResultSet rs = executeSelect(req);
            while (rs.next()) {
                User user = new User(rs.getString("login"), rs.getString("firstname"), rs.getString("lastname"), rs.getBoolean("active"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUser(String date) {
        String req = String.format("Select * from user where login = '%s'", date);
        try {
            ResultSet rs = executeSelect(req);
            if (rs.next()) {
                return new User(rs.getString("login"), rs.getString("firstname"), rs.getString("lastname"), rs.getBoolean("active"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
