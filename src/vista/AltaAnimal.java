package vista;

import java.awt.EventQueue;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import modelo.Animal;
import modelo.GestorAnimales;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Endika Serrano Lomas
 *
 */
public class AltaAnimal extends JDialog {

	private static final long serialVersionUID = 1L;
	private static int idGanaderia;
	private static Animal animal;
	private JPanel pnlAnimales = new JPanel();
	private JPanel Toro = new JPanel();
	private JPanel Cabestro = new JPanel();
	private JTextField txtNombreT;
	private JTextField txtAlturaT;
	private JTextField txtPesoT;
	private JTextField txtLongT;
	private JTextField txtPesoC;
	private JTextField txtAlturaC;
	private JTextField txtColorC;
	private JTextField txtAnioT;
	private JTextField txtAnioC;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JLabel lblLongT = new JLabel("Longitud Cornamenta:");
	private JLabel lblNombreT = new JLabel("Nombre:");
	private JLabel lblAnioC = new JLabel("A\u00F1o de nacimiento:");
	private JLabel lblAlturaT = new JLabel("Altura:");
	private JLabel lblAlturaC = new JLabel("Altura:");
	private JLabel lblColorC = new JLabel("Color:");
	private JLabel lblPesoT = new JLabel("Peso:");
	private JLabel lblPesoC = new JLabel("Peso:");
	private JLabel lblAnio = new JLabel("A\u00F1o de nacimiento:");
	private JPanel pnlBotones = new JPanel();
	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnCancelar = new JButton("Cancelar");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAnimal frame = new AltaAnimal(idGanaderia,animal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AltaAnimal(int pIdGanaderia, Animal pAnimal) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		idGanaderia = pIdGanaderia;
		animal = pAnimal;
		inicializar();
	}
	
	private void inicializar(){
		setTitle("Gestion Animales");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 320);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(pnlAnimales, BorderLayout.CENTER);
		pnlAnimales.add(tabbedPane);
		
		//PESTAÑAS DE TORO Y CABESTRO
		tabbedPane.addTab("Toro", null, Toro, null);
		GridBagLayout gbl_Toro = new GridBagLayout();
		gbl_Toro.columnWidths = new int[]{132, 182, 0};
		gbl_Toro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Toro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Toro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		Toro.setLayout(gbl_Toro);
		
		tabbedPane.addTab("Cabestro", null, Cabestro, null);
		GridBagLayout gbl_Cabestro = new GridBagLayout();
		gbl_Cabestro.columnWidths = new int[]{132, 182, 0};
		gbl_Cabestro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Cabestro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Cabestro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		Cabestro.setLayout(gbl_Cabestro);
		
		//Control TEXTFIELDS para MODIFICAR
		txtNombreT = new JTextField();
		txtAnioT = new JTextField();
		txtPesoT = new JTextField();
		txtLongT = new JTextField();
		txtAnioC = new JTextField();
		txtAlturaT = new JTextField();
		txtAlturaC = new JTextField();
		txtColorC = new JTextField();
		txtPesoC = new JTextField();
		
		if (animal instanceof modelo.Toro){
			tabbedPane.removeTabAt(1);
			txtNombreT.setText(((modelo.Toro) animal).getNombre());
			txtAnioT.setText(animal.getNacimiento());
			txtPesoT.setText(String.valueOf(animal.getPeso()));
			txtAlturaT.setText(String.valueOf(animal.getAltura()));
			txtLongT.setText(String.valueOf(((modelo.Toro) animal).getLongCorn()));
			
		}else if (animal instanceof modelo.Cabestro){
			tabbedPane.removeTabAt(0);
			txtAnioC.setText(animal.getNacimiento());
			txtPesoC.setText(String.valueOf(animal.getPeso()));
			txtAlturaC.setText(String.valueOf(animal.getAltura()));
			txtColorC.setText(((modelo.Cabestro) animal).getColor());
		}
		
