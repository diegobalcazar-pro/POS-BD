package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearVariante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTalle;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearVariante frame = new CrearVariante();
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
	public CrearVariante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear variante");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(204, 57, 150, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Producto:");
		lblNewJgoodiesLabel.setBounds(174, 129, 92, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Talle:");
		lblNewJgoodiesLabel_1.setBounds(174, 183, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Color:");
		lblNewJgoodiesLabel_2.setBounds(174, 235, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblNewJgoodiesLabel_3.setBounds(298, 129, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
		lblNewJgoodiesLabel_4.setBounds(298, 181, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_4);
		
		JComboBox comboBoxProd = new JComboBox();
		comboBoxProd.setBounds(205, 152, 30, 22);
		contentPane.add(comboBoxProd);
		
		txtTalle = new JTextField();
		txtTalle.setBounds(172, 206, 96, 20);
		contentPane.add(txtTalle);
		txtTalle.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(172, 258, 96, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(296, 152, 96, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JComboBox comboBoxDeposito = new JComboBox();
		comboBoxDeposito.setBounds(329, 256, 30, 22);
		contentPane.add(comboBoxDeposito);
		
		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Deposito:");
		lblNewJgoodiesLabel_5.setBounds(298, 233, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_5);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(296, 204, 96, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 88, 22);
		contentPane.add(btnConf);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 322, 88, 22);
		contentPane.add(btnCancelar);

	}
}
