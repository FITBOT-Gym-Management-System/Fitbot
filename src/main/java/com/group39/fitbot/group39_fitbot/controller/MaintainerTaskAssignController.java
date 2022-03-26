package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MaintainerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

public class MaintainerTaskAssignController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MaintainerTaskAssignController called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String maintainerID = req.getParameter("maintainerID");
        String equipmentID = req.getParameter("equipmentID");
        LocalDate dateCompare = LocalDate.parse(req.getParameter("dateCompare"));

        try {
            boolean added = MaintainerDAO.addMaintainerTaskDetails(maintainerID,equipmentID,dateCompare);
            boolean added1 = MaintainerDAO.updateMaintainerTaskDetails(equipmentID);

            if(added && added1){
                out.print("1");
            }else if(!added){
                System.out.println("Added failed");
                out.print("0");
            }else{
                out.print("0");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
