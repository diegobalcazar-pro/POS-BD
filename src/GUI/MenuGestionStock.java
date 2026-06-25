package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import BLL.Usuario;
import BLL.VarianteProducto;
import DLL.ControllerVarianteProducto;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MenuGestionStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modeloTabla;
	private JTextField txtBuscar;

	private ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();
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
	public MenuGestionStock(Usuario logueado) {
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
		nav.setBounds(0, 76, 190, 437);
		nav.setBackground(new Color(90, 0, 0));
		contentPane.add(nav);
		nav.setLayout(null);

		JButton btnModificar = new JButton("Modificar Stock");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModificar.setBackground(new Color(128, 0, 0));
		btnModificar.setBounds(10, 15, 170, 45);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setOpaque(true);
		nav.add(btnModificar);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAtras.setBounds(10, 380, 170, 45);
		nav.add(btnAtras);

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

		JLabel lblBienvenida = new JLabel("Gestión Stock - Repositor " + usuarioLogueado.getNombre_usuario());
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 315, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblBuscar = new JLabel("Buscar Producto:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar.setBounds(200, 87, 110, 30);
		contentPane.add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBuscar.setBounds(315, 87, 401, 30);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cargarStockEnTabla();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 127, 516, 375);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnas = { "ID", "Producto", "Talle", "Color", "Precio", "Stock" };
		modeloTabla = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modeloTabla);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();

				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null,
							"Por favor, seleccione un producto de la tabla para modificar su stock.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int idVariante = (int) table.getValueAt(filaSeleccionada, 0);
				String producto = (String) table.getValueAt(filaSeleccionada, 1);
				String talle = (String) table.getValueAt(filaSeleccionada, 2);
				String color = (String) table.getValueAt(filaSeleccionada, 3);
				double precio = (double) table.getValueAt(filaSeleccionada, 4);
				int stockActual = (int) table.getValueAt(filaSeleccionada, 5);

				ModificarStock ventanaModificar = new ModificarStock(usuarioLogueado, idVariante, producto, talle,
						color, precio, stockActual);
				ventanaModificar.setVisible(true);

				dispose();
			}
		});

		cargarStockEnTabla();
	}

	private void cargarStockEnTabla() {
		modeloTabla.setRowCount(0);

		String filtro = (txtBuscar != null) ? txtBuscar.getText().trim().toLowerCase() : "";

		List<VarianteProducto> listaVariantes = controllerVar.obtenerVariantes();

		for (VarianteProducto v : listaVariantes) {
			String nombreProducto = v.getProducto().getNombre_producto();

			if (filtro.isEmpty() || nombreProducto.toLowerCase().contains(filtro)) {

				int stockActual = controllerVar.obtenerCantidadStock(v.getid_variante_producto());

				Object[] fila = { v.getid_variante_producto(), nombreProducto, v.getTalle(), v.getColor(),
						v.getPrecio_venta(), stockActual };
				modeloTabla.addRow(fila);
			}
		}
	}
}