package org.example;
import javax.swing.*;
import Administrador.menu;
import Desarrollador.menuD;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setContentPane(new menu().menu);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/logo.jpg"));
    frame.setTitle("Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 325);
    frame.setVisible(true);






    }
}