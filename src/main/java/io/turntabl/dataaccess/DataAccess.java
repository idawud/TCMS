package io.turntabl.dataaccess;

import io.turntabl.dataentry.DataEntry;
import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.Printer;
import io.turntabl.persistance.ClientData;
import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataAccess {

    public static void showAllClientsRecords() throws IOException {
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.retrieveAll();
        printRecords(records);
    }

    private static void printRecords(List<ClientData> records) {
        if (records.size() == 0) {
            Printer.recordNotFound();
        } else {
            records.forEach(Printer::printClientCard);
        }
    }

    public static void showSearchedClientsRecords() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.search(name, ClientInformationPersistence.FILEPATH);
        printRecords(records);
    }

    public static void deleteClientRecord() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.search(name, ClientInformationPersistence.FILEPATH);

        if (records.size() == 0){
            Printer.recordNotFound();
        }else {
            records.forEach(Printer::printClientCardWithId);
            List<Integer> searchedIds = records.stream()
                                                .map(ClientData::getId)
                                                .collect(Collectors.toList());
            int id = getId("\nEnter the ID to be deleted: ");

            if (isValidId(id, searchedIds)) {
                if (cip.moveRecord(id, ClientInformationPersistence.FILEPATH, ClientInformationPersistence.ARCHIVEPATH)) {
                    System.out.println(AnsiConsole.GREEN + "\nClient Record Deleted Successfully!" + AnsiConsole.RESET);
                } else {
                    System.out.println(AnsiConsole.RED + "Oops! Client with id " + id + " does not exist" + AnsiConsole.RESET);
                }
            } else {
                System.out.println(AnsiConsole.RED + "You entered an invalid id" + AnsiConsole.RESET);
            }
        }
    }

    private static boolean isValidId(int id, List<Integer> numbers) {
        return numbers.contains(id);
    }

    private static int getId(String s){
        Scanner input = new Scanner(System.in);
        System.out.print(s);
        int id = -99999;
        try {
            id = input.nextInt();
        }catch (Exception ignored){
        }
        return id;
    }


    public static void recoverDeleteClientRecord() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.search( name, ClientInformationPersistence.ARCHIVEPATH);

        if (records.size() == 0){
            Printer.recordNotFound();
        }else {
            records.forEach(Printer::printClientCardWithId);
            List<Integer> searchedIds = records.stream()
                            .map(ClientData::getId)
                            .collect(Collectors.toList());
            int id = getId("\nEnter the ID to be recovered: ");
            if (isValidId(id, searchedIds)) {
                if (cip.moveRecord(id, ClientInformationPersistence.ARCHIVEPATH, ClientInformationPersistence.FILEPATH)){
                    System.out.println(AnsiConsole.GREEN + "\nClient Record Recovered Successfully!" + AnsiConsole.RESET);
                } else {
                    System.out.println(AnsiConsole.RED + "Oops! Client with id " + id + " does not exist" + AnsiConsole.RESET);
                }
            } else {
                System.out.println(AnsiConsole.RED + "You entered an invalid id" + AnsiConsole.RESET);
            }
        }
    }
}
