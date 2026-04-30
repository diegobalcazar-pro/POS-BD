package BLL;

import java.util.LinkedList;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JOptionPane;

import repository.Validaciones;

public class Profesor extends Usuario implements Validaciones {

	public Profesor(int id, String nombre, String email, String tipo, String password) {
		super(id, nombre, email, tipo, password);
	}

	@Override
	public String toString() {
		return "Profesor [toString()=" + super.toString() + "]";
	}

	@Override
	public void Menu() {

		String[] opciones = { "Agregar cajeros", "Ver cajeros", "Eliminar cajeros", "Editar cajeros", "Ver repositor", "Eliminar repositor", "Editar repositor", "Salir" };
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				//AGREGAR ALUMNOS
				// String nombre, String email, String tipo, String password
				this.getController().agregarUsuario(new Cajero(validarIngresoString("Ingrese nombre"),
						validarIngresoString("Ingrese mail"), "Alumno", validarIngresoString("Ingrese password")));
				break;
			case 1:
				//MOSTRAR Cajero
				JOptionPane.showMessageDialog(null, this.getController().mostrarCajeros());
				break;
			case 2:
				//ELIMINAR Cajero
				Cajero elegido = BuscarCajero();
				int confir = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar a : " + elegido);
				if (confir == JOptionPane.YES_OPTION) {
					this.getController().EliminarUsuario(elegido);
				}
				break;
			case 3:
				//EDITAR Cajero
				elegido = BuscarCajero();
				String[] datos = { "Nombre", "Tipo", "Contraseña", "Editar" };
				int elegir;
				do {
					elegir = JOptionPane.showOptionDialog(null,
							"información actual:\n" + elegido + "\n Elija que campo quiere editar", "", 0, 0, null,
							datos, datos[0]);
					switch (elegir) {
					case 0:
						elegido.setNombre(JOptionPane.showInputDialog("Ingresar nombre"));
						break;
					case 1:
						elegido.setTipo(JOptionPane.showInputDialog("Ingresar tipo"));
						break;
					case 2:
						elegido.setPassword(JOptionPane.showInputDialog("Ingresar Contraseña"));
						;
						break;
					default:
						break;
					}
				} while (elegir != 3);

				this.getController().EditarUsuario(elegido);
				break;
			case 4:
				//MOSTRAR REPOSITOR
				JOptionPane.showMessageDialog(null, this.getController().mostrarRepositores());
				break;	
			case 5:
				//ELIMINAR REPOSITOR
				Repositor elegido_repositor = BuscarRepositor();
				int confirm = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar a : " + elegido_repositor);
				if (confirm == JOptionPane.YES_OPTION) {
					this.getController().EliminarUsuario(elegido_repositor);
				}
				break;	
			case 6:
				//EDITAR REPOSITOR
				elegido_repositor = BuscarRepositor();
				String[] datosrepositor = { "Nombre", "Tipo", "Contraseña", "Editar" };
				int elegir_datos_repositor;
				do {
					elegir_datos_repositor = JOptionPane.showOptionDialog(null,
							"información actual:\n" + elegido_repositor + "\n Elija que campo quiere editar", "", 0, 0, null,
							datosrepositor, datosrepositor[0]);
					switch (elegir_datos_repositor) {
					case 0:
						elegido_repositor.setNombre(JOptionPane.showInputDialog("Ingresar nombre"));
						break;
					case 1:
						elegido_repositor.setTipo(JOptionPane.showInputDialog("Ingresar tipo"));
						break;
					case 2:
						elegido_repositor.setPassword(JOptionPane.showInputDialog("Ingresar Contraseña"));
						;
						break;
					default:
						break;
					}
				} while (elegir_datos_repositor != 3);

				this.getController().EditarUsuario(elegido_repositor);
				break;
			default:
				break;
			}
		} while (opcion != 7);

	}

	public Cajero BuscarCajero() {
		LinkedList<Cajero> cajeros = this.getController().mostrarCajeros();
		String[] mails = new String[cajeros.size()];
		for (int i = 0; i < mails.length; i++) {
			mails[i] = cajeros.get(i).getEmail();
		}
		int elegido = JOptionPane.showOptionDialog(null, "Seleccione mail", "", 0, 0, null, mails, mails[0]);
		return cajeros.get(elegido);

	}
	
	public Repositor BuscarRepositor() {
		LinkedList<Repositor> repositores = this.getController().mostrarRepositores();
		String[] mails = new String[repositores.size()];
		for (int i = 0; i < mails.length; i++) {
			mails[i] = repositores.get(i).getEmail();
		}
		int elegido = JOptionPane.showOptionDialog(null, "Seleccione mail", "", 0, 0, null, mails, mails[0]);
		return repositores.get(elegido);

	}

}
