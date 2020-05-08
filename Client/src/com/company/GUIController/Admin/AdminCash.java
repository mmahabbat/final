package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCash extends JFrame {
    private JLabel labelTotalIncome, labelEmpty;
    private JButton buttonBack;


    public AdminCash(){
        setTitle("Cash");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelTotalIncome=new JLabel("Total Income:");
        labelTotalIncome.setBounds(250,100,300,50);
        add(labelTotalIncome);

        int totalIncome= Client.dbManager.totalIncome();

        labelEmpty=new JLabel(String.valueOf(totalIncome));
        labelEmpty.setBounds(360,100,300,50);
        add(labelEmpty);


        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminMain adminMain=new AdminMain();
                adminMain.setVisible(true);
            }
        });

    }
}
