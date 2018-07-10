package com.rfm.gestorpeliculas.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.rfm.gestorpeliculas.modelo.conexion.Conexion;
import com.rfm.gestorpeliculas.modelo.vo.Pelicula;
import com.rfm.gestorpeliculas.vista.Ventana;

public class PeliculaDao {

    private static final String INSERT = "INSERT INTO peliculas (titulo, director, year, soporte) VALUES (?,?,?,?);";

    public void registrarPelicula(Pelicula miPelicula) {

	Conexion conex = new Conexion();

	try {
	    PreparedStatement stmt = conex.getConnection().prepareStatement(INSERT);
	    stmt.setString(1, miPelicula.getTitulo().trim());
	    stmt.setString(2, miPelicula.getDirector().trim());
	    stmt.setInt(3, miPelicula.getYear());
	    stmt.setString(4, miPelicula.getGenero().trim());
	    stmt.setString(5, miPelicula.getSoporte().trim());
	    stmt.executeUpdate();

	    Ventana.textoResultado.setText(" Registro realizado!\n · Título: " + miPelicula.getTitulo()
		    + "\n · Director: " + miPelicula.getDirector() + "\r\n · Año: " + miPelicula.getYear() + "\r\n · Género: " + miPelicula.getGenero()
		    + "\r\n · Soporte: " + miPelicula.getSoporte());

	    stmt.close();
	    conex.desconectar();

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null, "No se registraron los datos correctamente", "Error",
		    JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}
    }

    public ArrayList<Pelicula> consultarPelicula() {

	Conexion conex = new Conexion();
	ArrayList<Pelicula> miLista = new ArrayList<Pelicula>();
	Pelicula miPelicula;

	try {
	    Statement estatuto = conex.getConnection().createStatement();
	    ResultSet rs = estatuto.executeQuery("SELECT * FROM peliculas");

	    while (rs.next()) {
		miPelicula = new Pelicula();
		miPelicula.setTitulo(rs.getString("titulo"));
		miPelicula.setDirector(rs.getString("director"));
		miPelicula.setYear(Integer.parseInt(rs.getString("year")));
		miPelicula.setGenero(rs.getString("genero"));
		miPelicula.setSoporte(rs.getString("soporte"));
		miLista.add(miPelicula);
	    }
	    rs.close();
	    estatuto.close();
	    conex.desconectar();

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

	}
	return miLista;
    }

}
