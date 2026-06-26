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

import BLL.Categoria;
import BLL.Producto;
import BLL.Proveedor;
import BLL.Usuario;
import DLL.ControllerCategoria;
import DLL.ControllerProducto;
import DLL.ControllerProveedor;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomProd;
	private JTextField txtDescProd;
	private JComboBox<String> comboBoxCat;
	private JComboBox<String> comboBoxProv;
	private DefaultComboBoxModel<String> modeloCat;
	private DefaultComboBoxModel<String> modeloProv;

	private Usuario usuarioLogueado;
	private ControllerProducto controllerProducto = new ControllerProducto();
	private ControllerCategoria controllerCategoria = new ControllerCategoria();
	private ControllerProveedor controllerProveedor = new ControllerProveedor();

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
	public CrearProducto(Usuario logueado) {
		if (logueado == null) {
			this.dispose();
			return;
		}
		this.usuarioLogueado = logueado;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear producto");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(197, 23, 164, 36);
		contentPane.add(lblNewJgoodiesTitle);

		txtNomProd = new JTextField();
		txtNomProd.setBounds(197, 106, 175, 20);
		contentPane.add(txtNomProd);
		txtNomProd.setColumns(10);

		txtDescProd = new JTextField();
		txtDescProd.setBounds(197, 162, 175, 20);
		contentPane.add(txtDescProd);
		txtDescProd.setColumns(10);

		modeloCat = new DefaultComboBoxModel<>();
		comboBoxCat = new JComboBox<>(modeloCat);
		comboBoxCat.setBounds(197, 216, 175, 22);
		contentPane.add(comboBoxCat);

		modeloProv = new DefaultComboBoxModel<>();
		comboBoxProv = new JComboBox<>(modeloProv);
		comboBoxProv.setBounds(197, 272, 175, 22);
		contentPane.add(comboBoxProv);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNewJgoodiesLabel.setBounds(197, 81, 92, 14);
		contentPane.add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Descripción:");
		lblNewJgoodiesLabel_1.setBounds(197, 137, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_1);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Categorías:");
		lblNewJgoodiesLabel_2.setBounds(197, 191, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);

		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Proveedores:");
		lblNewJgoodiesLabel_3.setBounds(197, 249, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_3);

		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 100, 30);
		contentPane.add(btnConf);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(330, 322, 100, 30);
		contentPane.add(btnCancelar);

		cargarCategorias();
		cargarProveedores();

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNomProd.getText().trim();
				String descripcion = txtDescProd.getText().trim();
				int indexCat = comboBoxCat.getSelectedIndex();
				int indexProv = comboBoxProv.getSelectedIndex();

				if (nombre.isEmpty() || descripcion.isEmpty() || indexCat <= 0 || indexProv <= 0) {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos antes de continuar.",
							"Campos Incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					Categoria catSeleccionada = listaCategorias.get(indexCat - 1);
					Proveedor provSeleccionado = listaProveedores.get(indexProv - 1);

					Producto nuevoProducto = new Producto(0, nombre, descripcion, catSeleccionada, provSeleccionado);
					controllerProducto.agregarProducto(nuevoProducto);

					JOptionPane.showMessageDialog(null, "Producto '" + nombre + "' creado con éxito.");
					volverAlMenu();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al guardar el producto.", "Error",
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