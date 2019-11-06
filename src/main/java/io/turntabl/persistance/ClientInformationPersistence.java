package io.turntabl.persistance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc Storing & Retrieving Client Information from a File
 */
public class ClientInformationPersistence {
    /**
     *
     * @param name
     * @param address
     * @param telephoneNumber
     * @param email
     * @return
     */
    public boolean store(String name, String address, String telephoneNumber, String email){
        return false;
    }

    /**
     *
     * @return
     */
    public List<ClientData> retrieveAll(){
        return new ArrayList<>();
    }

    /**
     *
     * @param name
     * @return
     */
    public List<ClientData> search(String name){
        return new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(int id){
        return false;
    }

    /**
     *
     * @return
     */
    private int generateId(){
        return 0;
    }

}
