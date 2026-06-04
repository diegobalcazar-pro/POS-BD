package BLL;

import javax.swing.JOptionPane;

import DLL.ControllerProducto;
import repository.Validaciones;

public class Repositor extends Usuario {

	private static ControllerProducto controllerProducto = new ControllerProducto();
    
	public Repositor(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}
	
    public Repositor(String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(0, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}

    @Override
    public String toString() {
        return super.toString();
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
				String[] opciones_gestion_usuario = { "Ver Productos", "Nuevo Producto", "Agregar Variante", "Ver Variantes de Producto", "Modificar Producto", "Eliminar Producto", "← Salir" };
				int opcion_gestionar_usuario;
				do {
					opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion Productos", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario);
					switch (opcion_gestionar_usuario) {
					case 0:
						//Ver Productos
						JOptionPane.showMessageDialog(null,controllerProducto.mostrarProductosCompleto());
						
						break;
					case 1:
						//Nuevo Producto
						nuevoProducto();
						
						break;
					case 2:
						//Agregar Variante
						agregarVarianteAProducto();
						
						break;
					case 3:
						//Ver Variantes de Producto
						verVariantesDeProducto();
						
						break;
					case 4:
						//Modificar Producto
						modificarProducto();
						
						break;
					case 5:
						//Eliminar Producto
						eliminarProducto();
						
						break;

					default:
						break;
					}
					
				} while (opcion_gestionar_usuario != 6); //SALE DE GESTION PRODUCTOS
				
				
				break;
			case 1:
				//GESTION PEDIDOS
				String[] opciones_gestion_productos = { "Ver Pedido", "Nuevo Pedido", "Modificar Pedido", "Eliminar Pedido", "← Salir" };
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
	
	public void nuevoProducto() {

	    JOptionPane.showMessageDialog(null,"Categorías disponibles:\n\n" + controllerProducto.mostrarCategoriasTexto());

	    int idCategoria = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID de la categoría"));

	    JOptionPane.showMessageDialog(null,"Proveedores disponibles:\n\n" + controllerProducto.mostrarProveedoresTexto());

	    int idProveedor = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del proveedor"));

	    String nombre = Validaciones.validarIngresoString("Ingrese nombre del producto");
	    String descripcion = Validaciones.validarIngresoString("Ingrese descripción del producto");

	    Producto producto = new Producto(nombre,descripcion,idCategoria,idProveedor);

	    controllerProducto.agregarProducto(producto);

	    JOptionPane.showMessageDialog(null,"Producto cargado.\nAhora podés ir a 'Ver Productos' para ver el ID y luego usar 'Agregar Variante'.");
	}
	
	public void agregarVarianteAProducto() {

	    JOptionPane.showMessageDialog(null,controllerProducto.mostrarProductosCompleto());

	    int idProducto = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del producto"));

	    cargarVariante(idProducto);
	}
    
	public void cargarVariante(int idProducto) {

	    String talle = Validaciones.validarIngresoString("Ingrese talle");
	    String color = Validaciones.validarIngresoString("Ingrese color");

	    double precio = Double.parseDouble(Validaciones.validarIngresoString("Ingrese precio de venta"));

	    VarianteProducto variante = new VarianteProducto(talle,color,precio,idProducto);

	    controllerProducto.agregarVariante(variante);
	}
	
	public void verVariantesDeProducto() {

	    JOptionPane.showMessageDialog(null,controllerProducto.mostrarProductosCompleto());

	    int idProducto = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del producto"));

	    JOptionPane.showMessageDialog(null,controllerProducto.mostrarVariantesProducto(idProducto));
	}
	
	public void modificarProducto() {

	    JOptionPane.showMessageDialog(null,controllerProducto.mostrarProductosCompleto());

	    int idProducto = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del producto a modificar"));

	    String nuevoNombre = Validaciones.validarIngresoString("Ingrese nuevo nombre");
	    String nuevaDescripcion = Validaciones.validarIngresoString("Ingrese nueva descripción");

	    JOptionPane.showMessageDialog(null,"Categorías disponibles:\n" + controllerProducto.mostrarCategoriasTexto());

	    int idCategoria = Integer.parseInt(Validaciones.validarIngresoString("Ingrese nuevo ID de categoría"));

	    JOptionPane.showMessageDialog(null,"Proveedores disponibles:\n" + controllerProducto.mostrarProveedoresTexto());

	    int idProveedor = Integer.parseInt(Validaciones.validarIngresoString("Ingrese nuevo ID de proveedor"));
	    
	    Producto producto = new Producto(idProducto,nuevoNombre,nuevaDescripcion,idCategoria,idProducto);

	    controllerProducto.modificarProducto(producto);
	}
    
	public void eliminarProducto() {

	    JOptionPane.showMessageDialog(null,controllerProducto.mostrarProductosCompleto());

	    int idProducto = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del producto a eliminar"));

	    int confirmar_eliminar_producto = JOptionPane.showConfirmDialog(
	        null,
	        "¿Está seguro que desea eliminar el producto ID " + idProducto + "?",
	        "Confirmar eliminación",
	        JOptionPane.YES_NO_OPTION
	    );

	    if (confirmar_eliminar_producto == JOptionPane.YES_OPTION) {
	    	controllerProducto.eliminarProducto(idProducto);
	    	}
	}
   
}
