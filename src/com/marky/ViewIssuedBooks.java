package com.marky;

import javax.swing.*;
import java.awt.*;

public class ViewIssuedBooks {

    private static JFrame frame;
    private JPanel pnlViewIssuedBooks;

    // Launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new JFrame("Library Management");
                    frame.setContentPane(new ViewIssuedBooks().pnlViewIssuedBooks);
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
