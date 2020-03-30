package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian {

    private static JFrame frame;
    private JPanel pnlAddLibrarian;
    private JTextField tfName;
    private JPasswordField pfPassword;
    private JTextField tfEmail;
    private JTextField tfAddress;
    private JTextField tfCity;
    private JTextField tfPhoneNumber;
    private JButton btnAddLibrarian;
    private JButton btnBack;
    private JLabel lblAddLibrarian;
    private JLabel lblName;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JLabel lblAddress;
    private JLabel lblCity;
    private JLabel lblPhoneNumber;

    // Create action listeners
    public AddLibrarian() {
        btnAddLibrarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String password = String.valueOf(pfPassword.getPassword());
                String email = tfEmail.getText();
                String address = tfAddress.getText();
                String city = tfCity.getText();
                String phoneNumber = tfPhoneNumber.getText();

                int i = LibrarianDao.save(name, password, email, address, city, phoneNumber);

                if (name.isBlank() || password.isBlank() || email.isBlank() || address.isBlank() || city.isBlank() || phoneNumber.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Sorry, fields need to be filled!");
                } else if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Librarian added successfully!");
                    tfName.setText("");
                    pfPassword.setText("");
                    tfEmail.setText("");
                    tfAddress.setText("");
                    tfCity.setText("");
                    tfPhoneNumber.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, unable to save!");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminSection.main(new String[]{});
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
                    frame.setContentPane(new AddLibrarian().pnlAddLibrarian);
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
