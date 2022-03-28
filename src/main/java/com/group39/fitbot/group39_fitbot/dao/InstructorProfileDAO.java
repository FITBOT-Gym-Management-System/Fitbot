package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InstructorProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorProfileDAO {
    public static List<InstructorProfile> getInstructorProfile(String instructorID) throws SQLException, ClassNotFoundException{
        List<InstructorProfile> ins_profile = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT instructor.first_name,instructor.last_name,\n" +
                "instructor_profile.description,\n" +
                "instructor_profile.country,\n" +
                "instructor_languages.`language`,\n" +
                "instructor_profile.price,\n" +
                "instructor_profile.duration,\n" +
                "instructor_skills.skills \n" +
                "\n" +
                "FROM (((instructor\n" +
                "INNER JOIN instructor_languages ON instructor.instructor_id=instructor_languages.instructor_id)\n" +
                "INNER JOIN instructor_profile ON instructor.instructor_id=instructor_profile.instructor_id)\n" +
                "INNER JOIN instructor_skills ON instructor.instructor_id=instructor_skills.instructor_id)\n" +
                "\n" +
                "WHERE instructor.instructor_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("ins profilee");
        System.out.println(instructorID);
        pst.setString(1, instructorID);
        ResultSet resultSet = pst.executeQuery();


        while (resultSet.next()){
            if (resultSet != null){
                ins_profile.add(new InstructorProfile(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }
        }
        System.out.println("is profile work");
        System.out.println(ins_profile);
        return ins_profile;
    }
}
