package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSection {

    private static JFrame frame;
    private JPanel pnlAdminSection;
    private JButton btnAddLibrarian;
    private JButton btnViewLibrarian;
    private JButton btnDeleteLibrarian;
    private JButton btnLogout;
    private JLabel lblAdminSection;
    private JButton btnBack;

    // Create action listeners
    public AdminSection() {
        btnAddLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddLibrarian.main(new String[]{});
                frame.dispose();
            }
        });

        btnViewLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewLibrarian.main(new String[]{});
                frame.dispose();
            }
        });

        btnDeleteLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteLibrarian.main(new String[]{});
                frame.dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin.main(new String[]{});
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
                    frame.setContentPane(new AdminSection().pnlAdminSection);
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

