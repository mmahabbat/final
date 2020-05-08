package com.company.GUIController.Admin;

import com.company.GUIController.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMain extends JFrame{

    private JButton buttonAddEmployee, buttonMovies, buttonCash, buttonTickets, buttonExit;

    public AdminMain(){

        setTitle("Admin Panel/ Choose option");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        buttonAddEmployee=new JButton("Add Employee");
        buttonAddEmployee.setBounds(250,70,300,50);
        add(buttonAddEmployee);

        buttonMovies=new JButton("Movies");
        buttonMovies.setBounds(250,160,300,50);
        add(buttonMovies);

        buttonCash=new JButton("Cash");
        buttonCash.setBounds(250,250,300,50);
        add(buttonCash);

        buttonTickets=new JButton("Tickets");
        buttonTickets.setBounds(250,340,300,50);
        add(buttonTickets);

        buttonExit = new JButton("EXIT");
        buttonExit.setBounds(20,20, 100,50);
        add(buttonExit);

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login login=new Login();
                login.setVisible(true);
            }
        });


        buttonAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddEmployee adminAddEmployee=new AdminAddEmployee();
                adminAddEmployee.setVisible(true);
        }
            });

        buttonMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminMovies adminMovies= new AdminMovies();
                adminMovies.setVisible(true);
            }
        });

        buttonCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminCash adminCash= new AdminCash();
                adminCash.setVisible(true);
            }
        });

        buttonTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminTickets adminTickets= new AdminTickets();
                adminTickets.setVisible(true);
            }
        });

    }
}

