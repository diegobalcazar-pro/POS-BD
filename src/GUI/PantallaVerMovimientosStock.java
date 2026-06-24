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

import BLL.AuditoriaStock;
import DLL.ControllerAuditoriaStock;

public class PantallaVerMovimientosStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private JTextField inpFiltro;
    private ControllerAuditoriaStock controller = new ControllerAuditoriaStock();
	
	public PantallaVerMovimientosStock() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel lblProductos = new JLabel("Momiento de Stock:");
        lblProductos.setForeground(new Color(255, 255, 255));
        lblProductos.setBackground(new Color(255, 255, 255));
        lblProductos.setBounds(19, 66, 760, 20);
        contentPane.add(lblProductos);
        
        //defino el nombre qeu va a tener cada columna
        model = new DefaultTableModel(new String[]{"ID", "Movimiento", "Cantidad", "Fecha", "Variante", "Empleado", "Origen", "Destino"}, 0);
         table = new JTable(model);
        table.setBackground(new Color(248, 248, 255));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 87, 749, 200);
        contentPane.add(scrollPane);
        
        JButton filtrarProducto = new JButton("Buscar por tipo");
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
        filtrarProducto.setBounds(149, 353, 194, 23);
        contentPane.add(filtrarProducto);
        
        JButton btnFiltrarNombre = new JButton("Buscar por Deposito Origen");
        btnFiltrarNombre.setForeground(new Color(255, 255, 255));
        btnFiltrarNombre.setBackground(new Color(0, 128, 128));
        btnFiltrarNombre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	        		
        		if (inpFiltro.getText().isEmpty()) {
        			cargarTablaFiltrada("Buscar por Deposito Origen");
				}else {
        			cargarTablaFiltrada(inpFiltro.getText());
				}
        	}
        });
        btnFiltrarNombre.setBounds(150, 381, 193, 23);
        contentPane.add(btnFiltrarNombre);
        
        JButton btnLimpiarFiltro = new JButton("Limpiar busqueda");
        btnLimpiarFiltro.setForeground(new Color(255, 255, 255));
        btnLimpiarFiltro.setBackground(new Color(0, 128, 128));
        btnLimpiarFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cargarTabla();
        	}
        });
        btnLimpiarFiltro.setBounds(149, 412, 194, 23);
        contentPane.add(btnLimpiarFiltro);
        
        
        JLabel lblNewLabel = new JLabel("Buscar movimiento:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(148, 308, 135, 14);
        contentPane.add(lblNewLabel);
        
        inpFiltro = new JTextField();
        inpFiltro.setBounds(148, 322, 201, 20);
        contentPane.add(inpFiltro);
        inpFiltro.setColumns(10);

        //Muestra la Cargar datos en la tabla
        cargarTabla();
        
        //Titulo
        JLabel lblGestionProductos = new JLabel("Movimientos de Depositos");
        lblGestionProductos.setForeground(new Color(255, 250, 250));
        lblGestionProductos.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblGestionProductos.setBounds(242, 21, 313, 33);
    	contentPane.add(lblGestionProductos);
        
    	//Boton de salir
    	JButton btnSalir = new JButton("<- Salir");
    	btnSalir.setForeground(new Color(255, 255, 255));
    	btnSalir.setBackground(new Color(165, 42, 42));
    	btnSalir.setBounds(614, 326, 122, 33);
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
        LinkedList<AuditoriaStock> auditoriaStocks = controller.mostrarMovimientosStock();
        //recorro cada usuario
        for (AuditoriaStock u : auditoriaStocks) {
        	model.addRow(new Object[]{
    			    u.getid_auditoria_stock(),
    			    u.getTipo_movimiento(),
    			    u.getCantidad(),
    			    u.getFecha(),
    			    u.getVarianteproducto().getTalle(),
    			    u.getUsuario().getNombre_usuario(),
    			    u.getDepositoOrigen().getLugarDeposito(),
    			    u.getDepositoDestino().getLugarDeposito()
    			});
        }
        
    }
    private void cargarTablaFiltrada(String filtro) {
    	//vacia la tabla
        model.setRowCount(0);
        // traigo todos los productos
        LinkedList<AuditoriaStock> auditoriaStocks = controller.mostrarMovimientosStock();
        //recorro cada producto
        for (AuditoriaStock u : auditoriaStocks) {
        	if (u.getTipo_movimiento().equals(filtro) || u.getDepositoOrigen().getLugarDeposito().equals(filtro)) {
				
        		model.addRow(new Object[]{
        				u.getid_auditoria_stock(),
        			    u.getTipo_movimiento(),
        			    u.getCantidad(),
        			    u.getFecha(),
        			    u.getVarianteproducto().getTalle(),
        			    u.getUsuario().getNombre_usuario(),
        			    u.getDepositoOrigen().getLugarDeposito(),
        			    u.getDepositoDestino().getLugarDeposito()
        			});
			}
        }
    }
}