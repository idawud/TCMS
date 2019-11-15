package io.turntabl.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Desc Storing & Retrieving Client Information from a db
 */
public class DBConnection {
    private static final String URL = "JDBC";
    private static final String USERNAME = "dawud-ismail";
    private static final String PASSWORD = "turntabl";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public boolean store(String name, String address, String tel_num, String email) throws SQLException, ClassNotFoundException {
        String queryString = "INSERT INTO clients (client_name, address, tel_num, email) " +
                "VALUES ( ?, ?, ?, ?)";
        PreparedStatement statement = connect().prepareStatement(queryString);
        statement.clearParameters();
        statement.setString(1, name);
        statement.setString(1, address);
        statement.setString(1, tel_num);
        statement.setString(1, email);

        return statement.executeQuery().rowInserted();
    }
}
