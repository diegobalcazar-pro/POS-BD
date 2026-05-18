package BLL;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import repository.Validaciones;
import DLL.ControllerProducto;
import BLL.Producto;

	public class Admin extends Usuario implements Validaciones {

		public Admin(int id, String nombre, String apellido, String email, String rol, String contrasenia) {
			super(id, nombre, apellido, email, rol, contrasenia);
		}
		
		public Admin() {
	        super();
	    }
		
		@Override
		public String toString() {
			return "Profesor [toString()=" + super.toString() + "]";
		}
		
		
		@Override
		public void Menu() {

			String[] opciones = { "Agregar cajeros", "Ver Productos", "Eliminar cajeros", "Editar cajeros", "Ver repositor", "Eliminar repositor", "Editar repositor","Agregar Producto", "Salir" };
			int opcion;
			do {

				opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null, opciones, opciones);
				switch (opcion) {
				case 0:
					//AGREGAR Cajeros
					// String nombre, String apellido, String email, String tipo, String password
					this.getController().agregarUsuario(new Cajero(validarIngresoString("Ingrese nombre"), validarIngresoString("Ingrese apellido"),
							validarIngresoString("Ingrese mail"), "Cajero", validarIngresoString("Ingrese password")));
					break;
				case 1:
					//MOSTRAR productos
					JOptionPane.showMessageDialog(null, this.getController().mostrarProductos());
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
					String[] datos = { "Nombre", "Apellido", "Rol", "Contraseña", "Editar" };
					int elegir;
					do {
						elegir = JOptionPane.showOptionDialog(null,
								"información actual:\n" + elegido + "\n Elija que campo quiere editar", "", 0, 0, null,
								datos, datos[0]);
						switch (elegir) {
						case 0:
							elegido.setNombre_usuario(JOptionPane.showInputDialog("Ingresar nombre"));
							break;
						case 1:
							elegido.setNombre_usuario(JOptionPane.showInputDialog("Ingresar apellido"));
							break;
						case 2:
							elegido.setRol(JOptionPane.showInputDialog("Ingresar Rol"));
							break;
						case 3:
							elegido.setContrasenia(JOptionPane.showInputDialog("Ingresar Contraseña"));
							;
							break;
						default:
							break;
						}
					} while (elegir != 4);

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
					String[] datosrepositor = { "Nombre", "Apellido", "Rol", "Contraseña", "Editar" };
					int elegir_datos_repositor;
					do {
						elegir_datos_repositor = JOptionPane.showOptionDialog(null,
								"información actual:\n" + elegido_repositor + "\n Elija que campo quiere editar", "", 0, 0, null,
								datosrepositor, datosrepositor[0]);
						switch (elegir_datos_repositor) {
						case 0:
							elegido_repositor.setNombre_usuario(JOptionPane.showInputDialog("Ingresar nombre"));
							break;
						case 1:
							elegido_repositor.setApellido_usuario(JOptionPane.showInputDialog("Ingresar apellido"));
							break;
						case 2:
							elegido_repositor.setRol(JOptionPane.showInputDialog("Ingresar rol"));
							break;
						case 3:
							elegido_repositor.setContrasenia(JOptionPane.showInputDialog("Ingresar Contraseña"));
							;
							break;
						default:
							break;
						}
					} while (elegir_datos_repositor != 4);

					this.getController().EditarUsuario(elegido_repositor);
					break;
					
				case 7: 	this.getController().agregarProducto(new Producto(validarIngresoString("Ingrese nombre de producto"),
						validarIngresoString("Ingrese descripcion"), validarIngresoDouble("Ingrese precio"), validarIngresoInt("Ingrese Stock")));
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
