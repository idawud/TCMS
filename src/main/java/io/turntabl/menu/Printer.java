package io.turntabl.menu;

import io.turntabl.dataaccess.Client;

import java.util.List;


public class Printer {
    public static void printClientCard(Client clientData){
        System.out.println("***************************************************************************");
        System.out.println(
                  AnsiConsole.WHITE_BOLD + "** Name:      \t" + AnsiConsole.RESET + AnsiConsole.GREEN + clientData.getName()+ '\n'
                + AnsiConsole.WHITE_BOLD + "** Email:     \t" + AnsiConsole.RESET + AnsiConsole.BLUE + clientData.getEmail() + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Telephone: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + clientData.getTelephoneNumber() + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Address:   \t" + AnsiConsole.RESET + AnsiConsole.CYAN + clientData.getAddress() + AnsiConsole.RESET );
        System.out.println("***************************************************************************");
    }

    public static void printClientCardWithId(Client clientData){
        System.out.println("***************************************************************************");
        System.out.println(
                          AnsiConsole.WHITE_BOLD + "** Id:        \t" + AnsiConsole.RESET + AnsiConsole.YELLOW + clientData.getId()+ '\n'
                        + AnsiConsole.WHITE_BOLD + "** Name:      \t" + AnsiConsole.RESET + AnsiConsole.GREEN + clientData.getName() + '\n'
                        + AnsiConsole.WHITE_BOLD + "** Email:     \t" + AnsiConsole.RESET + AnsiConsole.BLUE + clientData.getEmail() + AnsiConsole.RESET + '\n'
                        + AnsiConsole.WHITE_BOLD + "** Telephone: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + clientData.getTelephoneNumber() + AnsiConsole.RESET + '\n'
                        + AnsiConsole.WHITE_BOLD + "** Address:   \t" + AnsiConsole.RESET + AnsiConsole.CYAN + clientData.getAddress() + AnsiConsole.RESET );
        System.out.println("***************************************************************************");
    }

    public static void recordNotFound() {
        System.out.println(AnsiConsole.RED + "Error 404: ClientsNotFound" + AnsiConsole.RESET);
    }
}
