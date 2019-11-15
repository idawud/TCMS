package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.MainMenu;
import io.turntabl.persistance.DBConnection;

import java.io.IOException;
import java.sql.SQLException;

public class TCMS {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DBConnection dbConnection = new DBConnection();

        TCMS tcms = new TCMS();
        MainMenu.welcome();

        while (true) {
            tcms.run();
        }
    }

    private void run() throws SQLException, ClassNotFoundException, IOException {
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
