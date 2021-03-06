package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAddDAO {
    public static boolean addMaintainer (Employee employee) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnection();
        String query = "INSERT INTO maintainer VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,employee.getEmployee_id());
        pst.setString(2,employee.getFirstname());
        pst.setString(3,employee.getLastname());
        pst.setString(4,employee.getGender());
        pst.setString(5,employee.getEmail());
        pst.setString(6, employee.getNic());
        pst.setString(7, (employee.getDob()));
        pst.setString(8,employee.getAddress());
        pst.setString(9, employee.getPrimarycontact());
        pst.setString(10,employee.getSecondarycontact());
        pst.setDate(11,Date.valueOf(employee.getDate_joined()));

        return pst.executeUpdate()>0;


    }

    public static boolean addInstructor (Employee employee) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnection();
        String query = "INSERT INTO instructor(instructor_id,branch_id,first_name,last_name,gender,email,nic,dob,address,primary_contact,secondary_contact,joined_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,employee.getEmployee_id());
        pst.setString(2,employee.getBranch_id());
        pst.setString(3,employee.getFirstname());
        pst.setString(4,employee.getLastname());
        pst.setString(5,employee.getGender());
        pst.setString(6,employee.getEmail());
        pst.setString(7, employee.getNic());
        pst.setString(8, (employee.getDob()));
        pst.setString(9,employee.getAddress());
        pst.setString(10, employee.getPrimarycontact());
        pst.setString(11,employee.getSecondarycontact());
        pst.setDate(12,Date.valueOf(employee.getDate_joined()));


        return pst.executeUpdate()>0;


    }

    public static boolean addbranchmanager (Employee employee) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnection();
        String query = "INSERT INTO branch_manager VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,employee.getEmployee_id());
        pst.setString(2,employee.getBranch_id());
        pst.setString(3,employee.getFirstname());
        pst.setString(4,employee.getLastname());
        pst.setString(5,employee.getGender());
        pst.setString(6,employee.getEmail());
        pst.setString(7, employee.getNic());
        pst.setString(8, (employee.getDob()));
        pst.setString(9,employee.getAddress());
        pst.setString(10, employee.getPrimarycontact());
        pst.setString(11,employee.getSecondarycontact());
        pst.setDate(12,Date.valueOf(employee.getDate_joined()));

        return pst.executeUpdate()>0;


    }
}
