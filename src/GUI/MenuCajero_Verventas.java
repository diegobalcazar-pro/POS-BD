package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;
import BLL.Venta;
import BLL.Cliente;
import DLL.ControllerVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;


public class MenuCajero_Verventas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    
    private ControllerVenta controllerVenta = new ControllerVenta();

    private Usuario logueado;
    private LinkedList<Venta> ventas = new LinkedList<Venta>();
    
    private JDateChooser calendarioFechaInicio;
    private JDateChooser calendarioFechaFin;

    private Cliente VentaSeleccionado;
    private JLabel lblDiaSeleccionado;
    private JLabel lblCantidadVentas;
    private JLabel lblTotalVendido;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCajero_Verventas frame = new MenuCajero_Verventas(null);
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
	public MenuCajero_Verventas(Usuario logueado) {
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
		lblNewLabel_1_1.setBounds(11, 119, 583, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("VER VENTAS");
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
				MenuCajero_Verventas ver_ventas = new MenuCajero_Verventas(logueado);
				ver_ventas.setVisible(false);
				dispose();
				
				MenuCajero m_caja = new MenuCajero(logueado);
				m_caja.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblTextoFechaInicio = new JLabel("Desde:");
		lblTextoFechaInicio.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTextoFechaInicio.setBounds(10, 86, 50, 25);
		contentPane.add(lblTextoFechaInicio);

		calendarioFechaInicio = new JDateChooser();
		calendarioFechaInicio.setDateFormatString("dd/MM/yyyy");
		calendarioFechaInicio.setBounds(60, 86, 120, 25);
		contentPane.add(calendarioFechaInicio);

		JLabel lblTextoFechaFin = new JLabel("Hasta:");
		lblTextoFechaFin.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTextoFechaFin.setBounds(190, 86, 50, 25);
		contentPane.add(lblTextoFechaFin);

		calendarioFechaFin = new JDateChooser();
		calendarioFechaFin.setDateFormatString("dd/MM/yyyy");
		calendarioFechaFin.setBounds(240, 86, 120, 25);
		calendarioFechaFin.setEnabled(false);
		contentPane.add(calendarioFechaFin);

		Button btnFiltrar = new Button("Filtrar");
		btnFiltrar.setBounds(375, 86, 80, 25);
		contentPane.add(btnFiltrar);

		Button btnDetalle = new Button("Ver Detalle");
		btnDetalle.setBounds(470, 86, 120, 25);
		contentPane.add(btnDetalle);

		calendarioFechaInicio.addPropertyChangeListener("date", evt -> {
		    Date fechaInicio = calendarioFechaInicio.getDate();

		    if (fechaInicio != null) {
		        calendarioFechaFin.setMinSelectableDate(fechaInicio);
		        calendarioFechaFin.setEnabled(true);

		        Date fechaFin = calendarioFechaFin.getDate();

		        if (fechaFin != null && fechaFin.before(fechaInicio)) {
		            calendarioFechaFin.setDate(null);
		        }
		    }
		});

		btnFiltrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        filtrarVentasPorFechas();
		    }
		});

		btnDetalle.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        verDetalleVentaSeleccionada();
		    }
		});
										
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 584, 197);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel(new String[]{"ID", "Fecha", "Total Neto", "Total Bruto", "Cliente", "M. Pago", "Descuento"}, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		table.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        actualizarDiaSeleccionadoPorTabla();
		    }
		});
		
		JLabel lblTextoDiaSeleccionado = new JLabel("DIA SELECCIONADO:");
		lblTextoDiaSeleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextoDiaSeleccionado.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTextoDiaSeleccionado.setBounds(11, 366, 140, 22);
		contentPane.add(lblTextoDiaSeleccionado);

		lblDiaSeleccionado = new JLabel("Sin seleccionar");
		lblDiaSeleccionado.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDiaSeleccionado.setBounds(161, 366, 160, 22);
		contentPane.add(lblDiaSeleccionado);

		JLabel lblTextoCantidadVentas = new JLabel("VENTAS:");
		lblTextoCantidadVentas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextoCantidadVentas.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTextoCantidadVentas.setBounds(11, 396, 140, 22);
		contentPane.add(lblTextoCantidadVentas);

		lblCantidadVentas = new JLabel("0");
		lblCantidadVentas.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCantidadVentas.setBounds(161, 396, 80, 22);
		contentPane.add(lblCantidadVentas);

		JLabel lblTextoTotalVendido = new JLabel("TOTAL VENDIDO:");
		lblTextoTotalVendido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTextoTotalVendido.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTextoTotalVendido.setBounds(245, 396, 130, 22);
		contentPane.add(lblTextoTotalVendido);

		lblTotalVendido = new JLabel("$0.0");
		lblTotalVendido.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTotalVendido.setBounds(385, 396, 110, 22);
		contentPane.add(lblTotalVendido);
										
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
				
				cargartablaventas();
	
		
		
	}
	
	
	private void cargartablaventas() {

	    ventas = controllerVenta.mostrarVentas();

	    cargarVentasEnTabla();
	}
	
	private void cargarVentasEnTabla() {

	    model.setRowCount(0);

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
	
	
	private void filtrarVentasPorFechas() {

	    Date fechaInicioDate = calendarioFechaInicio.getDate();
	    Date fechaFinDate = calendarioFechaFin.getDate();

	    if (fechaInicioDate == null) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de inicio.");
	        return;
	    }

	    if (fechaFinDate == null) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha fin.");
	        return;
	    }

	    try {
	        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	        String fechaInicioTexto = formato.format(fechaInicioDate);
	        String fechaFinTexto = formato.format(fechaFinDate);

	        Date fechaInicio = formato.parse(fechaInicioTexto);
	        Date fechaFin = formato.parse(fechaFinTexto);

	        if (fechaFin.before(fechaInicio)) {
	            JOptionPane.showMessageDialog(null, "La fecha fin no puede ser menor a la fecha inicio.");
	            return;
	        }

	        LinkedList<Venta> todasLasVentas = controllerVenta.mostrarVentas();

	        ventas = new LinkedList<Venta>();

	        for (Venta venta : todasLasVentas) {

	            String fechaVentaTexto = String.valueOf(venta.getFecha());

	            if (fechaVentaTexto.length() >= 10) {
	                fechaVentaTexto = fechaVentaTexto.substring(0, 10);
	            }

	            Date fechaVenta = formato.parse(fechaVentaTexto);

	            if (!fechaVenta.before(fechaInicio) && !fechaVenta.after(fechaFin)) {
	                ventas.add(venta);
	            }
	        }

	        cargarVentasEnTabla();

	        JOptionPane.showMessageDialog(null, "Ventas filtradas correctamente.");

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al filtrar las ventas.");
	    }
	}
	
	private void verDetalleVentaSeleccionada() {

	    int filaSeleccionada = table.getSelectedRow();

	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar una venta de la tabla.");
	        return;
	    }

	    int idVenta = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());

	    String fecha = model.getValueAt(filaSeleccionada, 1).toString();
	    String totalNeto = model.getValueAt(filaSeleccionada, 2).toString();
	    String totalBruto = model.getValueAt(filaSeleccionada, 3).toString();
	    String cliente = model.getValueAt(filaSeleccionada, 4).toString();
	    String metodoPago = model.getValueAt(filaSeleccionada, 5).toString();
	    String descuento = model.getValueAt(filaSeleccionada, 6).toString();

	    String detalle = controllerVenta.mostrarDetalleVenta(idVenta);

	    String texto = "";

	    texto += "VENTA N° " + idVenta + "\n";
	    texto += "Fecha: " + fecha + "\n";
	    texto += "Cliente: " + cliente + "\n";
	    texto += "Método de pago: " + metodoPago + "\n";
	    texto += "Descuento: " + descuento + "\n";
	    texto += "Total bruto: $" + totalBruto + "\n";
	    texto += "Total neto: $" + totalNeto + "\n";
	    texto += "\nDETALLE DE PRODUCTOS:\n";
	    texto += detalle;

	    JOptionPane.showMessageDialog(
	            null,
	            texto,
	            "Detalle de venta",
	            JOptionPane.INFORMATION_MESSAGE
	    );
	}
	
	private void actualizarDiaSeleccionadoPorTabla() {

	    int filaSeleccionada = table.getSelectedRow();

	    if (filaSeleccionada == -1) {
	        lblDiaSeleccionado.setText("Sin seleccionar");
	        return;
	    }

	    String fechaVenta = model.getValueAt(filaSeleccionada, 1).toString();

	    if (fechaVenta.length() >= 10) {
	        fechaVenta = fechaVenta.substring(0, 10);
	    }

	    lblDiaSeleccionado.setText(fechaVenta);
	}
	
	private void actualizarTotales() {

	    double totalVendido = calcularTotalVendido();
	    int cantidadVentas = calcularCantidadVentas();

	    lblCantidadVentas.setText(String.valueOf(cantidadVentas));
	    lblTotalVendido.setText("$" + totalVendido);

	    if (table.getSelectedRow() == -1) {
	        lblDiaSeleccionado.setText("Sin seleccionar");
	    }
	}
	
	private double calcularTotalVendido() {

	    double totalVendido = 0;

	    for (Venta venta : ventas) {
	        totalVendido += venta.getTotal_neto();
	    }

	    return totalVendido;
	}

	private int calcularCantidadVentas() {

	    int cantidadVentas = 0;

	    for (Venta venta : ventas) {
	        cantidadVentas++;
	    }

	    return cantidadVentas;
	}
	
	
}