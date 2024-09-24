package com.sheet.core.database.interfaces;

import java.sql.SQLException;

public interface Database {
    void getConnection() throws SQLException;
    void closeConnection() throws SQLException;
    void executeSelect(String req) throws SQLException;
    void initPreparedStatement(String req) throws SQLException;
    int executeUpdate() throws SQLException;
}
