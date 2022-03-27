package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerAddRequest;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerAddRequestDAO {

    public static boolean addNewRequest(ManagerAddRequest manrequest, LocalDate currentDate, LocalTime currentTime) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO form (equipment_id,equipment_type,status,description,re_date,re_time,branchmanager_id,branch_id) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("im sachinka");
        System.out.println(manrequest);

        String status = "1";
        pst.setString(1,manrequest.getEquipment_id());
        pst.setString(2,manrequest.getCategory());
        pst.setString(3,status);
        pst.setString(4,manrequest.getDescription());
        pst.setDate(5, Date.valueOf(currentDate));
        pst.setTime(6, Time.valueOf(currentTime));

        pst.setString(7, manrequest.getBranchmanager_id());
        pst.setString(8, manrequest.getBranch_id());
//
//        pst.setTimestamp(6,manrequest.getRe_time());
//        pst.setTime(6,manrequest.getRe_time());

        return pst.executeUpdate() > 0;
    }

}
