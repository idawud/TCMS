package io.turntabl.dataaccess;

import io.turntabl.dataentry.DataEntry;
import io.turntabl.menu.AnsiConsole;
import io.turntabl.menu.Printer;
import io.turntabl.persistance.DBConnection;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAccess {
    private ClientDAO clientDAO;

    public DataAccess(){
        try {
            clientDAO = new ClientDAO(DBType.POSTGRESQL);
        } catch (SQLException | ClassNotFoundException ignored) { }
    }

    public void entry() throws SQLException, ClassNotFoundException {
        if (DataEntry.toSave()){
            System.out.println(AnsiConsole.GREEN + "\nClient Added Successfully!!!" + AnsiConsole.RESET);
        }
        else{
            System.out.println(AnsiConsole.RED +"\nSomething went wrong! \nData was not stored!" + AnsiConsole.RESET);
        }
    }

    public void showAllClientsRecords() throws SQLException {
        List<Client> records = clientDAO.getAllClients();
        printRecords(records);
    }

    private static void printRecords(List<Client> records) {
        if (records.size() == 0) {
            Printer.recordNotFound();
        } else {
            records.forEach(Printer::printClientCard);
        }
    }

    public void showSearchedClientsRecords() throws SQLException {
        String name = DataEntry.getStringInput("Enter Client's name: ");
        List<Client> records = clientDAO.getAllSearchedClients(name);
        printRecords(records);
    }

    public void deleteClientRecord() throws SQLException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");

        List<Client> records = clientDAO.getAllSearchedClients(name);
        if (records.size() == 0) {
            Printer.recordNotFound();
        } else {
            records.forEach(Printer::printClientCardWithId);
            List<Integer> validIds = records.stream().map(Client::getId).collect(Collectors.toList());

            int id = getId("\nEnter the ID to be deleted: ");
            if (validIds.contains(id)) {
                boolean status = clientDAO.deleteClient(id);
                if (status) {
                    System.out.println(AnsiConsole.GREEN + "\nClient Record Deleted Successfully!" + AnsiConsole.RESET);
                }
            } else {
                System.out.println(AnsiConsole.RED + "Oops! Client with id " + id +
                        " does not exist " + AnsiConsole.RESET);
            }
        }
    }


    public void recoverDeleteClientRecord() throws SQLException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");

        List<Client> records = clientDAO.getAllSearchedArchivedClients(name);
        if (records.size() == 0) {
            Printer.recordNotFound();
        } else {
            records.forEach(Printer::printClientCardWithId);
            List<Integer> validIds = records.stream().map(Client::getId).collect(Collectors.toList());

            int id = getId("\nEnter the ID to be recovered: ");
            if (validIds.contains(id)) {
                boolean status = clientDAO.recoverClient(id);
                if (status) {
                    System.out.println(AnsiConsole.GREEN +
                            "\\nClient Record Recovered Successfully!" + AnsiConsole.RESET);
                }
            } else {
                System.out.println(AnsiConsole.RED + "Oops! Client with id " + id +
                        " does not exist " + AnsiConsole.RESET);
            }
        }
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

}
