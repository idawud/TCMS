package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

public class TCMS {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        Thread ui = new Thread(
                 new MainMenu(),
                "TCMS-DBProcessing"
        );

        Thread databaseProcessing = new Thread(
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

    public void welcome() {
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                + "*****************************************************************************" + AnsiConsole.RESET);
    }

}
