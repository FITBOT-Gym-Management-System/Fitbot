package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerEquipmentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ManagerEquipmentDisableController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerEquipmentDisableController get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerEquipmentDisableController post method called");

        PrintWriter out = resp.getWriter();
        String equipment_id = req.getParameter("equipment_id");

        System.out.println(equipment_id);
        resp.setContentType("text/plain");

        boolean disable_equipment=false;

        try {
            disable_equipment = ManagerEquipmentDAO.setEquipmentDisable(equipment_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(disable_equipment){
            out.print("1");
        }else {
            out.print("0");
        }
    }
}
