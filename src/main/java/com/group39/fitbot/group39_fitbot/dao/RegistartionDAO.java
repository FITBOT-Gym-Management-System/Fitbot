package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Login;
import com.group39.fitbot.group39_fitbot.model.Member;
import com.group39.fitbot.group39_fitbot.model.PhysicalPayment;
import com.group39.fitbot.group39_fitbot.model.Registartion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistartionDAO {
    public static boolean addRegistration(Registartion register) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO register VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,register.getFirst_name());
        pst.setString(2,register.getLast_name());
        pst.setDate(3, Date.valueOf(register.getDate_of_birth()));
        pst.setInt(4,register.getContact_number());
        pst.setString(5,register.getAddress());
        pst.setString(6,register.getCountry());
        pst.setString(7,register.getGender());
        pst.setString(8,register.getPassword());
        pst.setString(9,register.getConfirm_password());
        pst.setString(10,register.getMember_type());
        pst.setString(11,register.getMembership_category());

        pst.setInt(12,register.getHeight());
        pst.setInt(13,register.getWeight());
        pst.setString(14,register.getMember_id());
        pst.setString(15,register.getEmail());
        pst.setString(16,register.getBranch_type());
        pst.setDate(17, Date.valueOf(register.getJoined_date()));

//        System.out.println("Registration DAO");
        return pst.executeUpdate() > 0;
    }

//    public static String retriveBranchDetails(String branchType) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String query = "SELECT branch_id FROM branch WHERE branch_location = ?";
//        PreparedStatement pst = connection.prepareStatement(query);
//        pst.setString(1,branchType);
//
//        ResultSet resultSet = pst.executeQuery();
//
//        String branchId = null;
//
//        if (resultSet.next()) {
//            if (resultSet != null) {
//                branchId = resultSet.getString(1);
//            }
//        }
//        return branchId;
//    }

    public static boolean addRegistrationToUserTable(Registartion register) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO users(user_name,password,user_type,member_id,status) VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

//        pst.setString(1,register.getFirst_name());
        pst.setString(1,register.getEmail());
        pst.setString(2,register.getPassword());
        pst.setString(3,register.getMember_type());
        pst.setString(4,register.getMember_id());
        pst.setInt(5,1);
        return pst.executeUpdate() > 0;
    }

    public static boolean addRegistrationToUserTableStatus() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO users(status) VALUES(?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,1);
        return pst.executeUpdate() > 0;
    }

}
