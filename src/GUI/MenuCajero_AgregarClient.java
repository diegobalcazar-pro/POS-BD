package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Admin;
import BLL.Cajero;
import BLL.ItemVenta;
import BLL.Producto;
import BLL.Repositor;
import BLL.Usuario;
import BLL.VarianteProducto;
import BLL.Venta;
import BLL.Cliente;
import DLL.ControllerProducto;
import DLL.ControllerUsuario;
import DLL.ControllerVarianteProducto;
import DLL.ControllerVenta;
import repository.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JToggleButton;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.UIManager;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuCajero_AgregarClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private DefaultTableModel model;
    
    private ControllerVenta controllerVenta = new ControllerVenta();

    private Usuario logueado;
    private LinkedList<Venta> ventas = new LinkedList<Venta>();

    private JTextField inpNombre;
    private JTextField inpApellido;
    private JTextField inpCorreo;
    private JTextField inpTelefono;
    private JTextField inpDireccion;
    private JComboBox<String> selectTipo;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCajero_AgregarClient frame = new MenuCajero_AgregarClient(null);
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
	public MenuCajero_AgregarClient(Usuario logueado) {
	    this.logueado = logueado;


		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Rellenar los siguientes datos");
		lblNewLabel_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(0, 87, 504, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("AGREGAR CLIENTE");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 15, 504, 27);
		contentPane.add(lblNewLabel_1_2);
										
										Button button_4 = new Button("Salir");
										button_4.setBackground(new Color(64, 0, 0));
										button_4.setForeground(new Color(255, 255, 255));
										button_4.setFont(new Font("Dialog", Font.BOLD, 15));
										button_4.setBounds(418, 367, 62, 60);
										contentPane.add(button_4);
										button_4.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												//Cierra la Ventana agregar cliente
												MenuCajero_AgregarClient ver_caja = new MenuCajero_AgregarClient(logueado);
												ver_caja.setVisible(false);
												dispose();
												
												MenuCajero m_caja = new MenuCajero(logueado);
												m_caja.setVisible(true);
												dispose();
												
											}
										});
										
										model = new DefaultTableModel(new String[]{"ID", "Fecha", "Total Neto", "Total Bruto", "Cliente", "M. Pago", "Descuento"}, 0);
										
										
										
										
										JLabel lblNombre = new JLabel("NOMBRE:");
										lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
										lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
										lblNombre.setBounds(78, 145, 110, 22);
										contentPane.add(lblNombre);

										
										JPanel panel = new JPanel();
										panel.setBackground(new Color(64, 0, 0));
										panel.setBounds(0, 1, 604, 75);
										contentPane.add(panel);
										
										JLabel lblNewLabel_1_4 = new JLabel(LocalDate.now().getDayOfWeek().toString()+" | "+LocalDate.now().toString()+" | "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+"hs");
										lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_1_4.setForeground(Color.WHITE);
										lblNewLabel_1_4.setFont(new Font("Dubai", Font.BOLD, 13));
												GroupLayout gl_panel = new GroupLayout(panel);
												gl_panel.setHorizontalGroup(
													gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
															.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
															.addContainerGap(99, Short.MAX_VALUE))
												);
												gl_panel.setVerticalGroup(
													gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
															.addContainerGap(34, Short.MAX_VALUE)
															.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
															.addContainerGap())
												);
												panel.setLayout(gl_panel);
												
												inpNombre = new JTextField();
												inpNombre.setBounds(198, 143, 169, 27);
												contentPane.add(inpNombre);
												inpNombre.setColumns(10);
												
												JLabel lblApellido = new JLabel("APELLIDO:");
												lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
												lblApellido.setFont(new Font("Verdana", Font.BOLD, 14));
												lblApellido.setBounds(78, 180, 110, 22);
												contentPane.add(lblApellido);
												
												inpApellido = new JTextField();
												inpApellido.setColumns(10);
												inpApellido.setBounds(198, 178, 169, 27);
												contentPane.add(inpApellido);
												
												JLabel lblCorreo = new JLabel("CORREO:");
												lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
												lblCorreo.setFont(new Font("Verdana", Font.BOLD, 14));
												lblCorreo.setBounds(78, 218, 110, 22);
												contentPane.add(lblCorreo);
												
												inpCorreo = new JTextField();
												inpCorreo.setColumns(10);
												inpCorreo.setBounds(198, 216, 169, 27);
												contentPane.add(inpCorreo);
												
												JLabel lblTel = new JLabel("TEL:");
												lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
												lblTel.setFont(new Font("Verdana", Font.BOLD, 14));
												lblTel.setBounds(78, 253, 110, 22);
												contentPane.add(lblTel);
												
												inpTelefono = new JTextField();
												inpTelefono.setColumns(10);
												inpTelefono.setBounds(198, 251, 169, 27);
												contentPane.add(inpTelefono);
												
												JLabel lblDireccion = new JLabel("DIRECCIÓN:");
												lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
												lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
												lblDireccion.setBounds(78, 288, 110, 22);
												contentPane.add(lblDireccion);
												
												inpDireccion = new JTextField();
												inpDireccion.setColumns(10);
												inpDireccion.setBounds(198, 286, 169, 27);
												contentPane.add(inpDireccion);
												
												JLabel lblTipo = new JLabel("TIPO:");
												lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
												lblTipo.setFont(new Font("Verdana", Font.BOLD, 14));
												lblTipo.setBounds(78, 326, 110, 22);
												contentPane.add(lblTipo);
												
												selectTipo = new JComboBox<String>();
												selectTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"minorista", "mayorista"}));
												selectTipo.setBounds(198, 324, 169, 27);
												contentPane.add(selectTipo);
												
												Button button_4_1 = new Button("Guardar");
												button_4_1.setForeground(Color.WHITE);
												button_4_1.setFont(new Font("Dialog", Font.BOLD, 15));
												button_4_1.setBackground(new Color(64, 0, 0));
												button_4_1.setBounds(328, 367, 78, 60);
												contentPane.add(button_4_1);
												button_4_1.addActionListener(new ActionListener() {
												    public void actionPerformed(ActionEvent e) {
												        guardarCliente();
												    }
												});
												
											
									
		
		
	}
	
	private void guardarCliente() {

	    String nombre = inpNombre.getText().trim();
	    String apellido = inpApellido.getText().trim();
	    String correo = inpCorreo.getText().trim();
	    String telefono = inpTelefono.getText().trim();
	    String direccion = inpDireccion.getText().trim();
	    String tipo = selectTipo.getSelectedItem().toString();

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar el nombre.");
	        return;
	    }

	    if (apellido.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar el apellido.");
	        return;
	    }

	    if (correo.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar el correo.");
	        return;
	    }

	    if (telefono.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar el teléfono.");
	        return;
	    }

	    if (direccion.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar la dirección.");
	        return;
	    }

	    boolean clienteGuardado = controllerVenta.agregarCliente(
	            nombre,
	            apellido,
	            correo,
	            telefono,
	            direccion,
	            tipo
	    );

	    if (clienteGuardado) {
	        JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
	        limpiarCampos();
	    } else {
	        JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente.");
	    }
	}

	private void limpiarCampos() {

	    inpNombre.setText("");
	    inpApellido.setText("");
	    inpCorreo.setText("");
	    inpTelefono.setText("");
	    inpDireccion.setText("");
	    selectTipo.setSelectedIndex(0);
	}
	
	
	
	
	
}