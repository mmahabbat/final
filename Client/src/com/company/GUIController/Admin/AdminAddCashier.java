package com.company.GUIController.Admin;

import com.company.Client;
import com.company.DBManager.DBManagerImpl;
import com.company.Entity.Cashier;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddCashier extends JFrame {

    private JLabel labelName,labelSurname,labelPassword,labelPosition;
    private JTextField textFieldName, textFieldSurname, textFieldPassword, textFieldPosition;
    private JButton buttonBack, buttonAdd;

    public AdminAddCashier(){
        setTitle("ADD CASHIER");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelName=new JLabel("     Name: ");
        labelName.setBounds(220, 130, 200, 40);
        add(labelName);

        labelSurname=new JLabel("Surname: ");
        labelSurname.setBounds(220, 200, 200, 40);
        add(labelSurname);


        textFieldName=new JTextField();
        textFieldName.setBounds(290, 130, 200, 40);
        add(textFieldName);

        textFieldSurname=new JTextField();
        textFieldSurname.setBounds(290, 200, 200, 40);
        add(textFieldSurname);


        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(390,330, 100,30);
        add(buttonAdd);




        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddEmployee adminAddEmployee=new AdminAddEmployee();
                adminAddEmployee.setVisible(true);
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=textFieldName.getText();
                String surname=textFieldSurname.getText();
                String password = "qwerty";
                String position= "cashier";
                Cashier cashier=new Cashier(null, password,name, surname,position,0);
                Client.dbManager.addCashier(cashier);
                System.out.println(cashier);

            }
        });


    }
}
