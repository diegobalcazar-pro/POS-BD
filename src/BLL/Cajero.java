package BLL;

import javax.swing.JOptionPane;
import java.util.LinkedList;

import DLL.ControllerVenta;
import repository.Validaciones;

public class Cajero extends Usuario {
	
	private static ControllerVenta controllerVenta = new ControllerVenta();

    private Cliente clienteSeleccionado = null;
    private LinkedList<ItemVenta> carrito = new LinkedList<ItemVenta>();

    private int idDescuentoSeleccionado = 0;
    private double porcentajeDescuento = 0;


    
	public Cajero(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}
	
    public Cajero(String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(0, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}

    @Override
    public String toString() {
        return super.toString();
    }
	
	@Override
	//------------------------------------------------------------------ MENU DE CAJERO ----------------------------------------------------------------------------------------------------------------
	public void Menu() {

		String[] opciones = { "Realizar Venta", "Ver Caja", "Ver Ventas", "Cerra Caja", "Cerrar Sesion" };
		
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu Cajero", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				//REALIZAR VENTA
				String[] opciones_gestion_usuario = { "Cliente", "Agregar Producto", "Borrar Producto", "Agregar Descuento", "Procesar Cobro", "Ver Carrito", "← Salir" };

				int opcion_gestionar_usuario;

				do {
				    opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Realizar Venta", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario[0]);

				    System.out.println("Opción elegida en Realizar Venta: " + opcion_gestionar_usuario);

				    switch (opcion_gestionar_usuario) {
				        case 0:
				            seleccionarCliente();
				            break;

				        case 1:
				            agregarProducto();
				            break;

				        case 2:
				            borrarProducto();
				            break;

				        case 3:
				            agregarDescuento();
				            break;

				        case 4:
				            procesarCobro();
				            break;

				        case 5:
				            JOptionPane.showMessageDialog(null, mostrarCarrito());
				            break;

				        case 6:
				            JOptionPane.showMessageDialog(null, "Saliendo de realizar venta.");
				            break;

				        default:
				            JOptionPane.showMessageDialog(null, "No se seleccionó una opción válida.");
				            break;
				    }

				} while (opcion_gestionar_usuario != 6);
				
				
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
				//VER VENTAS
				String[] opciones_config = { "Por Fecha", "Por Cliente", "← Salir" };
				int opcion_config;
				do {
					opcion_config = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Ver Ventas", 0, 0, null, opciones_config, opciones_config);
					switch (opcion_config) {
					case 0:
						//POR FECHA
						String fecha = Validaciones.validarIngresoString("Ingrese fecha con formato AAAA-MM-DD");
			            JOptionPane.showMessageDialog(null, controllerVenta.mostrarVentasPorFecha(fecha));
						
						break;
					case 1:
						//POR CLIENTE
						JOptionPane.showMessageDialog(null, "Clientes disponibles:\n" + controllerVenta.mostrarClientesTexto());

			            int idCliente = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del cliente"));
			            JOptionPane.showMessageDialog(null, controllerVenta.mostrarVentasPorCliente(idCliente));
			            
						break;

					default:
						break;
					}
					
				} while (opcion_config != 2); //SALE DE VER VENTAS
				
				break;	
			case 3:
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
			
		} while (opcion != 4); //CIERRA SESION DE CAJERO

	}
	
	
	public void seleccionarCliente() {

	    JOptionPane.showMessageDialog(
	        null,
	        "Clientes disponibles:\n" + controllerVenta.mostrarClientesTexto()
	    );

	    int idCliente = Integer.parseInt(
	        Validaciones.validarIngresoString("Ingrese el ID del cliente")
	    );

	    Cliente cliente = controllerVenta.buscarClientePorId(idCliente);

	    if (cliente != null) {
	        clienteSeleccionado = cliente;

	        JOptionPane.showMessageDialog(null,"Cliente seleccionado:\n" + clienteSeleccionado);
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró el cliente.");
	    }
	}
	
