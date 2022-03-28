package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;

import java.sql.*;
import java.util.List;

public class MaintainerUpdateDAO {
    public static boolean updateForm(FormMaintain formMaintain) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query ="UPDATE form SET status = ? , complet_dis=?, complet_img=?, comp_date=?, comp_time=? WHERE form_id =?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1, 3);
        pst.setString(2, formMaintain.getComplet_dis());
        pst.setString(3, formMaintain.getComplet_img());
        pst.setDate(4, Date.valueOf(formMaintain.getComp_date()));
        pst.setTime(5, Time.valueOf(formMaintain.getComp_time()));
        pst.setString(6, formMaintain.getForm_id());


//        System.out.println(formMaintain);
//        System.out.println("I am in DAO");
//        System.out.println(pst.executeUpdate());
        return pst.executeUpdate()>0;
    }


    public static boolean addMaintainDetails(FormMaintain formMaintain) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query ="INSERT INTO form(equipment_id,maintainer_id,equipment_type,no_of_maintainers,description,status,branch_id,complet_dis,complet_img,comp_date,comp_time,re_date,re_time) VALUES(?,?,?,?,?,?,(SELECT branch_id FROM branch WHERE branch_name=?),?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1, formMaintain.getEquipment_id());
        pst.setString(2, formMaintain.getMaintainer_id());
        pst.setString(3, formMaintain.getEquipment_type());
        pst.setInt(4, formMaintain.getNo_of_maintainers());
        pst.setString(5, formMaintain.getDescription());
        pst.setInt(6, formMaintain.getStatus());
        pst.setString(7, formMaintain.getBranch());
        pst.setString(8, formMaintain.getComplet_dis());
        pst.setString(9, formMaintain.getComplet_img());
        pst.setDate(10, Date.valueOf(formMaintain.getComp_date()));
        pst.setTime(11, Time.valueOf(formMaintain.getComp_time()));
        pst.setDate(12, Date.valueOf(formMaintain.getRe_date()));
        pst.setTime(13, Time.valueOf((formMaintain.getRe_time())));

        return pst.executeUpdate()>0;

    }



}
