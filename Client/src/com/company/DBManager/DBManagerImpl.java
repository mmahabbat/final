package com.company.DBManager;

import com.company.Client;
import com.company.Entity.*;
import com.company.Request;
import sun.security.krb5.internal.Ticket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.util.ArrayList;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

public class DBManagerImpl implements DBManager{

    private Connection connection;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public DBManagerImpl(){
        try {

            outputStream = new ObjectOutputStream(Client.socket.getOutputStream());
            inputStream = new ObjectInputStream(Client.socket.getInputStream());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public Person Login(int person_id, String person_password){

                       try{

                           Request request = new Request("Login", null, String.valueOf(person_id), person_password, null);
                           outputStream.writeObject(request);

                           Person person = (Person) inputStream.readObject();
                           return person;

                       }catch (Exception e){
                           e.printStackTrace();
                       }
        return null;
    }

    ///////////////////////////////      MOVIES      ///////////////////////////////////////////////////////////

    public ArrayList<Movies> getMoviesById(){

        try {
            Request request = new Request("getMoviesById", null, null,null, null);
            outputStream.writeObject(request);
            ArrayList<Movies> movies=(ArrayList<Movies>) inputStream.readObject();
            return movies;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getCinemaId(){

        try {
            Request request = new Request("getCinemaId", null, null,null, null);
            outputStream.writeObject(request);
            int id=(int) inputStream.readObject();

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
}

    public void deleteMovies(Integer id){
        try {
            Request request = new Request("deleteMovies", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void addMovies(Movies movies){

        try {
            Request request = new Request("addMovies", movies, null,null, null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

//////////////////////////////////////      PERSONS     //////////////////////////////////////////////////////



    public ArrayList<Person> getUsersData()
    {

        try {

            Request request = new Request("getUsersData", null, null,null, null);
            outputStream.writeObject(request);

            ArrayList<Person> person=(ArrayList<Person>)inputStream.readObject();
            return person;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addCashier(Cashier cashier){

        try {
            Request request = new Request("addCashier", cashier, null,null, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void addChecker(Checker checker){

        try {
            Request request = new Request("addChecker", checker, null,null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void deleteEmployee(Integer id){
        try {

            Request request = new Request("deleteEmployee", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();

        }
    }


/////////////////////TICKETS//////////////////////////////
public ArrayList<Tickets> getTickets(){

    try {
        Request request = new Request("getTickets", null, null,null, null);
        outputStream.writeObject(request);

        ArrayList<Tickets> tickets=(ArrayList<Tickets>)inputStream.readObject();
        return tickets;
    } catch (Exception e){
        e.printStackTrace();
    }
    return null;
}


    public Tickets getTicketsById(int tickets_id){

        try {
            Request request = new Request("getTicketsById", null, String.valueOf(tickets_id),null, null);
            outputStream.writeObject(request);

            Tickets tickets = (Tickets) inputStream.readObject();
            return tickets;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void change_status_of_ticket(int id_of_ticket){
        try {

            Request request = new Request("change_status_of_ticket", null, String.valueOf(id_of_ticket),null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addTicket(Tickets tickets){

        try {
            Request request = new Request("addTicket", tickets, null,null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void change_cash(int id, int cash){
        try {
            Request request = new Request("change_cash", null, String.valueOf(id),String.valueOf(cash), null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCashierCash(Integer id){
        int cash=0;
        try {
            Request request = new Request("getCashierCash", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);
             cash=(int) inputStream.readObject();


        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }

    public int totalIncome(){
        int cash=0;
        try {
            Request request = new Request("totalIncome", null, null,null, null);
            outputStream.writeObject(request);
            cash=(int) inputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }
}


