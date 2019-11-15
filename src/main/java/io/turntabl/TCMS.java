package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.MainMenu;
import io.turntabl.persistance.DBConnection;

import java.io.IOException;

public class TCMS {
    public static void main(String[] args) throws IOException {
        DBConnection cip = new DBConnection();

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
                System.out.println(AnsiConsole.RED + "You Entered an InCorrect Option!" + AnsiConsole.RESET);
            }
    }

}
