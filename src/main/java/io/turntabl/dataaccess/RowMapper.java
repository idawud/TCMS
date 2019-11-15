package io.turntabl.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapper {
    public Client clientRowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Client(
                rs.getInt("client_id"),
                rs.getString("client_name"),
                rs.getString("address"),
                rs.getString("tel_num"),
                rs.getString("email")
        );
    }
}
