package GUI;

import java.awt.EventQueue;

import BLL.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MenuRepositor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRepositor frame = new MenuRepositor(null);
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
	public MenuRepositor(Usuario logueado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botonGstProd = new JButton("Gestión Productos");
		botonGstProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionProductos ventanaProductos = new MenuGestionProductos();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		botonGstProd.setBounds(112, 183, 162, 23);
		contentPane.add(botonGstProd);

		JButton botonGstPed = new JButton("Gestión Pedidos");
		botonGstPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionPedidos ventanaProductos = new MenuGestionPedidos();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		botonGstPed.setBounds(282, 183, 162, 23);
		contentPane.add(botonGstPed);

		JButton botonGstStock = new JButton("Gestión Stock");
		botonGstStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionStock ventanaProductos = new MenuGestionStock();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		botonGstStock.setBounds(112, 217, 162, 23);
		contentPane.add(botonGstStock);

		JButton botonCerrarSes = new JButton("Cerrar sesión");
		botonCerrarSes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ventanaProductos = new Login();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		botonCerrarSes.setBounds(205, 251, 147, 22);
		contentPane.add(botonCerrarSes);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("¡Bienvenido, Repositor [nombre]!");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesLabel.setBounds(99, 104, 360, 52);
		contentPane.add(lblNewJgoodiesLabel);
		
		JButton botonGstProv = new JButton("Gestión Proveedores");
		botonGstProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionProveedores ventanaProductos = new MenuGestionProveedores();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		botonGstProv.setBounds(282, 217, 162, 23);
		contentPane.add(botonGstProv);

	}
}
