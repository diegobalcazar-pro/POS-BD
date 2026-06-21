package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuGestionProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProd;
	private JTextField txtCategoria;
	private JTextField txtProductos;
	private JButton btnCrearProd;
	private JButton btnElimProd;
	private JButton btnEditProd;
	private JTextField txtVariantesProducto;
	private JButton btnCrearVarProd;
	private JButton btnElimVarProd;
	private JButton btnEditVarProd;
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
		
		txtCategoria = new JTextField();
		txtCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoria.setText("Categorias");
		txtCategoria.setBounds(62, 245, 96, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnEditCat = new JButton("Editar");
		btnEditCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditCat.setBounds(66, 340, 88, 22);
		contentPane.add(btnEditCat);
		
		JButton btnCrearCat = new JButton("Crear");
		btnCrearCat.setBounds(66, 276, 88, 22);
		contentPane.add(btnCrearCat);
		
		txtProductos = new JTextField();
		txtProductos.setText("Productos");
		txtProductos.setHorizontalAlignment(SwingConstants.CENTER);
		txtProductos.setColumns(10);
		txtProductos.setBounds(179, 245, 96, 20);
		contentPane.add(txtProductos);
		
		btnCrearProd = new JButton("Crear");
		btnCrearProd.setBounds(183, 276, 88, 22);
		contentPane.add(btnCrearProd);
		
		btnElimProd = new JButton("Eliminar");
		btnElimProd.setBounds(183, 308, 88, 22);
		contentPane.add(btnElimProd);
		
		btnEditProd = new JButton("Editar");
		btnEditProd.setBounds(183, 340, 88, 22);
		contentPane.add(btnEditProd);
		
		txtVariantesProducto = new JTextField();
		txtVariantesProducto.setText("Variantes Producto");
		txtVariantesProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtVariantesProducto.setColumns(10);
		txtVariantesProducto.setBounds(293, 245, 104, 20);
		contentPane.add(txtVariantesProducto);
		
		btnCrearVarProd = new JButton("Crear");
		btnCrearVarProd.setBounds(301, 276, 88, 22);
		contentPane.add(btnCrearVarProd);
		
		btnElimVarProd = new JButton("Eliminar");
		btnElimVarProd.setBounds(301, 308, 88, 22);
		contentPane.add(btnElimVarProd);
		
		btnEditVarProd = new JButton("Editar");
		btnEditVarProd.setBounds(301, 340, 88, 22);
		contentPane.add(btnEditVarProd);
		
		btnMoverProd = new JButton("Mover Producto");
		btnMoverProd.setBounds(408, 308, 115, 22);
		contentPane.add(btnMoverProd);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(418, 340, 88, 22);
		contentPane.add(btnAtras);

	}
}
