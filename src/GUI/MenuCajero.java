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

public class MenuCajero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    
    private ControllerVenta controllerVenta = new ControllerVenta();

    private Usuario logueado;
    private LinkedList<ItemVenta> carrito = new LinkedList<ItemVenta>();

    private Cliente clienteSeleccionado;
    private JLabel lblClienteSeleccionado;
    private JLabel lblSubtotal;
    private JLabel lblDescuento;
    private JLabel lblTotal;
    private JLabel lblItems;

    private double porcentajeDescuento = 0;
    private int idDescuentoSeleccionado = 0;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCajero frame = new MenuCajero(null);
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
	public MenuCajero(Usuario logueado) {
	    this.logueado = logueado;

	    clienteSeleccionado = controllerVenta.buscarClientePorId(1);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Cliente:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(213, 126, 179, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MODULO CAJERO");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(190, 15, 202, 27);
		contentPane.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_1_2_1 = new JLabel("REALIZAR VENTA");
				lblNewLabel_1_2_1.setForeground(new Color(128, 128, 128));
				lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblNewLabel_1_2_1.setBounds(213, 87, 169, 32);
				contentPane.add(lblNewLabel_1_2_1);
								
								JLabel lblNewLabel_2 = new JLabel("");
								lblNewLabel_2.setBackground(new Color(0, 0, 0));
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setIcon(new ImageIcon("src\\\\img\\\\logo1.png"));
								lblNewLabel_2.setBounds(4, 1, 169, 76);
								contentPane.add(lblNewLabel_2);
								
								Button ver_ventas = new Button("Ver Ventas");
								ver_ventas.setForeground(Color.WHITE);
								ver_ventas.setFont(new Font("Ebrima", Font.BOLD, 13));
								ver_ventas.setBackground(new Color(128, 0, 0));
								ver_ventas.setActionCommand("Cerrar Sesion");
								ver_ventas.setBounds(10, 96, 169, 44);
								contentPane.add(ver_ventas);
								ver_ventas.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										logueado.Menu();
										
										/*MenuCajero_Vercaja mcajero = new MenuCajero_Vercaja(logueado);
										mcajero.setVisible(true);
										dispose();*/
							
									}
								});
								
								
								Button agregar_cliente = new Button("Agregar Cliente");
								agregar_cliente.setForeground(Color.WHITE);
								agregar_cliente.setFont(new Font("Ebrima", Font.BOLD, 13));
								agregar_cliente.setBackground(new Color(128, 0, 0));
								agregar_cliente.setActionCommand("Cerrar Sesion");
								agregar_cliente.setBounds(10, 218, 169, 44);
								contentPane.add(agregar_cliente);
								
								Button ver_caja = new Button("Ver Caja");
								ver_caja.setForeground(Color.WHITE);
								ver_caja.setFont(new Font("Ebrima", Font.BOLD, 13));
								ver_caja.setBackground(new Color(128, 0, 0));
								ver_caja.setActionCommand("ver caja");
								ver_caja.setBounds(10, 158, 169, 44);
								contentPane.add(ver_caja);
								ver_caja.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										
										MenuCajero_Vercaja mcajero = new MenuCajero_Vercaja(logueado);
										mcajero.setVisible(true);
										dispose();
										
										
										
										
									}
								});
								
								
								Button cerrar_sesion = new Button("Cerrar Sesion");
								cerrar_sesion.setForeground(Color.WHITE);
								cerrar_sesion.setFont(new Font("Ebrima", Font.BOLD, 13));
								cerrar_sesion.setBackground(new Color(128, 0, 0));
								cerrar_sesion.setActionCommand("Cerrar Sesion");
								cerrar_sesion.setBounds(10, 459, 169, 32);
								contentPane.add(cerrar_sesion);
								cerrar_sesion.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										//Cierra la Ventana Cajero
										MenuCajero mcajero = new MenuCajero(logueado);
										mcajero.setVisible(false);
										dispose();
										
										//Abre la Ventana login
										Login jframe = new Login();
										jframe.setVisible(true);
										dispose();
										
									}
								});
								
								Button cerrar_caja = new Button("Cerrar Caja");
								cerrar_caja.setForeground(Color.WHITE);
								cerrar_caja.setFont(new Font("Ebrima", Font.BOLD, 13));
								cerrar_caja.setBackground(new Color(128, 0, 0));
								cerrar_caja.setActionCommand("Cerrar Sesion");
								cerrar_caja.setBounds(10, 278, 169, 44);
								contentPane.add(cerrar_caja);
										
								        Button seleccionarCliente = new Button("Seleccionar");
								        seleccionarCliente.setBounds(396, 144, 70, 22);
								        contentPane.add(seleccionarCliente);
        
								        seleccionarCliente.addActionListener(new ActionListener() {
								            public void actionPerformed(ActionEvent e) {
								                seleccionarCliente();
								            }
								        });
										
										Button button_4 = new Button("X");
										button_4.setForeground(new Color(128, 0, 0));
										button_4.setFont(new Font("Dialog", Font.BOLD, 26));
										button_4.setBounds(429, 442, 60, 60);
										contentPane.add(button_4);
										button_4.addActionListener(new ActionListener() {
										    public void actionPerformed(ActionEvent e) {
										        borrarProductoSeleccionado();
										    }
										});
										
										
										
										Button button_4_1 = new Button("+");
										button_4_1.setForeground(new Color(0, 128, 0));
										button_4_1.setFont(new Font("Dialog", Font.BOLD, 37));
										button_4_1.setBounds(690, 442, 60, 60);
										contentPane.add(button_4_1);
										button_4_1.addActionListener(new ActionListener() {
										    public void actionPerformed(ActionEvent e) {
										        agregarProductoAlCarrito();
										    }
										});
										
										
										
										
										Button button_4_1_1 = new Button("%");
										button_4_1_1.setForeground(new Color(0, 0, 0));
										button_4_1_1.setFont(new Font("Dialog", Font.BOLD, 32));
										button_4_1_1.setBounds(620, 442, 60, 60);
										contentPane.add(button_4_1_1);
										button_4_1_1.addActionListener(new ActionListener() {
										    public void actionPerformed(ActionEvent e) {
										        agregarDescuento();
										    }
										});
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(213, 189, 615, 210);
										contentPane.add(scrollPane);
										
										model = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Cantidad", "Subtotal"}, 0);
										table = new JTable(model);
										table.setFont(new Font("Tahoma", Font.PLAIN, 13));
										scrollPane.setViewportView(table);
										contentPane.add(scrollPane);
										
										
										
										
										JLabel lblTextoSubtotal = new JLabel("SUBTOTAL:");
										lblTextoSubtotal.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoSubtotal.setBounds(213, 410, 93, 22);
										contentPane.add(lblTextoSubtotal);

										lblSubtotal = new JLabel("$0.0");
										lblSubtotal.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblSubtotal.setBounds(290, 410, 100, 22);
										contentPane.add(lblSubtotal);

										JLabel lblTextoDescuento = new JLabel("DESCUENTO:");
										lblTextoDescuento.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoDescuento.setBounds(213, 440, 93, 22);
										contentPane.add(lblTextoDescuento);

										lblDescuento = new JLabel("0%");
										lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblDescuento.setBounds(300, 440, 100, 22);
										contentPane.add(lblDescuento);

										JLabel lblTextoTotal = new JLabel("TOTAL:");
										lblTextoTotal.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoTotal.setBounds(213, 470, 93, 22);
										contentPane.add(lblTextoTotal);

										lblTotal = new JLabel("$0.0");
										lblTotal.setFont(new Font("Verdana", Font.BOLD, 12));
										lblTotal.setBounds(270, 470, 120, 22);
										contentPane.add(lblTotal);

										JLabel lblTextoItems = new JLabel("ITEMS:");
										lblTextoItems.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoItems.setBounds(354, 410, 93, 22);
										contentPane.add(lblTextoItems);

										lblItems = new JLabel("0");
										lblItems.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblItems.setBounds(405, 410, 50, 22);
										contentPane.add(lblItems);

										cargarTabla();
										
										Button button_4_1_2 = new Button("COBRAR");
										button_4_1_2.setForeground(new Color(64, 0, 0));
										button_4_1_2.setFont(new Font("Dialog", Font.BOLD, 13));
										button_4_1_2.setBounds(768, 442, 60, 60);
										contentPane.add(button_4_1_2);
										button_4_1_2.addActionListener(new ActionListener() {
										    public void actionPerformed(ActionEvent e) {
										        cobrarVenta();
										    }
										});
										
										JSeparator separator = new JSeparator();
										separator.setOrientation(SwingConstants.VERTICAL);
										separator.setToolTipText("|");
										separator.setForeground(new Color(0, 0, 0));
										separator.setBackground(new Color(0, 0, 0));
										separator.setBounds(758, 447, 26, 49);
										contentPane.add(separator);
										
										lblClienteSeleccionado = new JLabel("");
										lblClienteSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
										lblClienteSeleccionado.setBackground(new Color(255, 255, 255));
										lblClienteSeleccionado.setFont(new Font("Verdana", Font.BOLD, 12));
										lblClienteSeleccionado.setBounds(213, 142, 179, 27);
										contentPane.add(lblClienteSeleccionado);
										
										JPanel panel_1 = new JPanel();
										panel_1.setBackground(new Color(64, 0, 0));
										panel_1.setBounds(0, 1, 186, 511);
										contentPane.add(panel_1);
										GroupLayout gl_panel_1 = new GroupLayout(panel_1);
										gl_panel_1.setHorizontalGroup(
											gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGap(0, 186, Short.MAX_VALUE)
										);
										gl_panel_1.setVerticalGroup(
											gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGap(0, 511, Short.MAX_VALUE)
										);
										panel_1.setLayout(gl_panel_1);
										
										JPanel panel = new JPanel();
										panel.setBackground(new Color(64, 0, 0));
										panel.setBounds(183, 1, 667, 75);
										contentPane.add(panel);
										
										JLabel lblNewLabel = new JLabel("");
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel.setIcon(new ImageIcon("src\\\\img\\\\logo.png"));
										
										JLabel lblNewLabel_1_4 = new JLabel(LocalDate.now().getDayOfWeek().toString()+" | "+LocalDate.now().toString()+" | "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+"hs");
										lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_1_4.setForeground(Color.WHITE);
										lblNewLabel_1_4.setFont(new Font("Dubai", Font.BOLD, 13));
										
												JLabel lblNewLabel_1 = new JLabel("Bienvenido, "+ logueado.getNombre_usuario());
												lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
												lblNewLabel_1.setForeground(new Color(255, 255, 255));
												lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 11));
												
												JLabel lblNewLabel_1_3 = new JLabel(logueado.getRol());
												lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
												lblNewLabel_1_3.setForeground(Color.WHITE);
												lblNewLabel_1_3.setFont(new Font("Nirmala UI", Font.BOLD, 12));
												GroupLayout gl_panel = new GroupLayout(panel);
												gl_panel.setHorizontalGroup(
													gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
															.addContainerGap()
															.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
															.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																	.addGap(25)
																	.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
																.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
															.addGap(18)
															.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
															.addGap(21))
												);
												gl_panel.setVerticalGroup(
													gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
															.addContainerGap(15, Short.MAX_VALUE)
															.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_panel.createSequentialGroup()
																		.addGap(19)
																		.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
																	.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																	.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
															.addContainerGap())
												);
												panel.setLayout(gl_panel);
												
												JPanel panel_1_1 = new JPanel();
												panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
												panel_1_1.setBackground(new Color(255, 255, 255));
												panel_1_1.setBounds(213, 142, 179, 27);
												contentPane.add(panel_1_1);
												GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
												gl_panel_1_1.setHorizontalGroup(
													gl_panel_1_1.createParallelGroup(Alignment.LEADING)
														.addGap(0, 186, Short.MAX_VALUE)
														.addGap(0, 186, Short.MAX_VALUE)
												);
												gl_panel_1_1.setVerticalGroup(
													gl_panel_1_1.createParallelGroup(Alignment.LEADING)
														.addGap(0, 511, Short.MAX_VALUE)
														.addGap(0, 511, Short.MAX_VALUE)
												);
												panel_1_1.setLayout(gl_panel_1_1);

										actualizarClienteSeleccionado();
		
		
	}
	
	private void agregarProductoAlCarrito() {

	    JOptionPane.showMessageDialog(null, "Productos disponibles:\n" + controllerVenta.mostrarProductosConStock());

	    String idTexto = JOptionPane.showInputDialog("Ingrese el ID de la variante");

	    if (idTexto == null || idTexto.trim().isEmpty()) {
	        return;
	    }

	    String cantidadTexto = JOptionPane.showInputDialog("Ingrese cantidad");

	    if (cantidadTexto == null || cantidadTexto.trim().isEmpty()) {
	        return;
	    }

	    int idVariante = 0;
	    int cantidad = 0;

	    try {
	        idVariante = Integer.parseInt(idTexto);
	        cantidad = Integer.parseInt(cantidadTexto);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar solamente números.");
	        return;
	    }

	    if (cantidad <= 0) {
	        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
	        return;
	    }

	    ItemVenta itemNuevo = controllerVenta.buscarItemVenta(idVariante, cantidad);

	    if (itemNuevo == null) {
	        return;
	    }

	    for (ItemVenta item : carrito) {

	        if (item.getId_variante_producto() == idVariante) {

	            int nuevaCantidad = item.getCantidad() + cantidad;

	            if (controllerVenta.hayStockSuficiente(idVariante, nuevaCantidad)) {
	                item.setCantidad(nuevaCantidad);
	                JOptionPane.showMessageDialog(null, "Cantidad actualizada en el carrito.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No hay stock suficiente para sumar esa cantidad.");
	            }

	            cargarTabla();
	            return;
	        }
	    }

	    carrito.add(itemNuevo);

	    cargarTabla();

	    JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
	}
	
	private void borrarProductoSeleccionado() {

	    int filaSeleccionada = table.getSelectedRow();

	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla.");
	        return;
	    }

	    int idVariante = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());

	    ItemVenta itemEliminar = null;

	    for (ItemVenta item : carrito) {
	        if (item.getId_variante_producto() == idVariante) {
	            itemEliminar = item;
	            break;
	        }
	    }

	    if (itemEliminar != null) {
	        carrito.remove(itemEliminar);
	        cargarTabla();
	        JOptionPane.showMessageDialog(null, "Producto eliminado del carrito.");
	    }
	}
	
	
	private void cargarTabla() {

	    model.setRowCount(0);

	    for (ItemVenta item : carrito) {

	        model.addRow(new Object[] {
	            item.getId_variante_producto(),
	            item.getNombre_producto(),
	            item.getPrecio_unitario(),
	            item.getCantidad(),
	            item.getSubtotal()
	        });
	    }

	    actualizarTotales();
	}
	
	private double calcularSubtotal() {

	    double subtotal = 0;

	    for (ItemVenta item : carrito) {
	        subtotal += item.getSubtotal();
	    }

	    return subtotal;
	}

	private double calcularTotal() {

	    double subtotal = calcularSubtotal();
	    double descuento = subtotal * porcentajeDescuento / 100;
	    double total = subtotal - descuento;

	    return total;
	}

	private int calcularItems() {

	    int items = 0;

	    for (ItemVenta item : carrito) {
	        items += item.getCantidad();
	    }

	    return items;
	}

	private void actualizarTotales() {

	    double subtotal = calcularSubtotal();
	    double total = calcularTotal();
	    int items = calcularItems();

	    lblSubtotal.setText("$" + subtotal);
	    lblDescuento.setText(porcentajeDescuento + "%");
	    lblTotal.setText("$" + total);
	    lblItems.setText(String.valueOf(items));
	}

	private void agregarDescuento() {

	    JOptionPane.showMessageDialog(null, "Descuentos disponibles:\n" + controllerVenta.mostrarDescuentosTexto());

	    String idTexto = JOptionPane.showInputDialog("Ingrese el ID del descuento. Ingrese 0 para quitar descuento");

	    if (idTexto == null || idTexto.trim().isEmpty()) {
	        return;
	    }

	    int idDescuento = 0;

	    try {
	        idDescuento = Integer.parseInt(idTexto);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar solamente números.");
	        return;
	    }

	    if (idDescuento == 0) {
	        idDescuentoSeleccionado = 0;
	        porcentajeDescuento = 0;
	        actualizarTotales();
	        JOptionPane.showMessageDialog(null, "Descuento eliminado.");
	        return;
	    }

	    double porcentaje = controllerVenta.obtenerPorcentajeDescuento(idDescuento);

	    if (porcentaje <= 0) {
	        JOptionPane.showMessageDialog(null, "No se encontró el descuento.");
	        return;
	    }

	    idDescuentoSeleccionado = idDescuento;
	    porcentajeDescuento = porcentaje;

	    actualizarTotales();

	    JOptionPane.showMessageDialog(null, "Descuento aplicado: " + porcentajeDescuento + "%");
	}

	private void cobrarVenta() {

	    if (logueado == null) {
	        JOptionPane.showMessageDialog(null, "No hay usuario logueado.");
	        return;
	    }

	    if (carrito.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El carrito está vacío.");
	        return;
	    }

	    if (clienteSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "No hay cliente seleccionado.");
	        return;
	    }

	    int idCliente = clienteSeleccionado.getid_cliente();

	    JOptionPane.showMessageDialog(null, "Métodos de pago disponibles:\n" + controllerVenta.mostrarMetodosPagoTexto());

	    String metodoTexto = JOptionPane.showInputDialog("Ingrese el ID del método de pago");

	    if (metodoTexto == null || metodoTexto.trim().isEmpty()) {
	        return;
	    }

	    int idMetodoPago = 0;

	    try {
	        idMetodoPago = Integer.parseInt(metodoTexto);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El método de pago debe ser un número.");
	        return;
	    }

	    double subtotal = calcularSubtotal();
	    double total = calcularTotal();

	    int confirmar = JOptionPane.showConfirmDialog(
	            null,
	            "¿Confirmar venta?\n\n" +
	            "Subtotal: $" + subtotal + "\n" +
	            "Descuento: " + porcentajeDescuento + "%\n" +
	            "Total: $" + total + "\n" +
	            "Items: " + calcularItems(),
	            "Confirmar cobro",
	            JOptionPane.YES_NO_OPTION
	    );

	    if (confirmar != JOptionPane.YES_OPTION) {
	        return;
	    }

	    boolean venta = controllerVenta.procesarVenta(
	            logueado.getId_usuario(),
	            idCliente,
	            idMetodoPago,
	            idDescuentoSeleccionado,
	            subtotal,
	            total,
	            carrito
	    );

	    if (venta) {
	        carrito.clear();

	        idDescuentoSeleccionado = 0;
	        porcentajeDescuento = 0;

	        volverAConsumidorFinal();

	        cargarTabla();
	        actualizarTotales();

	        JOptionPane.showMessageDialog(null, "Venta cobrada correctamente.");
	    } else {
	        JOptionPane.showMessageDialog(null, "No se pudo procesar la venta.");
	    }
	}
	
	
	private void actualizarClienteSeleccionado() {

	    if (lblClienteSeleccionado == null) {
	        return;
	    }

	    if (clienteSeleccionado != null) {
	        lblClienteSeleccionado.setText(
	            clienteSeleccionado.getid_cliente() + " - " +
	            clienteSeleccionado.getNombre_cliente() + " " +
	            clienteSeleccionado.getApellido_cliente()
	        );
	    } else {
	        lblClienteSeleccionado.setText("Cliente no encontrado");
	    }
	}

	private void seleccionarCliente() {

	    JOptionPane.showMessageDialog(null, "Clientes disponibles:\n" + controllerVenta.mostrarClientesTexto());

	    String idTexto = JOptionPane.showInputDialog("Ingrese el ID del cliente");

	    if (idTexto == null || idTexto.trim().isEmpty()) {
	        return;
	    }

	    int idCliente = 0;

	    try {
	        idCliente = Integer.parseInt(idTexto);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El ID del cliente debe ser un número.");
	        return;
	    }

	    Cliente cliente = controllerVenta.buscarClientePorId(idCliente);

	    if (cliente == null) {
	        JOptionPane.showMessageDialog(null, "No se encontró el cliente.");
	        return;
	    }

	    clienteSeleccionado = cliente;
	    actualizarClienteSeleccionado();

	    JOptionPane.showMessageDialog(null, "Cliente seleccionado correctamente.");
	}

	private void volverAConsumidorFinal() {

	    clienteSeleccionado = controllerVenta.buscarClientePorId(1);
	    actualizarClienteSeleccionado();
	}
}