package com.company.GUIController.Admin;

import com.company.Client;
import com.company.DBManager.DBManagerImpl;
import com.company.Entity.Person;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminListEmployee extends JFrame {

    private JTable tableListEmployee;
    private JButton buttonBack;
    private JScrollPane scrollPane;

    public AdminListEmployee(){
        setTitle("List Employee");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        ArrayList<Person> users= Client.dbManager.getUsersData();
        int size=users.size();
        String[][] data=new String[size][];

        int i=-1;
        for(Person pr: users){
            String[] row={pr.getId().toString(), pr.getName(), pr.getSurname()};
            data[++i]=row;
        }

        String column[]={"ID", "NAME", "POSITION"};
        tableListEmployee=new JTable(data, column);

        scrollPane= new JScrollPane(tableListEmployee);
        scrollPane.setBounds(100,100,600,300);
        scrollPane.setVerticalScrollBarPolicy(22);
        add(scrollPane);


        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddEmployee adminAddEmployee=new AdminAddEmployee();
                adminAddEmployee.setVisible(true);
            }
        });

    }


    }
