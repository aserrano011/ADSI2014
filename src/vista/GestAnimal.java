package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JList;

public class GestAnimal extends JFrame {

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
					GestAnimal frame = new GestAnimal();
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
	public GestAnimal() {
		setTitle("Gestionar animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,center][grow,center]", "[grow][][][][][][][]"));
		
		JList lstAnimales = new JList();
		contentPane.add(lstAnimales, "cell 0 0 2 6,grow");
		
		JButton btnNewButton_2 = new JButton("A\u00F1adir");
		contentPane.add(btnNewButton_2, "cell 0 6");
		
		JButton btnNewButton_3 = new JButton("Modificar");
		contentPane.add(btnNewButton_3, "cell 1 6");
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		contentPane.add(btnNewButton_1, "cell 0 7");
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		contentPane.add(btnNewButton, "cell 1 7");
	}

}
