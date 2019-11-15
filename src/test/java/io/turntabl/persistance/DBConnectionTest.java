package io.turntabl.persistance;


import org.junit.Test;

import java.io.IOException;
import java.sql.*;

import static org.junit.Assert.*;

public class DBConnectionTest {
    @Test
    public void store() throws SQLException, ClassNotFoundException, IOException {
        DBConnection connection = new DBConnection();
         boolean result = connection.store("alex", "md zg",
                 "68977-6788-788", "mail@mail.email");
         assertFalse(result);
    }

}