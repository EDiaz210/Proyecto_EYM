package Administrador;

import Equipos.Buscar;
import Equipos.Eliminar;
import Equipos.Insertar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuE {
    public JPanel menuE;
    private JButton buscar;
    private JButton insertar;
    private JButton eliminar;
    private JButton VolverE;

    public MenuE() {

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new Insertar().InsertarE);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Insercción Equipos");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,600);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });


        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new Buscar().BuscarE);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Búsqueda Equipos");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,600);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fs = new JFrame();
                fs.setContentPane(new Eliminar().EliminarE);
                fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fs.setTitle("Eliminacion de Equipos");
                fs.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                fs.setSize(600,600);
                fs.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });
        VolverE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new MENUP().MENUP);
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
                frame.setTitle("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 350);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(VolverE)).dispose();
            }
        });
    }
}
