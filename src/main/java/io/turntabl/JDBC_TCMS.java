package io.turntabl;

import java.sql.*;

public class JDBC_TCMS {

    public static void main(String args[]) throws ClassNotFoundException {


        Class.forName("org.postgresql.Driver");

        String url = "https://postgres/clientManager";
        String username = "patricia-agyekum";
        String password = "turntabl";

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
