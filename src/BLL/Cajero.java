package BLL;

import javax.swing.JOptionPane;

public class Cajero extends Usuario {

    
	public Cajero(int id_usuario, String nombre_usuario, String apellido_usuario, String email, String contrasenia, String rol) {
		super(id_usuario, nombre_usuario, apellido_usuario, email, contrasenia, rol);
	}
	
    public Cajero(String nombre_usuario, String apellido_usuario, String email, String contrasenia, String rol) {
		super(0, nombre_usuario, apellido_usuario, email, contrasenia, rol);
	}

	@Override
	public String toString() {
		return "Cajero [toString()=" + super.toString() + "]";
	}
	
	@Override
	//------------------------------------------------------------------ MENU DE CAJERO ----------------------------------------------------------------------------------------------------------------
	public void Menu() {

		String[] opciones = { "Realizar Venta", "Ver Caja", "Ver Stock", "Ver Ventas", "Cerra Caja", "Cerrar Sesion" };
		
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu Cajero", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				//REALIZAR VENTA
				String[] opciones_gestion_usuario = { "Cliente", "Agregar Producto", "Borrar Producto", "Agregar Descuento", "Procesar Cobro", "← Salir" };
				int opcion_gestionar_usuario;
				do {
					opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Realizar Venta", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario);
					switch (opcion_gestionar_usuario) {
					case 0:
						//CLIENTE
						
						
						break;
					case 1:
						//AGREGAR PRODUCTOS
						
						
						break;
					case 2:
						//BORRAR PRODUCTOS
						
						
						break;
					case 3:
						//AGREGAR DESCUENTO
						
						
						break;
					case 4:
						//PROCESAR COBRO
						
						
						break;
					default:
						break;
					}
					
				} while (opcion_gestionar_usuario != 5); //SALE DE REALIZAR VENTA
				
				
				break;
			case 1:
				//VER CAJA
				String[] opciones_gestion_productos = { "Imprimir Dia", "Añadir Gasto", "← Salir" };
				int opcion_gestionar_productos;
				do {
					opcion_gestionar_productos = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Ver Caja", 0, 0, null, opciones_gestion_productos, opciones_gestion_productos);
					switch (opcion_gestionar_productos) {
					case 0:
						//IMPRIMIR DIA
						
						break;
					case 1:
						//AÑADIR GASTO
						
						break;

					default:
						break;
					}
					
				} while (opcion_gestionar_productos != 2); //SALE DE VER CAJA
				
				break;
			case 2:
				//VER STOCK
				String[] opciones_info_ventas = { "Ver Todo", "Buscar Producto", "← Salir" };
				int opcion_info_ventas;
				do {
					opcion_info_ventas = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Ver Stock", 0, 0, null, opciones_info_ventas, opciones_info_ventas);
					switch (opcion_info_ventas) {
					case 0:
						//VER TODOs
						
						break;
					case 1:
						//BUSCAR PRODUCTO
						
						break;

					default:
						break;
					}
					
				} while (opcion_info_ventas != 2); //SALE DE VER STOCK
				
				break;
			case 3:
				//VER VENTAS
				String[] opciones_config = { "Por Fecha", "Por Cliente", "Por N° Venta", "← Salir" };
				int opcion_config;
				do {
					opcion_config = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Ver Ventas", 0, 0, null, opciones_config, opciones_config);
					switch (opcion_config) {
					case 0:
						//POR FECHA
						
						break;
					case 1:
						//POR CLIENTE
						
						break;
					case 2:
						//POR N°VENTA
						
						break;

					default:
						break;
					}
					
				} while (opcion_config != 3); //SALE DE VER VENTAS
				
				break;	
			case 4:
				//CERRAR CAJA
				String[] opciones_cerrar_caja = { "Si", "← No, Salir" };
				int opcion_cerrar_caja;
				do {
					opcion_cerrar_caja = JOptionPane.showOptionDialog(null, "¿Esta Seguro?", "Cerrar Caja", 0, 0, null, opciones_cerrar_caja, opciones_cerrar_caja);
					switch (opcion_cerrar_caja) {
					case 0:
						//SI, CERRAR CAJA
						
						opcion_cerrar_caja = 1;
						
						break;

					default:
						break;
					}
					
				} while (opcion_cerrar_caja != 1); //SALE DE CERRAR CAJA
				
				break;

			default:
				break;
			}
			
		} while (opcion != 5); //CIERRA SESION DE CAJERO

	}
    
    
   
}
