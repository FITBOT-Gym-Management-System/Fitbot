package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Registartion;
import com.group39.fitbot.group39_fitbot.model.ResetPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordConfirmDAO {
    public static boolean setNewPassword(ResetPassword reset) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE register SET password=?,confirm_password=? WHERE phone_number=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,reset.getPassword());
        pst.setString(2,reset.getConfirm_password());
        pst.setInt(3,reset.getPhone_number());

        System.out.println("Registration DAO");
        return pst.executeUpdate() > 0;
    }

    public static String retrivePassword(String member_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        //String query = "SELECT first_name,last_name,dob,phone_number,height,weight FROM register WHERE member_id= ?";
        String query = "SELECT password FROM users WHERE member_id= ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);

        String password = null;

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            password = resultSet.getString(1);
        }
        return password;
    }

    //only updated user table
    public static boolean setNewPasswordUsers(String member_id,String newPassword) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET password=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,newPassword);
        pst.setString(2,member_id);

        return pst.executeUpdate() > 0;
    }

}
