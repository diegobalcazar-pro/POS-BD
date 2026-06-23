package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Admin;
import BLL.Cajero;
import BLL.Repositor;
import BLL.Usuario;
import DLL.ControllerUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class MenuCajero2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpEmail;
	private JPasswordField inpContrasenia;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Intel I5\\Downloads\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				inpEmail = new JTextField();
				inpEmail.setToolTipText("correo");
				inpEmail.setBounds(445, 205, 220, 30);
				contentPane.add(inpEmail);
				inpEmail.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(445, 261, 220, 14);
		contentPane.add(lblNewLabel_1_1);

		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(445, 286, 220, 30);
		contentPane.add(inpContrasenia);
		
		JLabel lblNewLabel_1_2 = new JLabel("LOGIN | POS");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(263, 162, 237, 32);
		contentPane.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_1_2_1 = new JLabel("Bienvenido");
				lblNewLabel_1_2_1.setForeground(new Color(128, 128, 128));
				lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblNewLabel_1_2_1.setBounds(442, 121, 237, 32);
				contentPane.add(lblNewLabel_1_2_1);
								
								JLabel lblNewLabel_2 = new JLabel("");
								lblNewLabel_2.setBackground(new Color(0, 0, 0));
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Intel I5\\Downloads\\thunder express.png"));
								lblNewLabel_2.setBounds(4, 1, 169, 76);
								contentPane.add(lblNewLabel_2);
								
								Button button = new Button("Cerrar Sesion");
								button.setFont(new Font("Ebrima", Font.BOLD, 13));
								button.setForeground(new Color(255, 255, 255));
								button.setBackground(new Color(128, 0, 0));
								button.setActionCommand("Cerrar Sesion");
								button.setBounds(10, 96, 169, 44);
								contentPane.add(button);
								
								Button button_1 = new Button("Cerrar Sesion");
								button_1.setForeground(Color.WHITE);
								button_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1.setBackground(new Color(128, 0, 0));
								button_1.setActionCommand("Cerrar Sesion");
								button_1.setBounds(10, 156, 169, 44);
								contentPane.add(button_1);
								
								Button button_1_1 = new Button("Cerrar Sesion");
								button_1_1.setForeground(Color.WHITE);
								button_1_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_1_1.setBackground(new Color(128, 0, 0));
								button_1_1.setActionCommand("Cerrar Sesion");
								button_1_1.setBounds(10, 276, 169, 44);
								contentPane.add(button_1_1);
								
								Button button_2 = new Button("Cerrar Sesion");
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
								
								Button button_2_1 = new Button("Cerrar Sesion");
								button_2_1.setForeground(Color.WHITE);
								button_2_1.setFont(new Font("Ebrima", Font.BOLD, 13));
								button_2_1.setBackground(new Color(128, 0, 0));
								button_2_1.setActionCommand("Cerrar Sesion");
								button_2_1.setBounds(10, 396, 169, 44);
								contentPane.add(button_2_1);
								
								Button button_1_2 = new Button("Cerrar Sesion");
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
										
										JPanel panel = new JPanel();
										panel.setBackground(new Color(64, 0, 0));
										panel.setBounds(183, 1, 543, 75);
										contentPane.add(panel);
										
										JLabel lblNewLabel = new JLabel("");
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Intel I5\\Downloads\\Carpeta compartida Aula\\icono.jpg"));
										
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
												.addGroup(gl_panel.createSequentialGroup()
													.addContainerGap(15, Short.MAX_VALUE)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
															.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
															.addContainerGap())
														.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
															.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
															.addGap(19))))
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
}