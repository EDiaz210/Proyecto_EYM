package Equipos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Administrador.MenuE;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import com.mongodb.client.FindIterable;


public class Buscar {
    public JPanel BuscarE;
    private JTextField codigoE;
    private JButton buscarB;
    private JButton volver;
    private JPanel nombreEQ1;
    private JPanel des1t;
    private JPanel des2;
    private JPanel des3;
    private JPanel des4;
    private JPanel des5;
    private JLabel NombreQ;
    private JLabel des1;
    private JLabel desarr5;
    private JLabel desarr2;
    private JLabel desarr3;
    private JLabel desarr4;
    private JLabel resultado_txt;

    public Buscar() {
        buscarB.addActionListener(new ActionListener() {
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

                    Equipo e1 = new Equipo();
                    Document filtro = new Document("id_tarea", e1.getId_grupo());
                    for (Document documento : documentos) {

                        e1.setId_grupo(documento.getString("id_equipo"));
                        e1.setNombre(documento.getString("nombre"));
                        e1.setDesarrollador1(documento.getString("Desarrollador1"));
                        e1.setDesarrollador2(documento.getString("Desarrollador2"));
                        e1.setDesarrollador3(documento.getString("Desarrollador3"));
                        e1.setDesarrollador4(documento.getString("Desarrollador4"));
                        e1.setDesarrollador5(documento.getString("Desarrollador5"));


                        if (e1.getId_grupo().equals(codigoE.getText())) {
                            NombreQ.setText(e1.getNombre());
                            des1.setText(e1.getDesarrollador1());
                            desarr2.setText(e1.getDesarrollador2());
                            desarr3.setText(e1.getDesarrollador3());
                            desarr4.setText(e1.getDesarrollador4());
                            desarr5.setText(e1.getDesarrollador5());

                            int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar con la eliminación de la tarea?", "Confirmación", JOptionPane.YES_NO_OPTION);

                            if (option == JOptionPane.YES_OPTION) {
                                DeleteResult resultado = collection.deleteOne(filtro);
                                resultado_txt.setText("Equipos borrados: " + resultado.getDeletedCount());

                            } else {
                                resultado_txt.setText("No se ha borrado ninguna equipo");
                            }
                        }
                    }
                }
            }
        });



        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new MenuE().menuE);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Menu Equipos");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
