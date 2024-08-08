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

public class Eliminar {
    public JPanel EliminarE;
    private JTextField codigoE;
    private JLabel nombreE;
    private JLabel des1;
    private JLabel des2;
    private JLabel des3;
    private JLabel des4;
    private JLabel des5;
    private JLabel resultado_txt;
    private JButton eliminarB;
    private JButton volverButton;

    public Eliminar() {
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
        eliminarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((codigoE.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo del equipo");
                    return;
                }

                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

                    MongoDatabase database = mongoClient.getDatabase("LxxyzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Equipos");
                    FindIterable<Document> documentos = collection.find();

                    for (Document documento : documentos) {

                        Equipo e1 = new Equipo();
                        e1.setId_grupo(documento.getString("id_equipo"));
                        e1.setNombre(documento.getString("nombre"));
                        e1.setDesarrollador1(documento.getString("Desarrollador1"));
                        e1.setDesarrollador2(documento.getString("Desarrollador2"));
                        e1.setDesarrollador3(documento.getString("Desarrollador3"));
                        e1.setDesarrollador4(documento.getString("Desarrollador4"));
                        e1.setDesarrollador5(documento.getString("Desarrollador5"));



                        if (e1.getId_grupo().equals(codigoE.getText())) {
                            nombreE.setText(e1.getNombre());
                            des1.setText(e1.getDesarrollador1());
                            des2.setText(e1.getDesarrollador2());
                            des3.setText(e1.getDesarrollador3());
                            des4.setText(e1.getDesarrollador4());
                            des5.setText(e1.getDesarrollador5());
                            resultado_txt.setText("Equipo encontrado");



                        }else {
                            resultado_txt.setText("No el equipo");
                        }
                    }
                }
            }
        });
    }
}
