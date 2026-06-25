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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Descuento;
import DLL.ControllerDescuento;

public class PantallaConfiDescuentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private Descuento descuentoSeleccionado;  
    private JTextField inpFiltro;
    private ControllerDescuento controller = new ControllerDescuento();
	
	public PantallaConfiDescuentos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        
        JLabel lblSeleccionado = new JLabel("Descuento Seleccionado:");
        lblSeleccionado.setForeground(new Color(255, 255, 255));
        lblSeleccionado.setBackground(new Color(255, 255, 255));
        lblSeleccionado.setBounds(10, 67, 760, 20);
        contentPane.add(lblSeleccionado);
         
        
        //defino el nombre qeu va a tener cada columna
        model = new DefaultTableModel(new String[]{"Id", "Nombre Descuento", "Porcentaje de Descuento %"}, 0);
        
        table = new JTable(model);
        table.setBackground(new Color(248, 248, 255));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 87, 760, 200);
        contentPane.add(scrollPane);
        
        //botones
        JButton btnAgregar = new JButton("Agregar Descuento");
        btnAgregar.setForeground(new Color(255, 255, 255));
        btnAgregar.setBackground(new Color(0, 128, 128));
        btnAgregar.setBounds(234, 326, 131, 33);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar Descuento");
        btnEditar.setForeground(new Color(255, 255, 255));
        btnEditar.setBackground(new Color(0, 128, 128));
        btnEditar.setBounds(375, 326, 131, 33);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar Descuento");
        btnEliminar.setForeground(new Color(255, 255, 255));
        btnEliminar.setBackground(new Color(0, 128, 128));
        btnEliminar.setBounds(516, 326, 131, 33);
        contentPane.add(btnEliminar);
        
        JButton filtrarDescuento = new JButton("Buscar por Nombre");
        filtrarDescuento.setFont(new Font("Tahoma", Font.PLAIN, 10));
        filtrarDescuento.setForeground(new Color(255, 255, 255));
        filtrarDescuento.setBackground(new Color(0, 128, 128));
        filtrarDescuento.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (inpFiltro.getText().isEmpty()) {
        			cargarTablaFiltrada("nombre_descuento");
				}else {
        			cargarTablaFiltrada(inpFiltro.getText());

				}
        	}
        });
        filtrarDescuento.setBounds(31, 350, 152, 23);
        contentPane.add(filtrarDescuento);
        
        JButton filtrarPorcentaje = new JButton("Buscar por porcentaje");
        filtrarPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
        filtrarPorcentaje.setForeground(new Color(255, 255, 255));
        filtrarPorcentaje.setBackground(new Color(0, 128, 128));
        filtrarPorcentaje.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (inpFiltro.getText().isEmpty()) {
        			cargarTablaFiltrada("Nombre");
				}else {
        			cargarTablaFiltrada(inpFiltro.getText());
				}
        	}
        });
        filtrarPorcentaje.setBounds(31, 379, 152, 23);
        contentPane.add(filtrarPorcentaje);
        
        JButton btnLimpiarFiltro = new JButton("Limpiar busqueda");
        btnLimpiarFiltro.setForeground(new Color(255, 255, 255));
        btnLimpiarFiltro.setBackground(new Color(0, 128, 128));
        btnLimpiarFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cargarTabla();
        	}
        });
        btnLimpiarFiltro.setBounds(31, 409, 152, 23);
        contentPane.add(btnLimpiarFiltro);
        
        JLabel lblNewLabel = new JLabel("Buscar Descuento:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(31, 305, 96, 14);
        contentPane.add(lblNewLabel);
        
        inpFiltro = new JTextField();
        inpFiltro.setBounds(30, 319, 153, 20);
        contentPane.add(inpFiltro);
        inpFiltro.setColumns(10);

        // Acción al seleccionar fila
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
            	//la talba tiene un evento, que escucha que elemento seleccione(fila)
                int row = table.getSelectedRow();
                if (row != -1) {
                	descuentoSeleccionado = new Descuento(
                		    (int) model.getValueAt(row, 0),
                		    (String) model.getValueAt(row, 1),
                		    (Double) model.getValueAt(row, 2)
                		);
                	
                    lblSeleccionado.setText("Seleccionado: ID=" 
                    + descuentoSeleccionado.getId_descuento()
                    + ", Nombre=" + descuentoSeleccionado.getNombre_descuento()
                    + ", Porcentaje=" + descuentoSeleccionado.getPorcentaje_descuento());
                }
            }
        });

        // Cargar datos
        cargarTabla();

        // Acción: Agregar usuario
        btnAgregar.addActionListener(e -> {
            JTextField nombreField = new JTextField();
            JTextField porcentajeField = new JTextField();

            Object[] fields = {
                "Nombre:", nombreField,
                "Porcentaje", porcentajeField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Descuento", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
            	Double porcentaje_descuento = Double.parseDouble(porcentajeField.getText());
            	
            	Descuento nuevo;

            	if (porcentaje_descuento >= 0 && porcentaje_descuento <= 90) {

            	    nuevo = new Descuento(
            	        0,
            	        nombreField.getText(),
            	        porcentaje_descuento
            	    );


            	} else {

            	    JOptionPane.showMessageDialog(null, "Ingrese un valor no válido: 0 a 90 %");
            	    return;
            	}
       
                ControllerDescuento controller = new ControllerDescuento();
                controller.agregarDescuento(nuevo);
                cargarTabla();
            }
        });

        // Acción: Editar descuento
        btnEditar.addActionListener(e -> {

            if (descuentoSeleccionado != null) {

                JTextField nombre = new JTextField(descuentoSeleccionado.getNombre_descuento());
                JTextField porcentaje = new JTextField(String.valueOf(descuentoSeleccionado.getPorcentaje_descuento()));
       
                    Object[] campos = {
                    	    "Nombre:", nombre,
                    	    "Porcentaje:", porcentaje
                     };

                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        campos,
                        "Editar descuento",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (opcion == JOptionPane.OK_OPTION) {
                	descuentoSeleccionado.setPorcentaje_descuento( Double.parseDouble(porcentaje.getText()));
                    descuentoSeleccionado.setNombre_descuento(nombre.getText());

                    controller.EditarDescuento(descuentoSeleccionado);

                    JOptionPane.showMessageDialog(null, "Descuento editado correctamente");

                    cargarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Descuento.");
            }
        });

        // Acción: Eliminar descuento
        btnEliminar.addActionListener(e -> {
            if (descuentoSeleccionado != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar a " + descuentoSeleccionado.getNombre_descuento() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                	controller.EliminarDescuento(descuentoSeleccionado.getNombre_descuento());
                    cargarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("Gestión de Descuentos");
        lblNewLabel_1.setForeground(new Color(255, 250, 250));
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
    	lblNewLabel_1.setBounds(275, 23, 274, 33);
    	contentPane.add(lblNewLabel_1);
        
    	JButton btnSalir = new JButton("<- Salir");
    	btnSalir.setForeground(new Color(255, 255, 255));
    	btnSalir.setBackground(new Color(165, 42, 42));
    	btnSalir.setBounds(657, 326, 96, 33);
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
        // traigo todos los descuentos
        LinkedList<Descuento> descuentos = controller.mostrarDescuentos();
        //recorro cada descuento
        for (Descuento u : descuentos) {
        	//Si cambio el formato, acà tambièn cambia
        	//da el formato de la tabla a los datos
        	model.addRow(new Object[]{
        			u.getId_descuento(),
    			    u.getNombre_descuento(),
    			    u.getPorcentaje_descuento()
    			});
        }
    }
    private void cargarTablaFiltrada(String filtro) {
    	//vacia la tabla
        model.setRowCount(0);
        //???? traigo todos los descuentos
        LinkedList<Descuento> descuentos = controller.mostrarDescuentos();
        //recorro cada descuento
        for (Descuento u : descuentos) {
        	if (u.getNombre_descuento().equalsIgnoreCase(filtro) || String.valueOf(u.getPorcentaje_descuento()).equals(filtro)) {
				
        		model.addRow(new Object[]{
        			    u.getId_descuento(),
        			    u.getNombre_descuento(),
        			    u.getPorcentaje_descuento()
        			});
			}
        }
    }
}