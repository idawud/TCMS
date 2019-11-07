package io.turntabl.menu;

import io.turntabl.persistance.ClientData;

import java.util.List;


public class Printer {
    public static void printClientCard(ClientData clientData){
       List<String> record = clientData.toList();
        System.out.println("***************************************************************************");
        System.out.println(
                  AnsiConsole.WHITE_BOLD + "** Name:      \t" + AnsiConsole.RESET + AnsiConsole.GREEN + record.get(0)+ '\n'
                + AnsiConsole.WHITE_BOLD + "** Email:     \t" + AnsiConsole.RESET + AnsiConsole.BLUE + record.get(3) + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Telephone: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + record.get(2) + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Address:   \t" + AnsiConsole.RESET + AnsiConsole.CYAN + record.get(1)+ AnsiConsole.RESET );
        System.out.println("***************************************************************************");
    }

    public static void printClientCardWithId(ClientData clientData){
        List<String> record = clientData.toList();
        System.out.println("***************************************************************************");
        System.out.println(
                          AnsiConsole.WHITE_BOLD + "** Id:        \t" + AnsiConsole.RESET + AnsiConsole.YELLOW + record.get(4)+ '\n'
                        + AnsiConsole.WHITE_BOLD + "** Name:      \t" + AnsiConsole.RESET + AnsiConsole.GREEN + record.get(0)+ '\n'
                        + AnsiConsole.WHITE_BOLD + "** Email:     \t" + AnsiConsole.RESET + AnsiConsole.BLUE + record.get(3) + AnsiConsole.RESET + '\n'
                        + AnsiConsole.WHITE_BOLD + "** Telephone: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + record.get(2) + AnsiConsole.RESET + '\n'
                        + AnsiConsole.WHITE_BOLD + "** Address:   \t" + AnsiConsole.RESET + AnsiConsole.CYAN + record.get(1)+ AnsiConsole.RESET );
        System.out.println("***************************************************************************");
    }

    public static void recordNotFound() {
        System.out.println(AnsiConsole.RED + "Error 404: ClientsNotFound" + AnsiConsole.RESET);
    }
}
