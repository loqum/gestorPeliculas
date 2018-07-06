package com.rfm.gestorpeliculas.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://moviedatabase.cskuigrbplma.us-east-2.rds.amazonaws.com:3306/Movies";
    public static final String USER = "root";
    public static final String PASSWORD = "12345678";
    public Connection con = null;

    public Conexion() {

	try {
	    Class.forName(DRIVER);
	    con = DriverManager.getConnection(URL, USER, PASSWORD);
	    
	    if (con != null) {
		System.out.println("Conexión a base de datos: OK");
	    } else {
		System.out.println("No ha sido posible la conexión");
	    }
	    
	} catch (ClassNotFoundException e) {
	    System.out.println(e.toString());
	    e.printStackTrace();
	} catch (SQLException e) {
	    System.out.println(e.toString());
	    e.printStackTrace();
	}

    }
    
    public Connection getConnection() {
	return con;
    }
    
    public void desconectar() {
	con = null;
    }

}
