package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaGestionUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaGestionUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestión de Usuarios");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(152, 30, 166, 16);
		contentPane.add(lblNewLabel);
		
		//Ver Empleados
		JButton inpVerEmpleados = new JButton("Ver Empleados");
		inpVerEmpleados.setBounds(55, 86, 150, 29);
		contentPane.add(inpVerEmpleados);
		
		//Aãdir Empleado
		JButton inpAgregarEmpleado = new JButton("Añadir Empleado");
		inpAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inpAgregarEmpleado.setBounds(239, 86, 150, 29);
		contentPane.add(inpAgregarEmpleado);
		
		//Eliminar Empleado
		JButton inpEliminarEmpleado = new JButton("Eliminar Empleado");
		inpEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inpEliminarEmpleado.setBounds(239, 137, 150, 29);
		contentPane.add(inpEliminarEmpleado);
		
		//Editar Empleado
		JButton inpEditarEmpleado = new JButton("Editar Empleado");
		inpEditarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inpEditarEmpleado.setBounds(55, 137, 150, 29);
		contentPane.add(inpEditarEmpleado);
		
		//Salir 
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(128, 0, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalir.setBounds(164, 189, 117, 29);
		contentPane.add(btnSalir);

	}

}
