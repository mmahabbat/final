package com.company.GUIController.Cashier;

import com.company.Client;
import com.company.Entity.Cashier;
import com.company.Entity.Movies;
import com.company.Entity.Person;
import com.company.Entity.Tickets;
import com.company.GUIController.Login;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CashierMain extends JFrame {
    JButton Exit,SoldButton;
    JTable tableListOfMovies;
    JComboBox comboBoxFilmChoice, comboBoxTimeChoice, comboBoxID;
    JLabel NameOfCenter,BeforeJComboBox;
    JScrollPane scrollPane;

    public CashierMain(Person cashier){
        setTitle("Cashier Panel/ Choose option");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        NameOfCenter=new JLabel("Available Films");
        NameOfCenter.setBounds(350,70,100,20);
        add(NameOfCenter);


        ArrayList<Movies> movies= Client.dbManager.getMoviesById();
        int size=movies.size();
        Object[][] data=new Object[size][];

        int i=-1;
        for(Movies pr: movies){
            Object[] row={ pr.getName(), pr.getScheduleOfMovies(), pr.getCost(), pr.getHall_id() };
            data[++i]=row;
        }

        String column[]={ "NAME", "SCHEDULE", "COST", "HALL ID"};
        tableListOfMovies=new JTable(data, column);

        scrollPane= new JScrollPane(tableListOfMovies);
        scrollPane.setBounds(100,100,600,150);
        scrollPane.setVerticalScrollBarPolicy(22);
        add(scrollPane);



        Exit = new JButton("EXIT");
        Exit.setBounds(20,20, 100,50);
        add(Exit);


        String [] choice=new String[movies.size()];
        for (int j = 0; j <movies.size() ; j++) {
            choice[j]=movies.get(j).getName();
        }

        comboBoxFilmChoice =new JComboBox(choice);
        comboBoxFilmChoice.setBounds(100,280,150,40);
        add(comboBoxFilmChoice);

        comboBoxTimeChoice =new JComboBox();
        comboBoxTimeChoice.setBounds(380,280,150,40);
        add(comboBoxTimeChoice);


        SoldButton=new JButton("SELL");
        SoldButton.setBounds(700,280,100,40);
        add(SoldButton);


        SoldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Movies> movies= Client.dbManager.getMoviesById();
                String selected1=(String)comboBoxFilmChoice.getSelectedItem();
                String selected2=(String)comboBoxTimeChoice.getSelectedItem();
                Tickets tickets=new Tickets();

                for (int j = 0; j <movies.size() ; j++) {
                    if (selected1.equals(movies.get(j).getName()) && selected2.equals(movies.get(j).getScheduleOfMovies())){
                        tickets=new Tickets(null, movies.get(j).getName(), movies.get(j).getHall_id(),movies.get(j).getScheduleOfMovies(),movies.get(j).getCost(),false);
                    }
                }
                Client.dbManager.addTicket(tickets);
                ShowtTicket showtTicket=new ShowtTicket(tickets);
                showtTicket.setVisible(true);


               int tot_cash= Client.dbManager.getCashierCash(cashier.getId());
                Client.dbManager.change_cash(cashier.getId(), tot_cash+tickets.getCost());




            }
        });


        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login login=new Login();
                login.setVisible(true);
            }
        });

        comboBoxFilmChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String)comboBoxFilmChoice.getSelectedItem();
                int stringSize=0;

                for (int j = 0; j <movies.size() ; j++) {
                    if (selected.equals(movies.get(j).getName())){
                        stringSize++;
                    }
                }
                String[] choose=new String[stringSize];
                int lo=0;
                for (int j = 0; j <movies.size() ; j++) {
                    if(selected.equals(movies.get(j).getName())){
                        choose[lo]=movies.get(j).getScheduleOfMovies();
                        lo++;
                    }
                }
                comboBoxTimeChoice.setModel(new DefaultComboBoxModel(choose));
            }
        });
    }
}
