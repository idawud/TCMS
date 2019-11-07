package io.turntabl.menu;

import io.turntabl.persistance.ClientData;

public class Printer {
    public static void printClientCard(ClientData clientData){
        System.out.println(clientData.toList().get(1));
    }

    public static void printClientCardWithId(ClientData clientData){
        System.out.println(clientData.toList().get(0));
    }
}
