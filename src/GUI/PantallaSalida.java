package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class PantallaSalida extends JFrame {
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;

	public PantallaSalida() {
	
	setIconImage(Toolkit.getDefaultToolkit()
			.getImage("C:\\Users\\Intel I5\\Downloads\\92b80f55c7e3a2476cc2ff9481e357c3.jpg"));
	

		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(40, 355, 265, 32);
		contentPane.add(lblError);
		

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Cierra la Ventana login
				Login frame = new Login();
				frame.setVisible(false);
				dispose();

			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnSalir.setBackground(new Color(0, 64, 128));
		btnSalir.setBounds(439, 385, 220, 25);
		contentPane.add(btnSalir);

		JLabel lblNewLabel_1_2 = new JLabel("Sistema POS");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(426, 104, 237, 32);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("src\\img\\fondologin1.png"));
		lblNewLabel.setBounds(0, 0, 374, 512);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_2_1 = new JLabel("Vuelva Pronto!");
		lblNewLabel_1_2_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(426, 147, 237, 32);
		contentPane.add(lblNewLabel_1_2_1);

		

	}
}