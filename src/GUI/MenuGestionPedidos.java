package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;

public class MenuGestionPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtEnvios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionPedidos frame = new MenuGestionPedidos();
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
	public MenuGestionPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 538, 216);
		contentPane.add(table);
		
		txtEnvios = new JTextField();
		txtEnvios.setText("Envios");
		txtEnvios.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnvios.setColumns(10);
		txtEnvios.setBounds(143, 259, 96, 20);
		contentPane.add(txtEnvios);
		
		JButton btnElimEnv = new JButton("Eliminar");
		btnElimEnv.setBounds(147, 289, 88, 22);
		contentPane.add(btnElimEnv);
		
		JButton btnModiEnv = new JButton("Modificar");
		btnModiEnv.setBounds(147, 321, 88, 22);
		contentPane.add(btnModiEnv);
		
		JButton btnEnviarPedido = new JButton("Enviar Pedido");
		btnEnviarPedido.setBounds(258, 289, 99, 22);
		contentPane.add(btnEnviarPedido);
		
		JButton btnCupoDiario = new JButton("Cupo diario");
		btnCupoDiario.setBounds(258, 321, 99, 22);
		contentPane.add(btnCupoDiario);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(367, 321, 88, 22);
		contentPane.add(btnAtras);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 238, 538, 124);
		contentPane.add(separator);

	}

}
