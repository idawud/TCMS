package io.turntabl.menu;

import io.turntabl.dataaccess.DataAccess;
import io.turntabl.dataentry.DataEntry;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    private DataAccess dataAccess = new DataAccess();
    public void operation(int option) throws SQLException, ClassNotFoundException, IOException {
        switch (option){
            case 1:
                dataAccess.entry();
                break;
            case 2:
                dataAccess.showAllClientsRecords();
                //DataAccess.showAllClientsRecords();
                break;
            case 3:
                dataAccess.showSearchedClientsRecords();
                //DataAccess.showSearchedClientsRecords();
                break;
            case 4:
                dataAccess.deleteClientRecord();
                //DataAccess.deleteClientRecord();
                break;
            case 5:
                dataAccess.recoverDeleteClientRecord();
                //DataAccess.recoverDeleteClientRecord();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println( AnsiConsole.RED + "\nYou Entered an InCorrect Option!" + AnsiConsole.RESET);
        }
    }


    public static boolean isAnOptionOnMenu(int option){
        return option >= 1 && option <= 6;
    }

    public static int getUserMenuSelection(){
        System.out.print(">>>> ");
        Scanner input = new Scanner(System.in);
        int option;
        try {
            option = input.nextInt();
        }catch (Exception e){
            option = -99999;
        }
        return option;
    }

    public static void menuListing() {
        System.out.println("\n##############\t ENTER: \t##################");
        System.out.println("##\t 1. Enter New Client");
        System.out.println("##\t 2. View All Client");
        System.out.println("##\t 3. Search for a Client");
        System.out.println("##\t 4. Delete a Client");
        System.out.println("##\t 5. Undo Delete");
        System.out.println("##\t 6. Quit this Application");
        System.out.println("####################################################");
    }

}
