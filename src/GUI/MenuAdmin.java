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
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public MenuAdmin(Usuario logueado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Intel I5\\Downloads\\92b80f55c7e3a2476cc2ff9481e357c3.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 375);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel5 = new JLabel("Bienvenido Admin: " + logueado.getNombre_usuario());
		lblNewLabel5.setForeground(new Color(255, 255, 255));
		lblNewLabel5.setBackground(new Color(255, 0, 255));
		lblNewLabel5.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblNewLabel5.setBounds(119, 30, 360, 29);
		contentPane.add(lblNewLabel5);
		
		//Gestión Usuarios BOTON LOGUEADO
		JButton btnGestionUsuarios = new JButton("Gestión de Usuarios");
		btnGestionUsuarios.setForeground(new Color(255, 255, 255));
		btnGestionUsuarios.setBackground(new Color(128, 128, 192));
		btnGestionUsuarios.setBounds(66, 128, 158, 29);
		contentPane.add(btnGestionUsuarios);
		btnGestionUsuarios.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		     PantallaGestionUsuarios nueva = new PantallaGestionUsuarios(logueado);
		     nueva.setVisible(true);
		     dispose();
			   }
		    });
		
		
		//Info de ventas
		JButton btnInfoVentas = new JButton("Info de ventas");
		btnInfoVentas.setForeground(new Color(255, 255, 255));
		btnInfoVentas.setBackground(new Color(128, 128, 192));
		btnInfoVentas.setBounds(66, 184, 158, 29);
		contentPane.add(btnInfoVentas);
		btnInfoVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PantallaInfoVentas nueva = new PantallaInfoVentas(logueado);
		     nueva.setVisible(true);
		     dispose();
			   }
		    });
		
		
		//Gestión Productos
		JButton btnGestionProductos = new JButton("Gestión de Productos");
		btnGestionProductos.setForeground(new Color(255, 255, 255));
		btnGestionProductos.setBackground(new Color(128, 128, 192));
		btnGestionProductos.setBounds(307, 128, 158, 29);
		contentPane.add(btnGestionProductos);
		btnGestionProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGestionProductos nueva = new PantallaGestionProductos(logueado);
			     nueva.setVisible(true);
			     dispose();
				   }
			    });
		
		
		//Configuración
		JButton btnGestionDescuentos = new JButton("Gestión de Descuentos");
		btnGestionDescuentos.setForeground(new Color(255, 255, 255));
		btnGestionDescuentos.setBackground(new Color(128, 128, 192));
		btnGestionDescuentos.setBounds(297, 184, 168, 29);
		contentPane.add(btnGestionDescuentos);
		//MenuAdmin menu = this;
		btnGestionDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaConfiDescuentos nueva = new PantallaConfiDescuentos(logueado);
			     nueva.setVisible(true);
			     dispose();
				   }
			    });
		
		
		//Salir
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(160, 82, 45));
		btnCerrarSesion.setBounds(215, 280, 109, 23);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login salir = new Login();
		        salir.setVisible(true);
		        dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Menu Administrador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(160, 82, 45));
		lblNewLabel_1.setBounds(196, 82, 158, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("src\\img\\FondoAdmin.jpg"));
		lblNewLabel.setBounds(0, 0, 536, 336);
		contentPane.add(lblNewLabel);
		
		
		

	}

}
