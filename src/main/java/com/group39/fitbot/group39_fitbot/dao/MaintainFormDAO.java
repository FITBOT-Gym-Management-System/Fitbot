package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;
import com.group39.fitbot.group39_fitbot.model.MaintainerChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintainFormDAO {
    public static List<FormMaintain> getFormMaintain(String memberID) throws SQLException, ClassNotFoundException{
        List<FormMaintain> forms = new ArrayList<>();
//        FormMaintain formMaintain=new FormMaintain();
        Connection connection = DBConnection.getInstance().getConnection();
//        String query="SELECT * FROM form WHERE maintainer_id = ?";
        String query = "SELECT form.form_id, form.equipment_type, form.status ,branch.branch_name , form.re_date , IFNULL(form.comp_date,UTC_DATE())   FROM form INNER JOIN branch ON form.branch_id= branch.branch_id WHERE form.maintainer_id =? ORDER BY form.status";
//        String query = "SELECT branch_id , category , Duration ,description , purchase_date,last_modified_date FROM equipment";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, memberID);
//        System.out.println(memberID);

        ResultSet resultSet = pst.executeQuery();
//        System.out.println("DAO method called in new");

        while(resultSet.next()){
            if(resultSet !=null){
                forms.add(new FormMaintain(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDate(6).toLocalDate()
                ));
            }
        }
//        System.out.println(forms);
        return forms;
    }


    public static List<MaintainerChart> getActivityChart(String memberID) throws SQLException, ClassNotFoundException {
//        MaintainerChart activitycount = new MaintainerChart();
        List<MaintainerChart> activitycount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT comp_date , count(*) FROM form WHERE maintainer_id=? AND DATEDIFF(UTC_DATE(),comp_date) between 1 and 8 GROUP BY comp_date";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, memberID);
        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet !=null){
                activitycount.add(new MaintainerChart(
                        resultSet.getDate(1).toLocalDate(),
                        resultSet.getInt(2)

                ));
            }
        }

        return activitycount;
    }


}
