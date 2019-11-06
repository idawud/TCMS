package io.turntabl.entering_details;

import java.util.Scanner;

public class Client_info_entry {

    String name;
    String address;
    String tel;
    String email;

    public Client_info_entry(String name, String address, String tel, String email) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
    }

    public Client_info_entry(Scanner input) {
    }

    @Override
    public String toString() {
        return "Client_info_entry{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    Scanner input = new Scanner(System.in);

    public Scanner getInput() {
        System.out.println("Full Name: ");
        String name = input.nextLine();

        System.out.println("Address: ");
        String address = input.nextLine();

        System.out.println("Telephone number: ");
        String tel = input.nextLine();

        System.out.println("Email Address: ");
        String email = input.nextLine();

        return input;
    }
}
