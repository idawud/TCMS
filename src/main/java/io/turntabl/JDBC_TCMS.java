package io.turntabl;

import java.sql.*;

public class JDBC_TCMS {

    public static void main(String args[]) throws ClassNotFoundException {


        Class.forName("org.postgresql.Driver");

        String url = "https://postgres/clientManager";
        String username = "patricia-agyekum";
        String password = null;

        //Building the connection

        try (

                Connection db = DriverManager.getConnection(url, username, password)) {

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

        } catch (SQLException sqle) {
            System.err.println("Connection err: " + sqle);

        }
    }
}
