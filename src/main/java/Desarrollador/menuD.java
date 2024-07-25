package Desarrollador;

import Administrador.insertar;
import org.example.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuD {
    private JButton insertar;
    private JButton actualizar;
    private JButton cerrarSesiónBut;
    public  JPanel menuD;

    public menuD() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new insertar().insertar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Insercción");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,350);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new actualizar().actualizar);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Insercción");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,350);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();
            }
        });
        cerrarSesiónBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new login().login);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 350);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesiónBut)).dispose();
            }
        });
    }
}
