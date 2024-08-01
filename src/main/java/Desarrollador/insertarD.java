package Desarrollador;

import Administrador.menu;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Tareas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class insertarD {
    public JPanel insertarD;
    private JTextField nombreD;
    private JTextField desD;
    private JTextField descD;
    private JTextField AsigD;
    private JTextField VenD;
    private JButton volverButton;
    private JButton insertarBD;
    private JTextField idD;
    private JLabel resultadoD;
    private JTextField avanceD;
    private JLabel avanceDes;


    public insertarD() {
        insertarBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");

                    Tareas t1 = new Tareas();

                    if ((idD.getText().isEmpty() && nombreD.getText().isEmpty() && desD.getText().isEmpty() && descD.getText().isEmpty() && AsigD.getText().isEmpty() && avanceD.getText().isEmpty() && VenD.getText().isEmpty())){
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    }else {
                        t1.setId_tarea(idD.getText());
                        t1.setNombre(nombreD.getText());
                        t1.setNombreEncargado(desD.getText());
                        t1.setDescripcion(descD.getText());
                        t1.setAvance(Double.parseDouble(avanceD.getText()));
                        t1.setFechaAsignacion(AsigD.getText());
                        t1.setFechaVencimiento(VenD.getText());




                        Document documento = new Document("id_tarea", t1.getId_tarea())
                                .append("nombre", t1.getNombre())
                                .append("encargado", t1.getNombreEncargado())
                                .append("descripcion", t1.getDescripcion())
                                .append("avance", t1.getAvance())
                                .append("fechaAsignacion", t1.getFechaAsignacion())
                                .append("fechaVencimiento", t1.getFechaVencimiento());
                        collection.insertOne(documento);
                        resultadoD.setText("Datos insertados correctamente");

                    }
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


