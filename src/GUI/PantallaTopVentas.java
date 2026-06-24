package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerCategoria;
import DLL.ControllerProducto;

public class PantallaTopVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCategoria;
	private JTable tableProducto;
	private DefaultTableModel modelCategoria;
	private DefaultTableModel modelProducto;
	private ControllerProducto controllerProducto = new ControllerProducto();
	private ControllerCategoria controllerCategoria = new ControllerCategoria();
	
	public PantallaTopVentas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel lblcategoriaMsVendida = new JLabel("Categoria más vendida:");
        lblcategoriaMsVendida.setForeground(new Color(255, 255, 255));
        lblcategoriaMsVendida.setBackground(new Color(255, 255, 255));
        lblcategoriaMsVendida.setBounds(34, 91, 273, 20);
        contentPane.add(lblcategoriaMsVendida);
        
        //defino el nombre qeu va a tener cada columna
        modelProducto = new DefaultTableModel(new String[]{ "ID",  "Producto", "Cantidad"}, 0);
        modelCategoria = new DefaultTableModel(new String[]{ "ID",  "Categoria"}, 0);
        
        tableProducto = new JTable(modelProducto);
        tableCategoria = new JTable(modelCategoria);
        tableProducto.setBackground(new Color(248, 248, 255));
        tableCategoria.setBackground(new Color(248, 248, 255));
        JScrollPane scrollPaneProducto = new JScrollPane(tableProducto);
        JScrollPane scrollPaneCategoria = new JScrollPane(tableCategoria);
        scrollPaneProducto.setBounds(382, 111, 363, 200);
        scrollPaneCategoria.setBounds(34, 111, 294, 200);
        contentPane.add(scrollPaneProducto);
        contentPane.add(scrollPaneCategoria);

        //Muestra la Cargar datos en la tabla
        cargarTablaTopProducto();
        cargarTablaTopCategoria();
        
        //Titulo
        JLabel lblGestionProductos = new JLabel("TOP de Ventas");
        lblGestionProductos.setForeground(new Color(255, 250, 250));
        lblGestionProductos.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblGestionProductos.setBounds(281, 31, 168, 33);
    	contentPane.add(lblGestionProductos);
        
    	JLabel lblProductoMsVendido = new JLabel("Producto más vendido:");
    	lblProductoMsVendido.setForeground(Color.WHITE);
    	lblProductoMsVendido.setBackground(Color.WHITE);
    	lblProductoMsVendido.setBounds(372, 91, 273, 20);
    	contentPane.add(lblProductoMsVendido);
    	
    	//Boton de salir
    	JButton btnSalir = new JButton("<- Salir");
    	btnSalir.setForeground(new Color(255, 255, 255));
    	btnSalir.setBackground(new Color(165, 42, 42));
    	btnSalir.setBounds(281, 359, 122, 33);
    	contentPane.add(btnSalir);
    	
    	//Imagen de Fondo
        JLabel lblNewLabelFONDO = new JLabel("");
        lblNewLabelFONDO.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabelFONDO.setIcon(new ImageIcon("src\\img\\FondoAdmin.jpg"));
        lblNewLabelFONDO.setBounds(0, 0, 784, 461);
    	contentPane.add(lblNewLabelFONDO);
    	
    }

	
    private void cargarTablaTopCategoria() {
        modelCategoria.setRowCount(0);
        LinkedList<Object[]> categorias = controllerCategoria.MostrarCategoriasMasVendidasLista();
        for(Object[] fila : categorias){
            modelCategoria.addRow(fila);
        }
    }
        
   
    private void cargarTablaTopProducto(){
        modelProducto.setRowCount(0);
        LinkedList<Object[]> productos = controllerProducto.MostrarProductosMasVendidosLista();
        for(Object[] fila : productos){
            modelProducto.addRow(fila);

        }
    }
}