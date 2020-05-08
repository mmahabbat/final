package com.company.GUIController.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddEmployee extends JFrame {

    private JButton buttonAddCashier, buttonAddChecker, buttonListEmployee, buttonBack,buttonDeleteEmployee;

    public AdminAddEmployee(){

        setTitle("Add Employers /List Employee");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        buttonAddCashier =new JButton("Add Cashier");
        buttonAddCashier.setBounds(250,115,300,50);
        add(buttonAddCashier);

        buttonAddChecker =new JButton("Add Checker");
        buttonAddChecker.setBounds(250,195,300,50);
        add(buttonAddChecker);

        buttonListEmployee =new JButton("List employee");
        buttonListEmployee.setBounds(250,275,300,50);
        add(buttonListEmployee);

        buttonDeleteEmployee =new JButton("Delete employee");
        buttonDeleteEmployee.setBounds(250,355,300,50);
        add(buttonDeleteEmployee);

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


        buttonListEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminListEmployee adminListEmployee=new AdminListEmployee();
                adminListEmployee.setVisible(true);
            }
        });

        buttonDeleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminDeleteEmployee adminListEmployee=new AdminDeleteEmployee();
                adminListEmployee.setVisible(true);
            }
        });

        buttonAddCashier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddCashier adminAddCashier=new AdminAddCashier();
                adminAddCashier.setVisible(true);
            }
        });

        buttonAddChecker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddChecker adminAddChecker= new AdminAddChecker();
                adminAddChecker.setVisible(true);
            }
        });


    }



}
