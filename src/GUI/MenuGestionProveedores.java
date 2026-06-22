package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;

public class MenuGestionProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionProveedores frame = new MenuGestionProveedores();
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
	public MenuGestionProveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 538, 216);
		contentPane.add(table);
		
		JButton btnCrearProv = new JButton("Crear");
		btnCrearProv.setBounds(168, 322, 88, 22);
		contentPane.add(btnCrearProv);
		
		JButton btnElimProv = new JButton("Eliminar");
		btnElimProv.setBounds(39, 322, 88, 22);
		contentPane.add(btnElimProv);
		
		JButton btnModiProv = new JButton("Modificar");
		btnModiProv.setBounds(297, 322, 88, 22);
		contentPane.add(btnModiProv);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(426, 322, 88, 22);
		contentPane.add(btnAtras);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 238, 538, 124);
		contentPane.add(separator);

	}

}
