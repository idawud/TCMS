package io.turntabl.dataaccess;

import io.turntabl.dataentry.DataEntry;
import io.turntabl.menu.Printer;
import io.turntabl.persistance.ClientData;
import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
        List<ClientData> records = cip.search(name);
        printRecords(records);
    }

    public static void deleteClientRecord() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.search(name);

        if (records.size() == 0){
            Printer.recordNotFound();
        }else {
            int id = getId();
            if (cip.delete(id)) {
                System.out.println("Client Record Deleted Successfully!");
            } else {
                System.out.println("Oops! Client with id " + id + " does not exist");
            }
        }
    }

    private static int getId(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the ID to be deleted: ");
        int id = -9999;
        try {
            id = input.nextInt();
        }catch (Exception ignored){
        }
        return id;
    }
    

}
