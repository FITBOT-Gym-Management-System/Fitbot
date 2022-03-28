package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorAppointmentDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorAppointment;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorAppointmentCountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method call in ins student");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        List<InstructorAppointment> all_appointment = new ArrayList<>();

        try {
            all_appointment = InstructorAppointmentDAO.getAppointmentCount(memberID);
//            System.out.println("00000000000000");
            System.out.println(all_appointment);
            Gson gson = new Gson();
            String appointmentJSON = gson.toJson(all_appointment);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(appointmentJSON);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
