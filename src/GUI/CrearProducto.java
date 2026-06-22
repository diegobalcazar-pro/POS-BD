package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CrearProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomProd;
	private JTextField txtDescProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProducto frame = new CrearProducto();
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
	public CrearProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear producto");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(197, 23, 164, 36);
		contentPane.add(lblNewJgoodiesTitle);
		
		txtNomProd = new JTextField();
		txtNomProd.setBounds(231, 106, 96, 20);
		contentPane.add(txtNomProd);
		txtNomProd.setColumns(10);
		
		txtDescProd = new JTextField();
		txtDescProd.setBounds(231, 162, 96, 20);
		contentPane.add(txtDescProd);
		txtDescProd.setColumns(10);
		
		JComboBox comboBoxCat = new JComboBox();
		comboBoxCat.setBounds(264, 216, 30, 22);
		contentPane.add(comboBoxCat);
		
		JComboBox comboBoxProv = new JComboBox();
		comboBoxProv.setBounds(264, 272, 30, 22);
		contentPane.add(comboBoxProv);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNewJgoodiesLabel.setBounds(233, 81, 92, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Descripción:");
		lblNewJgoodiesLabel_1.setBounds(233, 137, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Categorias:");
		lblNewJgoodiesLabel_2.setBounds(233, 191, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Proveedores:");
		lblNewJgoodiesLabel_3.setBounds(233, 249, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_3);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 88, 22);
		contentPane.add(btnConf);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 322, 88, 22);
		contentPane.add(btnCancelar);

	}
}
