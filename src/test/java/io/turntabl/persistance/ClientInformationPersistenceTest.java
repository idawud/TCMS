package io.turntabl.persistance;

import io.turntabl.dataaccess.DBType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClientInformationPersistenceTest {


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    DBConnection connection = new DBConnection();

    public ClientInformationPersistenceTest() throws SQLException, IOException, ClassNotFoundException {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void store_successful() throws SQLException, ClassNotFoundException {
        when(connection.store(DBType.H2,"dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenReturn(true);
        assertTrue(connection.store(DBType.H2,"dawud", "achimota-accra", "052768256", "dawud@one.email"));
    }

    @Test
    public void store_unsuccessfulThrowsException() throws SQLException, ClassNotFoundException {
        when(connection.store(DBType.H2,"dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenThrow(new SQLException());

        exception.expect(SQLException.class);
        connection.store(DBType.H2,"dawud", "achimota-accra", "052768256", "dawud@one.email");
    }

}