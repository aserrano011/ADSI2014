package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Animal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textField_1;
	private JTextField txtPeso;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Animal frame = new Animal();
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
	public Animal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 446);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{168, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTree tree = new JTree();
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.insets = new Insets(0, 0, 5, 5);
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		getContentPane().add(tree, gbc_tree);
		
		JPanel pnlInfo = new JPanel();
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.fill = GridBagConstraints.VERTICAL;
		gbc_pnlInfo.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInfo.gridx = 1;
		gbc_pnlInfo.gridy = 0;
		getContentPane().add(pnlInfo, gbc_pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlInfo.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlInfo.setLayout(gbl_pnlInfo);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pnlInfo.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		pnlInfo.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("A\u00F1o de nacimiento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		pnlInfo.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Peso");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		pnlInfo.add(lblNewLabel, gbc_lblNewLabel);
		
		txtPeso = new JTextField();
		GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPeso.gridx = 1;
		gbc_txtPeso.gridy = 3;
		pnlInfo.add(txtPeso, gbc_txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Altura");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		pnlInfo.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		pnlInfo.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		pnlInfo.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		pnlInfo.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.EAST;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 0;
		gbc_lblImagen.gridy = 6;
		pnlInfo.add(lblImagen, gbc_lblImagen);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		pnlInfo.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton button = new JButton("...");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 6;
		pnlInfo.add(button, gbc_button);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		GridBagConstraints gbc_btnAñadir = new GridBagConstraints();
		gbc_btnAñadir.insets = new Insets(0, 0, 0, 5);
		gbc_btnAñadir.gridx = 0;
		gbc_btnAñadir.gridy = 8;
		pnlInfo.add(btnAñadir, gbc_btnAñadir);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 8;
		pnlInfo.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel pnlButLista = new JPanel();
		GridBagConstraints gbc_pnlButLista = new GridBagConstraints();
		gbc_pnlButLista.anchor = GridBagConstraints.NORTHEAST;
		gbc_pnlButLista.insets = new Insets(0, 0, 0, 5);
		gbc_pnlButLista.gridx = 0;
		gbc_pnlButLista.gridy = 1;
		getContentPane().add(pnlButLista, gbc_pnlButLista);
		pnlButLista.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBorrar = new JButton("-");
		pnlButLista.add(btnBorrar);
		
		JButton btnAgregar = new JButton("+");
		pnlButLista.add(btnAgregar);
	}

}
