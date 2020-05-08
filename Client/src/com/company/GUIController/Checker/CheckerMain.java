package com.company.GUIController.Checker;

import com.company.Client;
import com.company.Entity.Tickets;
import com.company.GUIController.Login;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckerMain extends JFrame {
    JButton Checked,Exit,Search,NotChecked,Back;
    JLabel idOfTicket;
    JTextField idOfTicketEnter;
    JLabel IdOfTicket,NameOfFilm,Cost,IdOfHall,Shedule;
    JLabel IdOfTicketEmpty,NameOfFilmEmpty,CostEmpty,IdOfHallEmpty,SheduleEmpty;
    public CheckerMain(){
        setTitle("Checker Panel/ Choose option");
        setBounds(800,300,485,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        idOfTicket=new JLabel("Enter the id of ticket:");
        idOfTicket.setBounds(100,100,120,30);
        add(idOfTicket);

        idOfTicketEnter=new JTextField();
        idOfTicketEnter.setBounds(221,100,60,30);
        add(idOfTicketEnter);

        Search=new JButton("Search");
        Search.setBounds(305,100,120,30);
        add(Search);



        //*****************************************************************


        IdOfTicket=new JLabel("Id of ticket:");
        IdOfTicket.setBounds(100,180,90,16);
        add(IdOfTicket);
        IdOfTicket.setVisible(false);

        NameOfFilm=new JLabel("Name of film:");
        NameOfFilm.setBounds(100,212,90,16);
        add(NameOfFilm);
        NameOfFilm.setVisible(false);

        Shedule=new JLabel("Time:");
        Shedule.setBounds(100,244,90,16);
        add(Shedule);
        Shedule.setVisible(false);

        Cost=new JLabel("Cost:");
        Cost.setBounds(100,276,90,16);
        add(Cost);
        Cost.setVisible(false);

        IdOfHall=new JLabel("Id of hall:");
        IdOfHall.setBounds(100,308,90,16);
        add(IdOfHall);
        IdOfHall.setVisible(false);

        IdOfTicketEmpty=new JLabel("");
        IdOfTicketEmpty.setBounds(190,180,90,16);
        add(IdOfTicketEmpty);
        IdOfTicketEmpty.setVisible(false);

        NameOfFilmEmpty=new JLabel("");
        NameOfFilmEmpty.setBounds(190,212,90,16);
        add(NameOfFilmEmpty);
        NameOfFilmEmpty.setVisible(false);

        SheduleEmpty=new JLabel("");
        SheduleEmpty.setBounds(190,244,90,16);
        add(SheduleEmpty);
        SheduleEmpty.setVisible(false);

        CostEmpty=new JLabel("");
        CostEmpty.setBounds(190,276,90,16);
        add(CostEmpty);
        CostEmpty.setVisible(false);

        IdOfHallEmpty=new JLabel("");
         IdOfHallEmpty.setBounds(190,308,90,16);
         add(IdOfHallEmpty);
         IdOfHallEmpty.setVisible(false);

//***************************************

        Checked=new JButton("Checked");
        Checked.setBounds(305,180,120,30);
        add(Checked);
        Checked.setVisible(false);
        NotChecked=new JButton("Not checked");
        NotChecked.setBounds(305,180,120,30);
        add(NotChecked);
        NotChecked.setVisible(false);

        Back=new JButton("Finish");
        Back.setBounds(305,230,120,30);
        add(Back);
        Back.setVisible(false);






        Exit = new JButton("EXIT");
        Exit.setBounds(30,30, 60,20);
        add(Exit);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tickets ticket= Client.dbManager.getTicketsById(Integer.parseInt(idOfTicketEnter.getText()));
                IdOfTicketEmpty.setText(String.valueOf(ticket.getTickets_id()));
                NameOfFilmEmpty.setText(ticket.getNameOfMovie());
                SheduleEmpty.setText(ticket.getScheduleOfMovies());
                CostEmpty.setText(String.valueOf(ticket.getCost()));
                IdOfHallEmpty.setText(String.valueOf(ticket.getIdOfHall()));


                System.out.println("work");
                IdOfTicket.setVisible(true);
                NameOfFilm.setVisible(true);
                Shedule.setVisible(true);
                Cost.setVisible(true);
                IdOfHall.setVisible(true);
                IdOfTicketEmpty.setVisible(true);
                NameOfFilmEmpty.setVisible(true);
                SheduleEmpty.setVisible(true);
                CostEmpty.setVisible(true);
                IdOfHallEmpty.setVisible(true);
                if(ticket.isIfChecked()==false) {
                    NotChecked.setVisible(true);
                    Back.setVisible(true);
                }
                else if(ticket.isIfChecked()==true){
                    Checked.setVisible(true);
                    Back.setVisible(true);
                }

            }
        });


        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdOfTicket.setVisible(false);
                NameOfFilm.setVisible(false);
                Shedule.setVisible(false);
                Cost.setVisible(false);
                IdOfHall.setVisible(false);
                IdOfTicketEmpty.setVisible(false);
                NameOfFilmEmpty.setVisible(false);
                SheduleEmpty.setVisible(false);
                CostEmpty.setVisible(false);
                IdOfHallEmpty.setVisible(false);
                NotChecked.setVisible(false);
                Back.setVisible(false);
                Checked.setVisible(false);
            }
        });


        NotChecked.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tickets ticket= Client.dbManager.getTicketsById(Integer.parseInt(idOfTicketEnter.getText()));
                Client.dbManager.change_status_of_ticket(ticket.getTickets_id());

                NotChecked.setVisible(false);
                Checked.setVisible(true);

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


    }

}
