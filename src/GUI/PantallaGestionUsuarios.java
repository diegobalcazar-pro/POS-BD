package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Usuario;
import DLL.ControllerUsuario;

import BLL.Admin;
import BLL.Cajero;
import BLL.Repositor;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;

public class PantallaGestionUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private Usuario usuarioSeleccionado;
    private JTextField inpFiltro;
    private ControllerUsuario controller = new ControllerUsuario();
	
	public PantallaGestionUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        
        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setForeground(new Color(255, 255, 255));
        lblSeleccionado.setBackground(new Color(255, 255, 255));
        lblSeleccionado.setBounds(10, 67, 760, 20);
        contentPane.add(lblSeleccionado);
        //si lo adapto, primero cambio las columnas -> depende de cada tabla 
        
        //defino el nombre qeu va a tener cada columna
        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Email", "Rol"}, 0);
        
        table = new JTable(model);
        table.setBackground(new Color(248, 248, 255));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 87, 760, 200);
        contentPane.add(scrollPane);
        //botones
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setForeground(new Color(255, 255, 255));
        btnAgregar.setBackground(new Color(0, 128, 128));
        btnAgregar.setBounds(235, 326, 122, 33);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setForeground(new Color(255, 255, 255));
        btnEditar.setBackground(new Color(0, 128, 128));
        btnEditar.setBounds(367, 326, 122, 33);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(new Color(255, 255, 255));
        btnEliminar.setBackground(new Color(0, 128, 128));
        btnEliminar.setBounds(499, 326, 122, 33);
        contentPane.add(btnEliminar);
        
        JButton filtrarEmpleado = new JButton("Buscar por Rol");
        filtrarEmpleado.setForeground(new Color(255, 255, 255));
        filtrarEmpleado.setBackground(new Color(0, 128, 128));
        filtrarEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (inpFiltro.getText().isEmpty()) {
        			cargarTablaFiltrada("Rol");
				}else {
        			cargarTablaFiltrada(inpFiltro.getText());

				}
        	}
        });
        filtrarEmpleado.setBounds(31, 350, 152, 23);
        contentPane.add(filtrarEmpleado);
        
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
        btnFiltrarNombre.setBounds(31, 379, 152, 23);
        contentPane.add(btnFiltrarNombre);
        
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
        
        JLabel lblNewLabel = new JLabel("Buscar usuario:");
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
                	usuarioSeleccionado = new Admin(
                		    (int) model.getValueAt(row, 0),
                		    (String) model.getValueAt(row, 1),
                		    (String) model.getValueAt(row, 2),
                		    (String) model.getValueAt(row, 3),
                		    "",
                		    "admin"
                		);
                	
                    lblSeleccionado.setText("Seleccionado: ID=" 
                    + usuarioSeleccionado.getId_usuario()
                    + ", Nombre=" + usuarioSeleccionado.getNombre_usuario()
                    + ", Nombre=" + usuarioSeleccionado.getApellido_usuario()
                    + ", Email=" + usuarioSeleccionado.getCorreo()
                    + ", Tipo=" + usuarioSeleccionado.getRol());
                }
            }
        });

        // Cargar datos
        cargarTabla();

        // Acción: Agregar usuario
        btnAgregar.addActionListener(e -> {
            JTextField nombreField = new JTextField();
            JTextField apellidoField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField rolField = new JTextField();
            JPasswordField passwordField = new JPasswordField();

            Object[] fields = {
                "Nombre:", nombreField,
                "Apellido", apellidoField,
                "Email:", emailField,
                "Rol:", rolField,
                "Contraseña:", passwordField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Usuario", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
            	
            	String rol = rolField.getText().toLowerCase();
            	
            	Usuario nuevo;

            	if (rol.equals("admin")) {

            	    nuevo = new Admin(
            	        0,
            	        nombreField.getText(),
            	        apellidoField.getText(),
            	        emailField.getText(),
            	        new String(passwordField.getPassword()),
            	        "admin"
            	    );


            	} else if (rol.equals("cajero")) {

            	    nuevo = new Cajero(
            	        0,
            	        nombreField.getText(),
            	        apellidoField.getText(),
            	        emailField.getText(),
            	        new String(passwordField.getPassword()),
            	        "cajero"
            	    );


            	} else if (rol.equals("repositor")) {

            	    nuevo = new Repositor(
            	        0,
            	        nombreField.getText(),
            	        apellidoField.getText(),
            	        emailField.getText(),
            	        new String(passwordField.getPassword()),
            	        "repositor"
            	    );


            	} else {

            	    JOptionPane.showMessageDialog(null, "Ingrese un rol válido: admin, cajero o repositor");
            	    return;
            	}
       
                ControllerUsuario controller = new ControllerUsuario();
                controller.agregarUsuario(nuevo);
                cargarTabla();
            }
        });

        // Acción: Editar usuario
        btnEditar.addActionListener(e -> {

            if (usuarioSeleccionado != null) {

                JTextField nombre = new JTextField(usuarioSeleccionado.getNombre_usuario());
                JTextField apellido = new JTextField(usuarioSeleccionado.getApellido_usuario());
                JTextField correo = new JTextField(usuarioSeleccionado.getCorreo());
                JTextField rol = new JTextField(usuarioSeleccionado.getRol());

                Object[] campos = {
                    "Nombre:", nombre,
                    "Apellido:", apellido,
                    "Correo:", correo,
                    "Rol:", rol
                };

                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        campos,
                        "Editar Usuario",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (opcion == JOptionPane.OK_OPTION) {

                    usuarioSeleccionado.setNombre_usuario(nombre.getText());
                    usuarioSeleccionado.setApellido_usuario(apellido.getText());
                    usuarioSeleccionado.setCorreo(correo.getText());
                    usuarioSeleccionado.setRol(rol.getText());

                    controller.EditarUsuario(usuarioSeleccionado);

                    JOptionPane.showMessageDialog(null, "Usuario editado correctamente");

                    cargarTabla();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
            }

        });

        // Acción: Eliminar usuario
        btnEliminar.addActionListener(e -> {
            if (usuarioSeleccionado != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar a " + usuarioSeleccionado.getNombre_usuario() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    
                    ControllerUsuario.EliminarUsuario(usuarioSeleccionado.getCorreo());
                    cargarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("Gestion de Usuarios");
        lblNewLabel_1.setForeground(new Color(255, 250, 250));
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
    	lblNewLabel_1.setBounds(275, 23, 235, 33);
    	contentPane.add(lblNewLabel_1);
        
    	JButton btnSalir = new JButton("<- Salir");
    	btnSalir.setForeground(new Color(255, 255, 255));
    	btnSalir.setBackground(new Color(165, 42, 42));
    	btnSalir.setBounds(631, 326, 122, 33);
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
        LinkedList<Usuario> usuarios = controller.mostrarUsuarios();
        //recorro cada usuario
        for (Usuario u : usuarios) {
        	//Si cambio el formato, acà tambièn cambia
        	//da el formato de la tabla a los datos
        	model.addRow(new Object[]{
    			    u.getId_usuario(),
    			    u.getNombre_usuario(),
    			    u.getApellido_usuario(),
    			    u.getCorreo(),
    			    u.getRol()
    			});
        }
    }
    private void cargarTablaFiltrada(String filtro) {
    	//vacia la tabla
        model.setRowCount(0);
        //???? traigo todos los usuarios
        LinkedList<Usuario> usuarios = controller.mostrarUsuarios();
        //recorro cada usuario
        for (Usuario u : usuarios) {
        	if (u.getRol().equals(filtro) || u.getNombre_usuario().equals(filtro) || u.getRol().startsWith(filtro)) {
				
        		model.addRow(new Object[]{
        			    u.getId_usuario(),
        			    u.getNombre_usuario(),
        			    u.getApellido_usuario(),
        			    u.getCorreo(),
        			    u.getRol()
        			});
			}
        }
    }
}
