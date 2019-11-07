package io.turntabl.dataformatting;

public class TCMS {

    public static void main(String[] args) {

        ClientDetails malam = new ClientDetails("alex owusu", "alex@gmail.com", "+223 4567 565", "Tantro Rd Kotobabi Accra Ghana");
        ClientDetails patricia = new ClientDetails("partricia owusu", "partricia@gmail.com", "+223 44347 565", "Mean Street Kumasi Accra Ghana");

        malam.prettyPrint(malam);
        patricia.prettyPrint(patricia);

    }

}
