package Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.Tareas;

public class insertar {
    public JPanel insertar;
    private JButton insertarB;
    private JTextField nombre_Ins;
    private JTextField des_Ins;
    private JTextField desc_Ins;
    private JTextField fecha_Ve_Ins;
    private JButton volverButton;
    private JTextField fecha_A_Ins;
    private JTextField id_Ins;
    private JTextField avance_Ins;
    private JLabel resultado_Ins;


    public insertar() {
        insertarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");

                    Tareas t1 = new Tareas();
                    t1.setId_tarea(id_Ins.getText());
                    t1.setNombre(nombre_Ins.getText());
                    t1.setNombreEncargado(des_Ins.getText());
                    t1.setDescripcion(desc_Ins.getText());
                    t1.setAvance(Double.parseDouble(avance_Ins.getText()));
                    t1.setFechaAsignacion(fecha_A_Ins.getText());
                    t1.setFechaVencimiento(fecha_Ve_Ins.getText());

                    Document documento = new Document("id_tarea", t1.getId_tarea())
                            .append("nombre", t1.getNombre())
                            .append("encargado", t1.getNombreEncargado())
                            .append("descripcion", t1.getDescripcion())
                            .append("avance", t1.getAvance())
                            .append("fechaAsignacion", t1.getFechaAsignacion())
                            .append("fechaVencimiento", t1.getFechaVencimiento());
                    collection.insertOne(documento);
                    resultado_Ins.setText("Datos insertados correctamente");
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









