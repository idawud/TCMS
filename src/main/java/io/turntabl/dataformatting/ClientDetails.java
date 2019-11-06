package io.turntabl.dataformatting;

import java.util.ArrayList;
import java.util.List;

public class ClientDetails {
    private static int Stringvalue;
    private String fullname;
    private String address;
    private String email;

    public ClientDetails(String fullname, String address, String email) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
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



    public static List<ClientDetails> printDetails() {
        List<ClientDetails> ClientList = new ArrayList<>();
        ClientDetails malam = new ClientDetails("alex owusu", "accra-gh", "alex@gmail.com");
       // ClientList.add(new ClientDetails("alex owusu", "accra-gh", "alex@gmail.com"));
        //ClientList.add(new ClientDetails("frank marfo","kumasi-gh","kofi243165"));
        ClientList.add(malam);
        return ClientList;
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

