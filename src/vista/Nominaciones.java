package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

public class Nominaciones extends JFrame {

	/**
	 * 
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
		setTitle("Nominaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][][][]"));
		
		JList lblGanaderias = new JList();
		contentPane.add(lblGanaderias, "cell 0 0 3 1,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Primer Nominado:");
		contentPane.add(lblNewLabel_2, "cell 0 1,alignx right,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		contentPane.add(lblNewLabel_3, "cell 1 1 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Segundo Nominado:");
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx right,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		contentPane.add(lblNewLabel_4, "cell 1 2 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel = new JLabel("Tercer Nominado:");
		contentPane.add(lblNewLabel, "cell 0 3,alignx right,aligny center");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		contentPane.add(lblNewLabel_5, "cell 1 3 2 1,alignx left,aligny center");
		
		JButton btnNewButton = new JButton("Aceptar");
		contentPane.add(btnNewButton, "cell 0 4,alignx center,aligny center");
		
		JButton btnNewButton_1 = new JButton("Reiniciar");
		contentPane.add(btnNewButton_1, "cell 2 4,alignx center,aligny center");
	}

}
