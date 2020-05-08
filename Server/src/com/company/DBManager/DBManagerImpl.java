package com.company.DBManager;

import com.company.Entity.*;
import sun.security.krb5.internal.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManagerImpl implements DBManager{

    private Connection connection;

    public DBManagerImpl(){

    }

    public void connect(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_park?useUnicode=true&serverTimezone=UTC","root","");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public Person Login(int person_id, String person_password){
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id=? and password=?");
            statement.setLong(1, person_id);
            statement.setString(2, String.valueOf(person_password));

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String position = resultSet.getString("position");

                if(position.equals("admin")){
                    Admin admin = new Admin(id, password, name, surname, position);

                    return admin;
                }
                else if(position.equals("cashier")){
                    int cash=resultSet.getInt("cash");

                    Cashier cashier = new Cashier(id, password,  name, surname, position, cash);

                    return cashier;
                }
                else if(position.equals("checker")){


                    Checker checker=new Checker(id, password, name, surname, position);

                    return checker;

                }

                resultSet.close();
                statement.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    ///////////////////////////////      MOVIES      ///////////////////////////////////////////////////////////

    public ArrayList<Movies> getMoviesById(){
        ArrayList<Movies> movies= new ArrayList<>();
        int movies_id=1;
        try {

            PreparedStatement statement= connection.prepareStatement("SELECT * FROM movies WHERE moviesIdOfUsers=?");
            statement.setInt(1, movies_id);


            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("cinema_id");
                String name = resultSet.getString("name");

                String sheduleOfMovies = resultSet.getString("sheduleOfMovies");

                int cost = resultSet.getInt("cost");
                int idOfHall = resultSet.getInt("idOfHall");
                Movies movies1 = new Movies(id,name,sheduleOfMovies,cost,idOfHall);
                movies.add(movies1);

            }
            resultSet.close();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return movies;
    }


    public int getCinemaId(){
        int id = 0;
        try {

            PreparedStatement statement= connection.prepareStatement("SELECT * FROM person ");
            
            ResultSet resultSet=statement.executeQuery();


                id = resultSet.getInt("cinema_id");

            resultSet.close();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return id;
}


    public void deleteMovies(Integer id){
        try {

            PreparedStatement statement=connection.prepareStatement("DELETE FROM movies WHERE cinema_id=?");
            statement.setLong(1,id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }


    public void addMovies(Movies movies){

        try {


            PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (cinema_id, name, sheduleOfMovies, cost, idOfHall) " +
                    "VALUES(null, ?, ?, ?, ?)");
            statement.setString(1, movies.getName());
            statement.setString(2, movies.getScheduleOfMovies());
            statement.setInt(3, movies.getCost());
            statement.setInt(4, movies.getHall_id());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }




//////////////////////////////////////      PERSONS     //////////////////////////////////////////////////////



    public ArrayList<Person> getUsersData()
    {
        ArrayList<Person> users=new ArrayList<>();
        try {
            PreparedStatement statement= connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String position = resultSet.getString("position");
                Person person=new Person(id, name, surname, position);
                if (!position.equals("admin")){
                    users.add(person);
                    System.out.println();
                }
            }
                resultSet.close();
                statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public void addCashier(Cashier cashier){

        try {


            PreparedStatement statement = connection.prepareStatement("INSERT INTO person (id,password, name, surname, position, cash) " +
                    "VALUES(null, ?, ?, ?, ?,?)");
            statement.setString(1, cashier.getPassword());
            statement.setString(2, cashier.getName());
            statement.setString(3, cashier.getSurname());
            statement.setString(4, cashier.getPosition());
            statement.setInt(5, cashier.getCash());
            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addChecker(Checker checker){

        try {


            PreparedStatement statement = connection.prepareStatement("INSERT INTO person (id,password, name, surname, position) " +
                    "VALUES(null, ?, ?, ?, ?)");
            statement.setString(1, checker.getPassword());
            statement.setString(2, checker.getName());
            statement.setString(3, checker.getSurname());
            statement.setString(4, checker.getPosition());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void deleteEmployee(Integer id){
        try {

            PreparedStatement statement=connection.prepareStatement("DELETE FROM person WHERE id=?");
            statement.setLong(1,id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }


/////////////////////TICKETS//////////////////////////////
public ArrayList<Tickets> getTickets(){
    ArrayList<Tickets> tickets= new ArrayList<>();

    try {

        PreparedStatement statement= connection.prepareStatement("SELECT * FROM tickets");


        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()) {

            int id = resultSet.getInt("tickets_id");
            String name = resultSet.getString("nameOfMovie");
            int idOfHall = resultSet.getInt("idOfHall");
            String sheduleOfMovies = resultSet.getString("sheduleOfMovies");
            int cost = resultSet.getInt("cost");
            boolean ifChecked=resultSet.getBoolean("ifChecked");
            Tickets ticket=new Tickets(id, name, idOfHall, sheduleOfMovies, cost, ifChecked);
            tickets.add(ticket);

        }
        resultSet.close();
        statement.close();

    } catch (Exception e){
        e.printStackTrace();
    }
    return tickets;
}


    public Tickets getTicketsById(int tickets_id){
       Tickets tickets=new Tickets();
        try {

            PreparedStatement statement= connection.prepareStatement("SELECT * FROM tickets WHERE tickets_id=?");
            statement.setInt(1, tickets_id);


            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("tickets_id");
                String name = resultSet.getString("nameOfMovie");
                int idOfHall = resultSet.getInt("idOfHall");
                String sheduleOfMovies = resultSet.getString("sheduleOfMovies");
                int cost = resultSet.getInt("cost");
                boolean ifChecked=resultSet.getBoolean("ifChecked");
                tickets=new Tickets(id, name, idOfHall,sheduleOfMovies,cost,ifChecked);
            }
            resultSet.close();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }

    public void change_status_of_ticket(int id_of_ticket){
        try {

            PreparedStatement statement=connection.prepareStatement("UPDATE tickets SET ifChecked=? WHERE tickets_id=?");
            statement.setBoolean(1,true);
            statement.setInt(2,id_of_ticket);


            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addTicket(Tickets tickets){

        try {


            PreparedStatement statement = connection.prepareStatement("INSERT INTO tickets (tickets_id,nameOfMovie,idOfHall,sheduleOfMovies,cost,ifChecked) " +
                    "VALUES(null, ?, ?, ?, ?, ?)");
            statement.setString(1, tickets.getNameOfMovie());
            statement.setInt(2, tickets.getIdOfHall());
            statement.setString(3, tickets.getScheduleOfMovies());
            statement.setInt(4, tickets.getCost());
            statement.setBoolean(5,tickets.isIfChecked());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void change_cash(int id, int cash){
        try {

            PreparedStatement statement=connection.prepareStatement("UPDATE person SET cash=? WHERE id=?");
            statement.setInt(1,cash);
            statement.setInt(2,id);


            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCashierCash(Integer id){
        int cash=0;
        try {

            PreparedStatement statement=connection.prepareStatement("SELECT * FROM person WHERE id=?");
            statement.setInt(1, id);


            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {


                cash= resultSet.getInt("cash");
            }
            resultSet.close();
            statement.close();


        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }

    public int totalIncome(){
        int cash=0;
        try {

            PreparedStatement statement=connection.prepareStatement("SELECT * FROM person WHERE position=?");
            statement.setString(1, "cashier");

            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {


                cash+= resultSet.getInt("cash");
            }
            resultSet.close();
            statement.close();


        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }
}


