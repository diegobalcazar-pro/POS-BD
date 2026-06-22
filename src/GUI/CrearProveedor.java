package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CrearProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomEmp;
	private JTextField txtNomCon;
	private JTextField txtTelf;
	private JTextField txtCor;
	private JButton btnConf;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProveedor frame = new CrearProveedor();
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
	public CrearProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear proveedor");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(192, 39, 173, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre de empresa:");
		lblNewJgoodiesLabel.setBounds(227, 79, 104, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nombre del contacto:");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setBounds(222, 136, 114, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Telefono:");
		lblNewJgoodiesLabel_2.setBounds(233, 188, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Correo:");
		lblNewJgoodiesLabel_3.setBounds(233, 242, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_3);
		
		txtNomEmp = new JTextField();
		txtNomEmp.setBounds(231, 104, 96, 20);
		contentPane.add(txtNomEmp);
		txtNomEmp.setColumns(10);
		
		txtNomCon = new JTextField();
		txtNomCon.setBounds(231, 157, 96, 20);
		contentPane.add(txtNomCon);
		txtNomCon.setColumns(10);
		
		txtTelf = new JTextField();
		txtTelf.setBounds(231, 211, 96, 20);
		contentPane.add(txtTelf);
		txtTelf.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(231, 267, 96, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 88, 22);
		contentPane.add(btnConf);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 322, 88, 22);
		contentPane.add(btnCancelar);

	}
}
