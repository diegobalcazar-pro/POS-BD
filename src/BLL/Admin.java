package BLL;

import java.util.LinkedList;
<<<<<<< HEAD

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
			return "Admin [toString()=" + super.toString() + "]";
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
=======
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JOptionPane;

import repository.Validaciones;

public class Admin extends Usuario implements Validaciones {

	public Admin(int id, String nombre, String apellido, String email, String contrasenia, String rol) {
		super(id, nombre, apellido, email, contrasenia, rol);
	}

	@Override
	public String toString() {
		return "Admin [toString()=" + super.toString() + "]";
	}

	@Override
	//------------------------------------------------------------------ MENU DE ADMINISTRADOR ----------------------------------------------------------------------------------------------------------------
	public void Menu() {

		String[] opciones = { "Gestion de Usuarios", "Gestion de Productos", "Informacion de Ventas", "Configuracion", "Cerrar Sesion" };
		
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu Administrador", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				//GESTION DE USUARIOS
				String[] opciones_gestion_usuario = { "Ver Empleados", "Añadir Empleado", "← Salir" };
				int opcion_gestionar_usuario;
				do {
					opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de Usuarios", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario);
					switch (opcion_gestionar_usuario) {
					case 0:
						//VER EMPLEADOS
						
						
						break;
					case 1:
						//AÑADIR EMPLEADO
						
						
						break;
					default:
						break;
					}
					
				} while (opcion_gestionar_usuario != 2); //SALE DE GESTION DE USUARIOS
				
				
				break;
			case 1:
				//GESTION DE PRODUCTOS
				String[] opciones_gestion_productos = { "Ver Productos", "Ver Movimientos de Stock", "← Salir" };
				int opcion_gestionar_productos;
				do {
					opcion_gestionar_productos = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de Productos", 0, 0, null, opciones_gestion_productos, opciones_gestion_productos);
					switch (opcion_gestionar_productos) {
					case 0:
						//VER PRODUCTOS
						
						break;
					case 1:
						//VER MOVIMIENTOS DE STOCK
						
						break;

					default:
						break;
					}
					
				} while (opcion_gestionar_productos != 2); //SALE DE GESTION DE PRODUCTOS
				
				break;
			case 2:
				//INFORMACION DE VENTAS
				String[] opciones_info_ventas = { "Historial de Ventas", "Productos Más Vendidos", "Categorias Más Vendidas", "← Salir" };
				int opcion_info_ventas;
				do {
					opcion_info_ventas = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Informacion de Ventas", 0, 0, null, opciones_info_ventas, opciones_info_ventas);
					switch (opcion_info_ventas) {
					case 0:
						//HISTORIAL DE VENTAS
						
						break;
					case 1:
						//PRODUCTOS MAS VENDIDOS
						
						break;
					case 2:
						//CATEGORIAS MAS VENDIDAS
						
						break;

					default:
						break;
					}
					
				} while (opcion_info_ventas != 3); //SALE DE INFORMACION DE VENTAS
				
				break;
			case 3:
				//CONFIG
				String[] opciones_config = { "Configurar Informacion", "Configurar Descuentos", "← Salir" };
				int opcion_config;
				do {
					opcion_config = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Configuración", 0, 0, null, opciones_config, opciones_config);
					switch (opcion_config) {
					case 0:
						//CONFIGURAR INFORMACION
						
						break;
					case 1:
						//CONFIGURAR DESCUENTOS
						
						break;

					default:
						break;
					}
					
				} while (opcion_config != 2);
				
				break;

			default:
				break;
			}
			
			
			
			
			/*switch (opcion) {
			
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
			}*/
			
			
			
			
			
		} while (opcion != 4); //CIERRA SESION DE ADMIN

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

>>>>>>> origin/diego
}
