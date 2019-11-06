package io.turntabl.persistance;

/**
 *
 */
class ClientData {
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;

    public ClientData(String name, String address, String telephoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
