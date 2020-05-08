package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Entity.Person;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeleteEmployee extends JFrame {
    private JLabel labelPosition,labelID;
    private JTable tableListEmployee;
    private JButton buttonBack, buttonDeleteEmployee;
    private JScrollPane scrollPane;
    private JComboBox comboBoxChoosePosition, comboBoxChooseEmployee;

    public AdminDeleteEmployee(){
        setTitle("Delete Employee");
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

        String column[]={"ID", "SURNAME", "POSITION"};
        tableListEmployee=new JTable(data, column);

        scrollPane= new JScrollPane(tableListEmployee);
        scrollPane.setBounds(100,100,600,150);
        scrollPane.setVerticalScrollBarPolicy(22);
        add(scrollPane);

        String [] choose={"cashier", "checker"};
        comboBoxChoosePosition=new JComboBox(new DefaultComboBoxModel(choose));
        comboBoxChoosePosition.setBounds(165,300,150,30);
        add(comboBoxChoosePosition);

        comboBoxChooseEmployee=new JComboBox();
        comboBoxChooseEmployee.setBounds(385,300,150,30);
        add(comboBoxChooseEmployee);

        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        buttonDeleteEmployee = new JButton("DELETE");
        buttonDeleteEmployee.setBounds(605,300, 80,30);
        add(buttonDeleteEmployee);

        labelPosition=new JLabel("Position: ");
        labelPosition.setBounds(100,300,60,30);
        add(labelPosition);

        labelID=new JLabel("ID: ");
        labelID.setBounds(360,300,20,30);
        add(labelID);

        comboBoxChoosePosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String)comboBoxChoosePosition.getSelectedItem();

                if(selected.equals("cashier")){
                    int stringSize=0;
                    for (int j = 0; j <users.size() ; j++) {
                        if(users.get(j).getSurname().equals("cashier")){
                            stringSize++;
                        }
                    }
                    String [] chosen=new String[stringSize];

                    int lenght=0;
                    for (int j = 0; j <users.size() ; j++) {
                        if(users.get(j).getSurname().equals("cashier")){
                            chosen [lenght] =users.get(j).getId().toString();
                            lenght++;
                        }
                    }

                   comboBoxChooseEmployee.setModel(new DefaultComboBoxModel(chosen));
                }
                else if(selected.equals("checker")){
                    int stringSize=0;
                    for (int j = 0; j <users.size() ; j++) {
                        if(users.get(j).getSurname().equals("checker")){
                            stringSize++;
                        }
                    }
                    String [] chosen=new String[stringSize];
                    int lenght=0;
                    for (int j = 0; j <users.size() ; j++) {
                        if(users.get(j).getSurname().equals("checker")){
                            chosen [lenght] =users.get(j).getId().toString();
                            lenght++;
                        }
                    }
                    comboBoxChooseEmployee.setModel(new DefaultComboBoxModel(chosen));
                }
            }
        });



        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddEmployee adminAddEmployee=new AdminAddEmployee();
                adminAddEmployee.setVisible(true);
            }
        });


        buttonDeleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chosen=Integer.parseInt((String)comboBoxChooseEmployee.getSelectedItem());
                Client.dbManager.deleteEmployee(chosen);
                setVisible(false);
                AdminDeleteEmployee ad=new AdminDeleteEmployee();
                ad.setVisible(true);
                Successful successful=new Successful();
                successful.setVisible(true);
            }
        });

    }


}