package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerInstructorView;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerInstructorViewDAO {
    public static List<ManagerInstructorView> getManagerInstructorView(String branchID) throws SQLException,ClassNotFoundException{
        List<ManagerInstructorView> all_instrucotr = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT instructor.first_name,instructor.last_name,instructor.joined_date,instructor.instructor_id \n" +
                "FROM instructor \n" +
                "INNER JOIN instructor_attendance ON instructor_attendance.instructor_id=instructor.instructor_id\n" +
                "WHERE instructor.branch_id = ? AND instructor_attendance.`status` = 0";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
//        pst.setDate(2, Date.valueOf(currentDate));

        System.out.println("****************");
        System.out.println(all_instrucotr);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()){
            if (resultSet != null){
                all_instrucotr.add(new ManagerInstructorView(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4)
                ));
            }
        }
        System.out.println(all_instrucotr);
        return all_instrucotr;
    }
}
