package com.marky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLibrarian {

    private static JFrame frame;
    private JPanel pnlDeleteLibrarian;
    private JTextField tfEnterID;
    private JButton btnDelete;
    private JButton btnBack;
    private JLabel lblEnterID;

    // Create action listeners
    public DeleteLibrarian() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strID = tfEnterID.getText();
                if (strID == null || strID.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "ID can't be blank.");
                } else {
                    int id = Integer.parseInt(strID);
                    int i = LibrarianDao.delete(id);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                        tfEnterID.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Unable to delete given ID!");
                        tfEnterID.setText("");
                    }
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
                    frame.setContentPane(new DeleteLibrarian().pnlDeleteLibrarian);
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
