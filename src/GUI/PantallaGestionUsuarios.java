package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 10, 760, 20);
        contentPane.add(lblSeleccionado);
        //si lo adapto, primero cambio las columnas -> depende de cada tabla 
        
        //defino el nombre qeu va a tener cada columna
        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Email", "Tipo"}, 0);
        
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 760, 200);
        contentPane.add(scrollPane);
        //botones
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 270, 150, 40);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(170, 270, 150, 40);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(330, 270, 150, 40);
        contentPane.add(btnEliminar);
        
        JButton filtrarEmpleado = new JButton("Filtrar Empleado");
        filtrarEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (inpFiltro.getText().isEmpty()) {
        			cargarTablaFiltrada("Usuario");
				}else {
        			cargarTablaFiltrada(inpFiltro.getText());

				}
        		
        		
        	}
        });
        filtrarEmpleado.setBounds(502, 270, 150, 40);
        contentPane.add(filtrarEmpleado);
        
        JButton btnFiitrarAdmin = new JButton("Fiitrar Admin");
        btnFiitrarAdmin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		cargarTablaFiltrada("Admin");

        	}
        });
        btnFiitrarAdmin.setBounds(502, 335, 150, 40);
        contentPane.add(btnFiitrarAdmin);
        
        JButton btnLimpiarFiltro = new JButton("Limpiar filtro");
        btnLimpiarFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cargarTabla();
        	}
        });
        btnLimpiarFiltro.setBounds(502, 410, 150, 40);
        contentPane.add(btnLimpiarFiltro);
        
        JLabel lblNewLabel = new JLabel("filtro");
        lblNewLabel.setBounds(668, 270, 46, 14);
        contentPane.add(lblNewLabel);
        
        inpFiltro = new JTextField();
        inpFiltro.setBounds(666, 308, 86, 20);
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
            JTextField emailField = new JTextField();
            JTextField tipoField = new JTextField();
            JPasswordField passwordField = new JPasswordField();

            Object[] fields = {
                "Nombre:", nombreField,
                "Email:", emailField,
                "Tipo:", tipoField,
                "Contraseña:", passwordField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Usuario", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
            	Usuario nuevo = new Admin(
            	        0,
            	        nombreField.getText(),
            	        "apellido",
            	        emailField.getText(),
            	        new String(passwordField.getPassword()),
            	        "admin"
            	);
            

                ControllerUsuario controller = new ControllerUsuario();
                controller.agregarUsuario(nuevo);
                cargarTabla();
            }
        });

        // Acción: Editar usuario
        btnEditar.addActionListener(e -> {
            if (usuarioSeleccionado != null) {
                JOptionPane.showMessageDialog(null, "Editar lógica aún no implementada para: " + usuarioSeleccionado.getNombre_usuario());
                // Podrías abrir otro JFrame con los campos prellenados
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
            }
        });

        // Acción: Eliminar usuario
        btnEliminar.addActionListener(e -> {
            if (usuarioSeleccionado != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar a " + usuarioSeleccionado.getNombre_usuario() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Asumimos que hay un método DLLUsuario.eliminarUsuario(id)
                    JOptionPane.showMessageDialog(null, "Función de eliminación aún no implementada.");
                    // DLLUsuario.eliminarUsuario(usuarioSeleccionado.getId());
                    cargarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario.");
            }
        });
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
            model.addRow(new Object[]{u.getId_usuario(), u.getNombre_usuario(), u.getRol(), u.getRol()});
        }
    }
    private void cargarTablaFiltrada(String filtro) {
    	//vacia la tabla
        model.setRowCount(0);
        //???? traigo todos los usuarios
        LinkedList<Usuario> usuarios = controller.mostrarUsuarios();
        //recorro cada usuario
        for (Usuario u : usuarios) {
        	if (u.getRol().equals(filtro) || u.getRol().equals(filtro) || u.getRol().startsWith(filtro)) {
				
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
