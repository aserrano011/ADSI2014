package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestAlineacion extends JFrame {

	private JPanel contentPane;
	private JList textField;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestAlineacion frame = new GestAlineacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestAlineacion() {
		setTitle("Gestion de alineaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		final JButton btnInsertar = new JButton("Insertar Alineaci\u00F3n");
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertar.gridx = 1;
		gbc_btnInsertar.gridy = 1;
		contentPane.add(btnInsertar, gbc_btnInsertar);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnInsertar){
					setVisible(false);
					AltaAlineacion.main(null);
					
				}
			}
		});;
		
		final JButton btnSustituciones = new JButton("Sustituciones");
		GridBagConstraints gbc_btnSustituciones = new GridBagConstraints();
		gbc_btnSustituciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnSustituciones.gridx = 1;
		gbc_btnSustituciones.gridy = 2;
		contentPane.add(btnSustituciones, gbc_btnSustituciones);
		
		btnSustituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnSustituciones){
					setVisible(false);
					Sustituciones.main(null);
					
				}
			}
		});
		
		textField = new JList();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
	
		
		btnAtras = new JButton("Atr\u00E1s");
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.EAST;
		gbc_btnAtras.gridwidth = 2;
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 5;
		contentPane.add(btnAtras, gbc_btnAtras);
	
	}
}
