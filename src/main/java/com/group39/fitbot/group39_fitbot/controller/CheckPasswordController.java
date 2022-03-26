package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.PasswordConfirmDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.obtainSHA;
import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.toHexStr;

public class CheckPasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckPasswordController post called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String old_password = req.getParameter("old_password");
        String new_password = req.getParameter("new_password");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            old_password = toHexStr(obtainSHA(old_password));

            String password = PasswordConfirmDAO.retrivePassword(memberID);

            if(old_password.equals(password)){
                //only updated user table
                new_password = toHexStr(obtainSHA(new_password));
                boolean added = PasswordConfirmDAO.setNewPasswordUsers(memberID,new_password);
                if(added){
                    System.out.println("added");
                    out.print("1");
                }else{
                    out.print("0");
                }
            }else {
                out.print("0");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
