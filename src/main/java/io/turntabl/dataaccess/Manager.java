package io.turntabl.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Manager {
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public Manager(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getAllClientsDetailInfo() {
        List<String> allClientInfo = clients.stream().map(c -> c.getName() + " " + c.getAddress() + " " + c.getTelNumber() + " " + c.getEmail()).collect(Collectors.toList());
        return allClientInfo;
    }

    //
    public List<Client> findAllMatches(String nameToSearch) {
        List<Client> matchedClient = new ArrayList<>();
        for (Client client :
                clients) {
            if (client.getName() == nameToSearch) {
                matchedClient.add(client);
            }
        }
        return matchedClient;
    }
}

//
//    public List<String> findAllMatches(String nameToSearch) {
//        List<Client> matchedClients = clients.stream().filter(m -> m.getName() == "dawud").collect(Collectors.toList());
//
//        return matchedClients;
//    }

