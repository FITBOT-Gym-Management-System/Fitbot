package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaintainerStatusDAO {
    public static boolean setFormMaintainer(String form_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE form SET status=? WHERE form_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
//        Object reset;
//        pst.setString(1,.getstatus();
        pst.setInt(1,2);
        pst.setInt(2, Integer.parseInt(form_id));

        return pst.executeUpdate() > 0;
    }
}
