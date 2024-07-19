package org.example;

import javax.swing.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.result.DeleteResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminar {
    public JPanel eliminar;
    private JButton eliminarB;



    public eliminar() {
        eliminarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

                    MongoDatabase database = mongoClient.getDatabase("miBaseDeDatos");
                    MongoCollection<Document> collection = database.getCollection("miColeccion");
                    Document filtro = new Document("nombre", "Juan");
                    DeleteResult resultado = collection.deleteOne(filtro);
                    System.out.println("Documentos borrados: " + resultado.getDeletedCount());
                }
            }
        });
    }
}




