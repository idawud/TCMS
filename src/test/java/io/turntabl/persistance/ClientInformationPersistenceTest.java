package io.turntabl.persistance;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ClientInformationPersistenceTest {

    @Mock
    ClientInformationPersistence cip;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void store_successful() {
        cip = new ClientInformationPersistence();
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenReturn(true);
        assertTrue(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"));
    }

    @Test
    public void store_unsuccessfulThrowsException() {
        cip = new ClientInformationPersistence();
        when(cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email"))
                .thenThrow(new FileNotFoundException());

        boolean actual = cip.store("dawud", "achimota-accra", "052768256", "dawud@one.email");
        assertSame( new FileNotFoundException(), actual);
    }

    @Test
    public void retrieveAll_Empty(){
        cip = new ClientInformationPersistence();
        List<ClientData> expected = Arrays.asList(
                new ClientData("dawud", "achimota-accra", "022768256", "dawud@one.email"),
                new ClientData("pat", "st. johns -accra", "052768256", "pat@one.email"),
                new ClientData("alex", "achimota-accra", "092768256", "alex@one.email")
        );
        when( cip.retrieveAll())
                .thenReturn(expected);
        assertEquals(expected, cip.retrieveAll());
    }

    @Test
    public void retrieveAll_True(){
        cip = new ClientInformationPersistence();
        List<ClientData> expected = Arrays.asList(
                new ClientData("dawud", "achimota-accra", "022768256", "dawud@one.email"),
                new ClientData("pat", "st. johns -accra", "052768256", "pat@one.email"),
                new ClientData("alex", "achimota-accra", "092768256", "alex@one.email")
        );
        when( cip.retrieveAll())
                .thenReturn(expected);
        assertEquals(expected, cip.retrieveAll());
    }
}