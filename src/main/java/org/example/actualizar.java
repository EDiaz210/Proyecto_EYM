package org.example;

import javax.swing.*;
import java.sql.*;

public class actualizar {
    public JPanel actualizar;


    String URL = "jdbc:mysql://localhost:3306/estudiantes2024A";
    String USER = "root";
    String PASSWORD = "123456";
    Connection con = null;
    PreparedStatement ps = null;



    try {
            //establecer la conexion
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            //prepara la sentencia sql
            String sql = "UPDATE estudiantes SET b1=? WHERE cedula=?";
            ps = con.prepareStatement(sql);
            //seteamos lso valores de la sentencia previa
            ps.setInt(1, 100);
            ps.setString(2, "1726195207");
            System.out.println(sql);
            int n = ps.executeUpdate();
            System.out.println("se modificaron:" + n + "lineas");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //cerramos la conexion
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }




//oaaa








