package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import BLL.Usuario;

public class MenuGestionProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProd;
	private JButton btnCrearProd;
	private JButton btnElimProd;
	private JButton btnModiProd;
	private JButton btnCrearVarProd;
	private JButton btnElimVarProd;
	private JButton btnModiVarProd;
	private JButton btnMoverProd;
	private JButton btnAtras;
	
	private Usuario usuarioLogueado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionProductos frame = new MenuGestionProductos(null);
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
	public MenuGestionProductos(Usuario logueado) {
		
		this.usuarioLogueado = logueado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

		JLabel lblBienvenida = new JLabel("Gestión Proveedores - Repositor " + usuarioLogueado.getNombre_usuario());
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 315, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel nav = new JPanel();
		nav.setBounds(0, 76, 190, 437);
		nav.setBackground(new Color(90, 0, 0));
		contentPane.add(nav);
		nav.setLayout(null);
		
		JButton btnCrearCat = new JButton("Crear");
		btnCrearCat.setForeground(new Color(255, 255, 255));
		btnCrearCat.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearCat.setBackground(new Color(128, 0, 0));
		btnCrearCat.setBounds(51, 36, 88, 22);
		btnCrearCat.setContentAreaFilled(false);
		btnCrearCat.setOpaque(true);
		nav.add(btnCrearCat);
		
		btnElimVarProd = new JButton("Eliminar");
		btnElimVarProd.setForeground(new Color(255, 255, 255));
		btnElimVarProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimVarProd.setBackground(new Color(128, 0, 0));
		btnElimVarProd.setBounds(51, 306, 88, 22);
		btnElimVarProd.setContentAreaFilled(false);
		btnElimVarProd.setOpaque(true);
		nav.add(btnElimVarProd);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Categorias");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel.setBounds(47, 11, 96, 14);
		nav.add(lblNewJgoodiesLabel);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnElimCat = new JButton("Eliminar");
		btnElimCat.setBackground(new Color(128, 0, 0));
		btnElimCat.setForeground(new Color(255, 255, 255));
		btnElimCat.setBounds(51, 68, 88, 22);
		nav.add(btnElimCat);
		
		JButton btnModiCat = new JButton("Modificar");
		btnModiCat.setBackground(new Color(128, 0, 0));
		btnModiCat.setForeground(new Color(255, 255, 255));
		btnModiCat.setBounds(51, 100, 88, 22);
		nav.add(btnModiCat);
		
		btnElimProd = new JButton("Eliminar");
		btnElimProd.setBackground(new Color(128, 0, 0));
		btnElimProd.setForeground(new Color(255, 255, 255));
		btnElimProd.setBounds(51, 190, 88, 22);
		nav.add(btnElimProd);
		
		btnCrearProd = new JButton("Crear");
		btnCrearProd.setBackground(new Color(128, 0, 0));
		btnCrearProd.setForeground(new Color(255, 255, 255));
		btnCrearProd.setBounds(51, 158, 88, 22);
		nav.add(btnCrearProd);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Productos");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel_1.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_1.setBounds(47, 133, 96, 14);
		nav.add(lblNewJgoodiesLabel_1);
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnModiProd = new JButton("Modificar");
		btnModiProd.setBackground(new Color(128, 0, 0));
		btnModiProd.setForeground(new Color(255, 255, 255));
		btnModiProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModiProd.setBounds(51, 222, 88, 22);
		nav.add(btnModiProd);
		
		btnModiVarProd = new JButton("Modificar");
		btnModiVarProd.setBackground(new Color(128, 0, 0));
		btnModiVarProd.setForeground(new Color(255, 255, 255));
		btnModiVarProd.setBounds(51, 338, 88, 22);
		nav.add(btnModiVarProd);
		
		btnMoverProd = new JButton("Mover Producto");
		btnMoverProd.setBackground(new Color(128, 0, 0));
		btnMoverProd.setForeground(new Color(255, 255, 255));
		btnMoverProd.setBounds(29, 371, 133, 22);
		nav.add(btnMoverProd);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(38, 404, 115, 22);
		nav.add(btnAtras);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Variantes");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel_2.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_2.setBounds(47, 255, 96, 14);
		nav.add(lblNewJgoodiesLabel_2);
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnCrearVarProd = new JButton("Crear");
		btnCrearVarProd.setBackground(new Color(128, 0, 0));
		btnCrearVarProd.setForeground(new Color(255, 255, 255));
		btnCrearVarProd.setBounds(51, 277, 88, 22);
		nav.add(btnCrearVarProd);
		btnCrearVarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVariante ventanaProductos = new CrearVariante();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		
		tablaProd = new JTable();
		tablaProd.setBounds(200, 87, 514, 413);
		contentPane.add(tablaProd);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});
		btnCrearProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventanaProductos = new CrearProducto();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		btnModiCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCategoria ventanaProductos = new CrearCategoria();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});

	}
}
