package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCategoria frame = new ModificarCategoria();
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
	public ModificarCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField txtNombreCat = new JFormattedTextField();
		txtNombreCat.setBounds(230, 211, 98, 20);
		contentPane.add(txtNombreCat);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Modificar categoria");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(178, 75, 201, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(230, 180, 98, 20);
		contentPane.add(lblNewJgoodiesLabel);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 88, 22);
		contentPane.add(btnConf);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 322, 88, 22);
		contentPane.add(btnCancelar);

	}

}
