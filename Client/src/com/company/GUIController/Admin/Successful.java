package com.company.GUIController.Admin;

import javax.swing.*;

public class Successful extends JFrame {
    private JLabel labelSuccessful;

    public Successful() {
        setTitle("SUCCESSFUL");
        setBounds(1000, 600, 300, 150);
        setLayout(null);

        labelSuccessful = new JLabel("SUCCESSFUL!!!!");
        labelSuccessful.setBounds(50, 50, 300, 50);
        add(labelSuccessful);
    }
}
