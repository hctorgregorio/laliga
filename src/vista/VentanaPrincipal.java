package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LaLiga;

public class VentanaPrincipal {
	
	//Esto que es?
	/*
	private static final long serialVersionUID = 1L;
	*/
	private JFrame ventanaPrincipal;
	private JPanel panel;
	private JLabel etiquetaImagen;
	private JTextField cajaTexto;
	private JComboBox<String> menuDesplegable;
	private JButton boton1;
	private JButton boton2;
	private ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			LaLiga crearTemporada = new LaLiga();
			
			if (e.getActionCommand() == "Crear Temporada") {
				
				System.out.println(cajaTexto.getText());
				
				//Creamos la nueva temporada
				crearTemporada.crearLiga(cajaTexto.getText() + ".txt");
				VentanaTemporada nuevaVentana = new VentanaTemporada();
				ventanaPrincipal.dispose();
				
			

			} else if (e.getActionCommand() == "Seleccionar") {
				
				System.out.println(menuDesplegable.getSelectedItem());
				VentanaTemporada nuevaVentana = new VentanaTemporada();
				ventanaPrincipal.dispose();
				
			} else {
				
				System.out.println("esto no funciona");
				
			}
		}
	};

	public VentanaPrincipal() {
		
		//Constructor de ventana Principal
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setSize(600, 600);
		ventanaPrincipal.setMinimumSize(new Dimension(600, 600));
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventanaPrincipal.setTitle("LaLiga");
		ventanaPrincipal.setLocationRelativeTo(null);
		 
		iniciarVentana();
		
	}
	
	public void iniciarVentana() {
		
		//Coloca los distintos elementos en la ventana
		colocarPaneles();
		colocarImagen();
		colocarCajaDeTexto();
		colocarMenuDesplegable();
		colocarBotones();
		//hacemos visible la ventana y sus componentes
		ventanaPrincipal.setVisible(true);
		
	}
	
	public void colocarPaneles(){
		
		//Estructura del panel
		panel = new JPanel();
		panel.setLayout(null); //Desactivar el diseño
		ventanaPrincipal.getContentPane().add(panel); //Agregar el panel a la ventana, this se refiere a la ventana creada
	}

	public void colocarImagen() {
		
		//seleccionar la imagen y el tamaño
		etiquetaImagen = new JLabel(new ImageIcon("ficheros/imagenes/LaLiga2.png"));
		etiquetaImagen.setBounds(150, 50, 300, 300);
		//añadimos al panel
		panel.add(etiquetaImagen);
	}
	
	public void colocarCajaDeTexto() {
		
		cajaTexto = new JTextField();
		cajaTexto.setBounds(150, 375, 150, 25);
		cajaTexto.setText("2018-2019");
		panel.add(cajaTexto);
		
	}
	
	public void colocarMenuDesplegable() {
		
		String[] temporadas = leerTemporadas("ficheros/temporadas");
		
		menuDesplegable = new JComboBox<String>(temporadas);
		menuDesplegable.setBounds(150, 425, 150, 25);
		
		
		panel.add(menuDesplegable);
	}
	
	public void colocarBotones() {
		
		//boton crear Temporada
		boton1 = new JButton();//Se puede añadir texto al boton dentro del parentesis JButton("texto")
		boton1.setText("Crear Temporada");//añadir texto al boton
		boton1.setEnabled(true);
		boton1.setBounds(325, 375, 150, 25);//dimensiones en el boton y localizacion en el panel
		
		//boton crear Temporada
		boton2 = new JButton();//Se puede añadir texto al boton dentro del parentesis JButton("texto")
		boton2.setText("Seleccionar");//añadir texto al boton
		boton2.setEnabled(true);
		boton2.setBounds(325, 425, 150, 25);//dimensiones en el boton y localizacion en el panel
		
		panel.add(boton1);
		panel.add(boton2);
		
		boton1.addActionListener(listener);
		boton2.addActionListener(listener);
		
	}
	
	public String[] leerTemporadas (String ruta) {
		
		File directorio = new File(ruta);
		File subDirectorios[] = directorio.listFiles();
		
		String[] temporadas = new String[subDirectorios.length];
		
		for (int i = 0; i < temporadas.length; i++)
			temporadas[i] = subDirectorios[i].getName().substring(0, 9);

		return temporadas;
	}
	
	/*
	 * VENTANA PRINCIPAL
	 * 	*Crear temporada
	 * 
	 * 		-Cerrar la ventana
	 * 		-Nueva ventana con la clasificacion (vista1)
	 * 		-Boton atras (cierra ventana y vuelve al inicio)
	 * 
	 * 	*Seleccionar temporada
	 * 
	 * 		-Cerrar la ventana
	 * 		-Nueva ventana con la clasificacion (vista1)
	 * 		-Boton atras (cierra ventana y vuelve al inicio)
	 * 
	 * 	*Seleccionar equipo
	 * 
	 * 		-Cerrar ventana
	 * 		-Nueva ventana con las siguientes opciones (vista2):
	 * 
	 * 			*jugadores / seleccionar jugador (vista3)
	 * 
	 * 				-Boton atras (cierra ventana y vuelve al inicio)
	 * 
	 * 			*estadisticas del equipo (vista4)
	 * 
	 * 				-Boton atras (cierra ventana y vuelve al inicio)
	 * 
	 * 			*Boton atras (cierra ventana y vuelve al inicio)
	 * 
	 */
}
