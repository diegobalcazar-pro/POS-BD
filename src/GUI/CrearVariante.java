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
import BLL.Deposito;
import BLL.VarianteProducto;
import DLL.ControllerProducto;
import DLL.ControllerVarianteProducto;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearVariante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTalle;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtCantidad;

	private JComboBox<String> comboBoxProd;
	private JComboBox<String> comboBoxDeposito;
	private DefaultComboBoxModel<String> modeloProd;
	private DefaultComboBoxModel<String> modeloDeposito;

	private Usuario usuarioLogueado;
	private ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();
	private List<Producto> listaProductos;
	private List<Deposito> listaDepositos;

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
	public CrearVariante(Usuario logueado) {
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

		JLabel lblTitulo = DefaultComponentFactory.getInstance().createTitle("Crear Variante");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(204, 25, 180, 29);
		contentPane.add(lblTitulo);

		JLabel lblProducto = DefaultComponentFactory.getInstance().createLabel("Producto:");
		lblProducto.setBounds(100, 75, 150, 14);
		contentPane.add(lblProducto);

		modeloProd = new DefaultComboBoxModel<>();
		comboBoxProd = new JComboBox<>(modeloProd);
		comboBoxProd.setBounds(100, 95, 160, 25);
		contentPane.add(comboBoxProd);

		JLabel lblTalle = DefaultComponentFactory.getInstance().createLabel("Talle:");
		lblTalle.setBounds(100, 135, 150, 14);
		contentPane.add(lblTalle);

		txtTalle = new JTextField();
		txtTalle.setBounds(100, 155, 160, 25);
		contentPane.add(txtTalle);
		txtTalle.setColumns(10);

		JLabel lblColor = DefaultComponentFactory.getInstance().createLabel("Color:");
		lblColor.setBounds(100, 195, 150, 14);
		contentPane.add(lblColor);

		txtColor = new JTextField();
		txtColor.setBounds(100, 215, 160, 25);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setBounds(300, 75, 150, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(300, 95, 160, 25);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblCantidad = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
		lblCantidad.setBounds(300, 135, 150, 14);
		contentPane.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(300, 155, 160, 25);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblDeposito = DefaultComponentFactory.getInstance().createLabel("Depósito:");
		lblDeposito.setBounds(300, 195, 150, 14);
		contentPane.add(lblDeposito);

		modeloDeposito = new DefaultComboBoxModel<>();
		comboBoxDeposito = new JComboBox<>(modeloDeposito);
		comboBoxDeposito.setBounds(300, 215, 160, 25);
		contentPane.add(comboBoxDeposito);

		JButton btnConf = new JButton("Confirmar");
		btnConf.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConf.setBounds(127, 300, 110, 30);
		contentPane.add(btnConf);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(330, 300, 110, 30);
		contentPane.add(btnCancelar);

		cargarProductos();
		cargarDepositos();

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexProd = comboBoxProd.getSelectedIndex();
				int indexDep = comboBoxDeposito.getSelectedIndex();
				String talle = txtTalle.getText().trim();
				String color = txtColor.getText().trim();
				String precioStr = txtPrecio.getText().trim();
				String cantidadStr = txtCantidad.getText().trim();

				if (indexProd <= 0 || indexDep <= 0 || talle.isEmpty() || color.isEmpty() || precioStr.isEmpty()
						|| cantidadStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos requeridos.",
							"Campos vacíos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					double precio = Double.parseDouble(precioStr);
					int cantidad = Integer.parseInt(cantidadStr);

					if (precio < 0 || cantidad < 0) {
						JOptionPane.showMessageDialog(null, "El precio y la cantidad no pueden ser valores negativos.",
								"Valores inválidos", JOptionPane.ERROR_MESSAGE);
						return;
					}

					Producto prodSeleccionado = listaProductos.get(indexProd - 1);
					Deposito depSeleccionado = listaDepositos.get(indexDep - 1);

					VarianteProducto nuevaVariante = new VarianteProducto(0, talle, color, precio, prodSeleccionado);

					controllerVar.agregarVarianteConStock(nuevaVariante, cantidad, depSeleccionado.getid_deposito());

					JOptionPane.showMessageDialog(null, "Variante y stock registrados con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					volverAlMenu();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Asegúrese de ingresar un precio numérico válido y una cantidad entera.",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al procesar el guardado de la variante.", "Error",
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
		modeloProd.removeAllElements();
		modeloProd.addElement("-- Seleccionar Producto --");
		listaProductos = ControllerProducto.mostrarProductos();
		if (listaProductos != null) {
			for (Producto p : listaProductos) {
				modeloProd.addElement(p.getNombre_producto());
			}
		}
	}

	private void cargarDepositos() {
		modeloDeposito.removeAllElements();
		modeloDeposito.addElement("-- Seleccionar Depósito --");
		listaDepositos = controllerVar.obtenerDepositos();
		if (listaDepositos != null) {
			for (Deposito d : listaDepositos) {
				modeloDeposito.addElement(d.getLugarDeposito().toUpperCase());
			}
		}
	}

	private void volverAlMenu() {
		MenuGestionProductos menu = new MenuGestionProductos(usuarioLogueado);
		menu.setVisible(true);
		dispose();
	}
}