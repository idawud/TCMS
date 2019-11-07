package io.turntabl;

import io.turntabl.menu.MainMenu;

import java.io.IOException;

public class TCMS {
    public static void main(String[] args) throws IOException {
        // ClientInformationPersistence cip = new ClientInformationPersistence();
        // Files.readAllLines(Paths.get("./resources/clientsInformation.txt")).forEach(System.out::println);
        // cip.retrieveAll().forEach(clientData -> System.out.println(clientData.toCSV()));
        // System.out.println(cip.store("last killer", "nankrom", "558-8958-65", "mail@mail.er") );
        // cip.search("babon").forEach(clientData -> System.out.print(clientData.toCSV()));
        // cip.delete(3);
        // cip.retrieveAll().forEach(clientData -> System.out.println(clientData.toCSV()));

        TCMS tcms = new TCMS();
        MainMenu.welcome();
        while (true) {
            tcms.run();
        }
    }

    private void run() throws IOException {
            MainMenu.menuListing();
            int option = MainMenu.getUserMenuSelection();
            if (MainMenu.isAnOptionOnMenu(option)){
                MainMenu.operation(option);
            }
            else {
                System.out.println("You Entered an InCorrect Option!");
            }
    }

}
