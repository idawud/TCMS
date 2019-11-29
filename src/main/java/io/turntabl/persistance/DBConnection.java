package io.turntabl.persistance;

import io.turntabl.dataaccess.DBType;

import java.sql.*;

/**
 * @Desc Storing & Retrieving Client Information from a db
 */
public class DBConnection {
    private static final String POSTGRESQL_TCMS = "jdbc:postgresql:tcms";
    private static final String H2_TCMS = "jdbc:h2:~/tcmsv1.1";
    private static final String USERNAME = "dawud";
    private static final String PASSWORD = "dawud";

    public static Connection connect(DBType dbType) throws SQLException, ClassNotFoundException {
        switch (dbType){
            case H2:
                Class.forName("org.h2.Driver");
                return DriverManager.getConnection(H2_TCMS, "", "");
            case POSTGRESQL:
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(POSTGRESQL_TCMS, USERNAME, PASSWORD);
            default:
                return DriverManager.getConnection(POSTGRESQL_TCMS);
        }
    }

    public DBConnection(){ }

    public boolean store(DBType dbType, String name, String address, String tel_num, String email) throws SQLException, ClassNotFoundException {
        String queryString = "INSERT INTO clients (client_name, address, tel_num, email) " +
                "VALUES ( ?, ?, ?, ? )";
        PreparedStatement statement = connect(dbType).prepareStatement(queryString);
        statement.clearParameters();
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setString(3, tel_num);
        statement.setString(4, email);
        return statement.execute();
    }

}
