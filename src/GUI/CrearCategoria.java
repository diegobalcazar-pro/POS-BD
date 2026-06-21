package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class CrearCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCategoria frame = new CrearCategoria();
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
	public CrearCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField txtNombreCat = new JFormattedTextField();
		txtNombreCat.setBounds(230, 211, 98, 20);
		contentPane.add(txtNombreCat);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear categoria");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(195, 75, 168, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(230, 180, 98, 20);
		contentPane.add(lblNewJgoodiesLabel);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 307, 88, 22);
		contentPane.add(btnConf);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 307, 88, 22);
		contentPane.add(btnCancelar);

	}
}
