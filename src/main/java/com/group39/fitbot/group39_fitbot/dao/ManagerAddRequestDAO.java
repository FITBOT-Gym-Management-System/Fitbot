package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerAddRequest;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerAddRequestDAO {

    public static boolean addNewRequest(ManagerAddRequest manrequest, LocalDate currentDate, LocalTime currentTime) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO form (equipment_id,maintainer_id,equipment_type,no_of_maintainers,status,description,re_date,re_time,branchmanager_id,branch_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("im sachinka");
        System.out.println(manrequest);

        int status = Integer.parseInt("1");
        pst.setString(1,manrequest.getEquipment_id());
        pst.setString(2,"Man2");
        pst.setString(3,manrequest.getCategory());
        pst.setInt(4,2);
        pst.setInt(5,status);
        pst.setString(6,manrequest.getDescription());
        pst.setDate(7, Date.valueOf(currentDate));
        pst.setTime(8, Time.valueOf(currentTime));

        pst.setString(9, manrequest.getBranchmanager_id());
        pst.setString(10, manrequest.getBranch_id());
//
//        pst.setTimestamp(6,manrequest.getRe_time());
//        pst.setTime(6,manrequest.getRe_time());

        return pst.executeUpdate() > 0;
    }

}
