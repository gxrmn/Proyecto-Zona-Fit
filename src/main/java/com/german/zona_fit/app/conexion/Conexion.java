package com.german.zona_fit.app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion(){
        Connection conexion = null;
        String baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/"+baseDatos;
        var usuario = "root";
        var password = "12345";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (Exception e) {
            System.out.println("Error al conectarnos a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Connection conexion = getConexion();

        if(conexion != null){
            System.out.println("Conexion exitosa: " + conexion);
        }
        else{
            System.out.println("Error al conectarse");
        }
    }
}
