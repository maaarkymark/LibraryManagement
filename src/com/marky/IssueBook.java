package com.marky;

import javax.swing.*;
import java.awt.*;

public class IssueBook {

    private static JFrame frame;
    private JPanel pnlIssueBook;

    // Launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new JFrame("Library Management");
                    frame.setContentPane(new IssueBook().pnlIssueBook);
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
