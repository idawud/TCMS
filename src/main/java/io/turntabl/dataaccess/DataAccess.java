package io.turntabl.dataaccess;

import io.turntabl.dataentry.DataEntry;
import io.turntabl.menu.Printer;
import io.turntabl.persistance.ClientData;
import io.turntabl.persistance.ClientInformationPersistence;

import java.io.IOException;
import java.util.List;

public class DataAccess {

    public static void showAllClientsRecords() throws IOException {
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.retrieveAll();
        records.forEach(Printer::printClientCard);
    }

    public static void showSearchedClientsRecords() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        List<ClientData> records = cip.search(name);
        if (records.size() == 0){
            Printer.recordNotFound();
        }else {
            records.forEach(Printer::printClientCard);
        }
    }

    public static void deleteClientRecord() throws IOException {
        String name = DataEntry.getStringInput("Enter Client's name: ");
        ClientInformationPersistence cip = new ClientInformationPersistence();
        cip.search(name).forEach(Printer::printClientCard);

        int id = 9999;
        if (cip.delete(id)){
            System.out.println("Client Record Deleted Successfully!");
        }else {
            System.out.println("Oops! Either Client with id " + id + " does not exist");
        }
    }
    

}
