package BLL;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import repository.Validaciones;

public class Admin extends Usuario implements Validaciones {

	// --- CONSTRUCTORES ---
	public Admin(int id, String nombre, String apellido, String correo, String contrasenia, String rol) {
		super(id, nombre, apellido, correo, contrasenia, rol);
	}

	public Admin(String nombre, String apellido, String correo, String contrasenia, String rol) {
		super(0, nombre, apellido, correo, contrasenia, rol);
	}

	public Admin() {
		super();
	}

	// --- MÉTODOS DE BÚSQUEDA ---
	public Cajero BuscarCajero() {
		LinkedList<Usuario> cajeros = getController().mostrarCajeros();
		if (cajeros.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay cajeros registrados.");
			return null;
		}

		String[] correos = new String[cajeros.size()];
		for (int i = 0; i < correos.length; i++) {
			correos[i] = cajeros.get(i).getCorreo();
		}

		int elegido = JOptionPane.showOptionDialog(null, "Seleccione correo", "Buscar Cajero", 0, 0, null, correos,
				correos[0]);

		if (elegido != -1) {
			return (Cajero) cajeros.get(elegido);
		}
		return null;
	}

	public Repositor BuscarRepositor() {
		LinkedList<Usuario> repositores = getController().mostrarRepositores();
		if (repositores.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay repositores registrados.");
			return null;
		}

		String[] correos = new String[repositores.size()];
		for (int i = 0; i < correos.length; i++) {
			correos[i] = repositores.get(i).getCorreo();
		}

		int elegido = JOptionPane.showOptionDialog(null, "Seleccione correo", "Buscar Repositor", 0, 0, null, correos,
				correos[0]);

		if (elegido != -1) {
			return (Repositor) repositores.get(elegido);
		}
		return null;
	}

	// --- MENÚ ---
	@Override
	public void Menu() {
		String[] opciones = { "Gestionar Usuario", "Gestion de Productos", "Informacion de Ventas", "Configuracion",
				"Cerrar Sesion" };

		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Panel de Administrador", 0, 0, null,
					opciones, opciones[0]);
			switch (opcion) {
			case 0:
				String[] opciones_gestion_usuario = { "Ver Empleados", "Añadir Empleado", "← Salir" };
				int opcion_gestionar_usuario;
				do {
					opcion_gestionar_usuario = JOptionPane.showOptionDialog(null, "Seleccione una opción",
							"Gestión de Usuarios", 0, 0, null, opciones_gestion_usuario, opciones_gestion_usuario[0]);
					switch (opcion_gestionar_usuario) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
				} while (opcion_gestionar_usuario != 2 && opcion_gestionar_usuario != -1);
				break;

			case 1:
				String[] opciones_gestion_productos = { "Ver Productos", "Ver Movimientos de Stock", "← Salir" };
				int opcion_gestionar_productos;
				do {
					opcion_gestionar_productos = JOptionPane.showOptionDialog(null, "Seleccione una opción",
							"Gestión de Productos", 0, 0, null, opciones_gestion_productos,
							opciones_gestion_productos[0]);
					switch (opcion_gestionar_productos) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
				} while (opcion_gestionar_productos != 2 && opcion_gestionar_productos != -1);
				break;

			case 2:
				String[] opciones_info_ventas = { "Historial de Ventas", "Productos Más Vendidos",
						"Categorias Más Vendidas", "← Salir" };
				int opcion_info_ventas;
				do {
					opcion_info_ventas = JOptionPane.showOptionDialog(null, "Seleccione una opción",
							"Informes de Ventas", 0, 0, null, opciones_info_ventas, opciones_info_ventas[0]);
					switch (opcion_info_ventas) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
				} while (opcion_info_ventas != 3 && opcion_info_ventas != -1);
				break;

			case 3:
				String[] opciones_config = { "Configurar Informacion", "Configurar Descuentos", "← Salir" };
				int opcion_config;
				do {
					opcion_config = JOptionPane.showOptionDialog(null, "Seleccione una opción",
							"Configuración del Sistema", 0, 0, null, opciones_config, opciones_config[0]);
					switch (opcion_config) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
				} while (opcion_config != 2 && opcion_config != -1);
				break;

			default:
				break;
			}
		} while (opcion != 4 && opcion != -1);
	}

	@Override
	public String toString() {
		return "Admin [" + super.toString() + "]";
	}
}