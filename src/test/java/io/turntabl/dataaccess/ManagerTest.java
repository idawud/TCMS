package io.turntabl.dataaccess;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class ManagerTest {

    @Test
    public void getAllClientDetailedInfoTest() {
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
        assertEquals(expected, manager.getAllClientsDetailInfo());
    }


    @Test
    public void findAllMarches() {
        Manager manager = new Manager(Arrays.asList(
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("alex", "2334", "553472114", "john.erbynn@gmail.com")
        ));

        List<Client> expected = manager.getClients().stream().filter(c -> c.getName() == "dawud").collect(Collectors.toList());
//        List<String> expected = Arrays.asList("dawud 2334 553472114 john.erbynn@gmail.com");
        //        System.out.println(expected);
//        System.out.println(manager.findAllMarches("dawud"));
        assertEquals(expected, manager.findAllMatches("dawud"));
    }

    @Test
    public void findAllMarches_ZeroMatch() {
        Manager manager = new Manager(Arrays.asList(
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("alex", "2334", "553472114", "john.erbynn@gmail.com")
        ));

        assertEquals(Arrays.asList(), manager.findAllMatches("dawu"));
    }


    @Test
    public void findAllMarches_ManyMatches() {
        Manager manager = new Manager(Arrays.asList(
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "4444", "553472114", "john.erbynn@gmail.com"),
                new Client("alex", "2334", "553472114", "john.erbynn@gmail.com")
        ));
        List<Client> expected = manager.getClients().stream().filter(c -> c.getName() == "pk").collect(Collectors.toList());
        assertEquals(expected, manager.findAllMatches("pk"));
    }

}

