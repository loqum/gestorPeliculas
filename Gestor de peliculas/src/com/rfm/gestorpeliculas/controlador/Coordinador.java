package com.rfm.gestorpeliculas.controlador;

import com.rfm.gestorpeliculas.modelo.logica.Logica;
import com.rfm.gestorpeliculas.modelo.vo.Pelicula;
import com.rfm.gestorpeliculas.vista.Ventana;

public class Coordinador {

    private Logica miLogica;
    private Ventana miVentana;

    public Ventana getMiVentana() {
	return miVentana;
    }

    public void setMiVentana(Ventana miVentana) {
	this.miVentana = miVentana;
    }

    public Logica getMiLogica() {
	return miLogica;
    }

    public void setMiLogica(Logica miLogica) {
	this.miLogica = miLogica;
    }

    public void registrarPelicula(Pelicula miPelicula) {
	miLogica.validarRegistro(miPelicula);
    }

//    public void consultarPelicula(Pelicula miPelicula) {
//	miLogica.validarConsulta(miPelicula);
//    }
}
