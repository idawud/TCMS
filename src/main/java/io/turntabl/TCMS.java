package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

public class TCMS {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        Thread databaseProcessing = new Thread(
                ()-> {
                    while (!Thread.interrupted()){

                    }
                },
                "TCMS-DBProcessing"
        );

        Thread ui = new Thread(
                ()-> {
                    while (!Thread.interrupted()){

                    }
                },
                "TCMS-UI"
        );

        TCMS tcms = new TCMS();
        tcms.welcome();

        databaseProcessing.start();
        ui.start();

        databaseProcessing.join();
        ui.join();
    }

    private void run() throws SQLException, ClassNotFoundException, IOException {
            MainMenu.menuListing();
            int option = MainMenu.getUserMenuSelection();
            if (MainMenu.isAnOptionOnMenu(option)){
                // MainMenu.operation(option);
            }
            else {
                System.out.println(AnsiConsole.RED + "You Entered an InCorrect Option!" + AnsiConsole.RESET);
            }
    }

    public void welcome() {
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                + "*****************************************************************************" + AnsiConsole.RESET);
    }

}
