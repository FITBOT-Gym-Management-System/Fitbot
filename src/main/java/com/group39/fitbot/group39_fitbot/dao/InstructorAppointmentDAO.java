package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InsAppointment;
import com.group39.fitbot.group39_fitbot.model.InsStudent;
import com.group39.fitbot.group39_fitbot.model.InstructorAppointment;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorAppointmentDAO {

    public static List<PhysicalAppointment> getAppointment(String InsId) throws SQLException, ClassNotFoundException{
        System.out.println("in student appointment");
        System.out.println(InsId);

        List<PhysicalAppointment> all_appointment = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT  a.appointment_date, a.start_time, a.finish_time ,a.equipment,CONCAT(r.first_name,' ',r.last_name)FROM register r INNER JOIN physical_member p ON r.member_id =p.member_id INNER JOIN appointment a ON a.member_id = p.member_id  WHERE p.instructor_id = ? AND a.start_time > TIME(SYSDATE()) AND DATEDIFF(appointment_date,UTC_DATE()) between 0 and 2 ORDER BY a.start_time";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, InsId);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_appointment.add(new PhysicalAppointment(
                        resultSet.getDate(1).toLocalDate(),
                        resultSet.getTime(2).toLocalTime(),
                        resultSet.getTime(3).toLocalTime(),
                        resultSet.getString(4),
                        resultSet.getString(5)

                ));
            }
        }


        return all_appointment;
    }

    public static List<InstructorAppointment> getAppointmentCount(String InsId) throws SQLException, ClassNotFoundException{
        System.out.println("in student appointment");
        System.out.println(InsId);

        List<InstructorAppointment> all_appointment = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT appointment.appointment_date ,COUNT(appointment.member_id) FROM appointment INNER JOIN physical_member ON physical_member.member_id = appointment.member_id WHERE physical_member.instructor_id=? GROUP BY appointment.appointment_date ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, InsId);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_appointment.add(new InstructorAppointment(
                       resultSet.getDate(1).toLocalDate(),
                        resultSet.getInt(2)

                ));
            }
        }


        return all_appointment;
    }
}