		//TORO
		GridBagConstraints gbc_lblNombreT = new GridBagConstraints();
		gbc_lblNombreT.anchor = GridBagConstraints.EAST;
		gbc_lblNombreT.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreT.gridx = 0;
		gbc_lblNombreT.gridy = 1;
		Toro.add(lblNombreT, gbc_lblNombreT);
		
		
		GridBagConstraints gbc_txtNombreT = new GridBagConstraints();
		gbc_txtNombreT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreT.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombreT.gridx = 1;
		gbc_txtNombreT.gridy = 1;
		Toro.add(txtNombreT, gbc_txtNombreT);
		txtNombreT.setColumns(10);
		
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 0;
		gbc_lblAnio.gridy = 2;
		Toro.add(lblAnio, gbc_lblAnio);
		
		
		txtAnioT.setColumns(10);
		GridBagConstraints gbc_txtAnioT = new GridBagConstraints();
		gbc_txtAnioT.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnioT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnioT.gridx = 1;
		gbc_txtAnioT.gridy = 2;
		Toro.add(txtAnioT, gbc_txtAnioT);
		
		GridBagConstraints gbc_lblPesoT = new GridBagConstraints();
		gbc_lblPesoT.anchor = GridBagConstraints.EAST;
		gbc_lblPesoT.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoT.gridx = 0;
		gbc_lblPesoT.gridy = 3;
		Toro.add(lblPesoT, gbc_lblPesoT);
		
		
		GridBagConstraints gbc_txtPesoT = new GridBagConstraints();
		gbc_txtPesoT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesoT.insets = new Insets(0, 0, 5, 0);
		gbc_txtPesoT.gridx = 1;
		gbc_txtPesoT.gridy = 3;
		Toro.add(txtPesoT, gbc_txtPesoT);
		txtPesoT.setColumns(10);
		
		GridBagConstraints gbc_lblAlturaT = new GridBagConstraints();
		gbc_lblAlturaT.anchor = GridBagConstraints.EAST;
		gbc_lblAlturaT.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlturaT.gridx = 0;
		gbc_lblAlturaT.gridy = 4;
		Toro.add(lblAlturaT, gbc_lblAlturaT);
		
		
		GridBagConstraints gbc_txtAlturaT = new GridBagConstraints();
		gbc_txtAlturaT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlturaT.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlturaT.gridx = 1;
		gbc_txtAlturaT.gridy = 4;
		Toro.add(txtAlturaT, gbc_txtAlturaT);
		txtAlturaT.setColumns(10);
		
		
		GridBagConstraints gbc_lblLongT = new GridBagConstraints();
		gbc_lblLongT.anchor = GridBagConstraints.EAST;
		gbc_lblLongT.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongT.gridx = 0;
		gbc_lblLongT.gridy = 5;
		Toro.add(lblLongT, gbc_lblLongT);
		
		
		GridBagConstraints gbc_txtLongT = new GridBagConstraints();
		gbc_txtLongT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLongT.insets = new Insets(0, 0, 5, 0);
		gbc_txtLongT.gridx = 1;
		gbc_txtLongT.gridy = 5;
		Toro.add(txtLongT, gbc_txtLongT);
		txtLongT.setColumns(10);
		
		//CABESTRO
		GridBagConstraints gbc_lblAnioC = new GridBagConstraints();
		gbc_lblAnioC.anchor = GridBagConstraints.EAST;
		gbc_lblAnioC.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnioC.gridx = 0;
		gbc_lblAnioC.gridy = 1;
		Cabestro.add(lblAnioC, gbc_lblAnioC);
		
		GridBagConstraints gbc_txtAnioC = new GridBagConstraints();
		gbc_txtAnioC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnioC.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnioC.gridx = 1;
		gbc_txtAnioC.gridy = 1;
		Cabestro.add(txtAnioC, gbc_txtAnioC);
		
		GridBagConstraints gbc_lblPesoC = new GridBagConstraints();
		gbc_lblPesoC.anchor = GridBagConstraints.EAST;
		gbc_lblPesoC.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoC.gridx = 0;
		gbc_lblPesoC.gridy = 2;
		Cabestro.add(lblPesoC, gbc_lblPesoC);
		
		txtPesoC.setColumns(10);
		GridBagConstraints gbc_txtPesoC = new GridBagConstraints();
		gbc_txtPesoC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesoC.insets = new Insets(0, 0, 5, 0);
		gbc_txtPesoC.gridx = 1;
		gbc_txtPesoC.gridy = 2;
		Cabestro.add(txtPesoC, gbc_txtPesoC);
		
