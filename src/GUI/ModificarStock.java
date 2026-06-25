package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;
import DLL.ControllerVarianteProducto;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtTalle;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnConf;
	private JButton btnCancelar;

	private ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();
	private Usuario usuarioLogueado;
	private int idVariante;

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

	public ModificarStock() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setTitle("Modificar Stock de Variante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 430);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Modificar Stock");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(150, 25, 260, 29);
		contentPane.add(lblNewJgoodiesTitle);

		JLabel lblProducto = DefaultComponentFactory.getInstance().createLabel("Producto (Lectura):");
		lblProducto.setBounds(227, 65, 140, 14);
		contentPane.add(lblProducto);

		JLabel lblTalle = DefaultComponentFactory.getInstance().createLabel("Talle (Lectura):");
		lblTalle.setBounds(227, 115, 140, 14);
		contentPane.add(lblTalle);

		JLabel lblColor = DefaultComponentFactory.getInstance().createLabel("Color (Lectura):");
		lblColor.setBounds(227, 165, 140, 14);
		contentPane.add(lblColor);

		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio Venta (Lectura):");
		lblPrecio.setBounds(227, 215, 140, 14);
		contentPane.add(lblPrecio);

		JLabel lblCantidad = DefaultComponentFactory.getInstance().createLabel("Nueva Cantidad de Stock:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(210, 265, 160, 14);
		contentPane.add(lblCantidad);

		Color colorBloqueado = new Color(240, 240, 240);

		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBackground(colorBloqueado);
		txtProducto.setBounds(192, 85, 173, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);

		txtTalle = new JTextField();
		txtTalle.setEditable(false);
		txtTalle.setBackground(colorBloqueado);
		txtTalle.setBounds(192, 135, 173, 20);
		contentPane.add(txtTalle);
		txtTalle.setColumns(10);

		txtColor = new JTextField();
		txtColor.setEditable(false);
		txtColor.setBackground(colorBloqueado);
		txtColor.setBounds(195, 185, 173, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBackground(colorBloqueado);
		txtPrecio.setBounds(195, 235, 173, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(195, 285, 173, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 335, 100, 30);
		contentPane.add(btnConf);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(330, 335, 100, 30);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionStock ventanaStock = new MenuGestionStock(usuarioLogueado);
				ventanaStock.setVisible(true);
				dispose();
			}
		});
	}

	public ModificarStock(Usuario logueado, int id, String producto, String talle, String color, double precio,
			int stockActual) {
		this();
		if (logueado == null) {
			JOptionPane.showMessageDialog(null, "Acceso Denegado: Debe iniciar sesión para acceder a este formulario.",
					"Error de Seguridad", JOptionPane.ERROR_MESSAGE);
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
			return;
		}

		this.usuarioLogueado = logueado;
		this.idVariante = id;

		txtProducto.setText(producto);
		txtTalle.setText(talle);
		txtColor.setText(color);
		txtPrecio.setText(String.valueOf(precio));
		txtCantidad.setText(String.valueOf(stockActual));

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cantidadStr = txtCantidad.getText().trim();

				if (cantidadStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingresa una cantidad de stock.", "Campo Vacío",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					int nuevaCantidad = Integer.parseInt(cantidadStr);

					if (nuevaCantidad < 0) {
						JOptionPane.showMessageDialog(null, "Error: El stock no puede ser un número negativo.",
								"Cantidad inválida", JOptionPane.ERROR_MESSAGE);
						return;
					}

					controllerVar.actualizarCantidadStock(idVariante, nuevaCantidad);
					JOptionPane.showMessageDialog(null, "Stock actualizado correctamente a: " + nuevaCantidad);

					MenuGestionStock ventanaStock = new MenuGestionStock(usuarioLogueado);
					ventanaStock.setVisible(true);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese únicamente números enteros para el stock.",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}