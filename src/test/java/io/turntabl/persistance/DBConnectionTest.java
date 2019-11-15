package io.turntabl.persistance;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DBConnectionTest {

    @Before
    public void connect() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.connect();
        String query = "drop table clients if exists";
        String createTable = "create table clients( client_id int primary key auto_increment, " +
                "client_name varchar(200) not null, address varchar(250) not null, " +
                "tel_num varchar(50) not null, email varchar(200) not null, " +
                "active boolean default 'true')";
        connection.createStatement().execute(query);
        connection.createStatement().execute(createTable);
    }

    @Test
    public void store() throws SQLException, ClassNotFoundException {
         boolean result = DBConnection.store("alex", "md zg",
                 "68977-6788-788", "mail@mail.email");
         assertFalse(result);
    }

    @Test
    public  void get() throws SQLException, ClassNotFoundException {
        String query = "select * from clients";
        Connection connection = DBConnection.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int count  = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString(3));
        }
        assertEquals(1, count);
    }
}