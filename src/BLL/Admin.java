package BLL;

import java.util.LinkedList;

import javax.swing.JOptionPane;


import repository.Validaciones;
	public class Admin extends Usuario implements Validaciones {

		public Admin(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
			super(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
		}
		
		public Admin(String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
            super(nombre_usuario, apellido_usuario, correo, contrasenia, rol);
   }
		public Admin() {
	        super();
	    }
		
		
		 @Override
		    public void agregarUsuario(Usuario usuario) {
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
					
					String[] opciones_gestion_usuario = { "Ver Empleados", "Añadir Empleado", "Eliminar Empleado", "Editar Empleado", "← Salir" };
					int opcion_gestionar_usuario;
					do {
						opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de Usuarios", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario);
						
						Usuario elegido;
						switch (opcion_gestionar_usuario) {
						case 0:
							//VER EMPLEADOS
							JOptionPane.showMessageDialog(null, this.getController().mostrarUsuarios());
							
							break;
							
						case 1:
							//AÑADIR EMPLEADO
							String[] opciones_agregar_usuario = { "Agregar Admin", "Agregar Repositor","Agregar Cajero", "← Salir" };
							int opcion_agregar_usuario;
							do {
								opcion_agregar_usuario = JOptionPane.showOptionDialog(null, "Agregar Usuario: ", "Gestion de Usuarios", 0, 0, null, opciones_agregar_usuario, opciones_agregar_usuario);
								
								switch (opcion_agregar_usuario) {
								case 0:
									//AGREGAR ADMIN
					                getController().agregarUsuario( new Admin(validarIngresoString("Ingrese nombre: "),
							                validarIngresoString("Ingrese apellido: "),
								            validarIngresoString("Ingrese correo: "),
								            validarIngresoString("Ingrese contraseña: "),
								            "Admin"));
					                JOptionPane.showMessageDialog(null, "Admin Agregado con exito!");
									
									break;
								case 1: //AGREGAR REPOSITOR
									getController().agregarUsuario( new Repositor(validarIngresoString("Ingrese nombre: "),
								            validarIngresoString("Ingrese apellido: "),
									        validarIngresoString("Ingrese correo: "),
									        validarIngresoString("Ingrese contraseña: "),
									        "Repositor"));
									JOptionPane.showMessageDialog(null, "Repositor Agregado con exito!");
									break;
								case 2: //AGREGAR CAJERO
									getController().agregarUsuario( new Cajero(validarIngresoString("Ingrese nombre: "),
								            validarIngresoString("Ingrese apellido: "),
									        validarIngresoString("Ingrese correo: "),
									        validarIngresoString("Ingrese contraseña: "),
									        "Cajero"));
									JOptionPane.showMessageDialog(null, "Cajero Agregado con exito!");
									break;
								default:
									break;
								}	
							} while (opcion_agregar_usuario != 3); //SALE DE AGREGAR DE USUARIOS
							break;
							
						case 2:
							//ELIMINAR USUARIO EMPLEADO
							getController().EliminarUsuario(validarIngresoString("Ingrese correo de usuario que desea eliminar: "));
							JOptionPane.showMessageDialog(null, "El usuario se elimino correctamente");
							break;
							
						case 3:
							//EDITAR USUARIOS
							
							elegido = BuscarUsuario();
							String[] datos = { "Nombre", "Apellido", "correo",  "Rol", "Contraseña", "← Salir" };
						    int elegir;
						    do {
						          elegir = JOptionPane.showOptionDialog(null, "Información actual:\n" + elegido + "\nSeleccione qué desea editar", "", 0, 0, null, datos, datos[0]);
						          switch (elegir) {

						          case 0:
						              elegido.setNombre_usuario(validarIngresoString("Ingresar nuevo nombre"));
						              JOptionPane.showMessageDialog(null, "El nombre fue modificado correctamente!");
						              break;
						              
						          case 1:
						              elegido.setApellido_usuario(validarIngresoString("Ingresar nuevo apellido"));
						              JOptionPane.showMessageDialog(null, "El apellido fue mofidicado correctamente!");
						              break;
						              
						          case 2:
						              elegido.setCorreo(validarIngresoString("Ingresar nuevo correo"));
						              JOptionPane.showMessageDialog(null, "El correo fue mofidicado correctamente!");
						              break;

						          case 3:
						           
						        	  String[] roles = {"admin", "cajero", "repositor"};
						        	  String rol = (String) JOptionPane.showInputDialog(null, "Seleccione nuevo rol", "Rol",JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]
						        	  );
						        	  elegido.setRol(rol);
						        	  JOptionPane.showMessageDialog(null, "El rol fue modificado correctamente!");	
						              break;

						          case 4:
						              elegido.setContrasenia(JOptionPane.showInputDialog("Ingresar nueva contraseña"));
						              JOptionPane.showMessageDialog(null, "La contraseña fue modificada correctamente!");
						              break;
						           }
						         } while (elegir != 5);

						      this.getController().EditarUsuario(elegido);

						   break;
							
							
							
						default:
							break;
						}
						
					} while (opcion_gestionar_usuario != 4); //SALE DE GESTION DE USUARIOS
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
							JOptionPane.showMessageDialog(null, Producto.mostrarProductos());
						
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
							JOptionPane.showMessageDialog(null,"El nombre de la empresa es POS...\nPor el momento no se puede editar el nombre");
							
							break;
						case 1:
							//CONFIGURAR DESCUENTOS
							
							String[] opciones_descuentos = { "Ver Descuentos", "Agregar Descuentos","Eliminar Descuento", "← Salir" };
							int opcion_descuentos;
							do {
								opcion_descuentos = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Configuración", 0, 0, null, opciones_descuentos, opciones_descuentos);
								switch (opcion_descuentos) {
								case 0:
									//VER DESCUENTOS
									JOptionPane.showMessageDialog(null, Descuento.mostrarDescuentos());
									break;
								case 1:
									//AGREGAR DESCUENTOS
									Descuento.agregarDescuento( new Descuento(validarIngresoString("Ingrese nombre de descuento: "),
							                validarIngresoDouble("Ingrese el valor del porcentaje del descuento: ")));
					                JOptionPane.showMessageDialog(null, "Descuento Agregado con exito!");
									break;
								case 2:
									//ELIMINAR DESCUENTOS
									//Descuento.EliminarDescuento(validarIngresoString("Ingrese el nombre del descuento a eliminar"));
									
									Descuento descuento = new Descuento().BuscarDescuento();

								    if (descuento != null) {

								        int confirmar = JOptionPane.showConfirmDialog(
								                null,"¿Desea eliminar el descuento '" + descuento.getNombre_descuento() + "'?","Confirmar",JOptionPane.YES_NO_OPTION);

								        if (confirmar == JOptionPane.YES_OPTION) {
								            Descuento.EliminarDescuento(descuento.getNombre_descuento());
								        }
								    }
									
									break;

								default:
									break;
								}
								
							} while (opcion_descuentos != 3);
							
							
		
							break;

						default:
							break;
						}//cierre de config
						
					} while (opcion_config != 2);
					
					break;

				default:
					break;
				}
				
				
			} while (opcion != 4); //CIERRA SESION DE ADMIN
			JOptionPane.showMessageDialog(null, "Sesion cerrada!\nHasta luego.");
	
		}
		
		
		
		

		public Cajero BuscarCajero() {
			LinkedList<Cajero> cajeros = this.getController().mostrarCajeros();
			String[] correos = new String[cajeros.size()];
			for (int i = 0; i < correos.length; i++) {
				correos[i] = cajeros.get(i).getCorreo();
			}
			int elegido = JOptionPane.showOptionDialog(null, "Seleccione mail", "", 0, 0, null, correos, correos[0]);
			return cajeros.get(elegido);

		}
		
		public Repositor BuscarRepositor() {
			LinkedList<Repositor> repositores = this.getController().mostrarRepositores();
			String[] correos = new String[repositores.size()];
			for (int i = 0; i < correos.length; i++) {
				correos[i] = repositores.get(i).getCorreo();
			}
			int elegido = JOptionPane.showOptionDialog(null, "Seleccione mail", "", 0, 0, null, correos, correos[0]);
			return repositores.get(elegido);

		}				
}