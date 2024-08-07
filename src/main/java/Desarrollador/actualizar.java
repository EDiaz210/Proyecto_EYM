package Desarrollador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.Binary;
import org.example.Tareas;

public class actualizar {
    public JPanel actualizar;
    private JTextField buscarA;
    private JButton VolverT;
    private JButton actualizarB;
    private JLabel resultadoA;
    private JLabel iconM;
    private JProgressBar progressA;
    private JLabel nombreA;
    private JLabel idA;
    private JLabel descA;
    private JLabel desA;
    private JLabel fechaAsigA;
    private JLabel fechaVenA;
    private JTextField descM;
    private JTextField desM;
    private JTextField avanceM;
    private JLabel prioridadA;


    public actualizar() {

        actualizarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    FindIterable<Document> documentos = collection.find();

                    Tareas t1 = new Tareas();
                    t1.setId_tarea(buscarA.getText());
                    Document filtro = new Document("id_tarea", t1.getId_tarea());

                    for(Document documento : documentos){
                        if(documento.getString("id_tarea").equals(t1.getId_tarea())){
                            nombreA.setText(documento.getString("nombre"));
                            idA.setText(documento.getString("id_tarea"));
                            descA.setText(documento.getString("descripcion"));
                            desA.setText(documento.getString("encargado"));
                            fechaAsigA.setText(documento.getString("fechaAsignacion"));
                            fechaVenA.setText(documento.getString("fechaVencimiento"));
                            progressA.setString(Double.toString(documento.getDouble("avance")));
                            progressA.setValue(documento.getDouble("avance").intValue());


                            Binary Binaryimage = documento.get("imagenPrioridad", Binary.class);
                            if (Binaryimage != null) {
                                byte[] imageBytes =Binaryimage.getData();
                                InputStream is = new ByteArrayInputStream(imageBytes);
                                BufferedImage image = ImageIO.read(is);
                                ImageIcon icon = new ImageIcon(image.getScaledInstance(90, 75, Image.SCALE_SMOOTH));
                                prioridadA.setIcon(icon);
                            }else{
                                prioridadA.setText("Imagen no encontrada");
                            }

                            Tareas t2 = new Tareas();

                            if(descM.getText().isEmpty() && desM.getText().isEmpty() && avanceM.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                            }else {
                                t2.setNombreEncargado(desM.getText());
                                t2.setDescripcion(descM.getText());
                                t2.setAvance(Double.parseDouble(avanceM.getText()));

                                Document actualizacion = new Document("$set", new Document("descripcion", t2.getDescripcion())
                                        .append("encargado", t2.getNombreEncargado())
                                        .append("avance", t2.getAvance()));
                                collection.updateOne(filtro, actualizacion);
                                resultadoA.setText("Datos insertados correctamente");
                            }
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        VolverT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new menuD().menuD);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(VolverT)).dispose();
            }
        });
    }
}
















