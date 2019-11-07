package io.turntabl.dataaccess;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagerDriver {
    public static void main(String[] args) {

        System.out.println("Enter search name: ");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();

        Manager manager = new Manager(Arrays.asList(
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("dawud", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("pk", "2334", "553472114", "john.erbynn@gmail.com"),
                new Client("alex", "2334", "553472114", "john.erbynn@gmail.com")
        ));

        List<Client> clientsCaught = manager.findAllMatches(userName);
        System.out.println(clientsCaught + " here");
    }
}
