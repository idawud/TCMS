package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.AppMenu;

public class TCMS {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread databaseProcessing = new Thread(new Consumer(sharedData), "TCMS-DataProcessing");
        Thread ui = new Thread(new AppMenu(sharedData), "TCMS-ui");

        // Welcome
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                + "*****************************************************************************" + AnsiConsole.RESET);

        ui.start();

        databaseProcessing.start();
    }
}
