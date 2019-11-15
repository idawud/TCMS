package io.turntabl.menu;

import io.turntabl.dataaccess.DataAccess;
import io.turntabl.dataentry.DataEntry;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    public static void operation(int option) throws SQLException, ClassNotFoundException, IOException {
        switch (option){
            case 1:
                entry();
                break;
            case 2:
                DataAccess.showAllClientsRecords();
                break;
            case 3:
                DataAccess.showSearchedClientsRecords();
                break;
            case 4:
                DataAccess.deleteClientRecord();
                break;
            case 5:
                DataAccess.recoverDeleteClientRecord();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println( AnsiConsole.RED + "\nYou Entered an InCorrect Option!" + AnsiConsole.RESET);
        }
    }

    private static void entry() throws SQLException, ClassNotFoundException, IOException {
        if (DataEntry.toSave()){
            System.out.println(AnsiConsole.GREEN + "\nClient Added Successfully!!!" + AnsiConsole.RESET);
        }
        else{
            System.out.println(AnsiConsole.RED +"\nSomething went wrong! \nData was not stored!" + AnsiConsole.RESET);
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

    public static void welcome() {
        System.out.println(AnsiConsole.YELLOW +"*****************************************************************************\n"
                        + "***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***\n"
                        + "*****************************************************************************" + AnsiConsole.RESET);
    }
}
