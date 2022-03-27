package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Equipment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintainerEquipmentDAO {

    public static List<Equipment> getEquipmentList(String List_order,String Branch_selecter,String Equipments_id) throws SQLException, ClassNotFoundException {
//        System.out.println("in equipmentsDAO");
        List<Equipment> equipments = new ArrayList<>();
//        Equipment equipment = new Equipment();

        if ((Branch_selecter.equals("all")) && (Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration FROM branch, equipment WHERE branch.branch_id = equipment.branch_id LIMIT 10";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            System.out.println("all print in dao");
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getDate(6).toLocalDate(),
                            resultSet.getDate(7).toLocalDate(),
                            resultSet.getInt(8)
                    ));
                }
            }
            System.out.println(equipments);

        } else if ((!Branch_selecter.equals("all")) && (Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration FROM branch, equipment WHERE branch.branch_id = equipment.branch_id AND branch_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Branch_selecter);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getDate(6).toLocalDate(),
                            resultSet.getDate(7).toLocalDate(),
                            resultSet.getInt(8)
                    ));
                }
            }
            System.out.println(equipments);

        }else if ((Branch_selecter.equals("all")) && (!Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration FROM branch, equipment WHERE branch.branch_id = equipment.branch_id AND equipment_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Equipments_id);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getDate(6).toLocalDate(),
                            resultSet.getDate(7).toLocalDate(),
                            resultSet.getInt(8)
                    ));
                }
            }
            System.out.println(equipments);

        }else if ((!Branch_selecter.equals("all")) && (!Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration FROM branch, equipment WHERE branch.branch_id = equipment.branch_id AND equipment_id=? AND branch_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Equipments_id);
            pst.setString(2, Branch_selecter);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getDate(6).toLocalDate(),
                            resultSet.getDate(7).toLocalDate(),
                            resultSet.getInt(8)
                    ));
                }
            }
            System.out.println(equipments);

        }else {
            System.out.println("in else");
        }
        System.out.println("before the return");
        System.out.println(equipments);
        return equipments;
    }


    public static List<Equipment> getNextTaskList() throws SQLException, ClassNotFoundException {
        List<Equipment> equipments = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        System.out.println("all print in dao");
        String query = "SELECT SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration FROM branch, equipment WHERE branch.branch_id = equipment.branch_id LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();
        System.out.println("all print in dao");
        while (resultSet.next()) {
            if (resultSet != null) {
                equipments.add(new Equipment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getDate(7).toLocalDate(),
                        resultSet.getInt(8)
                ));
            }
        }

        return null;
    }

    public static List<Equipment> getDailyTaskList(LocalDate date) throws SQLException, ClassNotFoundException {
        List<Equipment> equipments = new ArrayList<>();
        System.out.println("date"+date);
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch.branch_location,equipment.equipment_id,equipment.description,equipment.category,equipment.purchase_date,equipment.last_modified_date,equipment.next_maintenance_date,equipment.Duration,equipment.equipment_has_modified FROM branch, equipment WHERE branch.branch_id=equipment.branch_id AND next_maintenance_date >= ? ORDER BY next_maintenance_date";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setDate(1, Date.valueOf(date));
        System.out.println(date);
        System.out.println(Date.valueOf(date));
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                equipments.add(new Equipment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getDate(7).toLocalDate(),
                        resultSet.getInt(8),
                        resultSet.getInt(9)
                ));
            }
        }
//        System.out.println("11111111111");
//        System.out.println(equipments);
//        System.out.println("11111111111111");
        return equipments;
    }
}
