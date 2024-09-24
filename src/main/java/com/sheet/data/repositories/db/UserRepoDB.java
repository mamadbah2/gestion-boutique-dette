package com.sheet.data.repositories.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sheet.core.database.DatabaseImpl;
import com.sheet.data.entities.User;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserRepoDB extends DatabaseImpl implements UserInterf {

    public UserRepoDB() {
        try {
            this.getConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void add(User user) {
        String req = String.format("INSERT INTO user (login, password, firstname, lastname, roleId, clientId) VALUES ('%s', '%s', '%s', '%s', '%d', '%d')",
                user.getLogin(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getRole2().getId(), user.getClient().getId());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void remove(User object) {
        String req = String.format("DELETE FROM user WHERE login = '%s'", object.getLogin());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void set(List<User> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String req = "Select * from user";
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                users.add(this.convertToObject(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public User getUser(String date) {
        String req = String.format("Select * from user where login = '%s'", date);
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                User user = this.convertToObject(rs);
                return user;            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public User convertToObject(ResultSet rs) {
        try {
            return new User(rs.getString("login"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getBoolean("active"));
        } catch (SQLException e) {
        }
        return null;
    }
}
