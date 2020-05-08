package com.company;

import com.company.DBManager.DBManager;
import com.company.DBManager.DBManagerImpl;



public class Main {

  public static DBManager dbManager;

    public static void main(String[] args) {

        try{
            dbManager =new DBManagerImpl();
            dbManager.connect();

            Server server=new Server();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