		GridBagConstraints gbc_lblAlturaC = new GridBagConstraints();
		gbc_lblAlturaC.anchor = GridBagConstraints.EAST;
		gbc_lblAlturaC.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlturaC.gridx = 0;
		gbc_lblAlturaC.gridy = 3;
		Cabestro.add(lblAlturaC, gbc_lblAlturaC);
		
		
		txtAlturaC.setColumns(10);
		GridBagConstraints gbc_txtAlturaC = new GridBagConstraints();
		gbc_txtAlturaC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlturaC.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlturaC.gridx = 1;
		gbc_txtAlturaC.gridy = 3;
		Cabestro.add(txtAlturaC, gbc_txtAlturaC);
		
		GridBagConstraints gbc_lblColorC = new GridBagConstraints();
		gbc_lblColorC.anchor = GridBagConstraints.EAST;
		gbc_lblColorC.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorC.gridx = 0;
		gbc_lblColorC.gridy = 4;
		Cabestro.add(lblColorC, gbc_lblColorC);
		
		txtColorC.setColumns(10);
		GridBagConstraints gbc_txtColorC = new GridBagConstraints();
		gbc_txtColorC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtColorC.insets = new Insets(0, 0, 5, 0);
		gbc_txtColorC.gridx = 1;
		gbc_txtColorC.gridy = 4;
		Cabestro.add(txtColorC, gbc_txtColorC);
		
		//BOTONES
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
		pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				//AÑADIR TORO
				if (tabbedPane.getSelectedIndex() == 0 && tabbedPane.getTabCount() == 2){
					if (!txtNombreT.getText().equals("") && !txtAnioT.getText().equals("") && !txtPesoT.getText().equals("") && !txtAlturaT.getText().equals("") && !txtLongT.getText().equals("")){
						
						GestorAnimales.getInstance().anadirToro(txtNombreT.getText(), txtAnioT.getText(),
							Float.parseFloat(txtPesoT.getText()), Float.parseFloat(txtAlturaT.getText()),
							Float.parseFloat(txtLongT.getText()), idGanaderia);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null,"Rellena todos los campos");
					}
				//AÑADIR CABESTRO
				}else if (tabbedPane.getSelectedIndex() == 1 && tabbedPane.getTabCount() == 2){
					if(!txtAnioC.getText().equals("") && !txtPesoC.getText().equals("") && !txtAlturaC.getText().equals("") && !txtColorC.getText().equals("")){
						
						GestorAnimales.getInstance().anadirCabestro(txtAnioC.getText(),	Float.parseFloat(txtPesoC.getText()), 
							Float.parseFloat(txtAlturaC.getText()),txtColorC.getText(), idGanaderia);
						dispose();
					}else{
					JOptionPane.showMessageDialog(null,"Rellena todos los campos");
					}
				//MODIFICAR TORO
				}else if (tabbedPane.getTitleAt(0).equals("Toro") && tabbedPane.getTabCount() == 1){
					if (!txtNombreT.getText().equals("") && !txtAnioT.getText().equals("") && !txtPesoT.getText().equals("") && !txtAlturaT.getText().equals("") && !txtLongT.getText().equals("")){
							
							((modelo.Toro) animal).modificarToro(txtNombreT.getText(), txtAnioT.getText(),
								Float.parseFloat(txtPesoT.getText()), Float.parseFloat(txtAlturaT.getText()),
								Float.parseFloat(txtLongT.getText()));
							
							dispose();
						}else{
							JOptionPane.showMessageDialog(null,"Rellena todos los campos");
						}
				//MODIFICAR CABESTRO
				}else if (tabbedPane.getTitleAt(0).equals("Cabestro") && tabbedPane.getTabCount() == 1){	
					if(!txtAnioC.getText().equals("") && !txtPesoC.getText().equals("") && !txtAlturaC.getText().equals("") && !txtColorC.getText().equals("")){
								
								((modelo.Cabestro) animal).modificarCabestro(txtAnioC.getText(), 
									Float.parseFloat(txtPesoC.getText()), Float.parseFloat(txtAlturaC.getText()),txtColorC.getText());
								
								dispose();
							}else{
								JOptionPane.showMessageDialog(null,"Rellena todos los campos");
							}
						}
				}
		});
		
		pnlBotones.add(btnAceptar);
		pnlBotones.add(btnCancelar);
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
	}

}
