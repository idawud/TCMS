package io.turntabl.dataformatting;

public class TCMS {
    public static void main(String[] args) {
       // ClientDetails clientDetails = new ClientDetails("marfo kofi","kkk","sdfghjkl");
        ;
        ClientDetails malam = new ClientDetails("alex owusu", "accra-gh", "alex@gmail.com");
       System.out.println(ClientDetails.printDetails());
        ClientDetails francis = new ClientDetails("francis owusu", "accra-gh", "alex@gmail.com");
        System.out.println("=========================== ");
        System.out.println(AnsiConsole.GREEN +"NAME:    " +  malam.getFullname()+'\n'+"ADDRESS: "+ malam.getAddress());
        System.out.println("=========================== ");
        System.out.println("NAME:    " +  francis.getFullname()+'\n'+"ADDRESS: "+ francis.getAddress());

    }

//public TCMS(){
   // System.out.println(ClientDetails.printfomat());
  //  }
}
