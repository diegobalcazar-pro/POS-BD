package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaConfiDescuentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaConfiDescuentos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configurar Descuentos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(133, 31, 191, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnVerDescuentos = new JButton("Ver Descuentos");
		btnVerDescuentos.setBounds(49, 104, 156, 29);
		contentPane.add(btnVerDescuentos);
		
		JButton btnAgregarDescuentos = new JButton("Agregar Descuentos");
		btnAgregarDescuentos.setBounds(238, 104, 156, 29);
		contentPane.add(btnAgregarDescuentos);
		
		JButton btnEliminarDescuentos = new JButton("Eliminar Descuentos");
		btnEliminarDescuentos.setBounds(49, 167, 156, 29);
		contentPane.add(btnEliminarDescuentos);
		
		JButton btnSalir = new JButton("<- Salir");
		btnSalir.setBounds(262, 167, 117, 29);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				 PantallaConfiguracion nueva = new PantallaConfiguracion();
			     nueva.setVisible(true);
			     dispose();
				   }
			    });

	}

}
