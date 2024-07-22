package org.example;
import javax.swing.*;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setContentPane(new login().login);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
    frame.setTitle("Actualizacion");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 300);
    frame.setVisible(true);






    }
}