package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerMemberView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerMemberViewCheckStatusDAO {
    public static List<ManagerMemberView> getManagerMemberViewCheckStatus(String memberId) throws SQLException,ClassNotFoundException{
        List<ManagerMemberView> checkStatus_attendence = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT member_attendance.date,member_attendance.`status` FROM member_attendance WHERE member_id = ? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberId);
        System.out.println("****************");
        System.out.println(checkStatus_attendence);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                checkStatus_attendence.add(new ManagerMemberView(
                        resultSet.getDate(1).toLocalDate(),
                        resultSet.getInt(2)
                ));
            }
    }
        System.out.println(checkStatus_attendence);
        return checkStatus_attendence;
}
}
