package com.rfm.gestorpeliculas.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import com.rfm.gestorpeliculas.controlador.Coordinador;
import com.rfm.gestorpeliculas.modelo.dao.PeliculaDao;
import com.rfm.gestorpeliculas.modelo.vo.Pelicula;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Ventana extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public JFrame moviesDataBase;
    private Coordinador miCoordinador;
    private JButton botonNuevaPelicula;
    private JButton botonLimpiar;
    private JFormattedTextField bindTitulo;
    private JFormattedTextField bindYear;
    private JFormattedTextField bindDirector;
    private JFormattedTextField bindSoporte;
    public static JTextArea textoResultado;
    private JTextArea textoMoviesDataBase;
    private JTextArea textoTitulo;
    private JTextArea textoDirector;
    private JTextArea textoYear;
    private JTextArea textoSoporte;
    private JButton botonConsulta;
    private JButton boton;
    private JScrollPane scrollPane;
    private JTable table;
    private JScrollPane scrollPane_1;

    /**
     * Initialize the contents of the frame.
     */
    public Ventana() {

	moviesDataBase = new JFrame();
	moviesDataBase.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
	moviesDataBase.setIconImage(Toolkit.getDefaultToolkit()
		.getImage(Ventana.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
	moviesDataBase.setTitle("MoviesDataBase");
	moviesDataBase.setResizable(false);
	moviesDataBase.setBounds(100, 100, 900, 600);
	moviesDataBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	moviesDataBase.getContentPane().setLayout(null);
	moviesDataBase.setVisible(true);

	bindDirector = new JFormattedTextField();
	bindDirector.setBounds(433, 76, 140, 20);
	moviesDataBase.getContentPane().add(bindDirector);

	bindYear = new JFormattedTextField();
	bindYear.setBounds(433, 107, 40, 20);
	moviesDataBase.getContentPane().add(bindYear);

	scrollPane = new JScrollPane();
	scrollPane.setBounds(630, 50, 254, 100);
	moviesDataBase.getContentPane().add(scrollPane);

	textoResultado = new JTextArea();
	scrollPane.setViewportView(textoResultado);
	textoResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
	textoResultado.setEditable(false);
	textoResultado.setTabSize(0);
	textoResultado.setBackground(SystemColor.inactiveCaptionBorder);

	textoMoviesDataBase = new JTextArea();
	textoMoviesDataBase.setEditable(false);
	textoMoviesDataBase.setBackground(SystemColor.inactiveCaptionBorder);
	textoMoviesDataBase.setFont(new Font("Monospaced", Font.BOLD, 18));
	textoMoviesDataBase.setText("MoviesDataBase");
	textoMoviesDataBase.setBounds(20, 11, 170, 29);
	moviesDataBase.getContentPane().add(textoMoviesDataBase);

	textoDirector = new JTextArea();
	textoDirector.setEditable(false);
	textoDirector.setText("Director");
	textoDirector.setFont(new Font("Monospaced", Font.BOLD, 12));
	textoDirector.setBackground(SystemColor.inactiveCaptionBorder);
	textoDirector.setBounds(363, 75, 60, 20);
	moviesDataBase.getContentPane().add(textoDirector);

	textoYear = new JTextArea();
	textoYear.setEditable(false);
	textoYear.setText("A\u00F1o");
	textoYear.setFont(new Font("Monospaced", Font.BOLD, 12));
	textoYear.setBackground(SystemColor.inactiveCaptionBorder);
	textoYear.setBounds(393, 106, 30, 20);
	moviesDataBase.getContentPane().add(textoYear);

	botonNuevaPelicula = new JButton("Nueva Pel\u00EDcula");
	botonNuevaPelicula.setFont(new Font("Monospaced", Font.BOLD, 13));
	botonNuevaPelicula.setBounds(32, 540, 200, 20);
	botonNuevaPelicula.addActionListener(this);
	moviesDataBase.getContentPane().add(botonNuevaPelicula);

	botonLimpiar = new JButton("Limpiar");
	botonLimpiar.setFont(new Font("Monospaced", Font.BOLD, 13));
	botonLimpiar.setBounds(242, 540, 200, 20);
	botonLimpiar.addActionListener(this);
	moviesDataBase.getContentPane().add(botonLimpiar);

	botonConsulta = new JButton("Consultar");
	botonConsulta.setFont(new Font("Monospaced", Font.BOLD, 13));
	botonConsulta.setBounds(452, 540, 200, 20);
	botonConsulta.addActionListener(this);
	moviesDataBase.getContentPane().add(botonConsulta);

	boton = new JButton("Modificar");
	boton.setFont(new Font("Monospaced", Font.BOLD, 13));
	boton.setBounds(662, 540, 200, 20);
	moviesDataBase.getContentPane().add(boton);

	JPanel panel = new JPanel();
	panel.setBorder(new LineBorder(Color.DARK_GRAY));
	panel.setBackground(SystemColor.inactiveCaptionBorder);
	panel.setBounds(10, 50, 610, 100);
	moviesDataBase.getContentPane().add(panel);
	panel.setLayout(null);

	textoTitulo = new JTextArea();
	textoTitulo.setBounds(20, 25, 60, 20);
	panel.add(textoTitulo);
	textoTitulo.setEditable(false);
	textoTitulo.setText("T\u00EDtulo");
	textoTitulo.setFont(new Font("Monospaced", Font.BOLD, 12));
	textoTitulo.setBackground(SystemColor.inactiveCaptionBorder);

	textoSoporte = new JTextArea();
	textoSoporte.setBounds(20, 56, 60, 20);
	panel.add(textoSoporte);
	textoSoporte.setEditable(false);
	textoSoporte.setText("Soporte");
	textoSoporte.setFont(new Font("Monospaced", Font.BOLD, 12));
	textoSoporte.setBackground(SystemColor.inactiveCaptionBorder);

	bindSoporte = new JFormattedTextField();
	bindSoporte.setBounds(90, 57, 230, 20);
	panel.add(bindSoporte);

	bindTitulo = new JFormattedTextField();
	bindTitulo.setBounds(90, 26, 230, 20);
	panel.add(bindTitulo);
	
	scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 169, 874, 354);
	moviesDataBase.getContentPane().add(scrollPane_1);

	table = new JTable();
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"T\u00EDtulo", "Director", "A\u00F1o", "Soporte"
		}
	));
	table.setFont(new Font("Monospaced", Font.PLAIN, 12));
	scrollPane_1.setViewportView(table);
	table.setFillsViewportHeight(true);
	table.setBorder(new LineBorder(new Color(0, 0, 0)));
	table.setBackground(SystemColor.inactiveCaptionBorder);
	table.setVisible(true);
	
	moviesDataBase.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { bindTitulo,
		bindDirector, bindSoporte, bindYear, botonNuevaPelicula, botonLimpiar, botonConsulta, boton }));
	moviesDataBase.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { bindTitulo, bindDirector,
		bindSoporte, bindYear, botonNuevaPelicula, botonLimpiar, boton }));
    }

    private void construirTabla() {
	String titulos[] = { "Título", "Director", "Año", "Soporte" };
	String informacion[][] = obtenerMatriz();
	
	scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 169, 874, 354);
	moviesDataBase.getContentPane().add(scrollPane_1);

	table = new JTable(informacion, titulos);
	table.setFont(new Font("Monospaced", Font.PLAIN, 12));
	scrollPane_1.setViewportView(table);
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setFillsViewportHeight(true);
	table.setBorder(new LineBorder(new Color(0, 0, 0)));
	table.setBackground(SystemColor.inactiveCaptionBorder);
	table.setVisible(true);

    }

    private String[][] obtenerMatriz() {

	PeliculaDao miPeliculaDao = new PeliculaDao();
	ArrayList<Pelicula> miLista = miPeliculaDao.consultarPelicula();

	String matrizInfo[][] = new String[miLista.size()][5];

	for (int i = 0; i < miLista.size(); i++) {
	    matrizInfo[i][0] = miLista.get(i).getTitulo() + "";
	    matrizInfo[i][1] = miLista.get(i).getDirector() + "";
	    matrizInfo[i][2] = miLista.get(i).getYear() + "";
	    matrizInfo[i][3] = miLista.get(i).getSoporte() + "";
	}

	return matrizInfo;
    }

    public void setCoordinador(Coordinador miCoordinador) {
	this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	if (e.getSource() == botonNuevaPelicula) {
	    try {
		Pelicula miPelicula = new Pelicula();
		miPelicula.setTitulo(bindTitulo.getText());
		miPelicula.setDirector(bindDirector.getText());
		miPelicula.setYear(Integer.parseInt(bindYear.getText()));
		miPelicula.setSoporte(bindSoporte.getText());

		miCoordinador.registrarPelicula(miPelicula);

	    } catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Error en el ingreso de los datos", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }

	}

	if (e.getSource() == botonLimpiar) {

	    bindTitulo.setText("");
	    bindDirector.setText("");
	    bindYear.setText("");
	    bindSoporte.setText("");
	    textoResultado.setText("");
//	    table.set

	}
	
	if (e.getSource() == botonConsulta) {
	    try {
		construirTabla();
	    } catch (Exception ex) {
		System.out.println("ERROR");
	    }
	    
	}
    }
}
