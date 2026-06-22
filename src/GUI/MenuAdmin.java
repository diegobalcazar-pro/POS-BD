package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Admin;

public class MenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public MenuAdmin(Admin admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Admin:" + admin.getNombre_usuario());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblNewLabel.setBounds(90, 32, 310, 16);
		contentPane.add(lblNewLabel);
		
		//Gestión Usuarios
		JButton btnGestionUsuarios = new JButton("Gestión de Usuarios");
		btnGestionUsuarios.setBounds(48, 98, 158, 29);
		contentPane.add(btnGestionUsuarios);
		/*btnGestionUsuarios.addActionListener(e -> {
		   PantallaGestionUsuarios nueva = new PantallaGestionUsuarios();
		   nueva.setVisible(true);
		    dispose();
		});*/
		
		//Info de ventas
		JButton btnInfoVentas = new JButton("Info de ventas");
		btnInfoVentas.setBounds(58, 139, 133, 29);
		contentPane.add(btnInfoVentas);
		/*btnInfoVentas.addActionListener(e -> {
			PantallaInfoVentas nueva = new PantallaInfoVentas();
			   nueva.setVisible(true);
			   dispose();
			});*/
		
		//Gestión Productos
		JButton btnGestionProductos = new JButton("Gestión de Productos");
		btnGestionProductos.setBounds(242, 98, 158, 29);
		contentPane.add(btnGestionProductos);
		/*btnGestionProductos.addActionListener(e -> {
			   PantallaGestionProductos nueva = new PantallaGestionProductos();
			   nueva.setVisible(true);
			    dispose();
			});*/
		
		//Configuración
		JButton btnConfiguracion = new JButton("Configuración");
		btnConfiguracion.setBounds(252, 139, 137, 29);
		contentPane.add(btnConfiguracion);
		/*btnConfiguracion.addActionListener(e -> {
			   PantallaConfiguracion nueva = new PantallaConfiguracion();
			   nueva.setVisible(true);
			    dispose();
			});*/
		
		//Salir
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBounds(170, 191, 117, 29);
		contentPane.add(btnCerrarSesion);

	}

}
