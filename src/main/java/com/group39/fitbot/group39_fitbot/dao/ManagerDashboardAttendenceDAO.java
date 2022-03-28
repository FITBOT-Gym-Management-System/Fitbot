package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAttendence;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerDashboardAttendenceDAO {

    public static List<ManagerDashboardAttendence> getManagerDashboardAttendence(String branchID, LocalDate firstdate,LocalDate lastdate,LocalDate fullDate) throws SQLException, ClassNotFoundException {
        List<ManagerDashboardAttendence> new_attendence = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT\n" +
                "(SELECT SUM(online_payment.payment_amount)\n" +
                "FROM ((online_payment\n" +
                "INNER JOIN  payment_paidmember_membership ON payment_paidmember_membership.payment_id = online_payment.payment_id)\n" +
                "INNER JOIN register ON register.member_id = payment_paidmember_membership.member_id)\n" +
                "WHERE register.branch_id = ? AND \n" +
                "online_payment.payment_date >= ? AND online_payment.payment_date <= ?),\n" +
                "\n" +
                "(SELECT COUNT(instructor_attendance.instructor_id)\n" +
                "FROM (instructor_attendance\n" +
                "INNER JOIN instructor ON instructor.instructor_id = instructor_attendance.instructor_id)\n" +
                "WHERE instructor.branch_id = ? AND instructor_attendance.date= ?),\n" +
                "\n" +
                "(SELECT COUNT(register.member_id)\n" +
                "FROM (member_attendance\n" +
                "INNER JOIN register ON register.member_id = member_attendance.member_id)\n" +
                "WHERE register.branch_id = ? AND member_attendance.date= ? ),\n" +
                "\n" +
                "(SELECT COUNT(appointment.appointment_id)\n" +
                "FROM ((appointment\n" +
                "INNER JOIN register ON appointment.member_id = register.member_id)\n" +
                "INNER JOIN branch ON branch.branch_id = register.branch_id)\n" +
                "WHERE branch.branch_id = ? ),\n" +
                "\n" +
                "(SELECT COUNT(register.member_id)\n" +
                "FROM register\n" +
                "WHERE register.branch_id= ? AND register.joined_date = UTC_DATE())";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, branchID);
        pst.setDate(2, Date.valueOf(firstdate));
        pst.setDate(3, Date.valueOf(lastdate));
        pst.setString(4, branchID);
        pst.setDate(5, Date.valueOf(fullDate));
        pst.setString(6, branchID);
        pst.setDate(7, Date.valueOf(fullDate));
        pst.setString(8, branchID);
//        pst.setDate(9, Date.valueOf(fullDate));
        pst.setString(9, branchID);

        System.out.println(branchID);
        System.out.println("attendence print");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                new_attendence.add(new ManagerDashboardAttendence(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
        }
        System.out.println(new_attendence);
        return new_attendence;
    }
}