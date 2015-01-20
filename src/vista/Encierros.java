package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;

import sun.util.calendar.BaseCalendar.Date;
import modelo.Encierro;
import modelo.Ganaderia;
import modelo.GestorBD;
import modelo.ListaGanaderias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Encierros extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encierros frame = new Encierros();
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
	public Encierros() {
		setTitle("Asignacion de encierros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setBounds(71, 5, 43, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGanadera = new JLabel("Ganaderia");
		lblGanadera.setBounds(238, 5, 75, 14);
		contentPane.add(lblGanadera);
		
		final JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(5, 25, 162, 20);
		contentPane.add(comboBox);
		final ArrayList<Encierro> ListaEncierros = Encierro.obtenerListaEncierrosDeBase();
		for (int i = 0; i<=ListaEncierros.size();i++){	
			
			comboBox.addItem(Integer.toString(ListaEncierros.get(i).getIdEncierro()));	
		}
		
		final JComboBox<String> comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 25, 182, 20);
		contentPane.add(comboBox_1);
		ListaGanaderias.getListaGanaderias().obtenerGanaderiasDeBase();
		final ArrayList<Ganaderia> l = ListaGanaderias.getListaGanaderias().getLista();
		for(Ganaderia g:l){
			comboBox_1.addItem(g.getNombre());
		}
		
		final JList list = new JList();
		list.setBounds(5, 52, 418, 177);
		contentPane.add(list);
		final DefaultListModel modelo= new DefaultListModel();
		
		final JButton btnNewButton_2 = new JButton("Asignar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton_2){
					ListaEncierros.get(comboBox.getSelectedIndex()).setIdGanaderia(l.get(comboBox_1.getSelectedIndex()).getIdGanaderia());
					modelo.addElement(comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString());
					list.setModel(modelo);
					Encierro.añadirIDGanaderiaBD(ListaEncierros.get(comboBox.getSelectedIndex()));
					
				}
			}
		});
		
		
		btnNewButton_2.setBounds(359, 24, 69, 23);
		contentPane.add(btnNewButton_2);

		
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 234, 423, 23);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		final JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
				
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		//panel.add(gbc_btnNewButton_1);
		
	}
	
			}	

