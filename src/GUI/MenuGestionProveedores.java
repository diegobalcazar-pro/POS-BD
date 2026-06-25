package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BLL.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

public class MenuGestionProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private Usuario usuarioLogueado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionProveedores frame = new MenuGestionProveedores(null);
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
	public MenuGestionProveedores(Usuario logueado) {
		
		this.usuarioLogueado = logueado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel nav = new JPanel();
		nav.setBounds(0, 76, 190, 437);
		nav.setBackground(new Color(90, 0, 0));
		contentPane.add(nav);
		nav.setLayout(null);
		
		JButton btnCrearProv = new JButton("Crear");
		btnCrearProv.setForeground(new Color(255, 255, 255));
		btnCrearProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearProv.setBackground(new Color(128, 0, 0));
		btnCrearProv.setBounds(10, 15, 170, 45);
		btnCrearProv.setContentAreaFilled(false);
		btnCrearProv.setOpaque(true);
		nav.add(btnCrearProv);
		
		JButton btnModiProv = new JButton("Modificar");
		btnModiProv.setForeground(new Color(255, 255, 255));
		btnModiProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModiProv.setBackground(new Color(128, 0, 0));
		btnModiProv.setBounds(10, 65, 170, 45);
		btnModiProv.setContentAreaFilled(false);
		btnModiProv.setOpaque(true);
		nav.add(btnModiProv);
		
		JButton btnElimProv = new JButton("Eliminar");
		btnElimProv.setForeground(new Color(255, 255, 255));
		btnElimProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimProv.setBackground(new Color(128, 0, 0));
		btnElimProv.setBounds(10, 115, 170, 45);
		btnElimProv.setContentAreaFilled(false);
		btnElimProv.setOpaque(true);
		nav.add(btnElimProv);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAtras.setBounds(10, 380, 170, 45);
		nav.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});
		
		JPanel header = new JPanel();
		header.setBounds(0, 1, 726, 75);
		header.setBackground(new Color(64, 0, 0));
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
		
		String nombreExhibido = (usuarioLogueado != null) ? usuarioLogueado.getNombre_usuario() : "Invitado";
		JLabel lblBienvenida = new JLabel("Gestión Proveedores - Repositor " + nombreExhibido);
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 315, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		table = new JTable();
		table.setBounds(200, 87, 516, 415);
		contentPane.add(table);

	}
}
