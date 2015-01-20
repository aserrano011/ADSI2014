package vista;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;

import modelo.AlineacionCabestro;
import modelo.AlineacionToro;
import modelo.Animal;
import modelo.Encierro;
import modelo.Ganaderia;
import modelo.ListaGanaderias;

public class AltaAlineacion extends JFrame {

	private JPanel contentPane;
	private JList<Integer> listaCabestrosAlineados;
	private JList<Integer> listaTorosAlineados;
	private JList<Integer> listaTorosDisponibles;
	private JList<Integer> listaCabestrosDisponibles;
	private DefaultListModel<Integer> modeloCabestrosDisponibles;
	private DefaultListModel<Integer> modeloCabestrosAlineados;
	private DefaultListModel<Integer> modeloTorosDisponibles;
	private DefaultListModel<Integer> modeloTorosAlineados;
	private Encierro e;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAlineacion frame = new AltaAlineacion();
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
	public AltaAlineacion() {
		
		e = new Encierro(null, 1, 20, 1);
		
		
		setTitle("Insertar Alineaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAlineacionToros = new JLabel("Toros disponibles");
		GridBagConstraints gbc_lblAlineacionToros = new GridBagConstraints();
		gbc_lblAlineacionToros.anchor = GridBagConstraints.WEST;
		gbc_lblAlineacionToros.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlineacionToros.gridx = 1;
		gbc_lblAlineacionToros.gridy = 0;
		contentPane.add(lblAlineacionToros, gbc_lblAlineacionToros);
		
		JLabel lblTorosalineados = new JLabel("Toros Alineados");
		GridBagConstraints gbc_lblTorosalineados = new GridBagConstraints();
		gbc_lblTorosalineados.insets = new Insets(0, 0, 5, 5);
		gbc_lblTorosalineados.gridx = 3;
		gbc_lblTorosalineados.gridy = 0;
		contentPane.add(lblTorosalineados, gbc_lblTorosalineados);
		
		listaTorosDisponibles = new JList<Integer>();
		listaTorosDisponibles.setVisibleRowCount( 8 );
		add(new JScrollPane(listaTorosDisponibles));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		contentPane.add(listaTorosDisponibles, gbc_list);
		
		modeloTorosDisponibles = new DefaultListModel<Integer>();
		ArrayList<Integer> lista = e.obtenerTorosInscripcion();
		for(Integer i:lista){
			modeloTorosDisponibles.addElement(i);
		}
		listaTorosDisponibles.setModel(modeloTorosDisponibles);
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAnadirToro = new JButton(">>");
		GridBagConstraints gbc_btnAnadirToro = new GridBagConstraints();
		gbc_btnAnadirToro.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnadirToro.gridx = 0;
		gbc_btnAnadirToro.gridy = 0;
		panel.add(btnAnadirToro, gbc_btnAnadirToro);
		
		JButton btnEliminarToro = new JButton("<<");
		GridBagConstraints gbc_btnEliminarToro = new GridBagConstraints();
		gbc_btnEliminarToro.gridx = 0;
		gbc_btnEliminarToro.gridy = 1;
		panel.add(btnEliminarToro, gbc_btnEliminarToro);
		
		listaTorosAlineados = new JList<Integer>();
		listaTorosAlineados.setVisibleRowCount( 8 );
		add(new JScrollPane(listaTorosAlineados));
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.insets = new Insets(0, 0, 5, 5);
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 3;
		gbc_list_2.gridy = 1;
		contentPane.add(listaTorosAlineados, gbc_list_2);
		
		modeloTorosAlineados = new DefaultListModel<Integer>();
		if(!e.getAlineacion().isEmpty()){
			lista = e.generarListaIDToro();
			for(Integer i:lista){
				modeloCabestrosAlineados.addElement(i);
			}
			listaCabestrosAlineados.setModel(modeloCabestrosAlineados);
		}
		
		JLabel lblNewLabel = new JLabel("Cabestros disponibles");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CabestrosAlineados");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		listaCabestrosDisponibles = new JList<Integer>();
		listaCabestrosDisponibles.setVisibleRowCount( 8 );
		add(new JScrollPane(listaCabestrosDisponibles));
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 1;
		gbc_list_1.gridy = 3;
		contentPane.add(listaCabestrosDisponibles, gbc_list_1);
		
		modeloCabestrosDisponibles = new DefaultListModel<Integer>();
		lista = e.obtenerCabestrosInscripcion();
		for(Integer i:lista){
			modeloCabestrosDisponibles.addElement(i);
			
		}
		listaCabestrosDisponibles.setModel(modeloCabestrosDisponibles);
		
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnAnadirCabestro = new JButton(">>");
		GridBagConstraints gbc_btnAnadirCabestro = new GridBagConstraints();
		gbc_btnAnadirCabestro.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnadirCabestro.gridx = 0;
		gbc_btnAnadirCabestro.gridy = 0;
		panel_1.add(btnAnadirCabestro, gbc_btnAnadirCabestro);
		
		JButton btnEliminarCabestro = new JButton("<<");
		GridBagConstraints gbc_btnEliminarCabestro = new GridBagConstraints();
		gbc_btnEliminarCabestro.gridx = 0;
		gbc_btnEliminarCabestro.gridy = 1;
		panel_1.add(btnEliminarCabestro, gbc_btnEliminarCabestro);
		
		listaCabestrosAlineados = new JList<Integer>();
		listaCabestrosAlineados.setVisibleRowCount( 8 );
		add(new JScrollPane(listaCabestrosAlineados));
		GridBagConstraints gbc_list_3 = new GridBagConstraints();
		gbc_list_3.insets = new Insets(0, 0, 5, 5);
		gbc_list_3.fill = GridBagConstraints.BOTH;
		gbc_list_3.gridx = 3;
		gbc_list_3.gridy = 3;
		contentPane.add(listaCabestrosAlineados, gbc_list_3);
		
		modeloCabestrosAlineados = new DefaultListModel<Integer>();
		if(!e.getAlineacion().isEmpty()){
			lista = e.generarListaIDCabestro();
			for(Integer i:lista){
				modeloCabestrosAlineados.addElement(i);
			}
			listaCabestrosAlineados.setModel(modeloCabestrosAlineados);
		}
		
		
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 5;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.EAST;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 0;
		panel_2.add(btnAceptar, gbc_btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ArrayList<AlineacionToro> alineacion = new ArrayList<AlineacionToro>();
				Integer iaux;
				AlineacionToro ataux;
				for(int i=0; i<modeloTorosAlineados.getSize(); i++){
					iaux=modeloTorosAlineados.elementAt(i);
					ataux= new AlineacionToro(iaux, e.getIdEncierro());
					alineacion.add(ataux);
				}
				e.setAlineacion(alineacion);
				
				ArrayList<AlineacionCabestro> alineacioncab = new ArrayList<AlineacionCabestro>();
				AlineacionCabestro acaux;
				for(int i=0; i<modeloCabestrosAlineados.getSize(); i++){
					iaux=modeloCabestrosAlineados.elementAt(i);
					acaux= new AlineacionCabestro(iaux, e.getIdEncierro());
					alineacioncab.add(acaux);
				}
				e.setAlineacionCab(alineacioncab);
				
				e.registrarAlineacionesEnBase();
			}			
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel_2.add(btnCancelar, gbc_btnCancelar);
		
		
		btnAnadirCabestro.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Integer idsustituto;
				idsustituto = listaCabestrosDisponibles.getSelectedValue();
				if(idsustituto==null){
					JOptionPane.showMessageDialog(null, "Se deben seleccionar dos cabestros");
				}else{
					modeloCabestrosDisponibles.removeElement(idsustituto);
					listaCabestrosDisponibles.setModel(modeloCabestrosDisponibles);
					modeloCabestrosAlineados.addElement(idsustituto);
					listaCabestrosAlineados.setModel(modeloCabestrosAlineados);
					
				}
			}
		});
		
		btnEliminarCabestro.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Integer idsustituido;
				idsustituido = listaCabestrosAlineados.getSelectedValue();
				if(idsustituido==null){
					JOptionPane.showMessageDialog(null, "Se deben seleccionar dos cabestros");
				}else{
					modeloCabestrosDisponibles.addElement(idsustituido);
					listaCabestrosDisponibles.setModel(modeloCabestrosDisponibles);
					modeloCabestrosAlineados.removeElement(idsustituido);
					listaCabestrosAlineados.setModel(modeloCabestrosAlineados);
					
				}
			}
		});
		
		btnAnadirToro.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Integer idsustituto;
				idsustituto = listaTorosDisponibles.getSelectedValue();
				if(idsustituto==null){
					JOptionPane.showMessageDialog(null, "Se deben seleccionar dos cabestros");
				}else{
					modeloTorosDisponibles.removeElement(idsustituto);
					listaTorosDisponibles.setModel(modeloTorosDisponibles);
					modeloTorosAlineados.addElement(idsustituto);
					listaTorosAlineados.setModel(modeloTorosAlineados);
					
				}
			}
		});
		
		btnEliminarToro.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Integer idsustituido;
				idsustituido = listaTorosAlineados.getSelectedValue();
				if(idsustituido==null){
					JOptionPane.showMessageDialog(null, "Se deben seleccionar dos cabestros");
				}else{
					modeloTorosDisponibles.addElement(idsustituido);
					listaTorosDisponibles.setModel(modeloTorosDisponibles);
					modeloTorosAlineados.removeElement(idsustituido);
					listaTorosAlineados.setModel(modeloTorosAlineados);
					
				}
			}
		});
	}

}
