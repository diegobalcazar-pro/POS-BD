package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;
import BLL.Categoria;
import DLL.ControllerCategoria;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class EliminarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboCategorias;
	private DefaultComboBoxModel<String> modeloCombo;
	
	private Usuario usuarioLogueado;
	private ControllerCategoria controllerCategoria = new ControllerCategoria();
	private List<Categoria> listaCategorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null,
							"No se puede iniciar esta ventana de manera independiente sin iniciar sesión.",
							"Acceso Denegado", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EliminarCategoria(Usuario logueado) {
		if (logueado == null) {
			JOptionPane.showMessageDialog(null, "Acceso Denegado: Debe iniciar sesión para acceder a este formulario.", 
					"Error de Seguridad", JOptionPane.ERROR_MESSAGE);
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
			return; 
		}
		
		this.usuarioLogueado = logueado;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = DefaultComponentFactory.getInstance().createTitle("Eliminar categoría");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(178, 50, 230, 29);
		contentPane.add(lblTitle);
		
		JLabel lblSeleccionar = DefaultComponentFactory.getInstance().createLabel("Seleccionar categoría a eliminar:");
		lblSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccionar.setBounds(160, 120, 250, 20);
		contentPane.add(lblSeleccionar);

		modeloCombo = new DefaultComboBoxModel<>();
		comboCategorias = new JComboBox<>(modeloCombo);
		comboCategorias.setBounds(160, 160, 240, 30);
		contentPane.add(comboCategorias);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConf.setBounds(127, 270, 110, 35);
		contentPane.add(btnConf);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(330, 270, 110, 35);
		contentPane.add(btnCancelar);

		cargarCategoriasEnCombo();

		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = comboCategorias.getSelectedIndex();
				
				if (selectedIndex <= 0) {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una categoría para eliminar.", "Atención", JOptionPane.WARNING_MESSAGE);
					return;
				}

				Categoria catSeleccionada = listaCategorias.get(selectedIndex - 1);
				
				int confirm = JOptionPane.showConfirmDialog(null, 
						"¿Está seguro de eliminar la categoría '" + catSeleccionada.getNombre_categoria() + "'?", 
						"Confirmar Eliminación", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.WARNING_MESSAGE);
				
				if (confirm == JOptionPane.YES_OPTION) {
					try {
						controllerCategoria.eliminarCategoria(catSeleccionada.getid_categoria());
						JOptionPane.showMessageDialog(null, "Categoría eliminada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						volverAlMenu();
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error al eliminar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				// Si elige NO, simplemente permanece en esta ventana (no se hace nada)
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAlMenu();
			}
		});
	}

	private void cargarCategoriasEnCombo() {
		modeloCombo.removeAllElements();
		modeloCombo.addElement("-- Seleccionar Categoría --");
		
		listaCategorias = controllerCategoria.obtenerCategorias();
		
		if (listaCategorias != null) {
			for (Categoria cat : listaCategorias) {
				modeloCombo.addElement(cat.getNombre_categoria());
			}
		}
	}

	private void volverAlMenu() {
		MenuGestionProductos menu = new MenuGestionProductos(usuarioLogueado);
		menu.setVisible(true);
		dispose();
	}
}