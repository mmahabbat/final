package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Entity.Movies;
import com.company.Entity.Person;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminRemoveMovies extends JFrame {
    private JLabel NameOfCenter,labelChoose;
    private JTable tableListOfMovies;
    private JComboBox comboBoxChooseFilm;
    private JButton buttonBack, buttonRemove;
    private JScrollPane scrollPane;

    public AdminRemoveMovies(){
        setTitle("REMOVE MOVIES");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

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

        setTitle("REMOVE MOVIES");
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

        String [] choose=new String[movies.size()];
        for (int j = 0; j <movies.size() ; j++) {
             choose[j]=movies.get(j).getName();
        }
        comboBoxChooseFilm=new JComboBox(new DefaultComboBoxModel(choose));
        comboBoxChooseFilm.setBounds(100,280,150,30);
        add(comboBoxChooseFilm);

        labelChoose=new JLabel();
        labelChoose.setBounds(300,280,150,30);
        add(labelChoose);

        buttonRemove=new JButton("REMOVE");
        buttonRemove.setBounds(600,280,120,30);
        add(buttonRemove);

        comboBoxChooseFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String)comboBoxChooseFilm.getSelectedItem();
                for (int j = 0; j <movies.size() ; j++) {
                    if (selected.equals(movies.get(j).getName())){
                        labelChoose.setText(String.valueOf(movies.get(j).getCinema_id()));
                    }
                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String)comboBoxChooseFilm.getSelectedItem();

                for (int j = 0; j <movies.size() ; j++) {
                    if (selected.equals(movies.get(j).getName())){
                        Client.dbManager.deleteMovies((movies.get(j).getCinema_id()));
                    }
                }
                setVisible(false);
                AdminRemoveMovies ad=new AdminRemoveMovies();
                ad.setVisible(true);

            }
        });
    }
}
