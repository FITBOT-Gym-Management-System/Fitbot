package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MaintainFormDAO;
import com.group39.fitbot.group39_fitbot.dao.MaintainerDAO;
import com.group39.fitbot.group39_fitbot.dao.MemberDAO;
import com.group39.fitbot.group39_fitbot.model.*;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;
import com.mysql.cj.callback.UsernameCallback;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintainerController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Maintainer/FullSidebar.html");
        requestDispatcher.forward(req,resp);

//        System.out.println("get method call");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post method call in maintainer");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

//        System.out.println("before userName");
//        System.out.println(session.getAttribute("MemberID"));
//        System.out.println("after userName");

        try {
            Maintainer maintainer = MaintainerDAO.getMaintainer(memberID);
            Gson gson = new Gson();
            String maintainerJSON = gson.toJson(maintainer);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(maintainerJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        }
    }

