package io.turntabl.dataentry;

import io.turntabl.dataaccess.DBType;
import io.turntabl.persistance.DBConnection;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataEntry {
    private static final Scanner INPUT = new Scanner(System.in);

    public  static boolean toSave() throws SQLException, ClassNotFoundException {
        List<String> clientInformation = getClientInformation();
        DBConnection cip = new DBConnection();
        return ( !cip.store( DBType.POSTGRESQL,
                            clientInformation.get(0),
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

    public static String getStringInput(String s) {
        System.out.print(s);
        return ( INPUT.nextLine() );
    }
}
