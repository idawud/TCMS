package io.turntabl.persistance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DBConnectionTest {

    @Before
    public void setup() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.connect();
        String query = "drop table clients if exists";
        String createTable = "create table clients( client_id int primary key auto_increment, " +
                "client_name varchar(200) not null, address varchar(250) not null, " +
                "tel_num varchar(50) not null, email varchar(200) not null, " +
                "active boolean default 'true')";
        connection.createStatement().execute(createTable);
    }

    @After
    public void tearDown() throws Exception {
        Connection connection = DBConnection.connect();
        String query = "drop table clients if exists";
        connection.createStatement().execute(query);
    }

    @Test
    public void store() throws SQLException, ClassNotFoundException {
        DBConnection connection = new DBConnection();
         boolean result = connection.store("alex", "md zg",
                 "68977-6788-788", "mail@mail.email");
         assertFalse(result);
    }

}