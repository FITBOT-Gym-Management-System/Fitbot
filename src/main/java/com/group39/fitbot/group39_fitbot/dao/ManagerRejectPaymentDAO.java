package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerRejectPaymentDAO {
    public static boolean setCashRejectPayment(int payment_id) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE online_payment SET payment_status =? WHERE payment_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,"2");
        pst.setInt(2, Integer.parseInt(String.valueOf(payment_id)));

        return pst.executeUpdate() > 0;
    }
}
