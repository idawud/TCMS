package io.turntabl.dataaccess;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;


public class ManagerTest {

    @Test
    public void getClientByNameTest() {
        Manager manager = new Manager(Arrays.asList(
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("alex", "2334", "553472114", "john.erbynn@gmail.com")
        ));
        List<String> expected = Arrays.asList(
                "dawud 2334 553472114 john.erbynn@gmail.com",
                "pk 2334 553472114 john.erbynn@gmail.com",
                "alex 2334 553472114 john.erbynn@gmail.com"
        );
        assertEquals(expected, manager.getClientByName());
    }
}