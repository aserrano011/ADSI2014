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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import modelo.Cabestro;
import modelo.GestorAnimales;
import modelo.GestorBD;
import modelo.Toro;

public class GestAnimal extends JFrame {

	/**
	 * 
	 *@author Endika Serrano Lomas
	 *
	 */
	private static GestAnimal miGestAnimal;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int idGanaderia;
	final JList<Toro> listaToros = new JList<Toro>(GestorAnimales.getInstance().obtenerToros(1));
	final JList<Cabestro> listaCabestros = new JList<Cabestro>(GestorAnimales.getInstance().obtenerCabestros(1));
	
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
		idGanaderia = pIdGanaderia;
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
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(scrollPaneT);
		splitPane.setRightComponent(scrollPaneC);
		
		scrollPaneT.setViewportView(listaToros);
		scrollPaneC.setViewportView(listaCabestros);
		
		splitPane.setDividerLocation(170);
		

		//final JList<Toro> listaToros = new JList<Toro>(GestorAnimales.getInstance().obtenerToros(1));
		listaToros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (listaToros.getSelectedIndex() >= 0) {
					listaCabestros.clearSelection();
				}
			}
		});
		//final JList<Cabestro> listaCabestros = new JList<Cabestro>(GestorAnimales.getInstance().obtenerCabestros(1));
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
