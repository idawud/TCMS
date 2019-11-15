package io.turntabl.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Desc Storing & Retrieving Client Information from a db
 */
public class ClientInformationPersistence {
    private static final String URL = "JDBC";
    private static final String USERNAME = "dawud-ismail";
    private static final String PASSWORD = "turntabl";

    public static Connection dbConnect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
