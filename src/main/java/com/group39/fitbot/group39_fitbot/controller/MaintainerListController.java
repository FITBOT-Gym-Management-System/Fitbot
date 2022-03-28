package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MaintainerDAO;
import com.group39.fitbot.group39_fitbot.dao.MaintainerEquipmentDAO;
import com.group39.fitbot.group39_fitbot.model.Equipment;
import com.group39.fitbot.group39_fitbot.model.Maintainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MaintainerListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("in get maintainer");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        out.print(memberID);

    }
}
