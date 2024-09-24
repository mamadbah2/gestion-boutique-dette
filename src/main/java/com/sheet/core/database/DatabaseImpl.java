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
    public void executeSelect(String req) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'execution de la requete");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initPreparedStatement(String req) throws SQLException {
        if (req.trim().toUpperCase().startsWith("SELECT")) {
            ps = conn.prepareStatement(req);
        } else {
            ps = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        }
    }

    @Override
    public int executeUpdate() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }
    
}
// TODO Auto-generated method stub