package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

public class insertar {
    public JPanel insertar;
    private JButton insertarB;


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
    }
}
