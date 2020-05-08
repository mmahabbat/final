package com.company.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Checker extends Person implements Serializable {

    private String position;
    private int numberOfTickets;
    private ArrayList<Movies> movies;

    public Checker(Integer id, String password, String name, String surname, String position) {
        super(id, password, name, surname);
        this.position = position;
    }

    public Checker() {
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public int getNumberOfTickets() { return numberOfTickets; }

    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }

    public ArrayList<Movies> getMovies() { return movies; }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() { return getId()+" "+getName()+" "+getSurname();}
}
