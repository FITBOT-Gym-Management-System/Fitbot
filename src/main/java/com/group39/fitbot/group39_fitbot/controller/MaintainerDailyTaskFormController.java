package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MaintainerUpdateDAO;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class MaintainerDailyTaskFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("maintainerDailyTaskForm");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        FormMaintain formDailyTasks=new FormMaintain();
        formDailyTasks.setEquipment_id(req.getParameter("equipment_id"));
        formDailyTasks.setMaintainer_id(memberID);
        formDailyTasks.setEquipment_type(req.getParameter("category"));
        formDailyTasks.setNo_of_maintainers(1);
        formDailyTasks.setDescription(req.getParameter("description"));
        formDailyTasks.setStatus(3);
        formDailyTasks.setBranch(req.getParameter("branch_name"));
        formDailyTasks.setComplet_dis(req.getParameter("complet_dis"));
        formDailyTasks.setComplet_img(req.getParameter("complet_img"));
        formDailyTasks.setComp_date(Date.valueOf(req.getParameter("currentDate")).toLocalDate());
        formDailyTasks.setComp_time(Time.valueOf(req.getParameter("currentTime")).toLocalTime());


        boolean addMaintain=false;
        try {
            addMaintain = MaintainerUpdateDAO.addMaintainDetails(formDailyTasks);
            System.out.println(addMaintain);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
