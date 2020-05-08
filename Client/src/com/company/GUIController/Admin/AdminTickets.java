package com.company.GUIController.Admin;

import com.company.Client;
import com.company.Entity.Movies;
import com.company.Entity.Tickets;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminTickets extends JFrame {

    private JLabel NameOfCenter;
    private JTable tableTickets;
    private JButton buttonBack;
    private JScrollPane scrollPane;

    public AdminTickets(){
            setTitle("List of Tickets");
            setBounds(800,300,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);


            NameOfCenter=new JLabel(" Tickets");
            NameOfCenter.setBounds(350,70,100,20);
            add(NameOfCenter);

            ArrayList<Tickets> tickets= Client.dbManager.getTickets();
            int size=tickets.size();
            Object[][] data=new Object[size][];

            int i=-1;
            for(Tickets pr: tickets){
                Object[] row={pr.getTickets_id(),pr.getNameOfMovie(),pr.getIdOfHall(),pr.getScheduleOfMovies(),pr.getCost(), pr.isIfChecked()};
                data[++i]=row;
            }

            String column[]={"ID", "NAME", "HALL ID", "SCHEDULE", "COST", "STATUS"};
        tableTickets=new JTable(data, column);

            scrollPane= new JScrollPane(tableTickets);
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
                   AdminMain adminMain=new AdminMain();
                   adminMain.setVisible(true);
                }
            });



    }
}
