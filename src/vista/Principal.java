package vista;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal
{
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
	private void initialize(String pGanaderia)
	{
		//FRAME
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
		
		//Label GANADERIA
		JLabel lblGanaderia = new JLabel(pGanaderia);
		GridBagConstraints gbc_lblGanaderia = new GridBagConstraints();
		gbc_lblGanaderia.insets = new Insets(0, 0, 5, 5);
		gbc_lblGanaderia.gridx = 2;
		gbc_lblGanaderia.gridy = 1;
		frmPantallaPrincipal.getContentPane().add(lblGanaderia, gbc_lblGanaderia);
		
		//Botón GESTIONAR ANIMALES
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
		
		//Botón GESTIONAR ALINEACIÓN
		JButton btnGestAli = new JButton("Gestionar Alineaci\u00F3n");
		GridBagConstraints gbc_btnGestAli = new GridBagConstraints();
		gbc_btnGestAli.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGestAli.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestAli.gridx = 2;
		gbc_btnGestAli.gridy = 3;
		frmPantallaPrincipal.getContentPane().add(btnGestAli, gbc_btnGestAli);
		
		//Botón FICHA MEDICA
		JButton btnFicha = new JButton("Rellenar Ficha M\u00E9dica");
		GridBagConstraints gbc_btnFicha = new GridBagConstraints();
		gbc_btnFicha.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFicha.insets = new Insets(0, 0, 5, 5);
		gbc_btnFicha.gridx = 2;
		gbc_btnFicha.gridy = 4;
		frmPantallaPrincipal.getContentPane().add(btnFicha, gbc_btnFicha);
		
		//Botón VOTAR
		JButton btnVotos = new JButton("Votar");
		GridBagConstraints gbc_btnVotos = new GridBagConstraints();
		gbc_btnVotos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVotos.insets = new Insets(0, 0, 5, 5);
		gbc_btnVotos.gridx = 2;
		gbc_btnVotos.gridy = 5;
		frmPantallaPrincipal.getContentPane().add(btnVotos, gbc_btnVotos);
		
		//Botón OPCIONES
		JButton btnOpciones = new JButton("Opciones");
		GridBagConstraints gbc_btnOpciones = new GridBagConstraints();
		gbc_btnOpciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpciones.gridx = 1;
		gbc_btnOpciones.gridy = 7;
		frmPantallaPrincipal.getContentPane().add(btnOpciones, gbc_btnOpciones);
		
		//Botón CERRAR SESIÓN
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				frmPantallaPrincipal.dispose();
				vista.Login dialog = new vista.Login();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrarSesion.gridx = 2;
		gbc_btnCerrarSesion.gridy = 7;
		frmPantallaPrincipal.getContentPane().add(btnCerrarSesion, gbc_btnCerrarSesion);
		
		//Botón SALIR
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 3;
		gbc_btnSalir.gridy = 7;
		frmPantallaPrincipal.getContentPane().add(btnSalir, gbc_btnSalir);
		frmPantallaPrincipal.setVisible(true);
	}

}