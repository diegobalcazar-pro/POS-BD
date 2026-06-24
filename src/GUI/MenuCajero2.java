package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Admin;
import BLL.Cajero;
import BLL.Producto;
import BLL.Repositor;
import BLL.Usuario;
import BLL.VarianteProducto;
import DLL.ControllerProducto;
import DLL.ControllerUsuario;
import DLL.ControllerVarianteProducto;

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

public class MenuCajero2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField inpEmail;
	
    private DefaultTableModel model;
    private Usuario usuarioSeleccionado;
    private JTextField inpFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCajero2 frame = new MenuCajero2(null);
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
	public MenuCajero2(Usuario logueado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				inpEmail = new JTextField();
				inpEmail.setToolTipText("correo");
				inpEmail.setBounds(213, 142, 179, 27);
				contentPane.add(inpEmail);
				inpEmail.setColumns(10);

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
								
								Button button = new Button("Realizar Venta");
								button.setFont(new Font("Ebrima", Font.BOLD, 13));
								button.setForeground(new Color(255, 255, 255));
								button.setBackground(new Color(128, 0, 0));
								button.setActionCommand("Realizar Venta");
								button.setBounds(10, 96, 169, 44);
								contentPane.add(button);
								
								Button button_1 = new Button("Ver Ventas");
								button_1.setForeground(Color.WHITE);
								button_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1.setBackground(new Color(128, 0, 0));
								button_1.setActionCommand("Cerrar Sesion");
								button_1.setBounds(10, 156, 169, 44);
								contentPane.add(button_1);
								
								Button button_1_1 = new Button("Nuevo Cliente");
								button_1_1.setForeground(Color.WHITE);
								button_1_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1_1.setBackground(new Color(128, 0, 0));
								button_1_1.setActionCommand("Cerrar Sesion");
								button_1_1.setBounds(10, 276, 169, 44);
								contentPane.add(button_1_1);
								
								Button button_2 = new Button("Ver Caja");
								button_2.setForeground(Color.WHITE);
								button_2.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_2.setBackground(new Color(128, 0, 0));
								button_2.setActionCommand("Cerrar Sesion");
								button_2.setBounds(10, 216, 169, 44);
								contentPane.add(button_2);
								
								Button button_1_1_1 = new Button("Cerrar Sesion");
								button_1_1_1.setForeground(Color.WHITE);
								button_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1_1_1.setBackground(new Color(128, 0, 0));
								button_1_1_1.setActionCommand("Cerrar Sesion");
								button_1_1_1.setBounds(10, 464, 169, 27);
								contentPane.add(button_1_1_1);
								
								Button button_2_1 = new Button("Imprimir Ticket");
								button_2_1.setForeground(Color.WHITE);
								button_2_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_2_1.setBackground(new Color(128, 0, 0));
								button_2_1.setActionCommand("Cerrar Sesion");
								button_2_1.setBounds(10, 396, 169, 44);
								contentPane.add(button_2_1);
								
								Button button_1_2 = new Button("Cerrar Caja");
								button_1_2.setForeground(Color.WHITE);
								button_1_2.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1_2.setBackground(new Color(128, 0, 0));
								button_1_2.setActionCommand("Cerrar Sesion");
								button_1_2.setBounds(10, 336, 169, 44);
								contentPane.add(button_1_2);
								
										JLabel lblNewLabel_1 = new JLabel("Bienvenido, "+ logueado.getNombre_usuario());
										lblNewLabel_1.setBounds(477, 17, 202, 30);
										contentPane.add(lblNewLabel_1);
										lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_1.setForeground(new Color(255, 255, 255));
										lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 11));
										
										JLabel lblNewLabel_1_3 = new JLabel(logueado.getRol());
										lblNewLabel_1_3.setBounds(502, 36, 93, 27);
										contentPane.add(lblNewLabel_1_3);
										lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_1_3.setForeground(Color.WHITE);
										lblNewLabel_1_3.setFont(new Font("Nirmala UI", Font.BOLD, 12));
										
										Button button_3 = new Button("Seleccionar");
										button_3.setBounds(396, 144, 70, 22);
										contentPane.add(button_3);
										
										Button button_4 = new Button("X");
										button_4.setForeground(new Color(128, 0, 0));
										button_4.setFont(new Font("Dialog", Font.BOLD, 26));
										button_4.setBounds(213, 442, 60, 60);
										contentPane.add(button_4);
										
										Button button_4_1 = new Button("+");
										button_4_1.setForeground(new Color(0, 128, 0));
										button_4_1.setFont(new Font("Dialog", Font.BOLD, 37));
										button_4_1.setBounds(572, 442, 60, 60);
										contentPane.add(button_4_1);
										
										Button button_4_1_1 = new Button("%");
										button_4_1_1.setForeground(new Color(0, 0, 0));
										button_4_1_1.setFont(new Font("Dialog", Font.BOLD, 32));
										button_4_1_1.setBounds(502, 442, 60, 60);
										contentPane.add(button_4_1_1);
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(213, 189, 497, 179);
										contentPane.add(scrollPane);
										
										model = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Cantidad"}, 0);
										table = new JTable(model);
										scrollPane.setViewportView(table);
										contentPane.add(scrollPane);
										
										cargarTabla();
										
										
										JLabel lblNewLabel_3 = new JLabel("SUBTOTAL:");
										lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 11));
										lblNewLabel_3.setBounds(238, 374, 93, 22);
										contentPane.add(lblNewLabel_3);
										
										JLabel lblNewLabel_3_1 = new JLabel("DESCUENTO:");
										lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 11));
										lblNewLabel_3_1.setBounds(238, 394, 93, 22);
										contentPane.add(lblNewLabel_3_1);
										
										JLabel lblNewLabel_3_1_1 = new JLabel("TOTAL:");
										lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
										lblNewLabel_3_1_1.setBounds(238, 414, 93, 22);
										contentPane.add(lblNewLabel_3_1_1);
										
										JLabel lblNewLabel_3_2 = new JLabel("ITEMS:");
										lblNewLabel_3_2.setFont(new Font("Verdana", Font.BOLD, 11));
										lblNewLabel_3_2.setBounds(519, 374, 93, 22);
										contentPane.add(lblNewLabel_3_2);
										
										Button button_4_1_2 = new Button("COBRAR");
										button_4_1_2.setForeground(new Color(64, 0, 0));
										button_4_1_2.setFont(new Font("Dialog", Font.BOLD, 13));
										button_4_1_2.setBounds(650, 442, 60, 60);
										contentPane.add(button_4_1_2);
										
										JSeparator separator = new JSeparator();
										separator.setOrientation(SwingConstants.VERTICAL);
										separator.setToolTipText("|");
										separator.setForeground(new Color(0, 0, 0));
										separator.setBackground(new Color(0, 0, 0));
										separator.setBounds(640, 447, 26, 49);
										contentPane.add(separator);
										
										JPanel panel = new JPanel();
										panel.setBackground(new Color(64, 0, 0));
										panel.setBounds(183, 1, 543, 75);
										contentPane.add(panel);
										
										JLabel lblNewLabel = new JLabel("");
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel.setIcon(new ImageIcon("src\\\\img\\\\logo.png"));
										
										JLabel lblNewLabel_1_4 = new JLabel(LocalDate.now().getDayOfWeek().toString()+" | "+LocalDate.now().toString()+" | "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+"hs");
										lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_1_4.setForeground(Color.WHITE);
										lblNewLabel_1_4.setFont(new Font("Dubai", Font.BOLD, 13));
										GroupLayout gl_panel = new GroupLayout(panel);
										gl_panel.setHorizontalGroup(
											gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup()
													.addContainerGap()
													.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
													.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
													.addGap(21))
										);
										gl_panel.setVerticalGroup(
											gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
													.addContainerGap(15, Short.MAX_VALUE)
													.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
													.addContainerGap())
										);
										panel.setLayout(gl_panel);
										
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
		
		/*
		JButton btnRegistrar = new JButton("registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DLLUsuario controller = new DLLUsuario();
				controller.Registrarse(new Usuario("ghami","ghami@gmail.com","Profesor","1234"));
			}
		});
		btnRegistrar.setBounds(184, 452, 121, 23);
		contentPane.add(btnRegistrar);
*/
		
	}
	
	
	private void cargarTabla() {
    	//vacia la tabla
        model.setRowCount(0);
        //???? traigo todos los productos
        LinkedList<Producto> productos = ControllerProducto.mostrarProductos();

        		
        //recorro cada Producto
        for (Producto p : productos) {
        	//Si cambio el formato, acà tambièn cambia
        	//da el formato de la tabla a los datos
            model.addRow(new Object[]{p.getid_producto(), p.getNombre_producto(), p.getProveedor(), p.getNombre_producto()});
        }
    }
	
	
}