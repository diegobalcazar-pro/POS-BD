package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import BLL.Usuario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class MenuRepositor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Usuario usuarioLogueado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null,
							"No se puede iniciar esta ventana de manera independiente sin iniciar sesión.",
							"Acceso Denegado", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuRepositor(Usuario logueado) {
		if (logueado == null) {
			JOptionPane.showMessageDialog(null, "Acceso Denegado: Debe iniciar sesión para acceder a este menú.",
					"Error de Seguridad", JOptionPane.ERROR_MESSAGE);
			Login login = new Login();
			login.setVisible(true);

			this.dispose();
			return;
		}

		this.usuarioLogueado = logueado;

		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel nav = new JPanel();
		nav.setBackground(new Color(90, 0, 0));
		nav.setBounds(0, 76, 190, 437);
		contentPane.add(nav);
		nav.setLayout(null);

		JButton botonGstProd = new JButton("Gestión Productos");
		botonGstProd.setForeground(new Color(255, 255, 255));
		botonGstProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonGstProd.setBackground(new Color(128, 0, 0));
		botonGstProd.setBounds(10, 15, 170, 45);
		botonGstProd.setContentAreaFilled(false);
		botonGstProd.setOpaque(true);
		nav.add(botonGstProd);

		JButton botonGstStock = new JButton("Gestión Stock");
		botonGstStock.setBackground(new Color(128, 0, 0));
		botonGstStock.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonGstStock.setForeground(new Color(255, 255, 255));
		botonGstStock.setBounds(10, 115, 170, 45);
		botonGstStock.setContentAreaFilled(false);
		botonGstStock.setOpaque(true);
		nav.add(botonGstStock);

		JButton botonGstProv = new JButton("Gestión Proveedores");
		botonGstProv.setBackground(new Color(128, 0, 0));
		botonGstProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonGstProv.setForeground(new Color(255, 255, 255));
		botonGstProv.setBounds(10, 165, 170, 45);
		botonGstProv.setContentAreaFilled(false);
		botonGstProv.setOpaque(true);
		nav.add(botonGstProv);

		JButton botonCerrarSes = new JButton("Cerrar sesión");
		botonCerrarSes.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonCerrarSes.setBounds(10, 380, 170, 45);
		nav.add(botonCerrarSes);

		JButton botonGstPed = new JButton("Gestión Pedidos");
		botonGstPed.setBackground(new Color(128, 0, 0));
		botonGstPed.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonGstPed.setForeground(new Color(255, 255, 255));
		botonGstPed.setBounds(10, 65, 170, 45);
		botonGstPed.setContentAreaFilled(false);
		botonGstPed.setOpaque(true);
		nav.add(botonGstPed);

		botonGstPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionPedidos ventanaPedidos = new MenuGestionPedidos(usuarioLogueado);
				ventanaPedidos.setVisible(true);
				dispose();
			}
		});

		botonCerrarSes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ventanaLogin = new Login();
				ventanaLogin.setVisible(true);
				dispose();
			}
		});

		botonGstProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionProveedores ventanaProveedores = new MenuGestionProveedores(usuarioLogueado);
				ventanaProveedores.setVisible(true);
				dispose();
			}
		});

		botonGstStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionStock ventanaStock = new MenuGestionStock(usuarioLogueado);
				ventanaStock.setVisible(true);
				dispose();
			}
		});

		botonGstProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionProductos ventanaProductos = new MenuGestionProductos(usuarioLogueado);
				ventanaProductos.setVisible(true);
				dispose();
			}
		});

		JPanel header = new JPanel();
		header.setBackground(new Color(64, 0, 0));
		header.setBounds(0, 1, 726, 75);
		contentPane.add(header);
		header.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(621, 0, 95, 75);
		header.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagenOriginal = new ImageIcon("src\\\\img\\\\logo.png");
		Image imgEscalada = imagenOriginal.getImage().getScaledInstance(95, 75, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(imgEscalada));

		JLabel lblLogo1 = new JLabel("");
		lblLogo1.setBounds(10, 0, 169, 76);
		header.add(lblLogo1);
		lblLogo1.setBackground(new Color(0, 0, 0));
		lblLogo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo1.setIcon(new ImageIcon("src\\\\img\\\\logo1.png"));
		lblLogo1.setBackground(new Color(0, 0, 0));

		JLabel lblBienvenida = new JLabel("¡Bienvenido, Repositor " + usuarioLogueado.getNombre_usuario() + "!");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 256, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));

	}
}