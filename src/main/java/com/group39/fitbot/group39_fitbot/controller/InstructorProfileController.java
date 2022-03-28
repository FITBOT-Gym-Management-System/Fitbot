package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorProfileDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorProfile;

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

public class InstructorProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor profile get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Instructor/INSTRUCTOR_PROFILE/ins.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor profile post method called");

        HttpSession session = req.getSession();
        String instructorID = (String) session.getAttribute("MemberID");
        System.out.println(instructorID);

        List<InstructorProfile> insprofile = new ArrayList<>();

        try{
            insprofile = InstructorProfileDAO.getInstructorProfile(instructorID);
            System.out.println("lavinka");
            Gson gson = new Gson();
            String insprofileJSON = gson.toJson(insprofile);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(insprofileJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
