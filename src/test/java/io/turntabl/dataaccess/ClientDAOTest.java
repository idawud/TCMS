package io.turntabl.dataaccess;

import io.turntabl.persistance.DBConnection;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDAOTest {
    private  ClientDAO clientDAO;
    private static final String URL = "jdbc:h2:~/tcmsv1.1";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private void setup(Statement statement) throws IOException {
        Files.readAllLines(Paths.get("./clientData.sql")).forEach(
                s -> {
                    try {
                        statement.execute(s);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Before
    public void setup() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBConnection.connect(DBType.H2);
        Statement statement = connection.createStatement();
        clientDAO = new ClientDAO(DBType.H2);
        setup(statement);
    }


    @Test
    public void testGetAllClients() throws SQLException {
        List<Client> result = clientDAO.getAllClients();
        assertEquals( 2, result.size());
    }

    @Test
    public void testGetAllSearchedClients() throws SQLException {
        List<Client> result = clientDAO.getAllSearchedClients("Mary");
        assertEquals( 0, result.size());
    }

    @Test
    public void testDeleteClient() throws SQLException {
        boolean result = clientDAO.deleteClient(2);
        assertTrue(result);
    }

    @Test
    public void testGetAllSearchedArchivedClients_notAvailable() throws SQLException {
        List<Client> result = clientDAO.getAllSearchedArchivedClients("Dawud");
        assertEquals( 0, result.size());
    }

    @Test
    public void testGetAllSearchedArchivedClients_Available() throws SQLException {
        List<Client> result = clientDAO.getAllSearchedArchivedClients("Alex");
        assertEquals( 0, result.size());
    }

    @Test
    public void testRecoverClient() throws SQLException {
        boolean result = clientDAO.recoverClient(2);
       assertTrue(result);
    }

    @Test
    public void testGetAllClients_Again() throws SQLException {
        List<Client> result = clientDAO.getAllClients();
        assertEquals( 2, result.size());
    }
}