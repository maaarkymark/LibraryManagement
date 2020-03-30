package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin {

    private static JFrame frame;
    private JTextField tfEnterName;
    private JPasswordField pfEnterPassword;
    private JButton btnLogin;
    private JLabel lblAdminLoginForm;
    private JLabel lblEnterName;
    private JLabel lblEnterPassword;
    private JPanel pnlAdminLogin;
    private JButton btnBack;

    // Create action listeners
    public AdminLogin() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enterName = tfEnterName.getText();
                String enterPassword = String.valueOf(pfEnterPassword.getPassword());
                if (enterName.equals("admin") && enterPassword.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Welcome " + tfEnterName.getText() + "!");
                    AdminSection.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login error!\nSorry, username or password is invalid.");
                    tfEnterName.setText("");
                    pfEnterPassword.setText("");
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
                    frame.setContentPane(new AdminLogin().pnlAdminLogin);
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

