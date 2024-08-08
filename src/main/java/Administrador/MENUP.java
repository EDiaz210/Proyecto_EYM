package Administrador;

import org.example.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MENUP {
    private JButton equipos;
    private JButton tareas;
    private JButton CerrarSesion;
    public JPanel MENUP;

    public MENUP() {
        tareas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new menu().menu);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Tareas");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,600);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(tareas)).dispose();
            }
        });
        equipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new MenuE().menuE);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Equipos");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,400);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(equipos)).dispose();
            }
        });
        CerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new login().login);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Insercción");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,400);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(CerrarSesion)).dispose();
            }
        });
    }
}
