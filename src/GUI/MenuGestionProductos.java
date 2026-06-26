package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import BLL.Usuario;
import DLL.ControllerVarianteProducto;

public class MenuGestionProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProd;
	private DefaultTableModel modeloTabla;
	private JButton btnCrearProd;
	private JButton btnElimProd;
	private JButton btnModiProd;
	private JButton btnCrearVarProd;
	private JButton btnElimVarProd;
	private JButton btnModiVarProd;
	private JButton btnMoverProd;
	private JButton btnAtras;

	private Usuario usuarioLogueado;
	private ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();

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

	public MenuGestionProductos(Usuario logueado) {

		this.usuarioLogueado = logueado;

		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\logo3.png"));
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
		ImageIcon imagenOriginal = new ImageIcon("src\\img\\logo.png");
		Image imgEscalada = imagenOriginal.getImage().getScaledInstance(95, 75, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(imgEscalada));

		JLabel lblLogo1 = new JLabel("");
		lblLogo1.setBounds(10, 0, 169, 76);
		header.add(lblLogo1);
		lblLogo1.setBackground(new Color(0, 0, 0));
		lblLogo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo1.setIcon(new ImageIcon("src\\img\\logo1.png"));
		lblLogo1.setBackground(new Color(0, 0, 0));

		JLabel lblBienvenida = new JLabel("Gestión de Productos - Repositor "
				+ (usuarioLogueado != null ? usuarioLogueado.getNombre_usuario() : ""));
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 350, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel nav = new JPanel();
		nav.setBounds(0, 76, 190, 437);
		nav.setBackground(new Color(90, 0, 0));
		contentPane.add(nav);
		nav.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Categorías");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel.setBounds(47, 11, 96, 14);
		nav.add(lblNewJgoodiesLabel);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCrearCat = new JButton("Crear");
		btnCrearCat.setForeground(new Color(255, 255, 255));
		btnCrearCat.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearCat.setBackground(new Color(128, 0, 0));
		btnCrearCat.setBounds(51, 36, 88, 22);
		btnCrearCat.setContentAreaFilled(false);
		btnCrearCat.setOpaque(true);
		nav.add(btnCrearCat);

		JButton btnElimCat = new JButton("Eliminar");
		btnElimCat.setForeground(new Color(255, 255, 255));
		btnElimCat.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimCat.setBackground(new Color(128, 0, 0));
		btnElimCat.setBounds(51, 68, 88, 22);
		btnElimCat.setContentAreaFilled(false);
		btnElimCat.setOpaque(true);
		nav.add(btnElimCat);

		JButton btnModiCat = new JButton("Modificar");
		btnModiCat.setForeground(new Color(255, 255, 255));
		btnModiCat.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModiCat.setBackground(new Color(128, 0, 0));
		btnModiCat.setBounds(49, 100, 96, 22);
		btnModiCat.setContentAreaFilled(false);
		btnModiCat.setOpaque(true);
		nav.add(btnModiCat);

		// SECCION: Productos
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Productos");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesLabel_1.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_1.setBounds(47, 133, 96, 14);
		nav.add(lblNewJgoodiesLabel_1);
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		btnCrearProd = new JButton("Crear");
		btnCrearProd.setForeground(new Color(255, 255, 255));
		btnCrearProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearProd.setBackground(new Color(128, 0, 0));
		btnCrearProd.setBounds(51, 158, 88, 22);
		btnCrearProd.setContentAreaFilled(false);
		btnCrearProd.setOpaque(true);
		nav.add(btnCrearProd);

		btnElimProd = new JButton("Eliminar");
		btnElimProd.setForeground(new Color(255, 255, 255));
		btnElimProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimProd.setBackground(new Color(128, 0, 0));
		btnElimProd.setBounds(51, 190, 88, 22);
		btnElimProd.setContentAreaFilled(false);
		btnElimProd.setOpaque(true);
		nav.add(btnElimProd);

		btnModiProd = new JButton("Modificar");
		btnModiProd.setForeground(new Color(255, 255, 255));
		btnModiProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModiProd.setBackground(new Color(128, 0, 0));
		btnModiProd.setContentAreaFilled(false);
		btnModiProd.setOpaque(true);
		btnModiProd.setBounds(49, 222, 96, 22);
		nav.add(btnModiProd);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Variantes");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesLabel_2.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_2.setBounds(47, 255, 96, 14);
		nav.add(lblNewJgoodiesLabel_2);
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		btnCrearVarProd = new JButton("Crear");
		btnCrearVarProd.setForeground(new Color(255, 255, 255));
		btnCrearVarProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearVarProd.setBackground(new Color(128, 0, 0));
		btnCrearVarProd.setBounds(51, 277, 88, 22);
		btnCrearVarProd.setContentAreaFilled(false);
		btnCrearVarProd.setOpaque(true);
		nav.add(btnCrearVarProd);

		btnElimVarProd = new JButton("Eliminar");
		btnElimVarProd.setForeground(new Color(255, 255, 255));
		btnElimVarProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimVarProd.setBackground(new Color(128, 0, 0));
		btnElimVarProd.setBounds(51, 306, 88, 22);
		btnElimVarProd.setContentAreaFilled(false);
		btnElimVarProd.setOpaque(true);
		nav.add(btnElimVarProd);

		btnModiVarProd = new JButton("Modificar");
		btnModiVarProd.setForeground(new Color(255, 255, 255));
		btnModiVarProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModiVarProd.setBackground(new Color(128, 0, 0));
		btnModiVarProd.setBounds(47, 338, 96, 22);
		btnModiVarProd.setContentAreaFilled(false);
		btnModiVarProd.setOpaque(true);
		nav.add(btnModiVarProd);

		btnMoverProd = new JButton("Mover Producto");
		btnMoverProd.setForeground(new Color(255, 255, 255));
		btnMoverProd.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnMoverProd.setBackground(new Color(128, 0, 0));
		btnMoverProd.setBounds(24, 371, 142, 22);
		btnMoverProd.setContentAreaFilled(false);
		btnMoverProd.setOpaque(true);
		nav.add(btnMoverProd);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(38, 404, 115, 22);
		nav.add(btnAtras);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 127, 516, 375);
		contentPane.add(scrollPane);

		tablaProd = new JTable();
		scrollPane.setViewportView(tablaProd);

		String[] columnas = { "ID", "Producto", "Talle", "Color", "Precio", "Ubicación" };
		modeloTabla = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaProd.setModel(modeloTabla);

		cargarVariantesEnTabla();

		btnCrearVarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVariante ventanaVar = new CrearVariante(usuarioLogueado);
				ventanaVar.setVisible(true);
				dispose();
			}
		});

		btnElimVarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaProd.getSelectedRow();
				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una variante de la tabla para eliminar.",
							"Atención", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int idVariante = (int) tablaProd.getValueAt(filaSeleccionada, 0);
				String producto = (String) tablaProd.getValueAt(filaSeleccionada, 1);
				String talle = (String) tablaProd.getValueAt(filaSeleccionada, 2);
				String color = (String) tablaProd.getValueAt(filaSeleccionada, 3);

				int confirm = JOptionPane.showConfirmDialog(null,
						"¿Está seguro de eliminar definitivamente la variante de '" + producto + "' (Talle: " + talle
								+ ", Color: " + color + ")?",
						"Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (confirm == JOptionPane.YES_OPTION) {
					try {
						controllerVar.eliminarVariante(idVariante);
						JOptionPane.showMessageDialog(null, "Variante eliminada con éxito.", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						cargarVariantesEnTabla();
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error al intentar eliminar la variante.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btnModiVarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaProd.getSelectedRow();
				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null,
							"Por favor, seleccione una variante de la tabla para modificar.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int idVariante = (int) tablaProd.getValueAt(filaSeleccionada, 0);

				ModificarVariante ventanaModiVar = new ModificarVariante(usuarioLogueado, idVariante);
				ventanaModiVar.setVisible(true);
				dispose();
			}
		});

		btnMoverProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaProd.getSelectedRow();
				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null,
							"Por favor, seleccione una variante de la tabla para mover de ubicación.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int idVariante = (int) tablaProd.getValueAt(filaSeleccionada, 0);
				String producto = (String) tablaProd.getValueAt(filaSeleccionada, 1);

				List<BLL.Deposito> depositos = controllerVar.obtenerDepositos();
				if (depositos == null || depositos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay depósitos de almacenamiento registrados en el sistema.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JComboBox<String> comboDepositos = new JComboBox<>();
				for (BLL.Deposito dep : depositos) {
					comboDepositos.addItem(dep.getid_deposito() + " - " + dep.getLugarDeposito().toUpperCase());
				}

				int option = JOptionPane.showConfirmDialog(null, comboDepositos, "Mover Variante: " + producto,
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					int selectedIndex = comboDepositos.getSelectedIndex();
					if (selectedIndex != -1) {
						BLL.Deposito depSeleccionado = depositos.get(selectedIndex);
						int idNuevoDeposito = depSeleccionado.getid_deposito();

						int idUsuario = (usuarioLogueado != null) ? usuarioLogueado.getId_usuario() : 0;

						controllerVar.moverVariante(idVariante, idNuevoDeposito, idUsuario);
						JOptionPane.showMessageDialog(null, "La variante se ha trasladado correctamente a: "
								+ depSeleccionado.getLugarDeposito().toUpperCase());
						cargarVariantesEnTabla();
					}
				}
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});

		btnCrearProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventanaProductos = new CrearProducto(usuarioLogueado);
				ventanaProductos.setVisible(true);
				dispose();
			}
		});

		btnModiProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto ventanaModiProd = new ModificarProducto(usuarioLogueado);
				ventanaModiProd.setVisible(true);
				dispose();
			}
		});

		btnElimProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto ventanaElimProd = new EliminarProducto(usuarioLogueado);
				ventanaElimProd.setVisible(true);
				dispose();
			}
		});

		btnModiCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCategoria ventanaModiCat = new ModificarCategoria(usuarioLogueado);
				ventanaModiCat.setVisible(true);
				dispose();
			}
		});

		btnCrearCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCategoria ventanaCat = new CrearCategoria(usuarioLogueado);
				ventanaCat.setVisible(true);
				dispose();
			}
		});

		btnElimCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarCategoria ventanaElimCat = new EliminarCategoria(usuarioLogueado);
				ventanaElimCat.setVisible(true);
				dispose();
			}
		});
	}

	private void cargarVariantesEnTabla() {
		modeloTabla.setRowCount(0);

		List<Object[]> inventario = ControllerVarianteProducto.obtenerInventarioParaTabla();

		for (Object[] fila : inventario) {
			modeloTabla.addRow(fila);
		}
	}
}