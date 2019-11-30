package io.turntabl;

import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.AppMenu;

import java.sql.SQLException;

public class TCMS {

    public static void main(String[] args) throws InterruptedException {
        AppMenu appMenu = new AppMenu();

        // Welcome
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                + "*****************************************************************************" + AnsiConsole.RESET);

        appMenu.run();
    }
}
