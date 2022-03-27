package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Equipment;
import com.group39.fitbot.group39_fitbot.model.Maintainer;
import com.group39.fitbot.group39_fitbot.model.PhysicalPayment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaintainerDAO {

    public static Maintainer getMaintainer(String memberID) throws SQLException, ClassNotFoundException {
//        System.out.println("In maintainerDAO");
        Maintainer maintainer = new Maintainer();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT maintainer_id,first_name,last_name,email FROM maintainer WHERE maintainer_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
//      pst.setString(1, login.getMember_id);
        pst.setString(1, memberID);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()){
            maintainer.setMaintainer_id(resultSet.getString(1));
            maintainer.setFirst_name(resultSet.getString(2));
            maintainer.setLast_name(resultSet.getString(3));
            maintainer.setEmail(resultSet.getString(4));

        }

//        System.out.println(maintainer);
        return maintainer;
    }


    public static List<Maintainer> getMaintainersQueue() throws SQLException, ClassNotFoundException {
        List<Maintainer> MaintainerList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT maintainer_id FROM maintainer ORDER BY maintainer_id";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet =pst.executeQuery();

        while (resultSet.next()) {
           if (resultSet != null){
               MaintainerList.add(new Maintainer(
                       resultSet.getString(1)
               ));
           }
        }
        System.out.println("DDDDDDDDDDDDDDDDDDDD");
        System.out.println(MaintainerList);
        System.out.println("DDDDDDDDDDDDDDDDDDDDD");

        return MaintainerList;
    }


//    public static Maintainer getMaintainerDetail(String maintainerID) throws SQLException, ClassNotFoundException {
//
//        Connection connection = DBConnection.getInstance().getConnection();
//        String query = "SELECT * FROM maintainer ORDER BY maintainer_id";
//        PreparedStatement pst = connection.prepareStatement(query);
//        ResultSet resultSet =pst.executeQuery();
//
//        while (resultSet.next()) {
//            if (resultSet != null){
//                MaintainerList.add(new Maintainer(
//                        resultSet.getString(1)
//                ));
//            }
//        }
//        System.out.println("DDDDDDDDDDDDDDDDDDDD");
//        System.out.println(MaintainerList);
//        System.out.println("DDDDDDDDDDDDDDDDDDDDD");
//
//        return MaintainerList;
//    }

    public static boolean addMaintainerTaskDetails(String maintainerID, String equipmentID, LocalDate dateCompare) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "INSERT INTO equipment_modification(equipment_id,maintainer_id,maintainers_date) VALUES(?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,equipmentID);
        pst.setString(2,maintainerID);
        pst.setDate(3, Date.valueOf(dateCompare));

        System.out.println("Payment added addPaymentDetails");

        return pst.executeUpdate() > 0;
    }

    public static boolean updateMaintainerTaskDetails(String equipment_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE equipment SET equipment_has_modified=? WHERE equipment_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,1);
        pst.setString(2,equipment_id);

        System.out.println("Payment added updateMembershipRenewalDetails");

        return pst.executeUpdate() > 0;
    }

}
