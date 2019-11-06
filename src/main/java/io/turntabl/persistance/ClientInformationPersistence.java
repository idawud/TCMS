package io.turntabl.persistance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc Storing & Retrieving Client Information from a File
 */
public class ClientInformationPersistence {
    public boolean store(String name, String address, String telephoneNumber, String email){
        return false;
    }

    public List<ClientData> retrieveAll(){
        return new ArrayList<>();
    }

    public List<ClientData> search(String name){
        return new ArrayList<>();
    }

    public boolean delete(int id){
        return false;
    }

    private int generateId(){
        return 0;
    }

}
