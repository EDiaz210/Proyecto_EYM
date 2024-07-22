package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.result.UpdateResult;

public class actualizar {
    public JPanel actualizar;
    private JTextField textField1;
    private JButton VolverT;
    private JButton actualizarB;


    public actualizar() {

        actualizarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("miBaseDeDatos");
                    MongoCollection<Document> collection = database.getCollection("miColeccion");
                    Document filtro = new Document("nombre", "Yadira");
                    Document actualizacion = new Document("$set", new Document("apellido", "Gómez"));
                    UpdateResult resultado = collection.updateOne(filtro, actualizacion);
                    System.out.println("Documentos modificados: " + resultado.getModifiedCount());
                }
            }
        });
        VolverT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new menu().menu);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 300);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(VolverT)).dispose();
            }
        });
    }
}
















