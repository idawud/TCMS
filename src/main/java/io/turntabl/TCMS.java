package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.AppMenu;

public class TCMS {
    public static void main(String[] args) throws InterruptedException {

        Thread databaseProcessing = new Thread(
                ()-> {
                    while (!Thread.interrupted()){

                    }
                },
                "TCMS-DataProcessing"
        );

        // Welcome
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                + "*****************************************************************************" + AnsiConsole.RESET);

        AppMenu menu = new AppMenu();
        menu.run();

        databaseProcessing.start();
    }


}
