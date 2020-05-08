package com.company.Entity;

import java.io.Serializable;

public class Movies implements Serializable {

    private Integer cinema_id;
    private String name;
    private String scheduleOfMovies;
    private int cost;
    private int hall_id;

    public Movies(Integer cinema_id, String name, String scheduleOfMovies, int cost, int hall_id) {
        this.cinema_id = cinema_id;
        this.name = name;
        this.scheduleOfMovies = scheduleOfMovies;
        this.cost = cost;
        this.hall_id = hall_id;
    }

    public Movies() {
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getScheduleOfMovies() { return scheduleOfMovies; }

    public void setScheduleOfMovies(String scheduleOfMovies) { this.scheduleOfMovies = scheduleOfMovies; }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public Integer getCinema_id() { return cinema_id; }

    public void setCinema_id(Integer cinema_id) { this.cinema_id = cinema_id; }

    @Override
    public String toString() {
        return name;
    }
}
