package BLL;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import DLL.ControllerProveedor;

public class Repositor extends Usuario {
	private ControllerProveedor controllerProveedor = new ControllerProveedor();

	// --- CONSTRUCTORES ---
	public Repositor(int id, String nombre, String apellido, String correo, String contrasenia, String rol) {
		super(id, nombre, apellido, correo, contrasenia, rol);
	}

	public Repositor(String nombre, String apellido, String correo, String contrasenia, String rol) {
		super(0, nombre, apellido, correo, contrasenia, rol);
	}

	public Repositor() {
		super();
	}

	// --- GESTIÓN DE PROVEEDORES ---
	public void altaProveedor() {
		String nombreEmpresa = JOptionPane.showInputDialog("Ingrese nombre de la empresa:");
		if (nombreEmpresa == null || nombreEmpresa.isEmpty())
			return;

		String nombreContacto = JOptionPane.showInputDialog("Ingrese nombre del contacto:");
		if (nombreContacto == null || nombreContacto.isEmpty())
			return;

		String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
		if (telefono == null || telefono.isEmpty())
			return;

		String correo = JOptionPane.showInputDialog("Ingrese correo electrónico:");
		if (correo == null || correo.isEmpty())
			return;

		Proveedor nuevoProveedor = new Proveedor(0, nombreEmpresa, nombreContacto, telefono, correo);
		controllerProveedor.agregarProveedor(nuevoProveedor);
		JOptionPane.showMessageDialog(null, "Proveedor '" + nombreEmpresa + "' registrado con éxito.");
	}

	public void verProveedores() {
		LinkedList<Proveedor> lista = controllerProveedor.mostrarProveedores();

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay proveedores registrados.");
			return;
		}

		StringBuilder mensaje = new StringBuilder("LISTA DE PROVEEDORES:\n\n");
		for (Proveedor p : lista) {
			mensaje.append("------------------------------------------\n").append("Empresa: ")
					.append(p.getNombreEmpresa()).append("\n").append("Contacto: ").append(p.getNombreContacto())
					.append("\n").append("Teléfono: ").append(p.getTelefono()).append("\n").append("Correo: ")
					.append(p.getCorreo()).append("\n");
		}

		JOptionPane.showMessageDialog(null, mensaje.toString());
	}

	public void eliminarProveedor() {
		LinkedList<Proveedor> lista = controllerProveedor.mostrarProveedores();

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay proveedores para eliminar.");
			return;
		}

		String[] opciones = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			opciones[i] = lista.get(i).getNombreEmpresa();
		}

		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el proveedor a ELIMINAR:", "Eliminar Proveedor",
				0, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);

		if (seleccion != -1) {
			Proveedor provAEliminar = lista.get(seleccion);

			int confirm = JOptionPane.showConfirmDialog(null,
					"¿Estás seguro de eliminar a " + provAEliminar.getNombreEmpresa() + "?", "Confirmar",
					JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				controllerProveedor.eliminarProveedor(provAEliminar.getIdProveedor());
				JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
			}
		}
	}

	private Proveedor seleccionarProveedor() {
		LinkedList<Proveedor> lista = controllerProveedor.mostrarProveedores();

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay proveedores registrados.");
			return null;
		}

		String[] opciones = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			opciones[i] = lista.get(i).getNombreEmpresa();
		}

		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione un proveedor:", "Selección", 0,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		return (seleccion != -1) ? lista.get(seleccion) : null;
	}

	public void modificarProveedor() {
		Proveedor p = seleccionarProveedor();
		if (p == null)
			return;

		String nombre = JOptionPane.showInputDialog("Modificar empresa:", p.getNombreEmpresa());
		if (nombre == null)
			return;

		String contacto = JOptionPane.showInputDialog("Modificar contacto:", p.getNombreContacto());
		if (contacto == null)
			return;

		String tel = JOptionPane.showInputDialog("Modificar teléfono:", p.getTelefono());
		if (tel == null)
			return;

		String correo = JOptionPane.showInputDialog("Modificar correo:", p.getCorreo());
		if (correo == null)
			return;

		p.setNombreEmpresa(nombre);
		p.setNombreContacto(contacto);
		p.setTelefono(tel);
		p.setCorreo(correo);

		controllerProveedor.editarProveedor(p);

		JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente.");
	}

	// --- MENÚ Y OTROS ---
	@Override
	public String toString() {
		return "Repositor [" + super.toString() + "]";
	}

	@Override
	public void Menu() {
		String[] opciones = { "Gestión de Producto", "Gestión de Pedido", "Gestión de Proveedor", "Cerrar Sesión" };
		int opcion;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú de Repositor", 0, 0, null,
					opciones, opciones[0]);

			switch (opcion) {
			case 0:
				String[] opcionesproducto = { "Cargar producto", "Eliminar producto", "Modificar producto",
						"Mover producto", "← Salir" };
				int opcionproducto;
				do {
					opcionproducto = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Productos",
							0, 0, null, opcionesproducto, opcionesproducto[0]);
				} while (opcionproducto != 4 && opcionproducto != -1);
				break;

			case 1:
				String[] opcionespedido = { "Ver pedidos", "Ver cupos diarios", "Enviar pedido", "← Salir" };
				int opcionpedido;
				do {
					opcionpedido = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Pedidos", 0,
							0, null, opcionespedido, opcionespedido[0]);
				} while (opcionpedido != 3 && opcionpedido != -1);
				break;

			case 2:
				String[] opcionesProveedor = { "Ver Proveedores", "Agregar Proveedor", "Eliminar Proveedor",
						"Modificar Proveedor", "← Salir" };
				int opcionProv;
				do {
					opcionProv = JOptionPane.showOptionDialog(null, "Gestión de Proveedores", "", 0, 0, null,
							opcionesProveedor, opcionesProveedor[0]);
					switch (opcionProv) {
					case 0:
						verProveedores();
						break;
					case 1:
						altaProveedor();
						break;
					case 2:
						eliminarProveedor();
						break;
					case 3:
						modificarProveedor();
						break;
					}
				} while (opcionProv != 4 && opcionProv != -1);
				break;

			default:
				break;
			}

		} while (opcion != 3 && opcion != -1);
	}
}