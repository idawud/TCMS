package io.turntabl.persistance;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public List<String> toList(){
        return Arrays.asList(name, address, telephoneNumber, email, String.valueOf(id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientData that = (ClientData) o;
        return  Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(telephoneNumber, that.telephoneNumber) &&
                Objects.equals(email, that.email);
    }

    public int getId() {
        return id;
    }
}
