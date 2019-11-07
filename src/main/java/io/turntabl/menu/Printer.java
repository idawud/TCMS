package io.turntabl.menu;

import io.turntabl.persistance.ClientData;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Printer {
    public static void printClientCard(ClientData clientData){
       List<String> record = clientData.toList();
        System.out.println("***************************************************************************");
        System.out.println(
                 AnsiConsole.WHITE_BOLD + "** Name: \t\t\t\t" + AnsiConsole.RESET + AnsiConsole.GREEN + record.get(0)+ '\n'
                + AnsiConsole.WHITE_BOLD + "** Email: \t\t\t\t" + AnsiConsole.RESET + AnsiConsole.BLUE + record.get(3) + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Telephone Number: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + record.get(3) + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "** Address: \t\t\t" + AnsiConsole.RESET + AnsiConsole.CYAN + record.get(1)+ AnsiConsole.RESET );
        System.out.println("***************************************************************************");
    }

    public static void printClientCardWithId(ClientData clientData){
        System.out.println(clientData.toList().get(0));
    }

    public static void recordNotFound() {
        System.out.println("Error 404: ClientNotFound");
    }
}
