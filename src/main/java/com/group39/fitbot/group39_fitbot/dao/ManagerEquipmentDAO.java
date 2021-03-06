package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerEquipmentDAO {
    public static List<ManagerEquipment> getManagerEquipment(String branchID) throws SQLException, ClassNotFoundException{
        List<ManagerEquipment> equipments = new ArrayList<>();
//        Equipment equipments = new Equipment();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM equipment WHERE branch_id= ?\n" +
                "AND equipment.equipment_id NOT IN (Select equipment_id from equipment where `status` = 0 ) \n" +
                "ORDER BY equipment_id DESC LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        System.out.println("****************");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                equipments.add(new ManagerEquipment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getDate(7),
                        resultSet.getString(8)
                ));
            }
        }
        System.out.println(equipments);
        return equipments;

    }


    public static boolean setEquipmentDisable(String equipment_id) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE equipment SET status =? WHERE equipment_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,"0");
        pst.setString(2,equipment_id);

        return pst.executeUpdate() > 0;
    }
}
