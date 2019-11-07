package io.turntabl.menu;

import io.turntabl.dataentry.DataEntry;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    public static void operation(int option) throws IOException {
        switch (option){
            case 1:
                entry();
                break;
            case 2:
                System.out.println("Viewing all client");
                break;
            case 3:
                System.out.println("Searching for client");
                break;
            case 4:
                System.out.println("Deleting a client");
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("You Entered an InCorrect Option!");
        }
    }

    private static void entry() throws IOException {
        if (DataEntry.toSave()){
            System.out.println("Client Added Successfully!!!");
        }
        else{
            System.out.println("Something went wrong! \n Data was not stored!");
        }
    }

    public static boolean isAnOptionOnMenu(int option){
        return option >= 1 && option <= 5;
    }

    public static int getUserMenuSelection(){
        System.out.println(">>>> ");
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
        System.out.println("##############\t\t ENTER: ");
        System.out.println("\t\t\t 1. Enter New Client");
        System.out.println("\t\t\t 2. View All Client");
        System.out.println("\t\t\t 3. Search for a Client");
        System.out.println("\t\t\t 4. Delete a Client");
        System.out.println("\t\t\t 5. Quit this Application");
    }

    public static void welcome() {
        System.out.println("*****************************************************************************");
        System.out.println("***||          WELCOME TO TURNTABL CLIENT MANAGEMENT SYSTEM             ||***");
        System.out.println("*****************************************************************************");
    }
}
