package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import BLL.Usuario;
import BLL.Categoria;
import DLL.ControllerCategoria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField txtNombreCat;
	private Usuario usuarioLogueado;
	private ControllerCategoria controllerCategoria = new ControllerCategoria();

	public CrearCategoria(Usuario logueado) {
		this.usuarioLogueado = logueado;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombreCat = new JFormattedTextField();
		txtNombreCat.setBounds(230, 211, 150, 25);
		contentPane.add(txtNombreCat);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Crear categoría");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewJgoodiesTitle.setBounds(195, 75, 168, 29);
		contentPane.add(lblNewJgoodiesTitle);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(230, 180, 98, 20);
		contentPane.add(lblNewJgoodiesLabel);

		JButton btnConf = new JButton("Confirmar");
		btnConf.setBounds(127, 322, 100, 30);
		contentPane.add(btnConf);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(342, 322, 100, 30);
		contentPane.add(btnCancelar);

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreCat.getText().trim();

				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre para la categoría.", "Atención",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					Categoria nuevaCategoria = new Categoria(0, nombre);
					controllerCategoria.agregarCategoria(nuevaCategoria);

					JOptionPane.showMessageDialog(null, "Categoría '" + nombre + "' creada con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					volverAlMenu();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al guardar la categoría.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAlMenu();
			}
		});
	}

	private void volverAlMenu() {
		MenuGestionProductos menu = new MenuGestionProductos(usuarioLogueado);
		menu.setVisible(true);
		dispose();
	}
}