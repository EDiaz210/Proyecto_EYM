package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    public JPanel menu;
    private JButton CerrarSesion;
    private JButton insertar;
    private JButton buscar;
    private JButton eliminar;
    private JButton actualizar;

    public menu() {
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new actualizar().actualizar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Actualizacion");
                fs.setSize(600,300);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(actualizar)).dispose();
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new eliminar().eliminar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Actualizacion");
                fs.setSize(600,300);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame fs = new JFrame();
                fs.setContentPane(new buscar().buscar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Actualizacion");
                fs.setSize(600,300);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new insertar().insertar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Actualizacion");
                fs.setSize(600,300);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });
    }
}
