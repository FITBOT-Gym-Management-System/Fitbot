package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MaintainerDAO;
import com.group39.fitbot.group39_fitbot.dao.MaintainerEquipmentDAO;
import com.group39.fitbot.group39_fitbot.model.Equipment;
import com.group39.fitbot.group39_fitbot.model.Maintainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MaintainerUpcomeingTaskController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post method call in task");
//        Equipment TaskEquipments = new Equipment();



        try {
            List<Equipment> TaskEquipments = MaintainerEquipmentDAO.getNextTaskList();
//            Gson gson = new Gson();
//            String equipmentsJSON = gson.toJson(TaskEquipments);
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write(equipmentsJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





    }
}
