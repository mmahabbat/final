package com.company.DBManager;

import com.company.Entity.*;

import java.util.ArrayList;

public interface DBManager {


    Person Login(int person_id, String person_password);

    ArrayList<Movies> getMoviesById();

    int getCinemaId();

    ArrayList<Person> getUsersData();

    void addCashier(Cashier cashier);

    void addChecker(Checker checker);

    void deleteEmployee(Integer id);

    void deleteMovies(Integer id);

    void addMovies(Movies movies);
    ArrayList<Tickets> getTickets();

    Tickets getTicketsById(int tickets_id);

     void change_status_of_ticket(int id_of_ticket);

    void addTicket(Tickets tickets);

    void change_cash(int id, int cash);

    int getCashierCash(Integer id);

    int totalIncome();


}
