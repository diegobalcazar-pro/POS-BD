package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MenuPrincipalRepositor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalRepositor frame = new MenuPrincipalRepositor();
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
	public MenuPrincipalRepositor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botonGstProd = new JButton("Gestión Productos");
		botonGstProd.setBounds(150, 183, 133, 23);
		contentPane.add(botonGstProd);

		JButton botonGstPed = new JButton("Gestión Pedidos");
		botonGstPed.setBounds(293, 183, 133, 23);
		contentPane.add(botonGstPed);

		JButton botonGstStock = new JButton("Gestión Stock");
		botonGstStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonGstStock.setBounds(150, 217, 133, 23);
		contentPane.add(botonGstStock);

		JButton botonCerrarSes = new JButton("Cerrar sesión");
		botonCerrarSes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrarSes.setBounds(221, 251, 133, 22);
		contentPane.add(botonCerrarSes);

		JButton botonGstProv = new JButton("Gestión Proveedores");
		botonGstProv.setBounds(293, 216, 133, 23);
		contentPane.add(botonGstProv);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("¡Bienvenido, Repositor [nombre]!");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesLabel.setBounds(99, 104, 360, 52);
		contentPane.add(lblNewJgoodiesLabel);

	}
}
