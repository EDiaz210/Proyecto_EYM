package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class insertar {
    public JPanel insertar;
    private JButton insertarB;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton volverButton;


    public insertar() {
        insertarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("miBaseDeDatos");
                    MongoCollection<Document> collection = database.getCollection("miColeccion");
                    Document documento = new Document("nombre", "Juan")
                            .append("apellido", "Zaldumbide")
                            .append("edad", 31);
                    collection.insertOne(documento);
                    System.out.println("Documento insertado con éxito");
                }
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new menu().menu);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 300);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
}
