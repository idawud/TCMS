package io.turntabl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TCMS {
    private static Scanner InputStream;

    @Override
    public String toString() {
        return "TCMS{}";
    }

    public static void main(String[] args) {

        String pattern;
        String check = null;

        Scanner input = new Scanner(System.in);
        System.out.println("Full Name: ");
        Pattern patterncheck = Pattern.compile(String.valueOf(input), Pattern.CASE_INSENSITIVE);
        //public Scanner useDelimiter(Pattern patterncheck){}

        String name = input.nextLine();
       // public Scanner scanner =  Scanner(InputStream input);


        System.out.println("Address: ");
        String address = input.nextLine();

        System.out.println("Telephone number: ");
        String tel = input.nextLine();

        System.out.println("Email Address: ");
        String email = input.nextLine();

        System.out.println("Name: " + "  " + name + "  " +"Address: " + "  " + address + "  " + "Telephone: " + "  " + tel + "  " + "Email: " + "  " + email);
        Scanner enter = new Scanner(System.in);
        System.out.println("Press enter to accept this information");
        enter.nextLine();
        enter.close();

        System.out.println(input);
    }
}
