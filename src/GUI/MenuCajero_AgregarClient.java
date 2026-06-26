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

    private Cliente VentaSeleccionado;
    private JLabel lblTotalVendido;

    private double porcentajeDescuento = 0;
    private int idDescuentoSeleccionado = 0;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    

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

	    VentaSeleccionado = controllerVenta.buscarClientePorId(1);
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
												
												textField = new JTextField();
												textField.setBounds(198, 143, 169, 27);
												contentPane.add(textField);
												textField.setColumns(10);
												
												JLabel lblApellido = new JLabel("APELLIDO:");
												lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
												lblApellido.setFont(new Font("Verdana", Font.BOLD, 14));
												lblApellido.setBounds(78, 180, 110, 22);
												contentPane.add(lblApellido);
												
												textField_1 = new JTextField();
												textField_1.setColumns(10);
												textField_1.setBounds(198, 178, 169, 27);
												contentPane.add(textField_1);
												
												JLabel lblCorreo = new JLabel("CORREO:");
												lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
												lblCorreo.setFont(new Font("Verdana", Font.BOLD, 14));
												lblCorreo.setBounds(78, 218, 110, 22);
												contentPane.add(lblCorreo);
												
												textField_2 = new JTextField();
												textField_2.setColumns(10);
												textField_2.setBounds(198, 216, 169, 27);
												contentPane.add(textField_2);
												
												JLabel lblTel = new JLabel("TEL:");
												lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
												lblTel.setFont(new Font("Verdana", Font.BOLD, 14));
												lblTel.setBounds(78, 253, 110, 22);
												contentPane.add(lblTel);
												
												textField_3 = new JTextField();
												textField_3.setColumns(10);
												textField_3.setBounds(198, 251, 169, 27);
												contentPane.add(textField_3);
												
												JLabel lblDireccion = new JLabel("DIRECCIÓN:");
												lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
												lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
												lblDireccion.setBounds(78, 288, 110, 22);
												contentPane.add(lblDireccion);
												
												textField_4 = new JTextField();
												textField_4.setColumns(10);
												textField_4.setBounds(198, 286, 169, 27);
												contentPane.add(textField_4);
												
												JLabel lblTipo = new JLabel("TIPO:");
												lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
												lblTipo.setFont(new Font("Verdana", Font.BOLD, 14));
												lblTipo.setBounds(78, 326, 110, 22);
												contentPane.add(lblTipo);
												
												JComboBox comboBox = new JComboBox();
												comboBox.setModel(new DefaultComboBoxModel(new String[] {"minorista", "mayorista"}));
												comboBox.setBounds(198, 324, 169, 27);
												contentPane.add(comboBox);
												
												Button button_4_1 = new Button("Guardar");
												button_4_1.setForeground(Color.WHITE);
												button_4_1.setFont(new Font("Dialog", Font.BOLD, 15));
												button_4_1.setBackground(new Color(64, 0, 0));
												button_4_1.setBounds(328, 367, 78, 60);
												contentPane.add(button_4_1);
												
												cargartablaventas();
									
		
		
	}
	
	
	private void cargartablaventas() {
	    model.setRowCount(0);

	    ventas = controllerVenta.mostrarVentas();


	    for (Venta venta : ventas) {
	    	
	    	String cliente = "";

	        if (venta.getCliente() != null) {
	            cliente = venta.getCliente().getNombre_cliente() + " " + venta.getCliente().getApellido_cliente();
	        } else {
	            cliente = "Sin cliente";
	        }

	        String metodoPago = "";

	        if (venta.getMetododepago() != null) {
	            metodoPago = venta.getMetododepago().getTipo();
	        } else {
	            metodoPago = "Sin método";
	        }

	        String descuento = "";

	        if (venta.getDescuento() != null) {
	            descuento = venta.getDescuento().getNombre_descuento();
	        } else {
	            descuento = "Sin descuento";
	        }

	        model.addRow(new Object[] {
	            venta.getid_venta(),
	            venta.getFecha(),
	            venta.getTotal_neto(),
	            venta.getTotal_bruto(),
	            cliente,
	            metodoPago,
	            descuento
	        });
	    }

	    actualizarTotales();
	}
	

	private double calcularTotalEfectivo() {

	    double totalEfectivo = 0;

	    for (Venta venta : ventas) {

	        if (venta.getMetododepago() != null) {

	            int idMetodoPago = venta.getMetododepago().getid_metodo_de_pago();

	            if (idMetodoPago == 1) {
	                totalEfectivo += venta.getTotal_neto();
	            }
	        }
	    }

	    return totalEfectivo;
	}

	private double calcularTotalDebito() {

	    double totalDebito = 0;

	    for (Venta venta : ventas) {

	        if (venta.getMetododepago() != null) {

	            int idMetodoPago = venta.getMetododepago().getid_metodo_de_pago();

	            if (idMetodoPago == 2) {
	                totalDebito += venta.getTotal_neto();
	            }
	        }
	    }

	    return totalDebito;
	}

	private double calcularTotalTransferencia() {

	    double totalTransferencia = 0;

	    for (Venta venta : ventas) {

	        if (venta.getMetododepago() != null) {

	            int idMetodoPago = venta.getMetododepago().getid_metodo_de_pago();

	            if (idMetodoPago == 3) {
	                totalTransferencia += venta.getTotal_neto();
	            }
	        }
	    }

	    return totalTransferencia;
	}

	private double calcularTotalVendido() {

	    double totalVendido = 0;

	    for (Venta venta : ventas) {
	        totalVendido += venta.getTotal_neto();
	    }

	    return totalVendido;
	}

	private int calcularItems() {

	    int items = 0;

	    for (Venta venta : ventas) {
	        items++;
	    }

	    return items;
	}

	private void actualizarTotales() {

		double totalEfectivo = calcularTotalEfectivo();
	    double totalDebito = calcularTotalDebito();
	    double totalTransferencia = calcularTotalTransferencia();
	    double totalVendido = calcularTotalVendido();
	    int items = calcularItems();
	}
}