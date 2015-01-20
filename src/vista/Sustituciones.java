package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import modelo.AlineacionCabestro;
import modelo.AlineacionToro;
import modelo.Encierro;
import modelo.Ganaderia;
import modelo.ListaGanaderias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sustituciones extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblToroSustituto;
	private JComboBox<Integer> cbToroTit;
	private JComboBox<Integer> cbToroSus;
	private JComboBox<Integer> cbCabTit;
	private JComboBox<Integer> cbCabSus;
	private DefaultComboBoxModel<Integer> modeloToroTit;
	private DefaultComboBoxModel<Integer> modeloToroSus;
	private DefaultComboBoxModel<Integer> modeloCabTit;
	private DefaultComboBoxModel<Integer> modeloCabSus;
	private Encierro enci;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					Sustituciones frame = new Sustituciones();
					frame.setVisible(true);
					
				/*} catch (Exception e) {
					e.printStackTrace();}
				
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public Sustituciones() {
		enci = new Encierro(null, 1, 20, 1);
		int encierro = enci.ObtenerEncierroUnico(Principal.getIdGanaderia());
		
		enci.setIdEncierro(1);
		modeloToroTit = new DefaultComboBoxModel<Integer>();
		enci.obtenerTorosAlineacionSQL();
		ArrayList<Integer> lista = enci.generarListaIDToro();
		for(Integer i:lista){
			modeloToroTit.addElement(i);
		}
		cbToroTit.setModel(modeloToroTit);
		
		modeloToroSus = new DefaultComboBoxModel<Integer>();
		enci.obtenerCabestrosAlineacionSQL();
		lista = enci.obtenerTorosSustitutos();
		for(Integer i:lista){
			modeloToroSus.addElement(i);
		}
		cbToroSus.setModel(modeloToroSus);
		
		modeloCabTit = new DefaultComboBoxModel<Integer>();
	    lista = enci.generarListaIDCabestro();
		for(Integer i:lista){
			modeloCabTit.addElement(i);
		}
		cbCabTit.setModel(modeloCabTit);
		
		modeloCabSus = new DefaultComboBoxModel<Integer>();
		lista = enci.obtenerCabestrosSustitutos();
		for(Integer i:lista){
			modeloCabSus.addElement(i);
		}
		cbCabSus.setModel(modeloCabSus);
		
		setTitle("Sustituciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Toro a sustituir");
		lblNewLabel.setBounds(51, 5, 72, 14);
		contentPane.add(lblNewLabel);
		
		lblToroSustituto = new JLabel("Toro Sustituto");
		lblToroSustituto.setBounds(221, 5, 68, 14);
		contentPane.add(lblToroSustituto);
		
		cbToroTit = new JComboBox<Integer>();
		cbToroTit.setBounds(5, 24, 165, 20);
		contentPane.add(cbToroTit);
		
		
		
		
		
		cbToroSus = new JComboBox<Integer>();
		cbToroSus.setBounds(175, 24, 160, 20);
		contentPane.add(cbToroSus);
		
		
		
		JButton sustituirToro = new JButton("Sustituir");
		sustituirToro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id1 = (int)cbToroTit.getSelectedItem();
				int id2 = (int)cbToroSus.getSelectedItem();
				enci.anadirSustitucionToroSQL(id1, id2);
				JOptionPane.showMessageDialog(null, "Toro sustituido");
				GestAlineacion ventana = new GestAlineacion();
				ventana.setVisible(true);
				
			}
		});
		sustituirToro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sustituirToro.setBounds(340, 24, 89, 23);
		contentPane.add(sustituirToro);
		
		JList list = new JList();
		list.setBounds(5, 52, 419, 76);
		contentPane.add(list);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cabestro a Sustituir");
		lblNewLabel_1.setBounds(40, 133, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCabestroSustituto = new JLabel("Cabestro Sustituto");
		lblCabestroSustituto.setBounds(210, 133, 90, 14);
		contentPane.add(lblCabestroSustituto);
		
		cbCabTit = new JComboBox();
		cbCabTit.setBounds(5, 152, 165, 20);
		contentPane.add(cbCabTit);
		
		cbCabSus = new JComboBox<Integer>();
		cbCabSus.setBounds(175, 152, 160, 20);
		contentPane.add(cbCabSus);
		
		
		JButton sustituirCab = new JButton("Sustituir");
		sustituirCab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id3 = (int)cbCabTit.getSelectedItem();
				int id4 = (int)cbCabSus.getSelectedItem();
				enci.anadirSustitucionCabestroSQL(id3, id4);
				JOptionPane.showMessageDialog(null, "Cabestro sustituido");
				GestAlineacion ventana = new GestAlineacion();
				ventana.setVisible(true);
				
				
			}
		});
		sustituirCab.setBounds(340, 152, 89, 23);
		contentPane.add(sustituirCab);
		
		JList list_1 = new JList();
		list_1.setBounds(5, 180, 419, 76);
		contentPane.add(list_1);
	}

}
