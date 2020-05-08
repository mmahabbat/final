package com.company.Entity;

import java.io.Serializable;

public class Cinema_hall implements Serializable {
    private int idOfHall;
    private boolean occupied;

    public Cinema_hall(int idOfHall, boolean occupied) {
        this.idOfHall = idOfHall;
        this.occupied = occupied;
    }

    public Cinema_hall() {
    }

    public int getIdOfHall() { return idOfHall; }

    public void setIdOfHall(int idOfHall) { this.idOfHall = idOfHall; }

    public boolean isOccupied() { return occupied; }

    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
