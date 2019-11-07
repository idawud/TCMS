package io.turntabl.dataformatting;

public class ClientDetails {
    private static int Stringvalue;
    private String fullname;
    private String email;
    private String telno;
    private String address;

    public ClientDetails(String fullname, String email, String telno, String address) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.telno = telno;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelno() {
        return telno;
    }


    public static void prettyPrint(ClientDetails name) {
        System.out.println(AnsiConsole.WHITE_BOLD + "NAME: \t\t" + AnsiConsole.RESET + AnsiConsole.GREEN + name.getFullname() + '\n'
                + AnsiConsole.WHITE_BOLD + "EMAIL: \t\t" + AnsiConsole.RESET + AnsiConsole.BLUE + name.getEmail() + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "TEL. NO.: \t" + AnsiConsole.RESET + AnsiConsole.PURPLE + name.getTelno() + AnsiConsole.RESET + '\n'
                + AnsiConsole.WHITE_BOLD + "ADDRESS: \t" + AnsiConsole.RESET + AnsiConsole.CYAN + name.getAddress() + AnsiConsole.RESET + '\n');
        System.out.println("=========================== ");
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

