package io.turntabl.dataentry;

import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataEntry {
    private static final Scanner INPUT = new Scanner(System.in);

    public  static boolean toSave() throws IOException {
        List<String> clientInformation = getClientInformation();
        ClientInformationPersistence cip = new ClientInformationPersistence();
        return ( cip.store( clientInformation.get(0),
                            clientInformation.get(1),
                            clientInformation.get(2),
                            clientInformation.get(3)
                ));
    }

    private static List<String> getClientInformation() {
        String name = getStringInput("Full Name: ");
        String address = getStringInput("Address: ");
        String telephoneNumber = getStringInput("Telephone number: ");
        String email = getStringInput("Email Address: ");

        return Arrays.asList(name, address, telephoneNumber, email);
    }

    private static String getStringInput(String s) {
        System.out.println(s);
        String input = INPUT.nextLine();
        while (input.isEmpty()){
            System.out.print("Invalid!! Retry Enter " +s);
            input =INPUT.nextLine();
        }
        return input;
    }
}
