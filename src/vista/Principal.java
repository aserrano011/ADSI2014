package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {
	
	private int idGanaderia;
	private JFrame frmPantallaPrincipal;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					Principal window = new Principal();
					window.frmPantallaPrincipal.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Principal(int pIdGanaderia, String pGanaderia)
	{
		idGanaderia = pIdGanaderia;
		initialize(pGanaderia);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String pGanaderia) {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Pantalla principal");
		frmPantallaPrincipal.setBounds(100, 100, 390, 267);
		frmPantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frmPantallaPrincipal.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblGanaderia = new JLabel(pGanaderia);
		GridBagConstraints gbc_lblGanaderia = new GridBagConstraints();
		gbc_lblGanaderia.insets = new Insets(0, 0, 5, 5);
		gbc_lblGanaderia.gridx = 2;
		gbc_lblGanaderia.gridy = 1;
		frmPantallaPrincipal.getContentPane().add(lblGanaderia, gbc_lblGanaderia);
		
		JButton btnGestAnim = new JButton("Gestionar Animales");
		btnGestAnim.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				GestAnimal gA = new GestAnimal(idGanaderia);
				gA.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGestAnim = new GridBagConstraints();
		gbc_btnGestAnim.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGestAnim.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestAnim.gridx = 2;
		gbc_btnGestAnim.gridy = 2;
		frmPantallaPrincipal.getContentPane().add(btnGestAnim, gbc_btnGestAnim);
		
		JButton btnGestAli = new JButton("Gestionar Alineaci\u00F3n");
		GridBagConstraints gbc_btnGestAli = new GridBagConstraints();
		gbc_btnGestAli.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGestAli.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestAli.gridx = 2;
		gbc_btnGestAli.gridy = 3;
		frmPantallaPrincipal.getContentPane().add(btnGestAli, gbc_btnGestAli);
		
		JButton btnFicha = new JButton("Rellenar Ficha M\u00E9dica");
		GridBagConstraints gbc_btnFicha = new GridBagConstraints();
		gbc_btnFicha.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFicha.insets = new Insets(0, 0, 5, 5);
		gbc_btnFicha.gridx = 2;
		gbc_btnFicha.gridy = 4;
		frmPantallaPrincipal.getContentPane().add(btnFicha, gbc_btnFicha);
		
		JButton btnVotos = new JButton("Votar");
		GridBagConstraints gbc_btnVotos = new GridBagConstraints();
		gbc_btnVotos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVotos.insets = new Insets(0, 0, 5, 5);
		gbc_btnVotos.gridx = 2;
		gbc_btnVotos.gridy = 5;
		frmPantallaPrincipal.getContentPane().add(btnVotos, gbc_btnVotos);
		
		JButton btnOpciones = new JButton("Opciones");
		GridBagConstraints gbc_btnOpciones = new GridBagConstraints();
		gbc_btnOpciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOpciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpciones.gridx = 1;
		gbc_btnOpciones.gridy = 7;
		frmPantallaPrincipal.getContentPane().add(btnOpciones, gbc_btnOpciones);
		
		JButton btnSalir = new JButton("Salir");
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 3;
		gbc_btnSalir.gridy = 7;
		frmPantallaPrincipal.getContentPane().add(btnSalir, gbc_btnSalir);
		frmPantallaPrincipal.setVisible(true);
	}

}
