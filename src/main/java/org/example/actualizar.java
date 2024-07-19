package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

public class actualizar {
    public JPanel actualizar;
    private JTextField textField1;
    private JTextField textField2;
    private JButton actualizarB;


    String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
    String user = "root";
    String password = "123456";
    Connection con = null;
    PreparedStatement ps = null;

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
    }
}
















