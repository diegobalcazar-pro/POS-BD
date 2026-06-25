package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import BLL.Usuario;
import BLL.Proveedor;
import DLL.ControllerProveedor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class MenuGestionProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modeloTabla;
	private JTextField txtBuscar;

	private ControllerProveedor controllerProveedor = new ControllerProveedor();
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
	public MenuGestionProveedores(Usuario logueado) {
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

		JButton btnCrearProv = new JButton("Crear");
		btnCrearProv.setForeground(new Color(255, 255, 255));
		btnCrearProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCrearProv.setBackground(new Color(128, 0, 0));
		btnCrearProv.setBounds(10, 15, 170, 45);
		btnCrearProv.setContentAreaFilled(false);
		btnCrearProv.setOpaque(true);
		nav.add(btnCrearProv);

		btnCrearProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreEmpresa = JOptionPane.showInputDialog("Ingrese nombre de la empresa:");
				if (nombreEmpresa == null || nombreEmpresa.trim().isEmpty())
					return;

				String nombreContacto = JOptionPane.showInputDialog("Ingrese nombre del contacto:");
				if (nombreContacto == null || nombreContacto.trim().isEmpty())
					return;

				String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
				if (telefono == null || telefono.trim().isEmpty())
					return;

				String correo = JOptionPane.showInputDialog("Ingrese correo electrónico:");
				if (correo == null || correo.trim().isEmpty())
					return;

				Proveedor nuevoProveedor = new Proveedor(0, nombreEmpresa, nombreContacto, telefono, correo);
				controllerProveedor.agregarProveedor(nuevoProveedor);
				JOptionPane.showMessageDialog(null, "Proveedor '" + nombreEmpresa + "' registrado con éxito.");

				cargarProveedoresEnTabla();
			}
		});

		JButton btnModiProv = new JButton("Modificar");
		btnModiProv.setForeground(new Color(255, 255, 255));
		btnModiProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnModiProv.setBackground(new Color(128, 0, 0));
		btnModiProv.setBounds(10, 65, 170, 45);
		btnModiProv.setContentAreaFilled(false);
		btnModiProv.setOpaque(true);
		nav.add(btnModiProv);

		btnModiProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();

				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null,
							"Por favor, seleccione un proveedor de la tabla para modificar.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int id = (int) table.getValueAt(filaSeleccionada, 0);
				String nombreActual = (String) table.getValueAt(filaSeleccionada, 1);
				String contactoActual = (String) table.getValueAt(filaSeleccionada, 2);
				String telActual = (String) table.getValueAt(filaSeleccionada, 3);
				String correoActual = (String) table.getValueAt(filaSeleccionada, 4);

				String nombre = JOptionPane.showInputDialog("Modificar empresa:", nombreActual);
				if (nombre == null)
					return;

				String contacto = JOptionPane.showInputDialog("Modificar contacto:", contactoActual);
				if (contacto == null)
					return;

				String tel = JOptionPane.showInputDialog("Modificar teléfono:", telActual);
				if (tel == null)
					return;

				String correo = JOptionPane.showInputDialog("Modificar correo:", correoActual);
				if (correo == null)
					return;

				Proveedor p = new Proveedor(id, nombre, contacto, tel, correo);
				controllerProveedor.editarProveedor(p);

				JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente.");
				cargarProveedoresEnTabla();
			}
		});

		JButton btnElimProv = new JButton("Eliminar");
		btnElimProv.setForeground(new Color(255, 255, 255));
		btnElimProv.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnElimProv.setBackground(new Color(128, 0, 0));
		btnElimProv.setBounds(10, 115, 170, 45);
		btnElimProv.setContentAreaFilled(false);
		btnElimProv.setOpaque(true);
		nav.add(btnElimProv);

		btnElimProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();

				if (filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor de la tabla para eliminar.",
							"Atención", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int id = (int) table.getValueAt(filaSeleccionada, 0);
				String nombreEmpresa = (String) table.getValueAt(filaSeleccionada, 1);

				int confirm = JOptionPane.showConfirmDialog(null,
						"¿Estás seguro de eliminar definitivamente a la empresa " + nombreEmpresa + "?",
						"Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (confirm == JOptionPane.YES_OPTION) {
					controllerProveedor.eliminarProveedor(id);
					JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
					cargarProveedoresEnTabla();
				}
			}
		});

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAtras.setBounds(10, 380, 170, 45);
		nav.add(btnAtras);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});

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

		JLabel lblBienvenida = new JLabel("Gestión Proveedores - Repositor " + usuarioLogueado.getNombre_usuario());
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(225, 11, 315, 52);
		header.add(lblBienvenida);
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblBuscar = new JLabel("Buscar Empresa:");
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
				cargarProveedoresEnTabla();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 127, 516, 375);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnas = { "ID", "Empresa", "Contacto", "Teléfono", "Correo" };
		modeloTabla = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modeloTabla);

		cargarProveedoresEnTabla();
	}

	private void cargarProveedoresEnTabla() {
		modeloTabla.setRowCount(0);

		String filtro = (txtBuscar != null) ? txtBuscar.getText().trim().toLowerCase() : "";

		LinkedList<Proveedor> listaProveedores = controllerProveedor.mostrarProveedores();

		for (Proveedor prov : listaProveedores) {
			if (filtro.isEmpty() || prov.getNombreEmpresa().toLowerCase().contains(filtro)) {
				Object[] fila = { prov.getid_proveedor(), prov.getNombreEmpresa(), prov.getNombreContacto(),
						prov.getTelefono(), prov.getCorreo() };
				modeloTabla.addRow(fila);
			}
		}
	}
}