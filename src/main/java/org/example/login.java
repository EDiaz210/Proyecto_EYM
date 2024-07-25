package org.example;

import Administrador.Administrador;
import Administrador.menu;
import Desarrollador.menuD;
import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JTextField correo;
    private JTextField contra;
    private JButton iniciarSesion;
    public JPanel login;
    private JComboBox Seleccionador;

    public login() {
        Seleccionador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Seleccionador.getSelectedItem().toString().equals("Administrador")) {

                    System.out.println("Ingresaste como Administrador");

                    iniciarSesion.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                                MongoDatabase database = mongoClient.getDatabase("LxxuzOXCORP");
                                MongoCollection<Document> collection = database.getCollection("Administrador");
                                FindIterable<Document> documentos = collection.find();

                                for (Document documento : documentos) {

                                    Administrador ad1 = new Administrador();
                                    ad1.setCorreo(documento.getString("correo"));
                                    ad1.setContraseña(documento.getString("contraseña"));

                                    if (ad1.getCorreo().equals(correo.getText()) && ad1.getContraseña().equals(contra.getText())) {

                                        JFrame frame = new JFrame();
                                        frame.setContentPane(new menu().menu);
                                        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                                        frame.setTitle("Menú");
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame.setSize(600, 300);
                                        frame.setVisible(true);
                                        ((JFrame)SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();
                                    }else{
                                        System.out.println("Credenciales no validas");
                                    }
                                }
                            }
                        }
                    });

                } else if (Seleccionador.getSelectedItem().toString().equals("Desarrollador")) {

                    System.out.println("Ingresaste como Desarrollador");

                    iniciarSesion.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                                MongoDatabase database = mongoClient.getDatabase("LxxuzOXCORP");
                                MongoCollection<Document> collection = database.getCollection("Desarrollador");
                                FindIterable<Document> documentos = collection.find();

                                for (Document documento : documentos) {

                                    Administrador ad1 = new Administrador();
                                    ad1.setCorreo(documento.getString("correo"));
                                    ad1.setContraseña(documento.getString("contraseña"));

                                    if (correo.getText().equals(ad1.getCorreo()) && contra.getText().equals(ad1.getContraseña())) {
                                        JFrame frame = new JFrame();
                                        frame.setContentPane(new menuD().menuD);
                                        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                                        frame.setTitle("Menú");
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame.setSize(600, 300);
                                        frame.setVisible(true);
                                        ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();
                                    }else{
                                    System.out.println("Credenciales no validas");
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}

