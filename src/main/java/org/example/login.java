package org.example;

import Administrador.Administrador;
import Administrador.menu;
import Desarrollador.Desarrolladores;
import Desarrollador.menuD;
import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
                                    String contraseña = documento.getString("contraseña");
                                    String contraseñaEYTM = generateHash(contraseña);
                                    ad1.setContraseña(contraseñaEYTM);


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
                                MongoCollection<Document> collection = database.getCollection("Desarrolladores");
                                FindIterable<Document> documentos = collection.find();

                                for (Document documento : documentos) {

                                    Desarrolladores de1 = new Desarrolladores();
                                    de1.setCorreo(documento.getString("correo"));
                                    String contraseña = documento.getString("contraseña");
                                    String contraseñaEYTMDES = generateHash(contraseña);
                                    de1.setContraseña(contraseñaEYTMDES);

                                    if (de1.getCorreo().equals(correo.getText()) && contraseñaEYTMDES.equals(contra.getText())) {
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

    public static String generateHash(String input) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes());
            return bytesToHex(encodedhash);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

