package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Venta;
import DLL.ControllerVenta;

public class PantallaInfoVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private JTextField inpFiltro;
    private ControllerVenta controller = new ControllerVenta();
    public PantallaInfoVentas() {
		
			setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 500);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);
	        
	        JLabel lblProductos = new JLabel("Historial de Ventas:");
	        lblProductos.setForeground(new Color(255, 255, 255));
	        lblProductos.setBackground(new Color(255, 255, 255));
	        lblProductos.setBounds(24, 67, 760, 20);
	        contentPane.add(lblProductos);
	        
	        //defino el nombre qeu va a tener cada columna
	        model = new DefaultTableModel(new String[]{ "ID", "Fecha", "Total Neto", "Total Bruto", "Empleado", "Cliente", "Medio de pago", "Descuento"}, 0);
	        
	        table = new JTable(model);
	        table.setBackground(new Color(248, 248, 255));
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(18, 87, 749, 200);
	        contentPane.add(scrollPane);

	        JButton btnMovimientos = new JButton("Top de Ventas");
	        btnMovimientos.setForeground(new Color(255, 255, 255));
	        btnMovimientos.setBackground(new Color(0, 128, 128));
	        btnMovimientos.setBounds(323, 326, 187, 33);
	        contentPane.add(btnMovimientos);
	        btnMovimientos.addActionListener(new ActionListener() {
	 		   public void actionPerformed(ActionEvent e) {
	 		     PantallaTopVentas nueva = new PantallaTopVentas();
	 		     nueva.setVisible(true);
	 		     dispose();
	 			   }
	 		    });
	        
	        JButton filtrarProducto = new JButton("Buscar por Cliente");
	        filtrarProducto.setForeground(new Color(255, 255, 255));
	        filtrarProducto.setBackground(new Color(0, 128, 128));
	        filtrarProducto.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {	        		
	        		if (inpFiltro.getText().isEmpty()) {
	        			cargarTablaFiltrada("Categoria");
					}else {
	        			cargarTablaFiltrada(inpFiltro.getText());
					}
	        	}
	        });	        
	        filtrarProducto.setBounds(73, 350, 162, 23);
	        contentPane.add(filtrarProducto);
	        
	        JButton btnFiltrarNombre = new JButton("Buscar por Empleado");
	        btnFiltrarNombre.setForeground(new Color(255, 255, 255));
	        btnFiltrarNombre.setBackground(new Color(0, 128, 128));
	        btnFiltrarNombre.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {	        		
	        		if (inpFiltro.getText().isEmpty()) {
	        			cargarTablaFiltrada("Nombre");
					}else {
	        			cargarTablaFiltrada(inpFiltro.getText());
					}
	        	}
	        });
	        btnFiltrarNombre.setBounds(74, 378, 161, 23);
	        contentPane.add(btnFiltrarNombre);
	        
	        JButton btnLimpiarFiltro = new JButton("Limpiar busqueda");
	        btnLimpiarFiltro.setForeground(new Color(255, 255, 255));
	        btnLimpiarFiltro.setBackground(new Color(0, 128, 128));
	        btnLimpiarFiltro.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cargarTabla();
	        	}
	        });
	        btnLimpiarFiltro.setBounds(73, 409, 162, 23);
	        contentPane.add(btnLimpiarFiltro);
	        
	        
	        JLabel lblNewLabel = new JLabel("Buscar venta:");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setBounds(72, 305, 135, 14);
	        contentPane.add(lblNewLabel);
	        
	        inpFiltro = new JTextField();
	        inpFiltro.setBounds(72, 319, 163, 20);
	        contentPane.add(inpFiltro);
	        inpFiltro.setColumns(10);

	        //Muestra la Cargar datos en la tabla
	        cargarTabla();
	        
	        //Titulo
	        JLabel lblGestionProductos = new JLabel("Información de Ventas");
	        lblGestionProductos.setForeground(new Color(255, 250, 250));
	        lblGestionProductos.setFont(new Font("Tahoma", Font.BOLD, 22));
	        lblGestionProductos.setBounds(275, 23, 273, 33);
	    	contentPane.add(lblGestionProductos);
	        
	    	//Boton de salir
	    	JButton btnSalir = new JButton("<- Salir");
	    	btnSalir.setForeground(new Color(255, 255, 255));
	    	btnSalir.setBackground(new Color(165, 42, 42));
	    	btnSalir.setBounds(612, 326, 122, 33);
	    	contentPane.add(btnSalir);
	    	
	    	//Imagen de Fondo
	        JLabel lblNewLabelFONDO = new JLabel("");
	        lblNewLabelFONDO.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabelFONDO.setIcon(new ImageIcon("src\\img\\FondoAdmin.jpg"));
	        lblNewLabelFONDO.setBounds(0, 0, 784, 461);
	    	contentPane.add(lblNewLabelFONDO);
	    	
	    }
	

	    private void cargarTabla() {
	    	//vacia la tabla
	        model.setRowCount(0);
	        // traigo todos los usuarios
	        LinkedList<Venta> ventas = controller.mostrarVentas();
	        //recorro cada usuario
	        for (Venta u : ventas) {
	        	model.addRow(new Object[]{
	    			    u.getid_venta(),
	    			    u.getFecha(),
	    			    u.getTotal_neto(),
	    			    u.getTotal_bruto(),
	    			    u.getUsuario().getNombre_usuario(),
	    			    u.getCliente().getNombre_cliente(),
	    			    u.getMetododepago().getTipo(),
	    			    u.getDescuento().getPorcentaje_descuento()
	    			});
	        }
	    }
	    private void cargarTablaFiltrada(String filtro) {
	    	//vacia la tabla
	        model.setRowCount(0);
	        // traigo todos los productos
	        LinkedList<Venta> ventas = controller.mostrarVentas();
	        //recorro cada producto
	        for (Venta u : ventas) {
	        	if (u.getCliente().getNombre_cliente().equals(filtro) || u.getUsuario().getNombre_usuario().equals(filtro)) {
					
	        		model.addRow(new Object[]{
	        				u.getid_venta(),
		    			    u.getFecha(),
		    			    u.getTotal_neto(),
		    			    u.getTotal_bruto(),
		    			    u.getUsuario().getNombre_usuario(),
		    			    u.getCliente().getNombre_cliente(),
		    			    u.getMetododepago().getTipo(),
		    			    u.getDescuento().getPorcentaje_descuento()
	        			});
				}
	        }
	    }
}