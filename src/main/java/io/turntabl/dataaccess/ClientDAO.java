package io.turntabl.dataaccess;

import io.turntabl.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientDAO {
    private Connection connection;

    public ClientDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.connect();
    }

    private ResultSet getResultSet(String queryString, List<String> setValues) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(queryString);
        AtomicInteger count = new AtomicInteger(1);
        statement.clearParameters();
        for (String value : setValues) {
            try {
                statement.setString(count.get(), value);
                count.getAndIncrement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement.executeQuery();
    }

    private List<Client> getClients(ResultSet rs) throws SQLException {
        List<Client> result = new ArrayList<>();
        while ( rs.next()){
            result.add(rowMapper(rs, rs.getRow()));
        }
        return result;
    }

    public List<Client> getAllClients() throws SQLException {
        String queryString = "SELECT * FROM clients";
        ResultSet rs = getResultSet(queryString, Collections.emptyList());
        return getClients(rs);
    }


    public List<Client> getAllSearchedClients(String clientName) throws SQLException {
        String queryString = "SELECT * FROM clients WHERE client_name = ?";
        ResultSet rs = getResultSet(queryString, Arrays.asList(clientName));
        return getClients(rs);
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
