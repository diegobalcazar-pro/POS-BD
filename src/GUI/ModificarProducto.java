package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;
import BLL.Producto;
import BLL.Categoria;
import BLL.Proveedor;
import DLL.ControllerProducto;
import DLL.ControllerCategoria;
import DLL.ControllerProveedor;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomProd;
	private JTextField txtDescProd;

	private JComboBox<String> comboElegirProducto;
	private JComboBox<String> comboBoxCat;
	private JComboBox<String> comboBoxProv;

	private DefaultComboBoxModel<String> modeloElegirProd;
	private DefaultComboBoxModel<String> modeloCat;
	private DefaultComboBoxModel<String> modeloProv;

	private Usuario usuarioLogueado;
	private ControllerProducto controllerProducto = new ControllerProducto();
	private ControllerCategoria controllerCategoria = new ControllerCategoria();
	private ControllerProveedor controllerProveedor = new ControllerProveedor();

	private List<Producto> listaProductos;
	private List<Categoria> listaCategorias;
	private List<Proveedor> listaProveedores;

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
	public ModificarProducto(Usuario logueado) {
		if (logueado == null) {
			JOptionPane.showMessageDialog(null, "Acceso Denegado: Debe iniciar sesión para acceder a este formulario.",
					"Error de Seguridad", JOptionPane.ERROR_MESSAGE);
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
			return;
		}

		this.usuarioLogueado = logueado;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = DefaultComponentFactory.getInstance().createTitle("Modificar producto");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(180, 15, 230, 29);
		contentPane.add(lblTitle);

		JLabel lblSeleccionar = DefaultComponentFactory.getInstance().createLabel("Seleccionar producto a modificar:");
		lblSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionar.setBounds(110, 55, 350, 20);
		contentPane.add(lblSeleccionar);

		modeloElegirProd = new DefaultComboBoxModel<>();
		comboElegirProducto = new JComboBox<>(modeloElegirProd);
		comboElegirProducto.setBounds(110, 80, 350, 25);
		contentPane.add(comboElegirProducto);

		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNombre.setBounds(110, 115, 350, 14);
		contentPane.add(lblNombre);

		txtNomProd = new JTextField();
		txtNomProd.setBounds(110, 135, 350, 25);
		contentPane.add(txtNomProd);
		txtNomProd.setColumns(10);

		JLabel lblDescripcion = DefaultComponentFactory.getInstance().createLabel("Descripción:");
		lblDescripcion.setBounds(110, 170, 350, 14);
		contentPane.add(lblDescripcion);

		txtDescProd = new JTextField();
		txtDescProd.setBounds(110, 190, 350, 25);
		contentPane.add(txtDescProd);
		txtDescProd.setColumns(10);

		JLabel lblCategorias = DefaultComponentFactory.getInstance().createLabel("Categoría:");
		lblCategorias.setBounds(110, 225, 350, 14);
		contentPane.add(lblCategorias);

		modeloCat = new DefaultComboBoxModel<>();
		comboBoxCat = new JComboBox<>(modeloCat);
		comboBoxCat.setBounds(110, 245, 350, 25);
		contentPane.add(comboBoxCat);

		JLabel lblProveedores = DefaultComponentFactory.getInstance().createLabel("Proveedor:");
		lblProveedores.setBounds(110, 280, 350, 14);
		contentPane.add(lblProveedores);

		modeloProv = new DefaultComboBoxModel<>();
		comboBoxProv = new JComboBox<>(modeloProv);
		comboBoxProv.setBounds(110, 300, 350, 25);
		contentPane.add(comboBoxProv);

		JButton btnConf = new JButton("Confirmar");
		btnConf.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConf.setBounds(127, 360, 110, 35);
		contentPane.add(btnConf);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(330, 360, 110, 35);
		contentPane.add(btnCancelar);

		cargarProductos();
		cargarCategorias();
		cargarProveedores();

		comboElegirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = comboElegirProducto.getSelectedIndex();
				if (selectedIndex > 0) {
					Producto prod = listaProductos.get(selectedIndex - 1);
					txtNomProd.setText(prod.getNombre_producto());
					txtDescProd.setText(prod.getDescripcion_producto());

					comboBoxCat.setSelectedItem(prod.getCategoria().getNombre_categoria());
					comboBoxProv.setSelectedItem(prod.getProveedor().getNombreEmpresa());
				} else {
					txtNomProd.setText("");
					txtDescProd.setText("");
					comboBoxCat.setSelectedIndex(0);
					comboBoxProv.setSelectedIndex(0);
				}
			}
		});

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedProductIndex = comboElegirProducto.getSelectedIndex();

				if (selectedProductIndex <= 0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para modificar.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				String nombre = txtNomProd.getText().trim();
				String descripcion = txtDescProd.getText().trim();
				int indexCat = comboBoxCat.getSelectedIndex();
				int indexProv = comboBoxProv.getSelectedIndex();

				if (nombre.isEmpty() || descripcion.isEmpty() || indexCat <= 0 || indexProv <= 0) {
					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos requeridos.",
							"Campos vacíos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					Producto productoOriginal = listaProductos.get(selectedProductIndex - 1);
					Categoria catSeleccionada = listaCategorias.get(indexCat - 1);
					Proveedor provSeleccionado = listaProveedores.get(indexProv - 1);

					Producto productoModificado = new Producto(productoOriginal.getid_producto(), nombre, descripcion,
							catSeleccionada, provSeleccionado);
					controllerProducto.modificarProducto(productoModificado);

					JOptionPane.showMessageDialog(null, "Producto modificado con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					volverAlMenu();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al guardar las modificaciones del producto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAlMenu();
			}
		});
	}

	private void cargarProductos() {
		modeloElegirProd.removeAllElements();
		modeloElegirProd.addElement("-- Seleccionar Producto --");
		listaProductos = controllerProducto.obtenerProductos();
		if (listaProductos != null) {
			for (Producto p : listaProductos) {
				modeloElegirProd.addElement(p.getNombre_producto());
			}
		}
	}

	private void cargarCategorias() {
		modeloCat.removeAllElements();
		modeloCat.addElement("-- Seleccionar Categoría --");
		listaCategorias = controllerCategoria.obtenerCategorias();
		if (listaCategorias != null) {
			for (Categoria c : listaCategorias) {
				modeloCat.addElement(c.getNombre_categoria());
			}
		}
	}

	private void cargarProveedores() {
		modeloProv.removeAllElements();
		modeloProv.addElement("-- Seleccionar Proveedor --");
		listaProveedores = controllerProveedor.mostrarProveedores();
		if (listaProveedores != null) {
			for (Proveedor p : listaProveedores) {
				modeloProv.addElement(p.getNombreEmpresa());
			}
		}
	}

	private void volverAlMenu() {
		MenuGestionProductos menu = new MenuGestionProductos(usuarioLogueado);
		menu.setVisible(true);
		dispose();
	}
}