	public void agregarProducto() {

	    JOptionPane.showMessageDialog(null,"Productos disponibles:\n" + controllerVenta.mostrarProductosConStock());

	    int idVariante = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID de la variante"));

	    int cantidad = Integer.parseInt(Validaciones.validarIngresoString("Ingrese cantidad"));

	    if (cantidad <= 0) {
	        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
	        return;
	    }

	    ItemVenta itemNuevo = controllerVenta.buscarItemVenta(idVariante, cantidad);

	    if (itemNuevo == null) {
	        return;
	    }

	    for (ItemVenta item : carrito) {
	        if (item.getId_variante_producto() == idVariante) {
	            int nuevaCantidad = item.getCantidad() + cantidad;

	            if (controllerVenta.hayStockSuficiente(idVariante, nuevaCantidad)) {
	            	item.setCantidad(nuevaCantidad);
	                JOptionPane.showMessageDialog(null, "Cantidad actualizada en el carrito.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No hay stock suficiente para sumar esa cantidad.");
	            }

	            return;
	        }
	    }

	    carrito.add(itemNuevo);

	    JOptionPane.showMessageDialog(null,"Producto agregado al carrito:\n" + itemNuevo);
	}
	
	
	public void borrarProducto() {

	    if (carrito.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "El carrito está vacío.");
	        return;
	    }

	    JOptionPane.showMessageDialog(null, mostrarCarrito());

	    int idVariante = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID de la variante a borrar"));

	    ItemVenta itemEliminar = null;

	    for (ItemVenta item : carrito) {
	        if (item.getId_variante_producto() == idVariante) {
	            itemEliminar = item;
	            break;
	        }
	    }

	    if (itemEliminar != null) {
	        carrito.remove(itemEliminar);
	        JOptionPane.showMessageDialog(null, "Producto eliminado del carrito.");
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró ese producto en el carrito.");
	    }
	}
	
	public void agregarDescuento() {

	    JOptionPane.showMessageDialog(null,"Descuentos disponibles:\n" + controllerVenta.mostrarDescuentosTexto());

	    int idDescuento = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del descuento. Ingrese 0 para no aplicar descuento"));

	    if (idDescuento == 0) {
	        idDescuentoSeleccionado = 0;
	        porcentajeDescuento = 0;
	        JOptionPane.showMessageDialog(null, "Descuento eliminado.");
	        return;
	    }

	    double porcentaje = controllerVenta.obtenerPorcentajeDescuento(idDescuento);

	    idDescuentoSeleccionado = idDescuento;
	    porcentajeDescuento = porcentaje;

	    JOptionPane.showMessageDialog(null,"Descuento aplicado: " + porcentajeDescuento + "%");
	}
	
	public void procesarCobro() {

	    if (clienteSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "Primero debe seleccionar un cliente.");
	        return;
	    }

	    if (carrito.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El carrito está vacío.");
	        return;
	    }

	    double totalBruto = calcularTotalBruto();
	    double totalNeto = calcularTotalNeto();

	    JOptionPane.showMessageDialog(
	        null,
	        "Resumen de venta:\n" +
	        mostrarCarrito() +
	        "\nCliente:\n" + clienteSeleccionado.getNombre_cliente() + " " + clienteSeleccionado.getApellido_cliente() +
	        "\n\nTotal bruto: $" + totalBruto +
	        "\nDescuento: " + porcentajeDescuento + "%" +
	        "\nTotal neto: $" + totalNeto
	    );

	    JOptionPane.showMessageDialog(null,"Métodos de pago disponibles:\n" + controllerVenta.mostrarMetodosPagoTexto());

	    int idMetodoPago = Integer.parseInt(Validaciones.validarIngresoString("Ingrese el ID del método de pago"));

	    boolean venta = controllerVenta.procesarVenta(getId_usuario(),clienteSeleccionado.getid_cliente(),idMetodoPago,idDescuentoSeleccionado,totalBruto,totalNeto,carrito);

	    if (venta) {
	        carrito.clear();
	        clienteSeleccionado = null;
	        idDescuentoSeleccionado = 0;
	        porcentajeDescuento = 0;
	    } else {
	        JOptionPane.showMessageDialog(null, "No se pudo procesar la venta.");
	    }
	}
	
	
	public String mostrarCarrito() {

	    if (carrito.isEmpty()) {
	        return "El carrito está vacío.";
	    }

	    String texto = "CARRITO:\n";

	    for (ItemVenta item : carrito) {
	        texto += item.toString() + "\n";
	    }

	    texto += "\nTotal bruto: $" + calcularTotalBruto();
	    texto += "\nDescuento: " + porcentajeDescuento + "%";
	    texto += "\nTotal neto: $" + calcularTotalNeto();

	    return texto;
	}
    
	
	public double calcularTotalBruto() {
	    double total = 0;

	    for (ItemVenta item : carrito) {
	        total += item.getSubtotal();
	    }

	    return total;
	}

	public double calcularTotalNeto() {
	    double totalBruto = calcularTotalBruto();
	    double descuento = totalBruto * porcentajeDescuento / 100;
	    return totalBruto - descuento;
	}
    
   
}
