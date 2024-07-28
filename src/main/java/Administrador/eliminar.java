package Administrador;

import javax.swing.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import org.example.Tareas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminar {
    public JPanel eliminar;
    private JButton eliminarB;
    private JTextField buscarElimin;
    private JButton volverButton;
    private JLabel iconM;
    private JProgressBar progressE;
    private JLabel nombreE;
    private JLabel idE;
    private JLabel descE;
    private JLabel desE;
    private JLabel AsigE;
    private JLabel VenE;
    private JLabel resultadoE;


    public eliminar() {
        eliminarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    FindIterable<Document> documentos = collection.find();

                    Tareas t2 = new Tareas();
                    t2.setId_tarea(buscarElimin.getText());
                    Document filtro = new Document("id_tarea", t2.getId_tarea());
                    for(Document documento : documentos){
                        if(documento.getString("id_tarea").equals(t2.getId_tarea())){
                            nombreE.setText(documento.getString("nombre"));
                            idE.setText(documento.getString("id_tarea"));
                            descE.setText(documento.getString("descripcion"));
                            desE.setText(documento.getString("encargado"));
                            AsigE.setText(documento.getString("fechaAsignacion"));
                            VenE.setText(documento.getString("fechaVencimiento"));
                            progressE.setString(Double.toString(documento.getDouble("avance")));
                            progressE.setValue(documento.getDouble("avance").intValue());

                        }
                    }
                    int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar con la eliminación de la tarea?", "Confirmación",JOptionPane.YES_NO_OPTION);

                    if(option == JOptionPane.YES_OPTION){
                        DeleteResult resultado = collection.deleteOne(filtro);
                        resultadoE.setText("Documentos borrados: " + resultado.getDeletedCount());
                    }else{
                        resultadoE.setText("No se ha borrado ninguna tarea");
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




