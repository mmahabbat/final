package com.company;

import com.company.DBManager.DBManager;
import com.company.DBManager.DBManagerImpl;
import com.company.GUIController.Login;

import java.net.Socket;

public class Client {
    public static Socket socket;
    public static DBManager dbManager;

    public static void main(String[] args) {

        try {
            socket = new Socket("127.0.0.1", 2000);
            dbManager = new DBManagerImpl();

            Login login = new Login();
            login.setVisible(true);

        } catch (Exception e) {
            System.out.println("Client disconnected");
//            e.printStackTrace();
        }
    }

    }
