package io.turntabl.persistance;

import java.sql.*;

/**
 * @Desc Storing & Retrieving Client Information from a db
 */
public class DBConnection {
    private static final String URL = "jdbc:h2:~/tcmsv1.1";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static boolean store(String name, String address, String tel_num, String email) throws SQLException, ClassNotFoundException {
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
