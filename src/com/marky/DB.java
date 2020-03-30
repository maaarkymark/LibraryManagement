package com.marky;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management?useTimezone=true&serverTimezone=UTC","root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
