package io.turntabl.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private List<Client> clients;

    public Manager(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getClientDetailInfo(){
        List<String> allClientInfo = clients.stream().map(c -> c.getName() + " " + c.getAddress() + " " + c.getTelNumber() + " " + c.getEmail()).collect(Collectors.toList());
        return  allClientInfo;
    }


    public List<String> getClientDetailsByNameSearch() {
        return null;
    }

    public List<Client> findAllMarches(String nameToSearch){
        List<Client> matchedClient = new ArrayList<>();
        for (Client client :
                clients) {
            if (client.getName() == nameToSearch) {
                matchedClient.add(client);
            }
        }
    }


}
