package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerMemberView;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerMemberViewDAO {
    public static List<ManagerMemberView> getManagerMemberView(String branchID, LocalDate currentDate) throws SQLException, ClassNotFoundException {
        List<ManagerMemberView> members = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT DISTINCT member.member_id,member.first_name,member.last_name,\n" +
                "register.membership_category,instructor.first_name\n" +
                "FROM ((register\n" +
                "INNER JOIN member ON register.member_id = member.member_id)\n" +
                "INNER JOIN instructor ON instructor.instructor_id = member.instructor_id )\n" +
                "WHERE register.membership_sign = 'physical_member' AND member.branch_id = ? \n" +
                "AND member.member_id NOT IN (Select member_id from member_attendance where date = ?) LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        pst.setDate(2, Date.valueOf(currentDate));
        System.out.println("****************");
        System.out.println(members);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                members.add(new ManagerMemberView(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        }
        System.out.println(members);
        return members;
    }
}
