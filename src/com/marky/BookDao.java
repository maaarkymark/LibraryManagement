package com.marky;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {

    public static int save(String callNumber, String name, String author, String publisher, int quantity) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO book(call_number, name, author, publisher, quantity) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, callNumber);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
