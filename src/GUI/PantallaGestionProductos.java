package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaGestionProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaGestionProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestión de Productos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(135, 39, 194, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnVerProductos = new JButton("Ver Productos");
		btnVerProductos.setBounds(44, 108, 183, 29);
		contentPane.add(btnVerProductos);
		
		JButton btnMovimientoStock = new JButton("Ver Movimiento de Stock");
		btnMovimientoStock.setBounds(226, 108, 183, 29);
		contentPane.add(btnMovimientoStock);
		
		JButton btnSalir = new JButton("<- Salir");
		btnSalir.setBounds(170, 178, 117, 29);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(e -> {
			/*PantallaAdmin nueva = new PantallaAdmin();
	    	nueva.setVisible(true);
	    	dispose();*/
			});

	}

}
