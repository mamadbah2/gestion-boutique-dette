package com.sheet.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.sheet.core.database.interfaces.Database;

public class DatabaseImpl implements Database {
    protected Connection conn = null;
    protected PreparedStatement ps;
    protected String dbName = "gestion_dette";
    protected String userName = "root";
    protected String userPassword = "root";

    @Override
    public void getConnection() throws SQLException {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, userPassword);
            }
            System.out.println("Connexion BD etablie");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du Driver");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }

    @Override
    public ResultSet executeSelect(String req) throws SQLException {
        try {
            return this.ps.executeQuery();
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int executeUpdate() throws SQLException {
        return ps.executeUpdate();
    }
    
    @Override
    public void initPreparedStatement(String req) throws SQLException {
        if (req.trim().toUpperCase().startsWith("SELECT")) {
            ps = conn.prepareStatement(req);
        } else {
            ps = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        }
    }

}
// TODO Auto-generated method stub