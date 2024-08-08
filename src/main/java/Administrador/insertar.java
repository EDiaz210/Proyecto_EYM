package Administrador;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.SpinnerNumberModel;
import java.io.IOException;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
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
    private JLabel resultado_Ins;
    private JLabel Prioridad;
    private JButton selectImage;
    private JSpinner spinner2;
    private JSpinner spinner1;
    private Binary BinaryImage;


    public insertar() {

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

        selectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String image = "";
                JFileChooser JFileChooser = new JFileChooser();
                JFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                FileNameExtensionFilter formato = new FileNameExtensionFilter("format", "png", "jpeg");
                JFileChooser.setFileFilter(formato);
                int proceso = JFileChooser.showOpenDialog(selectImage);
                if (proceso == JFileChooser.APPROVE_OPTION) {
                    File seleccionado = JFileChooser.getSelectedFile();
                    try(FileInputStream archivo = new FileInputStream(seleccionado)){
                        byte[] imageBytes = archivo.readAllBytes();
                        BinaryImage = new Binary(imageBytes);
                        Image Miimagen = new ImageIcon(imageBytes).getImage();
                        ImageIcon icono = new ImageIcon(Miimagen.getScaledInstance(90, 75,Image.SCALE_SMOOTH));
                        Prioridad.setIcon(icono);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });



        insertarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((id_Ins.getText().isEmpty() || nombre_Ins.getText().isEmpty() || des_Ins.getText().isEmpty() || desc_Ins.getText().isEmpty() || fecha_A_Ins.getText().isEmpty()  || fecha_Ve_Ins.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }



                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("LyxuzOXCORP");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    FindIterable<Document> documentos = collection.find();

                    Tareas t1 = new Tareas();
                    t1.setId_tarea(id_Ins.getText());
                    t1.setNombre(nombre_Ins.getText());
                    t1.setEquipoEncargado(des_Ins.getText());
                    t1.setDescripcion(desc_Ins.getText());
                    t1.setDuracion(spinner1.getValue()+":"+spinner2.getValue());
                    t1.setFechaAsignacion(fecha_A_Ins.getText());
                    t1.setFechaVencimiento(fecha_Ve_Ins.getText());


                    t1.setImagenPrioridad(BinaryImage);

                    for (Document documento : documentos) {

                        if (documento.getString("id_tarea").equals(id_Ins.getText()) || documento.getString("encargado").equals(des_Ins.getText())){
                                JOptionPane.showMessageDialog(null, "La tarea ya existe o El desarrollador esta ocupado en otra tarea ");
                        }else {
                            Document documento1 = new Document("id_tarea", t1.getId_tarea())
                                    .append("nombre", t1.getNombre())
                                    .append("equipoEncargado", t1.getEquipoEncargado())
                                    .append("descripcion", t1.getDescripcion())
                                    .append("avance", 0.01)
                                    .append("fechaAsignacion", t1.getFechaAsignacion())
                                    .append("fechaVencimiento", t1.getFechaVencimiento())
                                    .append("imagenPrioridad", t1.getImagenPrioridad())
                                    .append("duracion", t1.getDuracion());

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
                frame.setContentPane(new menu().menu);
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









