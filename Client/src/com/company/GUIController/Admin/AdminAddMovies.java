package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Entity.Movies;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddMovies extends JFrame {
    private JLabel labelName,labelSchedule,labelCost;
    private JTextField textFieldName, textFieldSchedule, textFieldCost;
    private JButton buttonBack, buttonAdd;
    private JComboBox comboBoxHallId;

    public AdminAddMovies(){
        setTitle("ADD MOVIES");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelName=new JLabel("     Name: ");
        labelName.setBounds(220, 100, 200, 40);
        add(labelName);

        labelSchedule=new JLabel("Schedule: ");
        labelSchedule.setBounds(220, 170, 200, 40);
        add(labelSchedule);

        labelCost=new JLabel("Cost: ");
        labelCost.setBounds(220, 240, 200, 40);
        add(labelCost);

        textFieldName=new JTextField();
        textFieldName.setBounds(290, 100, 200, 40);
        add(textFieldName);

        textFieldSchedule=new JTextField();
        textFieldSchedule.setBounds(290, 170, 200, 40);
        add(textFieldSchedule);

        textFieldCost=new JTextField();
        textFieldCost.setBounds(290, 240, 200, 40);
        add(textFieldCost);


        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        String [] choose={"1", "2"};
        comboBoxHallId=new JComboBox(new DefaultComboBoxModel(choose));
        comboBoxHallId.setBounds(290,310,200,40);
        add(comboBoxHallId);

        buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(390,380, 100,30);
        add(buttonAdd);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminMovies adminMovies=new AdminMovies();
                adminMovies.setVisible(true);

            }
        });



        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=textFieldName.getText();
                String schedule=textFieldSchedule.getText();
                int cost=Integer.parseInt(textFieldCost.getText());
                int hall_id=Integer.parseInt((String)comboBoxHallId.getSelectedItem());

                Movies movies=new Movies(null, name, schedule, cost, hall_id);
                Client.dbManager.addMovies(movies);
                textFieldName.setText("");
                textFieldSchedule.setText("");
                textFieldCost.setText("");
                Successful successful=new Successful();
                successful.setVisible(true);
            }
        });
    }
}
