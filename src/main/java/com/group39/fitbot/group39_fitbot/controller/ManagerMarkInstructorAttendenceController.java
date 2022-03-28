package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerMarkInstructorAttendenceDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkInstructorAttendence;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerMarkInstructorAttendenceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkInstructorAttendenceController get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkInstructorAttendenceController get method called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String instructorId = req.getParameter("instructorId");
        System.out.println(instructorId);
        LocalDate currentDate = LocalDate.parse(req.getParameter("currentDate"));
        System.out.println(currentDate);
        LocalTime currentTime = LocalTime.parse(req.getParameter("currentTime"));
        System.out.println(currentTime);
        LocalTime shiftTime = LocalTime.parse(req.getParameter("shiftTime"));
        System.out.println(shiftTime);

        boolean added = false;

        try {
            added = ManagerMarkInstructorAttendenceDAO.markInstructorAttendence( new ManagerMarkInstructorAttendence(
                    currentDate,
                    currentTime,
                    shiftTime,
                    instructorId,
                    1
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (added){
            System.out.println("added");
            out.print("1");
        }else {
            System.out.println("not added");
            out.print("0");
        }
    }
}
