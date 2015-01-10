package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import modelo.Cabestro;
import modelo.GestorAnimales;
import modelo.Toro;

public class GestAnimal extends JFrame {

	/**
	 * 
	 *@author Endika Serrano Lomas
	 *
	 */
	private static GestAnimal miGestAnimal;
	private static final long serialVersionUID = 1L;
	private int estado;
	private static int idGanaderia;
	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JList<Toro> listaToros = new JList<Toro>(GestorAnimales.getInstance().obtenerToros(1));
	private JList<Cabestro> listaCabestros = new JList<Cabestro>(GestorAnimales.getInstance().obtenerCabestros(1));
	private JButton btnAnadir = new JButton("A\u00F1adir");
	private JButton btnEliminar = new JButton("Eliminar");
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnAtras = new JButton("Atr\u00E1s");

	private JLabel lblToros = new JLabel("Toros");
	private JLabel lblCabestros = new JLabel("Cabestros");
	private JSplitPane splitPane = new JSplitPane();
	private JScrollPane scrollPaneT = new JScrollPane();
	private JScrollPane scrollPaneC = new JScrollPane();
	
	/**
	 * Create the frame.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestAnimal frame = new GestAnimal(idGanaderia);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	GestAnimal(int pIdGanaderia) {
		//TODO
		idGanaderia = 1;
		inicializar();
	}
	
	public static GestAnimal getInstance(){
		if (miGestAnimal == null){
			miGestAnimal = new GestAnimal(idGanaderia);	
		}
		
		return miGestAnimal;
	}
	
	public void inicializar(){
		
	
		
		setTitle("Gestionar animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//BOTONES
		
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		//AÑADIR
		panelBotones.add(btnAnadir);
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				estado = 0;
				AltaAnimal aA = new AltaAnimal(idGanaderia,estado);
				aA.setVisible(true);
				
				if (!aA.isVisible()){
					listaCabestros.setModel(GestorAnimales.getInstance().obtenerCabestros(1));
					listaToros.setModel(GestorAnimales.getInstance().obtenerToros(1));
				}
			}
		});
		
		//MODIFICAR
		panelBotones.add(btnModificar);
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
		});
		
		//ELIMINAR
		panelBotones.add(btnEliminar);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (listaToros.isSelectionEmpty() && !listaCabestros.isSelectionEmpty()){
					listaCabestros.getSelectedValue().eliminarAnimal();
					listaCabestros.setModel(GestorAnimales.getInstance().obtenerCabestros(1));
					
				}else if (!listaToros.isSelectionEmpty() && listaCabestros.isSelectionEmpty()) 
					listaToros.getSelectedValue().eliminarAnimal();
					listaToros.setModel(GestorAnimales.getInstance().obtenerToros(1));
				}
			
		});
		
		//ATRAS	
		panelBotones.add(btnAtras);
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		
		
		contentPane.add(panel, BorderLayout.NORTH);
		
		//LABELS
		
		lblToros.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblToros);
		panel.add(lblCabestros);
			
		//LISTAS

		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(scrollPaneT);
		splitPane.setRightComponent(scrollPaneC);
		
		scrollPaneT.setViewportView(listaToros);
		scrollPaneC.setViewportView(listaCabestros);
		
		splitPane.setDividerLocation(163);
		
		listaToros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (listaToros.getSelectedIndex() >= 0) {
					listaCabestros.clearSelection();
				}
			}
		});
	
		listaCabestros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (listaCabestros.getSelectedIndex() >= 0) {
					listaToros.clearSelection();
				}
			}
		});
		
		listaCabestros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaToros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	}
	

}
