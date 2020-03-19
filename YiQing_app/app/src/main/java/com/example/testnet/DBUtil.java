package com.example.testnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class DBUtil {

    public static String db_url = "jdbc:mysql://101.200.132.210:3306/test?useSSL=false&characterEncoding=UTF-8&serverTimezone=GMT";
    public static String db_user = "root";
    public static String db_pass = "root";

    public static Connection getConn () {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select * from myinfo";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println("不空");
        }else{
            System.out.println("空");
        }
    }
}
