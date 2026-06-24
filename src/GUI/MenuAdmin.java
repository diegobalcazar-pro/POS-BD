package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BLL.Admin;
import BLL.Cajero;
import BLL.Repositor;
import BLL.Usuario;
import DLL.ControllerUsuario;

public class MenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public MenuAdmin(Usuario logueado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel5 = new JLabel("Bienvenido Admin: " + logueado.getNombre_usuario());
		lblNewLabel5.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblNewLabel5.setBounds(132, 42, 310, 16);
		contentPane.add(lblNewLabel5);
		
		//Gestión Usuarios
		JButton btnGestionUsuarios = new JButton("Gestión de Usuarios");
		btnGestionUsuarios.setBounds(48, 128, 158, 29);
		contentPane.add(btnGestionUsuarios);
		
		btnGestionUsuarios.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		     PantallaGestionUsuarios nueva = new PantallaGestionUsuarios();
		     nueva.setVisible(true);
		     dispose();
			   }
		    });
		
		
		//Info de ventas
		JButton btnInfoVentas = new JButton("Info de ventas");
		btnInfoVentas.setBounds(66, 184, 133, 29);
		contentPane.add(btnInfoVentas);
		btnInfoVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PantallaInfoVentas nueva = new PantallaInfoVentas();
		     nueva.setVisible(true);
		     dispose();
			   }
		    });
		
		
		//Gestión Productos
		JButton btnGestionProductos = new JButton("Gestión de Productos");
		btnGestionProductos.setBounds(284, 128, 158, 29);
		contentPane.add(btnGestionProductos);
		btnGestionProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGestionProductos nueva = new PantallaGestionProductos();
			     nueva.setVisible(true);
			     dispose();
				   }
			    });
		
		
		//Configuración
		JButton btnConfiguracion = new JButton("Configuración");
		btnConfiguracion.setBounds(292, 184, 137, 29);
		contentPane.add(btnConfiguracion);
		//MenuAdmin menu = this;
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaConfiguracion nueva = new PantallaConfiguracion();
			     nueva.setVisible(true);
			     dispose();
				   }
			    });
		
		
		//Salir
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBounds(193, 262, 117, 29);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login salir = new Login();
		        salir.setVisible(true);
		        dispose();
			}
		});
		

	}

}
