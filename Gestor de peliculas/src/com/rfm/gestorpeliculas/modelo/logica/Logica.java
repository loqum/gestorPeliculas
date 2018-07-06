package com.rfm.gestorpeliculas.modelo.logica;

import javax.swing.JOptionPane;
import com.rfm.gestorpeliculas.controlador.Coordinador;
import com.rfm.gestorpeliculas.modelo.dao.PeliculaDao;
import com.rfm.gestorpeliculas.modelo.vo.Pelicula;

public class Logica {

    private Coordinador miCoordinador;
    public static boolean consultaPersona = false;
    public static boolean modificaPersona = false;

    public Coordinador getMiCoordinador() {
	return miCoordinador;
    }

    public void setMiCoordinador(Coordinador miCoordinador) {
	this.miCoordinador = miCoordinador;
    }

    public void validarRegistro(Pelicula miPelicula) {
	PeliculaDao miPeliculaDao;

	if (isNumeric(String.valueOf(miPelicula.getYear()))) {
	    if (!isEmpty(miPelicula.getTitulo(), miPelicula.getDirector(), String.valueOf(miPelicula.getYear()),
		    miPelicula.getSoporte())) {
		miPeliculaDao = new PeliculaDao();
		miPeliculaDao.registrarPelicula(miPelicula);
	    } else {
		JOptionPane.showMessageDialog(null,
			"Debe completar todos los campos disponibles",
			"Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	} else {
	    JOptionPane.showMessageDialog(null,
		    "Error al introducir los datos:\n·El formato del campo 'Año' es AAAA",
		    "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

    }
    
//    public Pelicula validarConsulta(String codigoPersona) {
//	PeliculaDao miPeliculaDao;
//	
//	try {
//		int codigo=Integer.parseInt(codigoPersona);	
//		if (codigo > 99) {
//			miPeliculaDao = new PeliculaDao();
//			consultaPersona=true;
//			return miPeliculaDao.consultarPelicula(codigo);						
//		}else{
//			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
//			consultaPersona=false;
//		}
//		
//	}catch (NumberFormatException e) {
//		JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
//		consultaPersona=false;
//	} catch (Exception e) {
//		JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
//		consultaPersona=false;
//	}
//				
//	return null;
//}

    public static boolean isNumeric(String s) {
	String pattern = "^(\\d\\d\\d\\d)";

	if (s.matches(pattern)) {
	    return true;
	}

	return false;
    }

    public static boolean isEmpty(String ti, String di, String ye, String so) {

	if (ti.equals("") || di.equals("") || ye.equals("") || so.equals("")) {
	    return true;
	}
	return false;
    }



}
