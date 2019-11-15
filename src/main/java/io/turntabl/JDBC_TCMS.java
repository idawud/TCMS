package io.turntabl;

import java.sql.*;
import java.util.Properties;

public class JDBC_TCMS {

    public static void main(String args[]) throws ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Properties ours = new Properties();
        ours.setProperty("udername", "adepa");
        ours.setProperty("password", "tryanything");
        //ours.setProperty("ssl", "true");

        String url = "jdbc:postgresql:/localhost:postgresql/clientManager";
        //String username = "adepa";
        //String password = "tryanything";

        //Building the connection

        try (

                Connection db = DriverManager.getConnection(url, ours)) {

            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from clients");
            String output = String.format("%25s %35s %25s %35s", "client_name", "address", "tel_num", "email", "active");

            while(rs.next()) {
                System.out.println(rs.getString("client_name"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getString("tel_num"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("active"));
            }

            //To include some prepared statements

            PreparedStatement cd = db.prepareStatement(
                    "select client_name, address, tel_num, email, active from clients where client_name like ?"
            );
            cd.clearParameters();
            cd.setString(1, "client_name");
            cd.setString(2, "address");
            cd.setString(3, "tel_num");
            cd.setString(4, "email");
            cd.setString(5, "active");
            ResultSet psr = cd.executeQuery();
            String psOut = String.format("%25s %35s %25s %35s", "client_name", "address", "tel_num", "email", "active");

            while(psr.next()) {
                System.out.println(psr.getString("client_name"));
                System.out.println(psr.getString("address"));
                System.out.println(psr.getString("tel_num"));
                System.out.println(psr.getString("email"));
                System.out.println(psr.getString("active"));
            }


        } catch (SQLException sqle) {
            System.err.println("Connection err: " + sqle);

        }
    }
}
