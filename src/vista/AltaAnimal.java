package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AltaAnimal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtAlturaT;
	private JTextField txtPesoT;
	private JTextField txtLongT;
	private JTextField txtNombreC;
	private JTextField txtPesoC;
	private JTextField txtAlturaC;
	private JTextField txtColorC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAnimal frame = new AltaAnimal();
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
	public AltaAnimal() {
		setTitle("Gestion Animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 302);
		
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Format shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
		
		df.setLenient(false);
		/*
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			mf.install(formattedTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lblNewLabel_3.setText("jar!");
		}*/
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		//TORO
		
		JPanel Toro = new JPanel();
		tabbedPane.addTab("Toro", null, Toro, null);
		GridBagLayout gbl_Toro = new GridBagLayout();
		gbl_Toro.columnWidths = new int[]{132, 182, 0};
		gbl_Toro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Toro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Toro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		Toro.setLayout(gbl_Toro);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		Toro.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		Toro.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAnio = new JLabel("A\u00F1o de nacimiento:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 0;
		gbc_lblAnio.gridy = 2;
		Toro.add(lblAnio, gbc_lblAnio);
		
		JFormattedTextField txtAnio = new JFormattedTextField(shortDate);
		GridBagConstraints gbc_txtAnio = new GridBagConstraints();
		gbc_txtAnio.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnio.gridx = 1;
		gbc_txtAnio.gridy = 2;
		Toro.add(txtAnio, gbc_txtAnio);
		
		JLabel lblPesoT = new JLabel("Peso:");
		GridBagConstraints gbc_lblPesoT = new GridBagConstraints();
		gbc_lblPesoT.anchor = GridBagConstraints.EAST;
		gbc_lblPesoT.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoT.gridx = 0;
		gbc_lblPesoT.gridy = 3;
		Toro.add(lblPesoT, gbc_lblPesoT);
		
		txtPesoT = new JTextField();
		GridBagConstraints gbc_txtPesoT = new GridBagConstraints();
		gbc_txtPesoT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesoT.insets = new Insets(0, 0, 5, 0);
		gbc_txtPesoT.gridx = 1;
		gbc_txtPesoT.gridy = 3;
		Toro.add(txtPesoT, gbc_txtPesoT);
		txtPesoT.setColumns(10);
		
		JLabel lblAlturaT = new JLabel("Altura:");
		GridBagConstraints gbc_lblAlturaT = new GridBagConstraints();
		gbc_lblAlturaT.anchor = GridBagConstraints.EAST;
		gbc_lblAlturaT.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlturaT.gridx = 0;
		gbc_lblAlturaT.gridy = 4;
		Toro.add(lblAlturaT, gbc_lblAlturaT);
		
		txtAlturaT = new JTextField();
		GridBagConstraints gbc_txtAlturaT = new GridBagConstraints();
		gbc_txtAlturaT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlturaT.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlturaT.gridx = 1;
		gbc_txtAlturaT.gridy = 4;
		Toro.add(txtAlturaT, gbc_txtAlturaT);
		txtAlturaT.setColumns(10);
		
		JLabel lblLongT = new JLabel("Longitud Cornamenta:");
		GridBagConstraints gbc_lblLongT = new GridBagConstraints();
		gbc_lblLongT.anchor = GridBagConstraints.EAST;
		gbc_lblLongT.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongT.gridx = 0;
		gbc_lblLongT.gridy = 5;
		Toro.add(lblLongT, gbc_lblLongT);
		
		txtLongT = new JTextField();
		GridBagConstraints gbc_txtLongT = new GridBagConstraints();
		gbc_txtLongT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLongT.insets = new Insets(0, 0, 5, 0);
		gbc_txtLongT.gridx = 1;
		gbc_txtLongT.gridy = 5;
		Toro.add(txtLongT, gbc_txtLongT);
		txtLongT.setColumns(10);
		
		JPanel pnlToro = new JPanel();
		GridBagConstraints gbc_pnlToro = new GridBagConstraints();
		gbc_pnlToro.gridwidth = 2;
		gbc_pnlToro.insets = new Insets(0, 0, 0, 5);
		gbc_pnlToro.gridx = 0;
		gbc_pnlToro.gridy = 7;
		Toro.add(pnlToro, gbc_pnlToro);
		pnlToro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAniadirT = new JButton("A\u00F1adir");
		pnlToro.add(btnAniadirT);
		
		JButton btnCerrarT = new JButton("Cerrar");
		btnCerrarT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		pnlToro.add(btnCerrarT);
		
		//CABESTRO
		
		JPanel Cabestro = new JPanel();
		tabbedPane.addTab("Cabestro", null, Cabestro, null);
		GridBagLayout gbl_Cabestro = new GridBagLayout();
		gbl_Cabestro.columnWidths = new int[]{132, 182, 0};
		gbl_Cabestro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Cabestro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Cabestro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		Cabestro.setLayout(gbl_Cabestro);
		
		JLabel lblNombreC = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombreC = new GridBagConstraints();
		gbc_lblNombreC.anchor = GridBagConstraints.EAST;
		gbc_lblNombreC.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreC.gridx = 0;
		gbc_lblNombreC.gridy = 1;
		Cabestro.add(lblNombreC, gbc_lblNombreC);
		
		txtNombreC = new JTextField();
		txtNombreC.setColumns(10);
		GridBagConstraints gbc_txtNombreC = new GridBagConstraints();
		gbc_txtNombreC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreC.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombreC.gridx = 1;
		gbc_txtNombreC.gridy = 1;
		Cabestro.add(txtNombreC, gbc_txtNombreC);
		
		JLabel lblAnioC = new JLabel("A\u00F1o de nacimiento:");
		GridBagConstraints gbc_lblAnioC = new GridBagConstraints();
		gbc_lblAnioC.anchor = GridBagConstraints.EAST;
		gbc_lblAnioC.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnioC.gridx = 0;
		gbc_lblAnioC.gridy = 2;
		Cabestro.add(lblAnioC, gbc_lblAnioC);
		
		JFormattedTextField txtAnioC = new JFormattedTextField((Format) null);
		GridBagConstraints gbc_txtAnioC = new GridBagConstraints();
		gbc_txtAnioC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnioC.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnioC.gridx = 1;
		gbc_txtAnioC.gridy = 2;
		Cabestro.add(txtAnioC, gbc_txtAnioC);
		
		JLabel lblPesoC = new JLabel("Peso:");
		GridBagConstraints gbc_lblPesoC = new GridBagConstraints();
		gbc_lblPesoC.anchor = GridBagConstraints.EAST;
		gbc_lblPesoC.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoC.gridx = 0;
		gbc_lblPesoC.gridy = 3;
		Cabestro.add(lblPesoC, gbc_lblPesoC);
		
		txtPesoC = new JTextField();
		txtPesoC.setColumns(10);
		GridBagConstraints gbc_txtPesoC = new GridBagConstraints();
		gbc_txtPesoC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesoC.insets = new Insets(0, 0, 5, 0);
		gbc_txtPesoC.gridx = 1;
		gbc_txtPesoC.gridy = 3;
		Cabestro.add(txtPesoC, gbc_txtPesoC);
		
		JLabel lblAlturaC = new JLabel("Altura:");
		GridBagConstraints gbc_lblAlturaC = new GridBagConstraints();
		gbc_lblAlturaC.anchor = GridBagConstraints.EAST;
		gbc_lblAlturaC.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlturaC.gridx = 0;
		gbc_lblAlturaC.gridy = 4;
		Cabestro.add(lblAlturaC, gbc_lblAlturaC);
		
		txtAlturaC = new JTextField();
		txtAlturaC.setColumns(10);
		GridBagConstraints gbc_txtAlturaC = new GridBagConstraints();
		gbc_txtAlturaC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlturaC.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlturaC.gridx = 1;
		gbc_txtAlturaC.gridy = 4;
		Cabestro.add(txtAlturaC, gbc_txtAlturaC);
		
		JLabel lblColorC = new JLabel("Color:");
		GridBagConstraints gbc_lblColorC = new GridBagConstraints();
		gbc_lblColorC.anchor = GridBagConstraints.EAST;
		gbc_lblColorC.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorC.gridx = 0;
		gbc_lblColorC.gridy = 5;
		Cabestro.add(lblColorC, gbc_lblColorC);
		
		txtColorC = new JTextField();
		txtColorC.setColumns(10);
		GridBagConstraints gbc_txtColorC = new GridBagConstraints();
		gbc_txtColorC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtColorC.insets = new Insets(0, 0, 5, 0);
		gbc_txtColorC.gridx = 1;
		gbc_txtColorC.gridy = 5;
		Cabestro.add(txtColorC, gbc_txtColorC);
		
		JPanel pnlCabestro = new JPanel();
		GridBagConstraints gbc_pnlCabestro = new GridBagConstraints();
		gbc_pnlCabestro.insets = new Insets(0, 0, 0, 5);
		gbc_pnlCabestro.gridwidth = 2;
		gbc_pnlCabestro.gridx = 0;
		gbc_pnlCabestro.gridy = 7;
		Cabestro.add(pnlCabestro, gbc_pnlCabestro);
		pnlCabestro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAnadirC = new JButton("A\u00F1adir");
		pnlCabestro.add(btnAnadirC);
		
		JButton btnCerrarC = new JButton("Cerrar");
		btnCerrarC.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		pnlCabestro.add(btnCerrarC);
	}

}
