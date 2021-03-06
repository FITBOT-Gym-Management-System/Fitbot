package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.PhysicalPayment;
import com.group39.fitbot.group39_fitbot.model.Registartion;
import com.group39.fitbot.group39_fitbot.model.UpdateWeight;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditProfileDAO {
    public static boolean updateMemberDetails(Registartion registartion) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
//        String query = "UPDATE register SET first_name=?,last_name=?,dob=?,phone_number=?,height=?,weight=? WHERE member_id=?";
        String query = "UPDATE register SET first_name=?,last_name=?,phone_number=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,registartion.getFirst_name());
        pst.setString(2,registartion.getLast_name());
//        pst.setDate(3, Date.valueOf(registartion.getDate_of_birth()));
        pst.setInt(3,registartion.getContact_number());
//        pst.setInt(5,registartion.getHeight());
//        pst.setInt(6,registartion.getWeight());
        pst.setString(4,registartion.getMember_id());

        System.out.println("Edit profile DAO");
        return pst.executeUpdate() > 0;
    }

    public static boolean updateLoginDetails(String memberId, Part edit_profile_container_detail_last_profile_image) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET user_image_url=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
//        pst.setString(1,registartion.getFirst_name());
        pst.setBlob(1,edit_profile_container_detail_last_profile_image.getInputStream());
        pst.setString(2,memberId);

        return pst.executeUpdate() > 0;
    }

    public static Blob getImageData(String member_id) throws SQLException, ClassNotFoundException {
        Registartion register = new Registartion();

        Connection connection = DBConnection.getInstance().getConnection();

        //String query = "SELECT first_name,last_name,dob,phone_number,height,weight FROM register WHERE member_id= ?";
        String query = "SELECT user_image_url FROM users WHERE member_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
//        pst.setString(3,login.getUserType());

        ResultSet resultSet = pst.executeQuery();

//        Part filePart = null;
        Blob filePart = null;

        if (resultSet.next()) {
            filePart = resultSet.getBlob(1);
            return filePart;
        } else {
            return null;
        }
    }

    public static Registartion retriveRegistration(String member_id) throws SQLException, ClassNotFoundException {
        Registartion register = new Registartion();

        Connection connection = DBConnection.getInstance().getConnection();

        //String query = "SELECT first_name,last_name,dob,phone_number,height,weight FROM register WHERE member_id= ?";
        String query = "SELECT first_name,last_name,dob,phone_number,address,height,weight,email FROM register WHERE member_id= ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
//        pst.setString(3,login.getUserType());

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            register.setFirst_name(resultSet.getString(1));
            register.setLast_name(resultSet.getString(2));
            register.setDate_of_birth((resultSet.getDate(3)).toLocalDate());
            register.setContact_number(resultSet.getInt(4));
            register.setAddress(resultSet.getString(5));
            register.setHeight(resultSet.getInt(6));
            register.setWeight(resultSet.getInt(7));
            register.setEmail(resultSet.getString(8));
            return register;
        } else {
            return null;
        }
    }

    public static Registartion retriveInstructorRegistration(String instructorID) throws SQLException, ClassNotFoundException {
        Registartion register = new Registartion();

        Connection connection = DBConnection.getInstance().getConnection();

        //String query = "SELECT first_name,last_name,dob,phone_number,height,weight FROM register WHERE member_id= ?";
        String query = "SELECT first_name,last_name,dob,primary_contact,address,email FROM instructor WHERE instructor_id= ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, instructorID);
//        pst.setString(3,login.getUserType());

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            register.setFirst_name(resultSet.getString(1));
            register.setLast_name(resultSet.getString(2));
            register.setDate_of_birth((resultSet.getDate(3)).toLocalDate());
            register.setContact_number(resultSet.getInt(4));
            register.setAddress(resultSet.getString(5));
            register.setEmail(resultSet.getString(6));
            return register;
        } else {
            return null;
        }
    }

    public static boolean updateWeightDetails(UpdateWeight updateWeight) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO weight_update(member_id,update_date,daily_count,previous_weight,new_weight) VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,updateWeight.getMember_id());
        pst.setDate(2,Date.valueOf(updateWeight.getUpdate_date()));
        pst.setInt(3,updateWeight.getDaily_count());
        pst.setDouble(4,updateWeight.getPrevious_weight());
        pst.setDouble(5,updateWeight.getNew_weight());

        return pst.executeUpdate() > 0;
    }

    public static List<UpdateWeight> retriveUpdateWeight(String member_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM weight_update WHERE member_id= ? ORDER BY update_date DESC";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
//        pst.setString(3,login.getUserType());
        List<UpdateWeight> updateWeightList = new ArrayList<>();

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()) {
            if (resultSet != null) {
                updateWeightList.add(
                      new  UpdateWeight(
                              resultSet.getInt(1),
                              resultSet.getString(2),
                              resultSet.getDate(3).toLocalDate(),
                              resultSet.getInt(4),
                              resultSet.getDouble(5),
                              resultSet.getDouble(6)
                      )
                );
            }
        }
        return updateWeightList;
    }

    public static boolean updateRegisterWeight(String member_id, double weight) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE register SET weight=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setDouble(1,weight);
        pst.setString(2,member_id);

        return pst.executeUpdate() > 0;
    }
}
