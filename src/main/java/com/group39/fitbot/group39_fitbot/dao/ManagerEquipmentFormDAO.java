package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import java.sql.*;

public class ManagerEquipmentFormDAO {

    public ManagerEquipmentFormDAO(){

    }

    public static boolean addNewEquipment(ManagerEquipment equipment) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO equipment (equipment_id,branch_id,category,description,purchase_date,serial_no) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("im sachinka");
        System.out.println(equipment);

        pst.setString(1, equipment.getEquipment_id());
        pst.setString(2, equipment.getBranch_id());
        pst.setString(3,equipment.getCategory());
        pst.setString(4,equipment.getDescription());
        pst.setDate(5, equipment.getPurchase_date());
        pst.setString(6, equipment.getSerial_no());
        return pst.executeUpdate() > 0;
    }


    public static int equipmentCount() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT COUNT(*) AS count_equip FROM equipment";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();

        System.out.println(resultSet);

        int value = 0;

        if(resultSet.next()) {
            if (resultSet != null) {
                value = resultSet.getInt(1);
                System.out.println(value);
                System.out.println("sachinka");
            }

        }
        return value;
    }
}
