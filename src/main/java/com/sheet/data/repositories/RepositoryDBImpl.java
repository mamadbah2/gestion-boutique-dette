package com.sheet.data.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class RepositoryDBImpl<T> implements Repository<T> {
    protected Connection conn = null;
    protected String dbName = "gestion_dette";
    protected String userName = "root";
    protected String userPassword = "root";

    public void open() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, userPassword);
            }

            System.out.println("Connexion BD etablie");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
    }

    public void close() {
        if (conn != null) {
            conn = null;
        }
    }

    public ResultSet executeSelect(String req) {
        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(req);
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD "+e.getSQLState()+" - "+e.getMessage());
        }
        return rs;
    }

    public boolean executeUpdate(String req) {
        int nbre = 0;
        try {
            Statement statement = conn.createStatement();
            nbre = statement.executeUpdate(String.format(req));
            System.out.println("Connexion Bd etablie");
        }catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
        return nbre == 0;
    }
    
}
