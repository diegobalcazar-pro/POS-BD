package BLL;

import javax.swing.JOptionPane;

public class Cajero extends Usuario {

	// --- CONSTRUCTORES ---
	public Cajero(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}

	public Cajero(String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		super(0, nombre_usuario, apellido_usuario, correo, contrasenia, rol);
	}

	public Cajero() {
		super();
	}

	// --- MENÚ ---
	@Override
	public void Menu() {
		String[] opciones = { "Realizar Venta", "Ver Caja", "Ver Stock", "Ver Ventas", "Cerrar Caja", "Cerrar Sesion" };
		int opcion;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal - Cajero", 0, 0, null,
					opciones, opciones[0]);

			switch (opcion) {
			case 0:
				String[] opVenta = { "Cliente", "Agregar Producto", "Borrar Producto", "Agregar Descuento",
						"Procesar Cobro", "← Salir" };
				int opVentaSub;
				do {
					opVentaSub = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Módulo de Ventas", 0, 0,
							null, opVenta, opVenta[0]);
					switch (opVentaSub) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						break;
					}
				} while (opVentaSub != 5 && opVentaSub != -1);
				break;

			case 1:
				String[] opCaja = { "Imprimir Dia", "Añadir Gasto", "← Salir" };
				int opCajaSub;
				do {
					opCajaSub = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Caja Diaria", 0, 0, null,
							opCaja, opCaja[0]);
					switch (opCajaSub) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
				} while (opCajaSub != 2 && opCajaSub != -1);
				break;

			case 2:
				String[] opStock = { "Ver Todo", "Buscar Producto", "← Salir" };
				int opStockSub;
				do {
					opStockSub = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Stock", 0, 0,
							null, opStock, opStock[0]);
					switch (opStockSub) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
				} while (opStockSub != 2 && opStockSub != -1);
				break;

			case 3:
				String[] opVentas = { "Por Fecha", "Por Cliente", "Por N° Venta", "← Salir" };
				int opVentasSub;
				do {
					opVentasSub = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Historial de Ventas", 0,
							0, null, opVentas, opVentas[0]);
					switch (opVentasSub) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
				} while (opVentasSub != 3 && opVentasSub != -1);
				break;

			case 4:
				String[] opCerrar = { "Si", "← No, Salir" };
				int opCerrarSub;
				do {
					opCerrarSub = JOptionPane.showOptionDialog(null, "¿Esta Seguro?", "Cerrar Caja", 0, 0, null,
							opCerrar, opCerrar[0]);
					if (opCerrarSub == 0)
						opCerrarSub = 1;
				} while (opCerrarSub != 1 && opCerrarSub != -1);
				break;

			default:
				break;
			}
		} while (opcion != 5 && opcion != -1);
	}

	// --- TO STRING ---
	@Override
	public String toString() {
		return "Cajero [" + super.toString() + "]";
	}
}