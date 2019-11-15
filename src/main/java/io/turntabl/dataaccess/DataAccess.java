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

public class DataAccess {
    private static ClientDAO clientDAO;

    static {
        try {
            clientDAO = new ClientDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DataAccess() throws SQLException, ClassNotFoundException { }

    public static void showAllClientsRecords() throws SQLException {
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

    public static void showSearchedClientsRecords() throws SQLException {
        String name = DataEntry.getStringInput("Enter Client's name: ");
        List<Client> records = clientDAO.getAllSearchedClients(name);
        printRecords(records);
    }

    public static void deleteClientRecord() throws IOException {
        queryAndMoveClientData( DBConnection.FILEPATH,
                                DBConnection.ARCHIVEPATH,
                            "\nEnter the ID to be deleted: ",
                            "\nClient Record Deleted Successfully!");
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
        queryAndMoveClientData( DBConnection.ARCHIVEPATH,
                                DBConnection.FILEPATH,
                            "\nEnter the ID to be recovered: ",
                            "\nClient Record Recovered Successfully!");
    }

    private static void queryAndMoveClientData(Path fromPath, Path toPath, String s, String s2) throws IOException {
        String name = DataEntry.getStringInput("Enter Client's Name: ");
        DBConnection cip = new DBConnection();
        List<Client> records = cip.search(name, fromPath);

        if (records.size() == 0) {
            Printer.recordNotFound();
        } else {
            records.forEach(Printer::printClientCardWithId);
            List<Integer> searchedIds = records.stream()
                    .map(Client::getId)
                    .collect(Collectors.toList());
            int id = getId(s);
            if (isValidId(id, searchedIds)) {
                if (cip.moveRecord(id, fromPath, toPath)) {
                    System.out.println(AnsiConsole.GREEN + s2 + AnsiConsole.RESET);
                } else {
                    System.out.println(AnsiConsole.RED + "Oops! Client with id " + id + " does not exist" + AnsiConsole.RESET);
                }
            } else {
                System.out.println(AnsiConsole.RED + "You entered an invalid id" + AnsiConsole.RESET);
            }
        }
    }

}
