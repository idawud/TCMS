package io.turntabl.persistance;


import io.turntabl.dataaccess.DBType;
import org.junit.Test;

import java.io.IOException;
import java.sql.*;

import static org.junit.Assert.*;

public class DBConnectionTest {
    @Test
    public void store() throws SQLException, ClassNotFoundException {
        DBConnection connection = new DBConnection();
         boolean result = connection.store(DBType.H2,"yaw pop", "md zg",
                 "68977-6788-788", "mail@mail.email");
         assertFalse(result);
    }

}