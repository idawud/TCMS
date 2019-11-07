package io.turntabl.persistance;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ClientInformationPersistenceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    ClientInformationPersistence cip = new ClientInformationPersistence();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void store_successful() throws IOException {
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenReturn(true);
        assertTrue(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"));
    }

    @Test
    public void store_unsuccessfulThrowsException() throws IOException {
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenThrow(new FileNotFoundException());

        exception.expect(FileNotFoundException.class);
        cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email");
    }

    @Test
    public void retrieveAll_Empty() throws IOException {
        when( cip.retrieveAll())
                .thenReturn(Collections.emptyList());
        assertEquals(0, cip.retrieveAll().size());
    }

    @Test
    public void retrieveAll_NotEmpty() throws IOException {
        List<ClientData> expected = Arrays.asList(
                new ClientData(1, "dawud", "achimota-accra", "022768256", "dawud@one.email"),
                new ClientData(2, "pat", "st. johns -accra", "052768256", "pat@one.email"),
                new ClientData(3, "alex", "achimota-accra", "092768256", "alex@one.email")
        );
        when( cip.retrieveAll())
                .thenReturn(expected);
        assertEquals(expected, cip.retrieveAll());
    }

    @Test
    public void search_Empty() throws IOException {
        List<ClientData> expected = Arrays.asList();

        when( cip.search("asdf"))
                .thenReturn(expected);
        assertEquals(expected, cip.search("asdf"));
    }

    @Test
    public void search_NotEmpty_Single() throws IOException {
        List<ClientData> expected = Arrays.asList(
                new ClientData(1 ,"alex", "achimota-accra", "092768256", "alex@one.email")
        );
        when( cip.search("alex"))
                .thenReturn(expected);
        assertEquals(expected, cip.search("alex"));
    }

    @Test
    public void search_NotEmpty_Multiple() throws IOException {
        List<ClientData> expected = Arrays.asList(
                new ClientData(1, "alex", "st. johns -accra", "052768256", "pat@one.email"),
                new ClientData(2, "alex", "achimota-accra", "092768256", "alex@one.email")
        );
        when( cip.search("alex"))
                .thenReturn(expected);
        assertEquals(expected, cip.search("alex"));
    }

    @Test
    public void delete_ClientAvailable() throws IOException {
        when(cip.delete(23))
                .thenReturn(true);
        assertTrue(cip.delete(23));
    }

    @Test
    public void delete_ClientNotAvailable() throws IOException {
        when(cip.delete(23))
                .thenReturn(false);
        assertFalse(cip.delete(23));
    }

    @Test
    public void delete_FileNotAvailable() throws IOException {
        when(cip.delete(23))
                .thenThrow(new FileNotFoundException());

        exception.expect(FileNotFoundException.class);
        cip.delete(23);
    }

}