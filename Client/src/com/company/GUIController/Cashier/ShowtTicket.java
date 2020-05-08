package com.company.GUIController.Cashier;

import com.company.Client;
import com.company.Entity.Tickets;
import com.company.Main;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShowtTicket extends JFrame {

    JLabel IdOfTicket,NameOfFilm,Cost,IdOfHall,Shedule;
    JLabel IdOfTicketEmpty,NameOfFilmEmpty,CostEmpty,IdOfHallEmpty,SheduleEmpty;

    public ShowtTicket(Tickets tickets){
        ArrayList<Tickets> tickets1= Client.dbManager.getTickets();
        String selected1=tickets.getNameOfMovie();
        String selected2=tickets.getScheduleOfMovies();
         for (int i = 0; i <tickets1.size() ; i++) {
             if (selected1.equals(tickets1.get(i).getNameOfMovie()) && selected2.equals(tickets1.get(i).getScheduleOfMovies())) {
                 tickets.setTickets_id(tickets1.get(i).getTickets_id());
             }
             }


        setTitle("Ticket");
        setBounds(800,300,320,250);
        setLayout(null);

        IdOfTicket=new JLabel("Id of ticket:");
        IdOfTicket.setBounds(45,52,90,16);
        add(IdOfTicket);

        NameOfFilm=new JLabel("Name of film:");
        NameOfFilm.setBounds(45,84,90,16);
        add(NameOfFilm);

        Shedule=new JLabel("Time:");
        Shedule.setBounds(45,116,90,16);
        add(Shedule);

        Cost=new JLabel("Cost:");
        Cost.setBounds(45,148,90,16);
        add(Cost);

        IdOfHall=new JLabel("Id of hall:");
        IdOfHall.setBounds(45,180,90,16);
        add(IdOfHall);

        IdOfTicketEmpty=new JLabel(String.valueOf(tickets.getTickets_id()));
        IdOfTicketEmpty.setBounds(135,52,90,16);
        add(IdOfTicketEmpty);

        NameOfFilmEmpty=new JLabel(tickets.getNameOfMovie());
        NameOfFilmEmpty.setBounds(135,84,90,16);
        add(NameOfFilmEmpty);

        SheduleEmpty=new JLabel(tickets.getScheduleOfMovies());
        SheduleEmpty.setBounds(135,116,90,16);
        add(SheduleEmpty);

        CostEmpty=new JLabel(String.valueOf(tickets.getCost()));
        CostEmpty.setBounds(135,148,90,16);
        add(CostEmpty);

        IdOfHallEmpty=new JLabel(String.valueOf(tickets.getIdOfHall()));
        IdOfHallEmpty.setBounds(135,180,90,16);
        add(IdOfHallEmpty);

    }


}
