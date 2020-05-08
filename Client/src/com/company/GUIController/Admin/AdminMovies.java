package com.company.GUIController.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMovies extends JFrame {

    private JButton buttonBack, buttonAdd, buttonRemove, buttonListMovies ;

    public AdminMovies(){
        setTitle("Movies");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(250, 130, 300,50);
        add(buttonAdd);

        buttonRemove = new JButton("REMOVE");
        buttonRemove.setBounds(250,220,300,50);
        add(buttonRemove);

        buttonListMovies = new JButton("LIST OF MOVIES");
        buttonListMovies.setBounds(250,310,300,50);
        add(buttonListMovies);

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

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAddMovies adminAddMovies=new AdminAddMovies();
                adminAddMovies.setVisible(true);
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminRemoveMovies adminRemoveMovies=new AdminRemoveMovies();
                adminRemoveMovies.setVisible(true);
            }
        });

        buttonListMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminListMovies adminListMovies=new AdminListMovies();
                adminListMovies.setVisible(true);
            }
        });
}
}
