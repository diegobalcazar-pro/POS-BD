package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionProductos frame = new MenuGestionProductos();
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
	public MenuGestionProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tablaProd = new JTable();
		tablaProd.setBounds(10, 11, 538, 216);
		contentPane.add(tablaProd);
		
		JButton btnElimCat = new JButton("Eliminar");
		btnElimCat.setBounds(66, 308, 88, 22);
		contentPane.add(btnElimCat);
		
		JButton btnModiCat = new JButton("Modificar");
		btnModiCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModiCat.setBounds(66, 340, 88, 22);
		contentPane.add(btnModiCat);
		
		JButton btnCrearCat = new JButton("Crear");
		btnCrearCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCategoria ventanaProductos = new CrearCategoria();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		btnCrearCat.setBounds(66, 276, 88, 22);
		contentPane.add(btnCrearCat);
		
		btnCrearProd = new JButton("Crear");
		btnCrearProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventanaProductos = new CrearProducto();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		btnCrearProd.setBounds(183, 276, 88, 22);
		contentPane.add(btnCrearProd);
		
		btnElimProd = new JButton("Eliminar");
		btnElimProd.setBounds(183, 308, 88, 22);
		contentPane.add(btnElimProd);
		
		btnModiProd = new JButton("Modificar");
		btnModiProd.setBounds(183, 340, 88, 22);
		contentPane.add(btnModiProd);
		
		btnCrearVarProd = new JButton("Crear");
		btnCrearVarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVariante ventanaProductos = new CrearVariante();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		btnCrearVarProd.setBounds(301, 276, 88, 22);
		contentPane.add(btnCrearVarProd);
		
		btnElimVarProd = new JButton("Eliminar");
		btnElimVarProd.setBounds(301, 308, 88, 22);
		contentPane.add(btnElimVarProd);
		
		btnModiVarProd = new JButton("Modificar");
		btnModiVarProd.setBounds(301, 340, 88, 22);
		contentPane.add(btnModiVarProd);
		
		btnMoverProd = new JButton("Mover Producto");
		btnMoverProd.setBounds(399, 308, 133, 22);
		contentPane.add(btnMoverProd);
		
		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalRepositor ventanaProductos = new MenuPrincipalRepositor();
		        ventanaProductos.setVisible(true);
		        dispose();
			}
		});
		btnAtras.setBounds(408, 340, 115, 22);
		contentPane.add(btnAtras);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Categorias");
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(62, 251, 96, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Productos");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setBounds(179, 251, 96, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Variantes");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_2.setBounds(297, 251, 96, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 238, 538, 124);
		contentPane.add(separator);

	}
}
