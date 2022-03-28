package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.AdminMemberCountDAO;
import com.group39.fitbot.group39_fitbot.dao.InstructorStudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorStudentCountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Student Count Post Method Called");
        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            List<Integer> studentcount = new ArrayList<>();
            studentcount = InstructorStudentDAO.getInstructorStudentCount(memberID);
            System.out.println(studentcount );
            Gson gson = new Gson();
            String employeecountJSON = gson.toJson(studentcount );
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(employeecountJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
