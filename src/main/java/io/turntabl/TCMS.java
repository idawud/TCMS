package io.turntabl;

import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;

public class TCMS {
    public static void main(String[] args) throws IOException {
        ClientInformationPersistence cip = new ClientInformationPersistence();
        // Files.readAllLines(Paths.get("./resources/clientsInformation.txt")).forEach(System.out::println);
        // cip.retrieveAll().forEach(clientData -> System.out.println(clientData.toCSV()));
        // System.out.println(cip.store("last killer", "nankrom", "558-8958-65", "mail@mail.er") );
        // cip.search("babon").forEach(clientData -> System.out.print(clientData.toCSV()));
        // cip.delete(3);
        // cip.retrieveAll().forEach(clientData -> System.out.println(clientData.toCSV()));
    }
}
