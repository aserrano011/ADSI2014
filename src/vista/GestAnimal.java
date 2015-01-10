package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import modelo.GestorAnimales;
import modelo.GestorBD;

public class GestAnimal extends JFrame {

	/**
	 *@author Endika Serrano Lomas
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestAnimal frame = new GestAnimal();
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
	public GestAnimal() {
		setTitle("Gestionar animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//BOTONES
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		panelBotones.add(btnAnadir);
		
		JButton btnModificar = new JButton("Modificar");
		panelBotones.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panelBotones.add(btnEliminar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		panelBotones.add(btnAtras);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblToros = new JLabel("Toros");
		lblToros.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblToros);
		
		JLabel lblCabestros = new JLabel("Cabestros");
		panel.add(lblCabestros);
		
		
		//LISTAS
		JScrollPane scrollPaneT = new JScrollPane();
		JScrollPane scrollPaneC = new JScrollPane();

		JList listaToros = new JList();
		listaToros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList listaCabestros = new JList();
		listaCabestros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(scrollPaneT);
		splitPane.setRightComponent(scrollPaneC);
		
		scrollPaneT.setViewportView(listaToros);
		scrollPaneC.setViewportView(listaCabestros);
		
		splitPane.setDividerLocation(170);
	}
	
	public void cargarDatosListas(){
		GestorAnimales.getInstance().obtenerToros(Principal.getIdGanaderia());
		GestorAnimales.getInstance().obtenerCabestros(Principal.getIdGanaderia());
	}
	

}
