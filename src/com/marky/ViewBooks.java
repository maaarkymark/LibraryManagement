package com.marky;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ViewBooks {

    private static JFrame frame;
    private JPanel pnlViewBooks;
    private JTable tblViewBooks;
    private JButton btnBack;
    private JScrollPane scpViewBooks;

    // Create action listener
    public ViewBooks() {

        String[] column = null;
        String[][] data = null;

        try {

            DefaultTableModel model = new DefaultTableModel();

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM book", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = rsmd.getColumnName(i);
                model.addColumn(column[i - 1]);
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            data = new String[rows][cols];
            int count = 0;
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = rs.getString(i);
                }
                model.addRow(new String[]{data[count][0], data[count][1], data[count][2], data[count][3], data[count][4]});
                count++;
            }
            tblViewBooks.setModel(model);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianSection.main(new String[]{});
                frame.dispose();
            }
        });
    }

    // Launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new JFrame("Library Management");
                    frame.setContentPane(new ViewBooks().pnlViewBooks);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
