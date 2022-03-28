package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkMemberAttendence;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerMarkMemberAttendenceDAO {
    public static boolean markMemberAttendence(ManagerMarkMemberAttendence managerMarkMemberAttendence) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO member_attendance (member_id,date,start_time,status) VALUES (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("is attendence part worked?");

      //  int status = 1;
        pst.setString(1,managerMarkMemberAttendence.getMember_id());
        pst.setDate(2, Date.valueOf(managerMarkMemberAttendence.getDate()));
        pst.setTime(3, Time.valueOf(managerMarkMemberAttendence.getStart_time()));
        pst.setInt(4,1);

        return pst.executeUpdate() > 0;
    }
    }




