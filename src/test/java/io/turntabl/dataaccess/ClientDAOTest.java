package io.turntabl.dataaccess;

import io.turntabl.persistance.DBConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDAOTest {
    private  ClientDAO clientDAO;

    @Before
    public void setup() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBConnection.connect();
        Statement statement = connection.createStatement();
        clientDAO = new ClientDAO();
        DBConnection setup = new DBConnection();
        setup.setup(statement);
    }


    @Test
    public void testGetAllClients() throws SQLException {
        List<Client> result = clientDAO.getAllClients();
        assertEquals( 2, result.size());
    }

    @Test
    public void testGetAllSearchedClients() throws SQLException {
        List<Client> result = clientDAO.getAllSearchedClients("Mary");
        assertEquals( 1, result.size());
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
        List<Client> result = clientDAO.getAllSearchedArchivedClients("Mary");
        assertEquals( 0, result.size());
    }

    @Test
    public void testRecoverClient() throws SQLException {
        boolean result = clientDAO.recoverClient(3);
       assertTrue(result);
    }
}