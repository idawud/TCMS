package io.turntabl.persistance;

/**
 *
 */
public class ClientData {
    private int id;
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;

    public ClientData(int id, String name, String address, String telephoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    String toCSV(){
        return ( this.id + "," + this.name + "," +  this.address + ","  + this.telephoneNumber + "," + this.email + "\n" );
    }

}
