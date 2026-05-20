package BLL;

import javax.swing.JOptionPane;

public class Repositor extends Usuario {

    
    public Repositor(int id, String nombre, String email, String tipo, String password) {
		super(id, nombre, email, tipo, password);
	}
    public Repositor( String nombre, String email, String tipo, String password) {
		super(0, nombre, email, tipo, password);
	}
	public Repositor() {
        super();
    }
	@Override
	public String toString() {
		return "Repositor [toString()=" + super.toString() + "]";
	}
	
	@Override
	//------------------------------------------------------------------ MENU DE REPOSITOR ----------------------------------------------------------------------------------------------------------------
	public void Menu() {

		String[] opciones = { "Gestion Productos", "Gestion Pedidos", "Gestion de Stock", "Gestion Proveedores", "Cerrar Sesion" };
		
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu Repositor", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				//GESTION PRODUCTOS
				String[] opciones_gestion_usuario = { "Nuevo Producto", "Modificar Producto", "Eliminar Producto", "Mover Producto Stock", "← Salir" };
				int opcion_gestionar_usuario;
				do {
					opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion Productos", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario);
					switch (opcion_gestionar_usuario) {
					case 0:
						//NUEVO PRODUCTO
						
						
						break;
					case 1:
						//MODIFICAR PRODUCTO
						
						
						break;
					case 2:
						//ELIMINAR PRODUCTO
						
						
						break;
					case 3:
						//MOVER PRODUCTO
						
						
						break;

					default:
						break;
					}
					
				} while (opcion_gestionar_usuario != 4); //SALE DE GESTION PRODUCTOS
				
				
				break;
			case 1:
				//GESTION PEDIDOS
				String[] opciones_gestion_productos = { "Nuevo Pedido", "Modificar Pedido", "Eliminar Pedido", "← Salir" };
				int opcion_gestionar_productos;
				do {
					opcion_gestionar_productos = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion Pedidos", 0, 0, null, opciones_gestion_productos, opciones_gestion_productos);
					switch (opcion_gestionar_productos) {
					case 0:
						//NUEVO PEDIDO
						
						break;
					case 1:
						//MODIFICAR PEDIDO
						
						break;
					case 2:
						//ELIMINAR PEDIDO
						
						break;

					default:
						break;
					}
					
				} while (opcion_gestionar_productos != 3); //SALE DE GESTION PEDIDOS
				
				break;
			case 2:
				//GESTION STOCK
				String[] opciones_info_ventas = { "Ver Stock", "Modificar Stock", "← Salir" };
				int opcion_info_ventas;
				do {
					opcion_info_ventas = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de Stock", 0, 0, null, opciones_info_ventas, opciones_info_ventas);
					switch (opcion_info_ventas) {
					case 0:
						//VER STOCK
						
						break;
					case 1:
						//MODIFICAR STOCK
						
						break;

					default:
						break;
					}
					
				} while (opcion_info_ventas != 2); //SALE DE GESTION STOCK
				
				break;
			case 3:
				//GESTION PROVEEDORES
				String[] opciones_config = { "Ver Proveedor", "Nuevo Proveedor", "Modificar Proveedor", "Eliminar Proveedor", "← Salir" };
				int opcion_config;
				do {
					opcion_config = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion Proveedores", 0, 0, null, opciones_config, opciones_config);
					switch (opcion_config) {
					
					case 0:
						//VER PORVEEDOR
						
						break;
					case 1:
						//NUEVO PORVEEDOR
						
						break;
					case 2:
						//MODIFICAR PROVEEDOR
						
						break;
					case 3:
						//ELIMINAR PROVEEDOR
						
						break;

					default:
						break;
					}
					
				} while (opcion_config != 4); //SALE DE GESTION PROVEEDORES
				
				break;	

			default:
				break;
			}
			
		} while (opcion != 4); //CIERRA SESION DE REPOSITOR

	}
    
    
   
}
