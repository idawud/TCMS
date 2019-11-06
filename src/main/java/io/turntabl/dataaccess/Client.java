package io.turntabl.dataaccess;

public class Client {
    private String name;
    private String address;
    private String telNumber;
    private String email;

    public Client(String name, String address, String telNumber, String email) {
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
