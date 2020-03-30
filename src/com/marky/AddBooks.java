package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBooks {

    private static JFrame frame;
    private JPanel pnlAddBooks;
    private JTextField tfCallNumber;
    private JTextField tfName;
    private JTextField tfAuthor;
    private JTextField tfPublisher;
    private JTextField tfQuantity;
    private JButton btnAdd;
    private JButton btnBack;
    private JLabel lblAddBooks;
    private JLabel lblCallNumber;
    private JLabel lblName;
    private JLabel lblAuthor;
    private JLabel lblPublisher;
    private JLabel lblQuantity;

    // Create action listeners
    public AddBooks() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String callNumber = tfCallNumber.getText();
                String name = tfName.getText();
                String author = tfAuthor.getText();
                String publisher = tfPublisher.getText();
                int quantity = Integer.parseInt(tfQuantity.getText());

                int i = BookDao.save(callNumber, name, author, publisher, quantity);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Book(s) added successfully!");
                    tfCallNumber.setText("");
                    tfName.setText("");
                    tfAuthor.setText("");
                    tfPublisher.setText("");
                    tfQuantity.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, unable to save!");
                }
            }
        });

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
                    frame.setContentPane(new AddBooks().pnlAddBooks);
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
