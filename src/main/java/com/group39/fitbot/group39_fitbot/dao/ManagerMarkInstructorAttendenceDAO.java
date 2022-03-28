package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkInstructorAttendence;

import java.sql.*;

public class ManagerMarkInstructorAttendenceDAO {
    public static boolean markInstructorAttendence(ManagerMarkInstructorAttendence managerMarkInstructorAttendence) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO instructor_attendance (instructor_id,date,start_time,end_time,status) VALUES (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("is attendence part worked?");

        //  int status = 1;
        pst.setString(1,managerMarkInstructorAttendence.getInstructor_id());
        pst.setDate(2, Date.valueOf(managerMarkInstructorAttendence.getDate()));
        pst.setTime(3, Time.valueOf(managerMarkInstructorAttendence.getStart_time()));
        pst.setTime(4, Time.valueOf(managerMarkInstructorAttendence.getEnd_time()));
        pst.setInt(5,1);

        return pst.executeUpdate() > 0;
    }
}
