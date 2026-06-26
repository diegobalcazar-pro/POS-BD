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
import BLL.VarianteProducto;
import DLL.ControllerProducto;
import DLL.ControllerVarianteProducto;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarVariante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtTalle;
	private JTextField txtColor;
	private JTextField txtPrecio;

	private JButton btnConf;
	private JButton btnCancelar;

	private JComboBox<String> comboBoxProd;
	private DefaultComboBoxModel<String> modeloProd;

	private Usuario usuarioLogueado;
	private ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();
	private List<Producto> listaProductos;

	private int idVariante;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JOptionPane.showMessageDialog(null, "No se puede iniciar esta ventana sin sesión.", "Acceso Denegado",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ModificarVariante() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titulo = DefaultComponentFactory.getInstance().createTitle("Modificar Variante");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titulo.setBounds(160, 20, 200, 30);
		contentPane.add(titulo);

		JLabel lblProd = new JLabel("Producto:");
		lblProd.setBounds(40, 70, 100, 14);
		contentPane.add(lblProd);

		modeloProd = new DefaultComboBoxModel<>();
		comboBoxProd = new JComboBox<>(modeloProd);
		comboBoxProd.setBounds(40, 90, 180, 25);
		contentPane.add(comboBoxProd);

		JLabel lblTalle = new JLabel("Talle:");
		lblTalle.setBounds(40, 125, 100, 14);
		contentPane.add(lblTalle);

		txtTalle = new JTextField();
		txtTalle.setBounds(40, 145, 180, 25);
		contentPane.add(txtTalle);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(40, 180, 100, 14);
		contentPane.add(lblColor);

		txtColor = new JTextField();
		txtColor.setBounds(40, 200, 180, 25);
		contentPane.add(txtColor);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(260, 70, 100, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(260, 90, 180, 25);
		contentPane.add(txtPrecio);

		btnConf = new JButton("Confirmar");
		btnConf.setBounds(110, 260, 110, 30);
		contentPane.add(btnConf);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(260, 260, 110, 30);
		contentPane.add(btnCancelar);
	}

	public ModificarVariante(Usuario logueado, int idVariante) {
		this();

		this.usuarioLogueado = logueado;
		this.idVariante = idVariante;

		cargarProductos();
		cargarDatos();

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indexProd = comboBoxProd.getSelectedIndex();
				String talle = txtTalle.getText().trim();
				String color = txtColor.getText().trim();
				String precioStr = txtPrecio.getText().trim();

				if (indexProd < 0 || talle.isEmpty() || color.isEmpty() || precioStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Complete todos los campos", "Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					double precio = Double.parseDouble(precioStr);

					if (precio < 0) {
						JOptionPane.showMessageDialog(null, "El precio no puede ser negativo", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					Producto prod = listaProductos.get(indexProd);

					VarianteProducto v = new VarianteProducto(idVariante, talle, color, precio, prod);

					controllerVar.modificarVariante(v);

					JOptionPane.showMessageDialog(null, "Variante modificada correctamente");

					volver();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancelar.addActionListener(e -> volver());
	}

	private void cargarProductos() {
		modeloProd.removeAllElements();
		listaProductos = ControllerProducto.mostrarProductos();

		if (listaProductos != null) {
			for (Producto p : listaProductos) {
				modeloProd.addElement(p.getNombre_producto());
			}
		}
	}

	private void cargarDatos() {
		VarianteProducto v = controllerVar.buscarPorId(idVariante);

		if (v != null) {
			txtTalle.setText(v.getTalle());
			txtColor.setText(v.getColor());
			txtPrecio.setText(String.valueOf(v.getPrecio_venta()));

			for (int i = 0; i < listaProductos.size(); i++) {
				if (listaProductos.get(i).getid_producto() == v.getProducto().getid_producto()) {
					comboBoxProd.setSelectedIndex(i);
					break;
				}
			}
		}
	}

	private void volver() {
		MenuGestionProductos menu = new MenuGestionProductos(usuarioLogueado);
		menu.setVisible(true);
		dispose();
	}
}