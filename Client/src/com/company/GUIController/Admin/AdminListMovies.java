package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Entity.Movies;
import com.company.Entity.Person;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminListMovies extends JFrame {
    private JLabel NameOfCenter;
    private JTable tableListOfMovies;
    private JButton buttonBack;
    private JScrollPane scrollPane;

    public AdminListMovies(){
        setTitle("List Movies");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        NameOfCenter=new JLabel(" Films");
        NameOfCenter.setBounds(350,70,100,20);
        add(NameOfCenter);

        ArrayList<Movies> movies= Client.dbManager.getMoviesById();
        int size=movies.size();
        Object[][] data=new Object[size][];

        int i=-1;
        for(Movies pr: movies){
            Object[] row={pr.getCinema_id(), pr.getName(), pr.getScheduleOfMovies(), pr.getCost(), pr.getHall_id() };
            data[++i]=row;
        }

        String column[]={"ID", "NAME", "SCHEDULE", "COST", "HALL ID"};
        tableListOfMovies=new JTable(data, column);

        scrollPane= new JScrollPane(tableListOfMovies);
        scrollPane.setBounds(100,100,600,150);
        scrollPane.setVerticalScrollBarPolicy(22);
        add(scrollPane);


        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20,20, 100,50);
        add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminMovies adminMovies=new AdminMovies();
                adminMovies.setVisible(true);
            }
        });

    }

}
