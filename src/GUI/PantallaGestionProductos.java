package GUI;

import java.awt.Color;
import java.awt.EventQueue;
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

import BLL.Producto;
import BLL.Usuario;
import DLL.ControllerProducto;

public class PantallaGestionProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private JTextField inpFiltro;
    private ControllerProducto controller = new ControllerProducto();
	
	public PantallaGestionProductos() {
		
		
	
			setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 500);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);
	        
	        
	        JLabel lblSeleccionado = new JLabel("Productos:");
	        lblSeleccionado.setForeground(new Color(255, 255, 255));
	        lblSeleccionado.setBackground(new Color(255, 255, 255));
	        lblSeleccionado.setBounds(19, 66, 760, 20);
	        contentPane.add(lblSeleccionado);
	        
	        
	        //defino el nombre qeu va a tener cada columna
	        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Descripción", "Categoria", "Proveedor"}, 0);
	        
	        table = new JTable(model);
	        table.setBackground(new Color(248, 248, 255));
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(18, 87, 749, 200);
	        contentPane.add(scrollPane);

	        JButton btnMovimientos = new JButton("Movimientos de sock");
	        btnMovimientos.setForeground(new Color(255, 255, 255));
	        btnMovimientos.setBackground(new Color(0, 128, 128));
	        btnMovimientos.setBounds(323, 326, 187, 33);
	        contentPane.add(btnMovimientos);
	        
	        JButton filtrarProducto = new JButton("Buscar por Categoria");
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
	        filtrarProducto.setBounds(73, 350, 152, 23);
	        contentPane.add(filtrarProducto);
	        
	        JButton btnFiltrarNombre = new JButton("Buscar por Nombre");
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
	        btnFiltrarNombre.setBounds(74, 378, 152, 23);
	        contentPane.add(btnFiltrarNombre);
	        
	        JButton btnLimpiarFiltro = new JButton("Limpiar busqueda");
	        btnLimpiarFiltro.setForeground(new Color(255, 255, 255));
	        btnLimpiarFiltro.setBackground(new Color(0, 128, 128));
	        btnLimpiarFiltro.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cargarTabla();
	        	}
	        });
	        btnLimpiarFiltro.setBounds(73, 409, 152, 23);
	        contentPane.add(btnLimpiarFiltro);
	        
	        
	        JLabel lblNewLabel = new JLabel("Buscar producto:");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setBounds(72, 305, 135, 14);
	        contentPane.add(lblNewLabel);
	        
	        inpFiltro = new JTextField();
	        inpFiltro.setBounds(72, 319, 153, 20);
	        contentPane.add(inpFiltro);
	        inpFiltro.setColumns(10);

	     // Cargar datos
	        cargarTabla();
	        
	        JLabel lblGestionProductos = new JLabel("Gestion de Productos");
	        lblGestionProductos.setForeground(new Color(255, 250, 250));
	        lblGestionProductos.setFont(new Font("Tahoma", Font.BOLD, 22));
	        lblGestionProductos.setBounds(275, 23, 235, 33);
	    	contentPane.add(lblGestionProductos);
	        
	    	JButton btnSalir = new JButton("<- Salir");
	    	btnSalir.setForeground(new Color(255, 255, 255));
	    	btnSalir.setBackground(new Color(165, 42, 42));
	    	btnSalir.setBounds(612, 326, 122, 33);
	    	contentPane.add(btnSalir);
	    	
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
	        LinkedList<Producto> productos = controller.mostrarProductos();
	        //recorro cada usuario
	        for (Producto u : productos) {
	        	model.addRow(new Object[]{
	    			    u.getid_producto(),
	    			    u.getNombre_producto(),
	    			    u.getDescripcion_producto(),
	    			    u.getCategoria().getNombre_categoria(),
	    			    u.getProveedor().getNombreEmpresa()
	    			});
	        }
	    }
	    private void cargarTablaFiltrada(String filtro) {
	    	//vacia la tabla
	        model.setRowCount(0);
	        // traigo todos los productos
	        LinkedList<Producto> productos = controller.mostrarProductos();
	        //recorro cada producto
	        for (Producto u : productos) {
	        	if (u.getCategoria().equals(filtro) || u.getNombre_producto().equals(filtro) /*|| u.getProveedor().startsWith(filtro)*/) {
					
	        		model.addRow(new Object[]{
	        			    u.getid_producto(),
	        			    u.getNombre_producto(),
	        			    u.getDescripcion_producto(),
	        			    u.getCategoria().getNombre_categoria(),
	        			    u.getProveedor().getNombreEmpresa()
	        			});
				}
	        }
	    }
}