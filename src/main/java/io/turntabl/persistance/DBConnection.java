package io.turntabl.persistance;

import io.turntabl.dataaccess.DBType;

import java.sql.*;

/**
 * @Desc Storing & Retrieving Client Information from a db
 */
public class DBConnection {
    private static final String URL = "jdbc:postgresql:tcms";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public static Connection connect(DBType dbType) throws SQLException, ClassNotFoundException {
        switch (dbType){
            case POSTGRESQL: Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            case H2: Class.forName("org.h2.Driver");
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            default:
                return DriverManager.getConnection(URL);
        }
    }

    public DBConnection(){ }

    public boolean store(String name, String address, String tel_num, String email) throws SQLException, ClassNotFoundException {
        String queryString = "INSERT INTO clients (client_name, address, tel_num, email) " +
                "VALUES ( ?, ?, ?, ? )";
        PreparedStatement statement = connect().prepareStatement(queryString);
        statement.clearParameters();
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setString(3, tel_num);
        statement.setString(4, email);
        statement.execute();
        return statement.execute();
    }

}
