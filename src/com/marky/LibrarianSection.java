package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSection {

    private static JFrame frame;
    private JPanel pnlLibrarianSection;
    private JButton btnAddBooks;
    private JButton btnViewBooks;
    private JButton btnIssueBook;
    private JButton btnViewIssuedBooks;
    private JButton btnReturnBook;
    private JButton btnLogout;
    private JLabel lblLibrarianSection;

    // Create action listeners
    public LibrarianSection() {
        btnAddBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBooks.main(new String[]{});
                frame.dispose();
            }
        });

        btnViewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooks.main(new String[]{});
                frame.dispose();
            }
        });

        btnIssueBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueBook.main(new String[]{});
                frame.dispose();
            }
        });

        btnViewIssuedBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBooks.main(new String[]{});
                frame.dispose();
            }
        });

        btnReturnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBook.main(new String[]{});
                frame.dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianLogin.main(new String[]{});
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
                    frame.setContentPane(new LibrarianSection().pnlLibrarianSection);
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
