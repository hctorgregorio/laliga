package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LaLiga;

public class VentanaTemporada {
	
	private JFrame ventanaTemporada;
	private JPanel panel;
	private JLabel etiquetaImagen;
	private JButton boton1;
	private ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand() == "Atras") {
			
				VentanaPrincipal ventanaAnterior = new VentanaPrincipal();
				ventanaTemporada.dispose();
				
			} 
		}
	};

	public VentanaTemporada() {
		
		ventanaTemporada = new JFrame();
		ventanaTemporada.setSize(600, 600);
		ventanaTemporada.setMinimumSize(new Dimension(600, 600));
		ventanaTemporada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventanaTemporada.setTitle("LaLiga");
		ventanaTemporada.setLocationRelativeTo(null);
		 
		iniciarVentana();
	}

	public void iniciarVentana() {
		
		colocarPaneles();
		colocarImagen();
		colocarBotones();
		ventanaTemporada.setVisible(true);
	}
	
	public void colocarBotones() {
		
		//boton atras
		boton1 = new JButton();//Se puede añadir texto al boton dentro del parentesis JButton("texto")
		boton1.setText("Atras");//añadir texto al boton
		boton1.setEnabled(true);
		boton1.setBounds(325, 375, 150, 25);//dimensiones en el boton y localizacion en el panel
		
		panel.add(boton1);
		
		boton1.addActionListener(listener);
		
	}

	public void colocarPaneles() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setLayout(null); //Desactivar el diseño
		ventanaTemporada.getContentPane().add(panel);
	}
	
	public void colocarImagen() {
		// TODO Auto-generated method stub
		etiquetaImagen = new JLabel(new ImageIcon("ficheros/imagenes/cesped2-600x600.jpg"));
		etiquetaImagen.setBounds(0, 0, 600, 600);
		//añadimos al panel
		panel.add(etiquetaImagen);
	}
}
