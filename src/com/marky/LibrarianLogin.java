package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibrarianLogin {

    private static JFrame frame;
    private JTextField tfEnterName;
    private JPasswordField pfEnterPassword;
    private JButton btnLogin;
    private JLabel lblLibrarianLoginForm;
    private JLabel lblEnterName;
    private JLabel lblEnterPassword;
    private JPanel pnlLibrarianLogin;
    private JButton btnBack;

    // Create action listeners
    public LibrarianLogin() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enterName = tfEnterName.getText();
                String enterPassword = String.valueOf(pfEnterPassword.getPassword());
                try{
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("SELECT name, password FROM librarian WHERE name = ? AND password = ?");
                    ps.setString(1, enterName);
                    ps.setString(2, enterPassword);
                    ResultSet results = ps.executeQuery();
                    if (results.next()) {
                        JOptionPane.showMessageDialog(null, "Welcome " + tfEnterName.getText() + "!");
                        LibrarianSection.main(new String[]{});
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login error!\nSorry, username or password is invalid.");
                        tfEnterName.setText("");
                        pfEnterPassword.setText("");
                    }
                    results.close();
                    con.close();
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryManagement.main(new String[]{});
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
                    frame.setContentPane(new LibrarianLogin().pnlLibrarianLogin);
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
