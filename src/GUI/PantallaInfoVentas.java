package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaInfoVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaInfoVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Información de Ventas");
		lblNewLabel.setBounds(132, 23, 187, 20);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		
		JButton btnHistorialVentas = new JButton("Historial de Ventas");
		btnHistorialVentas.setBounds(66, 91, 143, 29);
		contentPane.add(btnHistorialVentas);
		
		
		JButton btnCategoriaVendidas = new JButton("Categorias más vendidas");
		btnCategoriaVendidas.setBounds(47, 146, 187, 29);
		contentPane.add(btnCategoriaVendidas);
		
		
		JButton btnTopProductos = new JButton("Top de Productos");
		btnTopProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTopProductos.setBounds(248, 91, 143, 29);
		contentPane.add(btnTopProductos);
		
		
		JButton btnSalir = new JButton("<- Salir");
		btnSalir.setBounds(274, 146, 117, 29);
		contentPane.add(btnSalir);

	}

}
