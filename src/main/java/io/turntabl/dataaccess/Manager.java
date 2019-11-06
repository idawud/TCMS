package io.turntabl.dataaccess;

import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private List<Client> clients;

    public Manager(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getClientByName(){
        List<String> allClientInfo = clients.stream().map(c -> c.getName() + " " + c.getAddress() + " " + c.getTelNumber() + " " + c.getEmail()).collect(Collectors.toList());
        return  allClientInfo;
    }



}
