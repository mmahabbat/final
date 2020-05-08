package com.company.Entity;

import java.io.Serializable;

public class Tickets implements Serializable {

    private Integer tickets_id;
    private String nameOfMovie;
    private int idOfHall;
    private String scheduleOfMovies;
    private int cost;
    private boolean ifChecked;

    public Tickets(Integer tickets_id, String nameOfMovie, int idOfHall, String scheduleOfMovies, int cost, boolean ifChecked) {
        this.tickets_id = tickets_id;
        this.nameOfMovie = nameOfMovie;
        this.idOfHall = idOfHall;
        this.scheduleOfMovies = scheduleOfMovies;
        this.cost = cost;
        this.ifChecked = ifChecked;
    }

    public Tickets() {
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getTickets_id() { return tickets_id; }

    public void setTickets_id(Integer tickets_id) { this.tickets_id = tickets_id; }

    public String getNameOfMovie() { return nameOfMovie; }

    public void setNameOfMovie(String nameOfMovie) { this.nameOfMovie = nameOfMovie; }

    public int getIdOfHall() { return idOfHall; }

    public void setIdOfHall(int idOfHall) { this.idOfHall = idOfHall; }

    public String getScheduleOfMovies() { return scheduleOfMovies; }

    public void setScheduleOfMovies(String scheduleOfMovies) { this.scheduleOfMovies = scheduleOfMovies; }

    public boolean isIfChecked() { return ifChecked; }

    public void setIfChecked(boolean ifChecked) { this.ifChecked = ifChecked; }
}
