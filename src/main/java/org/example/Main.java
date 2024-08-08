package org.example;
import javax.swing.*;

import Administrador.MENUP;
import Administrador.menu;
import Desarrollador.insertarD;
import Desarrollador.menuD;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setContentPane(new MENUP().MENUP);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
    frame.setTitle("Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);


    }
}