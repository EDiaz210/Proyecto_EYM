package org.example;

import Administrador.menu;
import Desarrollador.menuD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JTextField textField1;
    private JTextField textField2;
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
                            JFrame frame = new JFrame();
                            frame.setContentPane(new menu().menu);
                            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                            frame.setTitle("Menú");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(600, 300);
                            frame.setVisible(true);
                        }
                    });

                }else{
                    System.out.println("Ingresaste como Desarrollador");

                    iniciarSesion.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame = new JFrame();
                            frame.setContentPane(new menuD().menuD);
                            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                            frame.setTitle("Menú");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(600, 300);
                            frame.setVisible(true);
                        }
                    });
                }
            }
        });
    }
}
