package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerEquipmentFormDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class ManagerEquipmentFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("equipment form get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_NOTICES/MANAGER_ADD_NEW_EQUIPMENT.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerEquipment equipment = new ManagerEquipment();

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        Date date30 = Date.valueOf(req.getParameter("date30"));

        equipment.setBranch_id(branchID);
        equipment.setCategory(req.getParameter("category"));
        equipment.setDescription(req.getParameter("description"));
        equipment.setPurchase_date(Date.valueOf(req.getParameter("purchase_date")));
        equipment.setSerial_no(req.getParameter("serial_no"));

        System.out.println(equipment);
        String equipment_id = null;

        try{
            int equip_count = ManagerEquipmentFormDAO.equipmentCount();
             equipment_id = "E" + (equip_count+1);
        }catch (SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        equipment.setEquipment_id(equipment_id);


        boolean added = false;
        try {
            added = ManagerEquipmentFormDAO.addNewEquipment(equipment,date30);
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }


        if(added) {
            System.out.println("added");
        }else {
            System.out.println("not added");
        }





    }
}

