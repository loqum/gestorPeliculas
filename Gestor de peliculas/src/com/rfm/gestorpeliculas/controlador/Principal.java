package com.rfm.gestorpeliculas.controlador;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.rfm.gestorpeliculas.modelo.logica.Logica;
import com.rfm.gestorpeliculas.vista.Ventana;

public class Principal {

    public Logica miLogica;
    public Ventana miVentana;
    public Coordinador miCoordinador;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Principal miPrincipal = new Principal();
		    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		    miPrincipal.iniciar();

		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    private void iniciar() {
	
	miVentana = new Ventana();
	
//	miVentanaConsulta = new VentanaConsulta();
	miLogica = new Logica();
	miCoordinador = new Coordinador();

	miVentana.setCoordinador(miCoordinador);
//	miVentanaConsulta.setCoordinador(miCoordinador);
	miLogica.setMiCoordinador(miCoordinador);

	miCoordinador.setMiVentana(miVentana);
//	miCoordinador.setMiVentanaConsulta(miVentanaConsulta);
	miCoordinador.setMiLogica(miLogica);


    }

}
