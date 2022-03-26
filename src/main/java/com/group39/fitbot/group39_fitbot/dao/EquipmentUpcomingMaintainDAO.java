package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipmentUpcomingMaintainDAO {
    public static List<ManagerEquipment> getEquipment(String branchID,Date date30) throws SQLException, ClassNotFoundException {
        List<ManagerEquipment> maintain = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT equipment_id,category,next_maintenance_date FROM equipment \n" +
                "WHERE ((next_maintenance_date >= UTC_DATE() AND next_maintenance_date <= ?) \n" +
                "AND branch_id= ?)\n" +
                "ORDER BY equipment_id DESC LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setDate(1, date30);
        pst.setString(2,branchID);

        System.out.println("****************");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                maintain.add(new ManagerEquipment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)
                ));
            }
        }
        System.out.println(maintain);
        return maintain;
    }
}

