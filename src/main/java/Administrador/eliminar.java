package Administrador;

import javax.swing.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.result.DeleteResult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminar {
    public JPanel eliminar;
    private JButton eliminarB;
    private JTextField buscarElimin;
    private JButton volverButton;
    private JLabel iconM;
    private JProgressBar progressBar1;


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
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
}




