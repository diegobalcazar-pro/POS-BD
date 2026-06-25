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

public class MenuCajero_Vercaja extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    
    private ControllerVenta controllerVenta = new ControllerVenta();

    private Usuario logueado;
    private LinkedList<Venta> ventas = new LinkedList<Venta>();

    private Cliente VentaSeleccionado;
    private JLabel lblDebito;
    private JLabel lblTransferencia;
    private JLabel lblTotal;
    private JLabel lblItems;
    private JLabel lblTotalVendido;

    private double porcentajeDescuento = 0;
    private int idDescuentoSeleccionado = 0;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCajero_Vercaja frame = new MenuCajero_Vercaja(null);
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
	public MenuCajero_Vercaja(Usuario logueado) {
	    this.logueado = logueado;

	    VentaSeleccionado = controllerVenta.buscarClientePorId(1);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel(" Ultimas Ventas");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(11, 93, 583, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("VER CAJA");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 15, 604, 27);
		contentPane.add(lblNewLabel_1_2);
										
										Button button_4 = new Button("Salir");
										button_4.setBackground(new Color(64, 0, 0));
										button_4.setForeground(new Color(255, 255, 255));
										button_4.setFont(new Font("Dialog", Font.BOLD, 15));
										button_4.setBounds(499, 366, 62, 60);
										contentPane.add(button_4);
										button_4.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												//Cierra la Ventana Cajero
												MenuCajero_Vercaja ver_caja = new MenuCajero_Vercaja(logueado);
												ver_caja.setVisible(false);
												dispose();
												
												MenuCajero m_caja = new MenuCajero(logueado);
												m_caja.setVisible(true);
												dispose();
												
											}
										});
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(10, 131, 584, 186);
										contentPane.add(scrollPane);
										
										model = new DefaultTableModel(new String[]{"ID", "Fecha", "Total Neto", "Total Bruto", "Cliente", "M. Pago", "Desuento"}, 0);
										table = new JTable(model);
										table.setFont(new Font("Tahoma", Font.PLAIN, 13));
										scrollPane.setViewportView(table);
										contentPane.add(scrollPane);
										
										
										
										
										JLabel lblTextoSubtotal = new JLabel("DEBITO:");
										lblTextoSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
										lblTextoSubtotal.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoSubtotal.setBounds(62, 338, 110, 22);
										contentPane.add(lblTextoSubtotal);

										lblDebito = new JLabel("$0.0");
										lblDebito.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblDebito.setBounds(182, 338, 75, 22);
										contentPane.add(lblDebito);
										
										JLabel lblTextoTotal = new JLabel("EFECTIVO:");
										lblTextoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
										lblTextoTotal.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoTotal.setBounds(62, 398, 110, 22);
										contentPane.add(lblTextoTotal);

										lblTotal = new JLabel("$0.0");
										lblTotal.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblTotal.setBounds(182, 398, 120, 22);
										contentPane.add(lblTotal);

										JLabel lblTextoVentas = new JLabel("VENTAS:");
										lblTextoVentas.setFont(new Font("Verdana", Font.BOLD, 11));
										lblTextoVentas.setBounds(261, 338, 63, 22);
										contentPane.add(lblTextoVentas);

										lblItems = new JLabel("0");
										lblItems.setFont(new Font("Verdana", Font.PLAIN, 11));
										lblItems.setBounds(334, 338, 62, 22);
										contentPane.add(lblItems);

										
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
														.addComponent(lblNewLabel_1_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
												);
												gl_panel.setVerticalGroup(
													gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
															.addContainerGap(34, Short.MAX_VALUE)
															.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
															.addContainerGap())
												);
												panel.setLayout(gl_panel);
												
												JLabel lblTextoSubtotal_1 = new JLabel("TRANSFERENCIA:");
												lblTextoSubtotal_1.setHorizontalAlignment(SwingConstants.CENTER);
												lblTextoSubtotal_1.setFont(new Font("Verdana", Font.BOLD, 11));
												lblTextoSubtotal_1.setBounds(62, 365, 110, 22);
												contentPane.add(lblTextoSubtotal_1);
												
												lblTransferencia = new JLabel("$0.0");
												lblTransferencia.setFont(new Font("Verdana", Font.PLAIN, 11));
												lblTransferencia.setBounds(182, 365, 75, 22);
												contentPane.add(lblTransferencia);
												
												lblTotalVendido = new JLabel("TOTAL VENDIDO:");
												lblTotalVendido.setHorizontalAlignment(SwingConstants.RIGHT);
												lblTotalVendido.setFont(new Font("Verdana", Font.BOLD, 11));
												lblTotalVendido.setBounds(253, 398, 110, 22);
												contentPane.add(lblTotalVendido);
												
												lblTotalVendido = new JLabel("$0.0");
												lblTotalVendido.setFont(new Font("Verdana", Font.BOLD, 12));
												lblTotalVendido.setBounds(373, 398, 120, 22);
												contentPane.add(lblTotalVendido);
												
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

	    lblDebito.setText("$" + totalDebito);
	    lblTransferencia.setText("$" + totalTransferencia);
	    lblTotal.setText("$" + totalEfectivo);
	    lblTotalVendido.setText("$" + totalVendido);
	    lblItems.setText(String.valueOf(items));
	}
}