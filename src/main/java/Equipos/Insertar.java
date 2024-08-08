package Equipos;

import Administrador.MenuE;

import org.bson.Document;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insertar {
    public JPanel InsertarE;
    private JTextField codigoEquipo;
    private JTextField desa1;
    private JTextField nombreEquipo;
    private JTextField desa2;
    private JTextField desa3;
    private JTextField desa4;
    private JTextField desa5;
    private JButton insertarB;
    private JButton volverButton;
    private JLabel resultado_Ins;

    public Insertar() {
        insertarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if ((codigoEquipo.getText().isEmpty() || nombreEquipo.getText().isEmpty() || desa1.getText().isEmpty() || desa2.getText().isEmpty() || desa3.getText().isEmpty()  || desa4.getText().isEmpty()) || desa5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LxxyzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Equipos");
                    FindIterable<Document> documentos = collection.find();

                    Equipo e1 = new Equipo();
                    e1.setId_grupo(codigoEquipo.getText());
                    e1.setNombre(nombreEquipo.getText());
                    e1.setDesarrollador1(desa1.getText());
                    e1.setDesarrollador2(desa2.getText());
                    e1.setDesarrollador3(desa3.getText());
                    e1.setDesarrollador4(desa4.getText());
                    e1.setDesarrollador5(desa5.getText());

                    for (Document documento : documentos) {

                        if (documento.getString("id_equipo").equals(codigoEquipo.getText()) || documento.getString("nombre").equals(nombreEquipo.getText())){
                            JOptionPane.showMessageDialog(null, "El id del equipo ya existe o El nombre del equipo ya existe");
                        }else {
                            Document documento1 = new Document("id_equipo", e1.getId_grupo())
                                    .append("nombre", e1.getNombre())
                                    .append("Desarrollador1", e1.getDesarrollador1())
                                    .append("Desarrollador2", e1.getDesarrollador2())
                                    .append("Desarrollador3", e1.getDesarrollador3())
                                    .append("Desarrollador4", e1.getDesarrollador4())
                                    .append("Desarrollador5", e1.getDesarrollador5());

                            collection.insertOne(documento1);
                            resultado_Ins.setText("Datos insertados correctamente");
                        }
                    }
                }
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new MenuE().menuE);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Menu Equipos");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }
}
