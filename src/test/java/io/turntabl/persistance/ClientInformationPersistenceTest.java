package io.turntabl.persistance;

import io.turntabl.dataaccess.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClientInformationPersistenceTest {

    public static final Path FILEPATH = Paths.get("./resources/clientsInformation.txt");
    public static final Path ARCHIVEPATH = Paths.get("./resources/archive.txt");

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    DBConnection cip = new DBConnection();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void store_successful() throws SQLException, ClassNotFoundException {
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenReturn(true);
        assertTrue(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"));
    }

    @Test
    public void store_unsuccessfulThrowsException() throws SQLException, ClassNotFoundException {
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenThrow(new FileNotFoundException());

        exception.expect(FileNotFoundException.class);
        cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email");
    }

}