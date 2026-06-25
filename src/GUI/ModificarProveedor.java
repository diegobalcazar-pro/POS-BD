package GUI;

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

import BLL.Proveedor;
import BLL.Usuario;
import DLL.ControllerProveedor;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomEmp;
	private JTextField txtNomCon;
	private JTextField txtTelf;
	private JTextField txtCor;
	private JButton btnConf;
	private JButton btnCancelar;

	private ControllerProveedor controllerProveedor = new ControllerProveedor();
	private Usuario usuarioLogueado;
	private int idProveedor;

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

	public ModificarProveedor() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 550);

		setTitle("Modificar Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Modificar proveedor");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(180, 39, 230, 29);
		contentPane.add(lblNewJgoodiesTitle);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre de empresa:");
		lblNewJgoodiesLabel.setBounds(227, 79, 140, 14);
		contentPane.add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nombre del contacto:");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setBounds(210, 136, 140, 14);
		contentPane.add(lblNewJgoodiesLabel_1);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Telefono:");
		lblNewJgoodiesLabel_2.setBounds(233, 188, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);

		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Correo:");
		lblNewJgoodiesLabel_3.setBounds(233, 242, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_3);

		txtNomEmp = new JTextField();
		txtNomEmp.setBounds(192, 104, 173, 20);
		contentPane.add(txtNomEmp);
		txtNomEmp.setColumns(10);

		txtNomCon = new JTextField();
		txtNomCon.setBounds(192, 157, 173, 20);
		contentPane.add(txtNomCon);
		txtNomCon.setColumns(10);

		txtTelf = new JTextField();
		txtTelf.setBounds(192, 211, 173, 20);
		contentPane.add(txtTelf);
		txtTelf.setColumns(10);

		txtCor = new JTextField();
		txtCor.setBounds(192, 267, 173, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);

		btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 100, 30);
		contentPane.add(btnConf);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(330, 322, 100, 30);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionProveedores ventanaProvs = new MenuGestionProveedores(usuarioLogueado);
				ventanaProvs.setVisible(true);
				dispose();
			}
		});
	}

	public ModificarProveedor(Usuario logueado, int id, String nombre, String contacto, String tel, String correo) {
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
		this.idProveedor = id;

		txtNomEmp.setText(nombre);
		txtNomCon.setText(contacto);
		txtTelf.setText(tel);
		txtCor.setText(correo);

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoNombre = txtNomEmp.getText().trim();
				String nuevoContacto = txtNomCon.getText().trim();
				String nuevoTel = txtTelf.getText().trim();
				String nuevoCorreo = txtCor.getText().trim();

				if (nuevoNombre.isEmpty() || nuevoContacto.isEmpty() || nuevoTel.isEmpty() || nuevoCorreo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos antes de confirmar.",
							"Campos Incompletos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				Proveedor p = new Proveedor(idProveedor, nuevoNombre, nuevoContacto, nuevoTel, nuevoCorreo);
				controllerProveedor.editarProveedor(p);

				JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente.");

				MenuGestionProveedores ventanaProvs = new MenuGestionProveedores(usuarioLogueado);
				ventanaProvs.setVisible(true);
				dispose();
			}
		});
	}
}