package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintainerWriteDAO {

    public static FormMaintain getFormDetails(String form_id) throws SQLException, ClassNotFoundException{
        FormMaintain formMaintain=new FormMaintain();
        Connection connection = DBConnection.getInstance().getConnection();
        String query="SELECT * FROM form WHERE form_id =?";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, form_id);

//        System.out.println(form_id);

        ResultSet oldresult = pst.executeQuery();

        if(oldresult.next()){
           formMaintain.setForm_id(oldresult.getString(1));
           formMaintain.setEquipment_id(oldresult.getString(2));
           formMaintain.setMaintainer_id(oldresult.getString(3));
           formMaintain.setEquipment_type(oldresult.getString(4));
           formMaintain.setNo_of_maintainers(oldresult.getInt(5));
           formMaintain.setDescription(oldresult.getString(6));
           formMaintain.setStatus(oldresult.getInt(7));
           formMaintain.setBranchmanager_id(oldresult.getString(8));
           formMaintain.setBranch(oldresult.getString(9));
           formMaintain.setRe_time(oldresult.getTime(10).toLocalTime());
           formMaintain.setRe_date(oldresult.getDate(11).toLocalDate());
           formMaintain.setComplet_dis(oldresult.getString(12));
           formMaintain.setComplet_img(oldresult.getString(13));
           formMaintain.setComp_date(oldresult.getDate(14).toLocalDate());
           formMaintain.setComp_time(oldresult.getTime(15).toLocalTime());

        }
//        System.out.println(formMaintain.getBranch_id());
        return formMaintain;
    }
}
