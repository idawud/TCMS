package io.turntabl;

import io.turntabl.menu.MainMenu;
import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;

public class TCMS {
    public static void main(String[] args) throws IOException {
        ClientInformationPersistence cip = new ClientInformationPersistence();

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
