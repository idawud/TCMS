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

    public ClientDAO(DBType dbType) throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.connect(dbType);
    }

    private ResultSet getResultSet(String queryString, String value) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(queryString);
        if ( !value.isEmpty()) {
            statement.clearParameters();
            statement.setString(1, value);
        }
        return statement.executeQuery();
    }

    private List<Client> getClients(ResultSet rs) throws SQLException {
        List<Client> result = new ArrayList<>();
        while ( rs.next()){
            result.add(rowMapper(rs));
        }
        return result;
    }

    public List<Client> getAllClients() throws SQLException {
        String queryString = "SELECT * FROM clients WHERE active = 'true' ";
        ResultSet rs = getResultSet(queryString, "");
        return getClients(rs);
    }


    public List<Client> getAllSearchedClients(String clientName) throws SQLException {
        String queryString = "SELECT * FROM clients WHERE active = 'true' AND LOWER(client_name) LIKE ?";
        ResultSet rs = getResultSet(queryString, "%" + clientName + "%");
        return getClients(rs);
    }

    public List<Client> getAllSearchedArchivedClients(String clientName) throws SQLException {
        String queryString = "SELECT * FROM clients WHERE active = 'false' AND LOWER(client_name) LIKE ?";
        ResultSet rs = getResultSet(queryString, "%" + clientName + "%");
        return getClients(rs);
    }

    public boolean deleteClient(int id) throws SQLException {
        String queryString = "UPDATE clients  SET active = 'false' " +
                "WHERE active = 'true' AND client_id = ?";
        updateActiveColumn(queryString, id);
        return true;
    }

    public boolean recoverClient(int id) throws SQLException {
        String queryString = "UPDATE clients SET active = 'true' " +
                "WHERE active = 'false' AND client_id = ?";
        updateActiveColumn(queryString, id);
        return true;
    }

    private void updateActiveColumn(String queryString, int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(queryString);
        statement.clearParameters();
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private Client rowMapper(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("client_id"),
                rs.getString("client_name"),
                rs.getString("address"),
                rs.getString("tel_num"),
                rs.getString("email")
        );
    }
}
