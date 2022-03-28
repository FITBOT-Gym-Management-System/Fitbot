package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InstructorDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDashboardDAO {
    public static List<InstructorDashboard> getInstructorDashboard(String instructorID) throws SQLException, ClassNotFoundException {
        List<InstructorDashboard> insdashboard = new ArrayList<>();
//        InstructorDashboard insdashboard = new InstructorDashboard();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT \n" +
                "(SELECT count(physical_member.member_id)\n" +
                "FROM (physical_member\n" +
                "INNER JOIN instructor ON physical_member.instructor_id = instructor.instructor_id)\n" +
                "WHERE physical_member.instructor_id = ?),\n" +
                "\n" +
                "(SELECT count(virtual_member.member_id)\n" +
                "FROM (virtual_member\n" +
                "INNER JOIN instructor ON virtual_member.instructor_id = instructor.instructor_id)\n" +
                "WHERE virtual_member.instructor_id = ?),\n" +
                "\n" +
                "instructor.first_name,instructor.last_name\n" +
                "FROM instructor\n" +
                "WHERE instructor.instructor_id= ?";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("ins dashboaaarddd");
        System.out.println(instructorID);
        pst.setString(1, instructorID);
        pst.setString(2, instructorID);
        pst.setString(3, instructorID);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                insdashboard.add(new InstructorDashboard(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));

            }
        }
        System.out.println("is dashboard work");
        System.out.println(insdashboard);
        return insdashboard;
    }
}
