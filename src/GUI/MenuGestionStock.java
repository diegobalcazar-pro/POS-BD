package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class MenuGestionStock extends JFrame {

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
					MenuGestionStock frame = new MenuGestionStock();
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
	public MenuGestionStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 538, 216);
		contentPane.add(table);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(126, 296, 88, 22);
		contentPane.add(btnModificar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBounds(341, 296, 88, 22);
		contentPane.add(btnAtrs);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 238, 538, 124);
		contentPane.add(separator);

	}

}
