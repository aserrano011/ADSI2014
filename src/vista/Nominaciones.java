package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Ganaderia;
import modelo.ListaGanaderias;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Nominaciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> listaGanaderias;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Ganaderia g;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nominaciones frame = new Nominaciones();
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
	public Nominaciones() {
		
		g = ListaGanaderias.getListaGanaderias().buscarPorId(Principal.getIdGanaderia());
		
		setTitle("Nominaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][][][]"));
		
		listaGanaderias = new JList<String>();
		add(new JScrollPane(listaGanaderias));
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		ArrayList<Ganaderia> lg = ListaGanaderias.getListaGanaderias().getLista();
		for(Ganaderia aux:lg){
			if(aux.getIdGanaderia()!=g.getIdGanaderia()){
				modelo.addElement(aux.getNombre());
			}
		}
		listaGanaderias.setModel(modelo);
		
		listaGanaderias.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent ev) {
				String seleccion = listaGanaderias.getSelectedValue();
				if(!(lblNewLabel_3.getText().equals(seleccion) || lblNewLabel_4.getText().equals(seleccion) || lblNewLabel_5.getText().equals(seleccion))){
					if(lblNewLabel_3.getText().equals("")){
						lblNewLabel_3.setText(seleccion);
					}else if(lblNewLabel_4.getText().equals("")){
						lblNewLabel_4.setText(seleccion);
					}else if(lblNewLabel_5.getText().equals("")){
						lblNewLabel_5.setText(seleccion);
					}
				}
			}
		});
		
		contentPane.add(listaGanaderias, "cell 0 0 3 1,grow");
		
		lblNewLabel_2 = new JLabel("Primer Nominado:");
		contentPane.add(lblNewLabel_2, "cell 0 1,alignx right,aligny center");
		
		lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 1 1 2 1,alignx left,aligny center");
		
		lblNewLabel_1 = new JLabel("Segundo Nominado:");
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx right,aligny center");
		
		lblNewLabel_4 = new JLabel("");
		contentPane.add(lblNewLabel_4, "cell 1 2 2 1,alignx left,aligny center");
		
		lblNewLabel = new JLabel("Tercer Nominado:");
		contentPane.add(lblNewLabel, "cell 0 3,alignx right,aligny center");
		
		lblNewLabel_5 = new JLabel("");
		contentPane.add(lblNewLabel_5, "cell 1 3 2 1,alignx left,aligny center");
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> nominados = new ArrayList<String>();
				if(!lblNewLabel_3.getText().equals("")){
					nominados.add(lblNewLabel_3.getText());
				}
				
				if(!lblNewLabel_4.getText().equals("")){
					nominados.add(lblNewLabel_4.getText());
				}
				
				if(!lblNewLabel_5.getText().equals("")){
					nominados.add(lblNewLabel_5.getText());
				}
				
				g.votar(nominados);
				btnNewButton.setEnabled(false);
				btnNewButton_1.setEnabled(false);
			}
		});
		contentPane.add(btnNewButton, "cell 0 4,alignx center,aligny center");
		
		btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");
				lblNewLabel_5.setText("");
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 4,alignx center,aligny center");
	
		if(g.haVotado()){
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Usted ya ha votado este año", "Error", JOptionPane.ERROR_MESSAGE);
			String[] nominados = g.obtenerNominaciones();
			if(nominados[0]!=null){
				lblNewLabel_3.setText(nominados[0]);
			}else{
				lblNewLabel_3.setText("En blanco");
			}
			
			if(nominados[1]!=null){
				lblNewLabel_4.setText(nominados[1]);
			}else{
				lblNewLabel_4.setText("En blanco");
			}
			
			if(nominados[2]!=null){
				lblNewLabel_5.setText(nominados[2]);
			}else{
				lblNewLabel_5.setText("En blanco");
			}
		}
	}
}
