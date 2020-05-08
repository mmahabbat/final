package com.company.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cashier extends Person implements Serializable {

    private String position;
    private int cash;
    private ArrayList<Movies> movies;


    public Cashier(Integer id, String password, String name, String surname, String position, int cash) {
        super(id, password, name, surname);
        this.position = position;
        this.cash = cash;

    }

    public Cashier() {
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public int getCash() { return cash; }

    public void setCash(int cash) { this.cash = cash; }

    public ArrayList<Movies> getMovies() { return movies; }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() { return getId()+" "+getName()+" "+getSurname(); }
}
