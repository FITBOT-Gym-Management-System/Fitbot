package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerMemberViewCheckStatusDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMemberView;

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

public class ManagerMemberViewCheckStatusController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMemberViewCheckStatusController get method calleed");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_MEMBER/MANAGER_MEMBER.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMemberViewCheckStatusController post method calleed");

        String memberId =req.getParameter("memberId");
        System.out.println("ammmmmmaaaaa");

        List<ManagerMemberView> checkAttendenceStatus = new ArrayList<>();

        try{
            checkAttendenceStatus = ManagerMemberViewCheckStatusDAO.getManagerMemberViewCheckStatus(memberId);
            System.out.println(checkAttendenceStatus);
            Gson gson = new Gson();
            String checkAttendenceStatusJSON = gson.toJson(checkAttendenceStatus);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(checkAttendenceStatusJSON);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

    }
}}
