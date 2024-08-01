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
import com.mongodb.client.FindIterable;
import org.example.Tareas;

public class buscar {
    public JPanel buscar;
    private JButton buscarB;
    private JTextField codigoT;
    private JButton volver;
    private JLabel iconM;
    private JProgressBar avanceB;
    private JLabel nombre;
    private JLabel id;
    private JLabel desarrollador;
    private JLabel desc;
    private JLabel fecha_V;
    private JLabel fecha_A;
    private JLabel resultado_txt;

    public buscar() {
        buscarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    FindIterable<Document> documentos = collection.find();

                    for (Document documento : documentos) {

                        Tareas t1 = new Tareas();
                        t1.setId_tarea(documento.getString("id_tarea"));
                        t1.setNombre(documento.getString("nombre"));
                        t1.setDescripcion(documento.getString("descripcion"));

                        t1.setNombreEncargado(documento.getString("encargado"));
                        t1.setAvance(documento.getDouble("avance"));
                        t1.setFechaAsignacion(documento.getString("fechaAsignacion"));
                        t1.setFechaVencimiento(documento.getString("fechaVencimiento"));


                        if (t1.getId_tarea().equals(codigoT.getText())){
                            nombre.setText(t1.getNombre());
                            avanceB.setString(Double.toString(t1.getAvance()));
                            avanceB.setValue((int) t1.getAvance());
                            avanceB.setStringPainted(true);
                            id.setText(t1.getId_tarea());
                            desarrollador.setText(t1.getNombreEncargado());
                            desc.setText(t1.getDescripcion());
                            fecha_A.setText(t1.getFechaAsignacion());
                            fecha_V.setText(t1.getFechaVencimiento());


                        }else {
                            resultado_txt.setText("No existe esa tarea");
                        }






                    }
                }
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new menu().menu);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 300);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
