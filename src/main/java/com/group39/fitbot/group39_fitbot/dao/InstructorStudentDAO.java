package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Equipment;
import com.group39.fitbot.group39_fitbot.model.InsStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorStudentDAO {

    public static List<InsStudent> getStudent(String MemberId) throws SQLException, ClassNotFoundException{
        System.out.println("in studentDAO");
        System.out.println(MemberId);

        List<InsStudent> all_student = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT r.member_id, CONCAT(r.first_name,' ',r.last_name), br.branch_name,\"Physical\" as type, r.email, r.membership_category  FROM register r INNER JOIN branch br ON br.branch_id = r.branch_id INNER JOIN physical_member p ON p.member_id =r.member_id WHERE p.instructor_id = ?" ;
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, MemberId);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_student.add(new InsStudent(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }
        }


        return all_student;
    }

    public static InsStudent getEachStudent(String MemberId) throws SQLException, ClassNotFoundException{

        InsStudent Student =new InsStudent();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT CONCAT(first_name,' ',last_name),gender ,dob ,weight,height,membership_category  FROM register WHERE member_id=?" ;
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, MemberId);

        ResultSet resultSet = pst.executeQuery();

            if(resultSet.next()) {
               Student.setName(resultSet.getString(1));
               Student.setBranch(resultSet.getString(2));
               Student.setDob(resultSet.getDate(3).toLocalDate());
               Student.setWeight(resultSet.getInt(4));
               Student.setHeight(resultSet.getInt(5));
               Student.setMembership(resultSet.getString(6));
            }


        return Student;
    }

    public static List<Integer> getInstructorStudentCount(String memberID) throws SQLException, ClassNotFoundException{
        List<Integer> studentcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT (SELECT COALESCE(count(member_id),0) FROM physical_member WHERE instructor_id = ?) AS \"Physical\",(SELECT COALESCE(count(member_id),0) FROM virtual_member WHERE instructor_id = ?) AS \"Virtual\"";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, memberID);
        pst.setString(2, memberID);
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            studentcount .add(resultSet.getInt(1));
            studentcount .add(resultSet.getInt(2));
        }

        return studentcount;
    }

}
