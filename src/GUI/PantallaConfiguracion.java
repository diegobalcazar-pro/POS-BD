package GUI;

import java.awt.Color;
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

import BLL.Usuario;

public class PantallaConfiguracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PantallaConfiguracion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuración");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(164, 29, 117, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Configurar Información");
		btnNewButton.setBounds(45, 94, 175, 29);
		contentPane.add(btnNewButton);
		
		JButton btnConfiDescuentos = new JButton("Configurar Descuentos");
		btnConfiDescuentos.setBounds(233, 94, 175, 29);
		contentPane.add(btnConfiDescuentos);
		btnConfiDescuentos.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				 PantallaConfiDescuentos nueva = new PantallaConfiDescuentos();
			     nueva.setVisible(true);
			     dispose();
				   }
			    });
		
		JButton btnNewButton_2 = new JButton("<- Salir");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(164, 157, 117, 29);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   
				
				 }
			   });

	}

}
