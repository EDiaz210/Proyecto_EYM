package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setContentPane(new login().login);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 300);
    frame.setVisible(true);


    }
}