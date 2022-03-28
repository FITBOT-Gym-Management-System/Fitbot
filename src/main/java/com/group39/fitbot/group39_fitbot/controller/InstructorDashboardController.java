package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorDashboardDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorDashboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor dashboard get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Instructor/INSTRUCTOR_DASHBOARD/instructor_dashboard.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor dashboard post method called");

        HttpSession session = req.getSession();
        String instructorID = (String) session.getAttribute("MemberID");
        System.out.println(instructorID);

//        List<InstructorDashboard> ins_dashboard = new ArrayList<>();

        try{
            List<InstructorDashboard> ins_dashboard = new ArrayList<>();
            ins_dashboard = InstructorDashboardDAO.getInstructorDashboard(instructorID);
            System.out.println(ins_dashboard);
            System.out.println("sunillll");
            Gson gson = new Gson();
            String insdashJSON = gson.toJson(ins_dashboard);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(insdashJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
