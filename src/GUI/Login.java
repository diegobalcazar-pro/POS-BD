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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Button;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Intel I5\\Downloads\\92b80f55c7e3a2476cc2ff9481e357c3.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(445, 179, 220, 14);
		contentPane.add(lblNewLabel_1);
		
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

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(40, 355, 265, 32);
		contentPane.add(lblError);
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.setBackground(new Color(0, 64, 128));//fondo del boton
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario logueado = Usuario.Login(inpEmail.getText(), inpContrasenia.getText());
				if (logueado == null) {
					lblError.setText("No se encontró");
				} else {
					
			
					Login frame = new Login();
					frame.setVisible(false);
					dispose();
						
					System.out.println("Bienvenido " + logueado.getNombre_usuario());
					
				
                    if (logueado != null) {
                        if (logueado instanceof Admin) {
                            JOptionPane.showMessageDialog(null, "Bienvenido Admin " + logueado.getNombre_usuario());
                            // Ir a menu de admin
                            logueado.Menu();
                        } else if (logueado instanceof Cajero) {
                            JOptionPane.showMessageDialog(null, "Bienvenido Cajero " + logueado.getNombre_usuario());
                            // Ir a menu de cajero
                            logueado.Menu();
                        } else if (logueado instanceof Repositor) {
                        	JOptionPane.showMessageDialog(null, "Bienvenido Repositor " + logueado.getNombre_usuario());
                            // Ir a menu de repositor
                        	logueado.Menu();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
					
					
				}
			}
		});
		btnLogin.setBounds(445, 349, 220, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1_2 = new JLabel("LOGIN | POS");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(434, 93, 237, 32);
		contentPane.add(lblNewLabel_1_2);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setIcon(new ImageIcon("src\\img\\fondologin.jpg"));
				lblNewLabel.setBounds(0, 0, 385, 512);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1_2_1 = new JLabel("Bienvenido");
				lblNewLabel_1_2_1.setForeground(new Color(128, 128, 128));
				lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblNewLabel_1_2_1.setBounds(442, 121, 237, 32);
				contentPane.add(lblNewLabel_1_2_1);
		
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