package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerPaymentDAO {
    public static List<ManagerPayment> getManagerPayment(String branchID) throws SQLException, ClassNotFoundException{
        List<ManagerPayment> payments = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT online_payment.cus_first_name,online_payment.cus_last_name,\n" +
                "((membership_fee+instructor_price)* (100 - discount_price)/100) AS payment, membership.membership_category,\n" +
                "online_payment.payment_id\n" +
                "FROM (((payment_paidmember_membership\n" +
                "INNER JOIN register ON payment_paidmember_membership.member_id = register.member_id)\n" +
                "INNER JOIN online_payment ON online_payment.payment_id = payment_paidmember_membership.payment_id)\n" +
                "INNER JOIN membership ON membership.membership_id = payment_paidmember_membership.membership_id)\n" +
                "WHERE register.branch_id= ? AND online_payment.payment_method = \"Cash Payment\"\n" +
                "AND online_payment.alter_table_payment_id NOT IN (SELECT alter_table_payment_id from online_payment where payment_status = '1' OR payment_status = '2' ) \n" +
                "ORDER BY payment_paidmember_membership.payment_id DESC";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        System.out.println("****************");
        System.out.println(payments);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                payments.add(new ManagerPayment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        }
            System.out.println(payments);
            return payments;
    }
}
