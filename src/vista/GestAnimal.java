package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestAnimal extends JFrame {

	/**
	 *@author Endika Serrano Lomas
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
		setBounds(100, 100, 386, 329);
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
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		panelBotones.add(btnAtras);
		
		//LISTA
		
		JPanel panelLista = new JPanel();
		contentPane.add(panelLista, BorderLayout.CENTER);
		
		JList listAnimales = new JList();

		JScrollPane scrollPane = new JScrollPane(listAnimales);
		panelLista.add(scrollPane);
		
		//panelLista.add(listAnimales);
		//scrollPane.setViewportView(list);
		
	}

}
