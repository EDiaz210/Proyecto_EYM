package Desarrollador;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Tareas;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.SpinnerNumberModel;


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
    private JLabel prioridadD;
    private JButton seleccionarImageD;
    private JTextField duracionD;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JLabel avanceDes;
    private Binary BinaryImage;


    public insertarD() {
        int minimo=1;
        int maximo=12;
        int inicializador=1;
        SpinnerNumberModel model = new SpinnerNumberModel(inicializador,minimo, maximo,1);
        spinner1.setModel(model);

        int minimo1=1;
        int maximo1=60;
        int inicializador1=1;
        SpinnerNumberModel model2 = new SpinnerNumberModel(inicializador1,minimo1, maximo1,1);
        spinner2.setModel(model2);

        seleccionarImageD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String image = "";
                JFileChooser JFileChooser = new JFileChooser();
                JFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                FileNameExtensionFilter formato = new FileNameExtensionFilter("format", "png", "jpeg");
                JFileChooser.setFileFilter(formato);
                int proceso = JFileChooser.showOpenDialog(seleccionarImageD);
                if (proceso == JFileChooser.APPROVE_OPTION) {
                    File seleccionado = JFileChooser.getSelectedFile();
                    try(FileInputStream archivo = new FileInputStream(seleccionado)){
                        byte[] imageBytes = archivo.readAllBytes();
                        BinaryImage = new Binary(imageBytes);
                        Image Miimagen = new ImageIcon(imageBytes).getImage();
                        ImageIcon icono = new ImageIcon(Miimagen.getScaledInstance(90, 75,Image.SCALE_SMOOTH));
                        prioridadD.setIcon(icono);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

            }
        });



        insertarBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((idD.getText().isEmpty() || nombreD.getText().isEmpty() || desD.getText().isEmpty() || descD.getText().isEmpty() || AsigD.getText().isEmpty() || VenD.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }


                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    FindIterable<Document> documentos = collection.find();

                    Tareas t1 = new Tareas();
                    t1.setId_tarea(idD.getText());
                    t1.setNombre(nombreD.getText());
                    t1.setEquipoEncargado(desD.getText());
                    t1.setDescripcion(descD.getText());
                    t1.setFechaAsignacion(AsigD.getText());
                    t1.setFechaVencimiento(VenD.getText());
                    t1.setDuracion(spinner1.getValue()+":"+spinner2.getValue());
                    t1.setImagenPrioridad(BinaryImage);

                        for (Document documento : documentos) {
                            if (idD.getText().equals(t1.getId_tarea()) && desD.getText().equals(t1.getNombre())) {
                                JOptionPane.showMessageDialog(null, "La tarea ya existe o El desarrollador esta ocupado en otra tarea");
                            }else {
                                Document documento1 = new Document("id_tarea", t1.getId_tarea())
                                        .append("nombre", t1.getNombre())
                                        .append("Equipoencargado", t1.getEquipoEncargado())
                                        .append("descripcion", t1.getDescripcion())
                                        .append("avance", 0.01)
                                        .append("fechaAsignacion", t1.getFechaAsignacion())
                                        .append("fechaVencimiento", t1.getFechaVencimiento())
                                        .append("imagenPrioridad", t1.getImagenPrioridad())
                                        .append("duracion", t1.getDuracion());
                                collection.insertOne(documento1);
                                resultadoD.setText("Datos insertados correctamente");
                            }
                        }
                    }
                }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new menuD().menuD);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });

    }
}


