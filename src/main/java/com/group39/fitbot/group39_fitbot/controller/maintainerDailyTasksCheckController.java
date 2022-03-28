package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MaintainerEquipmentDAO;
import com.group39.fitbot.group39_fitbot.model.Equipment;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class maintainerDailyTasksCheckController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        String maintainerId= memberID;
        LocalDate currentCompare = LocalDate.parse(req.getParameter("currentDate"));

       /* try {
            List<Equipment> equipment = MaintainerEquipmentDAO.getDailyTaskListCheck(memberID, currentCompare);
            System.out.println(equipment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }
}
