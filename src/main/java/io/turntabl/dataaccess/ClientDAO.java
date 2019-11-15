package io.turntabl.dataaccess;

import io.turntabl.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.connect();
    }

    private ResultSet getResultSet(String queryString) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(queryString);
        return statement.executeQuery();
    }

    public List<Client> getAllClients() throws SQLException {
        String queryString = "Select * from clients";
        ResultSet rs = getResultSet(queryString);
        List<Client> result = new ArrayList<>();
        while ( rs.next()){
            result.add(rowMapper(rs, rs.getRow()));
        }
        return result;
    }

    public List<Client> getAllSearchedClients(String clientName){
        return new ArrayList<>();
    }

    public boolean deleteClient(int id){
        return false;
    }

    public boolean recoverClient(int id){
        return false;
    }

    public Client rowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Client(
                rs.getInt("client_id"),
                rs.getString("client_name"),
                rs.getString("address"),
                rs.getString("tel_num"),
                rs.getString("email")
        );
    }
}
