package io.turntabl.menu;

import io.turntabl.ThreadProcessing;

import java.util.Scanner;

public class AppMenu  {

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


    public void run() throws InterruptedException {
        ThreadProcessing threadProcessing = new ThreadProcessing();
        while (true) {
            AppMenu.menuListing();
            int option = AppMenu.getUserMenuSelection();
            if (AppMenu.isAnOptionOnMenu(option)) {
                threadProcessing.operation(option);
            } else {
                System.out.println(AnsiConsole.RED + "You Entered an InCorrect Option!" + AnsiConsole.RESET);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
