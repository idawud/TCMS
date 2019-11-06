package io.turntabl.persistance;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientInformationPersistenceTest {

    @Test
    public void store() {
        ClientInformationPersistence cip = new ClientInformationPersistence();
        assertFalse(cip.store());
    }
}