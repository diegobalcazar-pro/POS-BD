package BLL;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import DLL.ControllerCategoria;
import DLL.ControllerEnvio;
import DLL.ControllerProducto;
import DLL.ControllerProveedor;
import DLL.ControllerVarianteProducto;

public class Repositor extends Usuario {
	private static ControllerProveedor controllerProveedor = new ControllerProveedor();
	private static ControllerCategoria controllerCat = new ControllerCategoria();
	private static ControllerProducto controllerProd = new ControllerProducto();
	private static ControllerVarianteProducto controllerVar = new ControllerVarianteProducto();
	private static ControllerEnvio controllerEnvio = new ControllerEnvio();

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

	// --- GESTIÓN DE PRODUCTOS ---
	// --- CRUD DE CATEGORÍAS ---
	public void altaCategoria() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la nueva categoría:");
		if (nombre == null || nombre.trim().isEmpty())
			return;

		Categoria nueva = new Categoria(0, nombre);
		controllerCat.agregarCategoria(nueva);
		JOptionPane.showMessageDialog(null, "Categoría '" + nombre + "' agregada con éxito.");
	}

	private Categoria seleccionarCategoria() {
		List<Categoria> lista = controllerCat.obtenerCategorias();

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay categorías registradas.");
			return null;
		}

		String[] opciones = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			opciones[i] = lista.get(i).getNombre_categoria();
		}

		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una categoría:", "Categorías", 0,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		return (seleccion != -1) ? lista.get(seleccion) : null;
	}

	public void eliminarCategoria() {
		Categoria cat = seleccionarCategoria();
		if (cat == null)
			return;

		int confirm = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de eliminar la categoría: " + cat.getNombre_categoria() + "?\n"
						+ "(Esto podría fallar si hay productos asociados)",
				"Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			controllerCat.eliminarCategoria(cat.getIdCategoria());
			JOptionPane.showMessageDialog(null, "Categoría eliminada.");
		}
	}

	public void modificarCategoria() {
		Categoria cat = seleccionarCategoria();
		if (cat == null)
			return;

		String nuevoNombre = JOptionPane.showInputDialog("Modificar nombre de la categoría:",
				cat.getNombre_categoria());
		if (nuevoNombre == null || nuevoNombre.trim().isEmpty())
			return;

		cat.setNombre_categoria(nuevoNombre);
		controllerCat.modificarCategoria(cat);

		JOptionPane.showMessageDialog(null, "Categoría actualizada correctamente.");
	}

	// --- VER INVENTARIO ---
	public void verInventario() {
		String datosInventario = controllerVar.obtenerInventarioCompleto();

		JOptionPane.showMessageDialog(null, datosInventario, "Inventario Completo", JOptionPane.INFORMATION_MESSAGE);
	}

	// --- CRUD PRODUCTO ---
	public void altaProducto() {
		String nombre = JOptionPane.showInputDialog("Nombre del producto:");
		String desc = JOptionPane.showInputDialog("Descripción:");

		Categoria cat = seleccionarCategoria();
		Proveedor prov = seleccionarProveedor();

		if (nombre != null && cat != null && prov != null) {
			Producto nuevo = new Producto(0, nombre, desc, cat, prov);
			controllerProd.agregarProducto(nuevo);
			JOptionPane.showMessageDialog(null, "Producto guardado con éxito.");
		}
	}

	private Producto seleccionarProducto() {
		List<Producto> lista = controllerProd.obtenerProductos();
		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay productos.");
			return null;
		}
		String[] opciones = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			opciones[i] = lista.get(i).getNombre_producto();
		}
		int sel = JOptionPane.showOptionDialog(null, "Seleccione producto:", "Productos", 0, 0, null, opciones,
				opciones[0]);
		return (sel != -1) ? lista.get(sel) : null;
	}

	public void eliminarProducto() {
		Producto p = seleccionarProducto();
		if (p == null)
			return;

		int confirm = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de eliminar el producto: " + p.getNombre_producto() + "?\n"
						+ "(Atención: Esto puede fallar si el producto ya tiene variantes/stock asociado)",
				"Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (confirm == JOptionPane.YES_OPTION) {
			controllerProd.eliminarProducto(p.getIdProducto());
			JOptionPane.showMessageDialog(null, "Producto eliminado.");
		}
	}

	public void modificarProducto() {
		Producto p = seleccionarProducto();
		if (p == null)
			return;

		String nombre = JOptionPane.showInputDialog("Nuevo nombre:", p.getNombre_producto());
		if (nombre == null || nombre.trim().isEmpty())
			return;

		String desc = JOptionPane.showInputDialog("Nueva descripción:", p.getDescripcion_producto());
		if (desc == null)
			return;
		Categoria cat = seleccionarCategoria();
		if (cat == null)
			return;
		Proveedor prov = seleccionarProveedor();
		if (prov == null)
			return;
		p.setNombre_producto(nombre);
		p.setDescripcion_producto(desc);
		p.setCategoria(cat);
		p.setProveedor(prov);

		controllerProd.modificarProducto(p);
		JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
	}

	// --- CRUD DE VARIANTES ---
	public void altaVariante() {
		Producto p = seleccionarProducto();
		if (p == null)
			return;

		String talle = JOptionPane.showInputDialog("Ingrese el talle (Ej: XL, 42):");
		if (talle == null || talle.trim().isEmpty())
			return;

		String color = JOptionPane.showInputDialog("Ingrese el color:");
		if (color == null || color.trim().isEmpty())
			return;

		String precioStr = JOptionPane.showInputDialog("Precio de venta:");
		if (precioStr == null)
			return;
		double precio = 0;
		try {
			precio = Double.parseDouble(precioStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: El precio debe ser un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String cantStr = JOptionPane.showInputDialog("Cantidad de stock inicial:");
		if (cantStr == null)
			return;
		int cantidad = 0;
		try {
			cantidad = Integer.parseInt(cantStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser un número entero.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		List<BLL.Deposito> depositos = controllerVar.obtenerDepositos();
		if (depositos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay depósitos registrados en la base de datos.");
			return;
		}
		Object[] depArray = depositos.toArray();
		BLL.Deposito depSel = (BLL.Deposito) JOptionPane.showInputDialog(null, "Seleccione el lugar de depósito:",
				"Depósito", JOptionPane.QUESTION_MESSAGE, null, depArray, depArray[0]);
		if (depSel == null)
			return;

		VarianteProducto nuevaVar = new VarianteProducto(0, talle, color, precio, p);
		controllerVar.agregarVarianteConStock(nuevaVar, cantidad, depSel.getIdDeposito());

		JOptionPane.showMessageDialog(null, "Variante creada y stock asignado exitosamente.");
	}

	private VarianteProducto seleccionarVariante() {
		List<VarianteProducto> lista = controllerVar.obtenerVariantes();
		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay variantes registradas.");
			return null;
		}

		String[] opciones = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			VarianteProducto v = lista.get(i);
			opciones[i] = v.getProducto().getNombre_producto() + " | Talle: " + v.getTalle() + " | Color: "
					+ v.getColor();
		}

		int sel = JOptionPane.showOptionDialog(null, "Seleccione la variante:", "Variantes", 0,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		return (sel != -1) ? lista.get(sel) : null;
	}

	public void eliminarVariante() {
		VarianteProducto v = seleccionarVariante();
		if (v == null)
			return;

		int confirm = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea eliminar la variante?\nProducto: " + v.getProducto().getNombre_producto()
						+ "\nTalle: " + v.getTalle() + " | Color: " + v.getColor(),
				"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (confirm == JOptionPane.YES_OPTION) {
			controllerVar.eliminarVariante(v.getIdVarianteProducto());
			JOptionPane.showMessageDialog(null, "Variante eliminada exitosamente.");
		}
	}

	public void modificarVariante() {
		VarianteProducto v = seleccionarVariante();
		if (v == null)
			return;

		String talle = JOptionPane.showInputDialog("Nuevo talle:", v.getTalle());
		if (talle == null || talle.trim().isEmpty())
			return;

		String color = JOptionPane.showInputDialog("Nuevo color:", v.getColor());
		if (color == null || color.trim().isEmpty())
			return;

		String precioStr = JOptionPane.showInputDialog("Nuevo precio de venta:", v.getPrecio_venta());
		if (precioStr == null)
			return;

		double precio = 0;
		try {
			precio = Double.parseDouble(precioStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: El precio debe ser un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		v.setTalle(talle);
		v.setColor(color);
		v.setPrecio_venta(precio);

		controllerVar.modificarVariante(v);
		JOptionPane.showMessageDialog(null, "Variante actualizada correctamente.");
	}

	// --- MOVER PRODUCTO ---
	public void moverProducto() {
		VarianteProducto v = seleccionarVariante();
		if (v == null)
			return;
		List<BLL.Deposito> depositos = controllerVar.obtenerDepositos();
		if (depositos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay depósitos registrados.");
			return;
		}

		Object[] depArray = depositos.toArray();
		BLL.Deposito depSel = (BLL.Deposito) JOptionPane.showInputDialog(null,
				"Mover variante: " + v.getProducto().getNombre_producto() + " (Talle: " + v.getTalle() + ")\n\n"
						+ "Seleccione el NUEVO depósito de destino:",
				"Mover Stock", JOptionPane.QUESTION_MESSAGE, null, depArray, depArray[0]);

		if (depSel == null)
			return;

		int confirm = JOptionPane.showConfirmDialog(null,
				"¿Confirmar el traslado al depósito: " + depSel.getLugarDeposito().toUpperCase() + "?\n"
						+ "(Se moverá todo el stock de esta variante a la nueva ubicación)",
				"Confirmar Movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (confirm == JOptionPane.YES_OPTION) {
			controllerVar.moverVariante(v.getIdVarianteProducto(), depSel.getIdDeposito());
			JOptionPane.showMessageDialog(null, "El stock ha sido movido exitosamente.");
		}
	}

	// --- GESTIÓN DE ENVÍOS ---
	// --- CRUD ENVÍOS ---
	public void verPedidos() {
		String datosPedidos = controllerEnvio.obtenerListaPedidos();

		JOptionPane.showMessageDialog(null, datosPedidos, "Lista de Pedidos y Envíos", JOptionPane.INFORMATION_MESSAGE);
	}

	public void modificarEnvio() {
		String[] opciones = controllerEnvio.obtenerOpcionesEnvios();

		if (opciones.length == 1 && opciones[0].equals("No hay envíos")) {
			JOptionPane.showMessageDialog(null, "No hay envíos registrados para modificar.");
			return;
		}

		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el envío a modificar:",
				"Modificar Seguimiento", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (seleccion == null)
			return;

		int idEnvio = Integer.parseInt(seleccion.split(" -")[0]);

		String nuevoSeguimiento = JOptionPane.showInputDialog(null,
				"Ingrese el nuevo número de seguimiento para el Envío #" + idEnvio + ":", "Nuevo Seguimiento",
				JOptionPane.QUESTION_MESSAGE);

		if (nuevoSeguimiento == null || nuevoSeguimiento.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Operación cancelada.");
			return;
		}

		controllerEnvio.modificarSeguimiento(idEnvio, nuevoSeguimiento);
		JOptionPane.showMessageDialog(null, "El número de seguimiento se actualizó correctamente.");
	}

	public void eliminarEnvio() {
		String[] opciones = controllerEnvio.obtenerOpcionesEnvios();

		if (opciones.length == 1 && opciones[0].equals("No hay envíos")) {
			JOptionPane.showMessageDialog(null, "No hay envíos registrados para eliminar.");
			return;
		}

		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el envío a ELIMINAR:",
				"Baja de Envío", JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);

		if (seleccion == null)
			return;

		int idEnvio = Integer.parseInt(seleccion.split(" -")[0]);

		int confirmacion = JOptionPane.showConfirmDialog(null,
				"¿Está seguro que desea eliminar definitivamente el Envío #" + idEnvio
						+ "?\nEsta acción no se puede deshacer.",
				"Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

		if (confirmacion == JOptionPane.YES_OPTION) {
			controllerEnvio.eliminarEnvio(idEnvio);
			JOptionPane.showMessageDialog(null, "El envío ha sido eliminado con éxito.", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Operación cancelada. El envío no fue eliminado.");
		}
	}

	public void enviarPedidoMenu() {
		if (!controllerEnvio.verificarCupoDiario()) {
			JOptionPane.showMessageDialog(null, "¡Cupo diario lleno! Ya se han realizado 10 despachos hoy.",
					"Límite alcanzado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String[] opciones = controllerEnvio.obtenerOpcionesPendientes();

		if (opciones.length == 1 && opciones[0].equals("No hay pedidos pendientes")) {
			JOptionPane.showMessageDialog(null, "No hay pedidos pendientes para enviar.");
			return;
		}

		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el pedido a DESPACHAR:",
				"Enviar Pedido", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (seleccion == null)
			return;

		int idEnvio = Integer.parseInt(seleccion.split(" -")[0]);
		controllerEnvio.enviarPedido(idEnvio);
		JOptionPane.showMessageDialog(null, "Pedido #" + idEnvio + " despachado con éxito.");
	}

	// --- VER CUPO DIARIO ---
	public void verCupoDiario() {
		int cantidad = controllerEnvio.obtenerCantidadDespachosHoy();

		JOptionPane.showMessageDialog(null, "Pedidos despachados hoy: " + cantidad + "/10", "Estado del Cupo Diario",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// --- GESTIÓN DE STOCK ---
	public void modificarStockMenu() {
		String[] opciones = controllerVar.obtenerOpcionesStock();

		if (opciones.length == 1 && opciones[0].equals("No hay stock registrado")) {
			JOptionPane.showMessageDialog(null, "No hay variantes con stock asignado para modificar.");
			return;
		}

		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la variante a modificar:",
				"Modificar Stock", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (seleccion == null)
			return;

		int idVariante = Integer.parseInt(seleccion.split(" -")[0]);

		String cantidadStr = JOptionPane.showInputDialog(null,
				"Ingrese la NUEVA cantidad de stock total para esta variante:", "Actualizar Stock",
				JOptionPane.INFORMATION_MESSAGE);

		if (cantidadStr == null || cantidadStr.trim().isEmpty())
			return;

		try {
			int nuevaCantidad = Integer.parseInt(cantidadStr);

			if (nuevaCantidad < 0) {
				JOptionPane.showMessageDialog(null, "Error: El stock no puede ser negativo.", "Cantidad inválida",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			controllerVar.actualizarCantidadStock(idVariante, nuevaCantidad);
			JOptionPane.showMessageDialog(null, "El stock se actualizó correctamente a: " + nuevaCantidad);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese únicamente números enteros.", "Error de formato",
					JOptionPane.ERROR_MESSAGE);
		}
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
		String[] opciones = { "Gestión de Producto", "Gestión de Pedido", "Gestión de Stock", "Gestión de Proveedor",
				"Cerrar Sesión" };
		int opcion;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú de Repositor", 0, 0, null,
					opciones, opciones[0]);

			switch (opcion) {
			case 0: // GESTIÓN DE PRODUCTOS
				String[] opGestion = { "Ver...", "Crear...", "Eliminar...", "Modificar...", "Mover producto...",
						"← Salir" };
				int opGestionSel;

				do {
					opGestionSel = JOptionPane.showOptionDialog(null, "Gestión de Productos", "Menú de Productos", 0, 0,
							null, opGestion, opGestion[0]);

					switch (opGestionSel) {
					case 0: // VER
						verInventario();
						break;

					case 1: // CREAR
						String[] opCrear = { "Categoría", "Producto", "Variante", "← Salir" };
						int opCrearSel = JOptionPane.showOptionDialog(null, "Elija qué crear:", "Crear", 0, 0, null,
								opCrear, opCrear[0]);

						switch (opCrearSel) {
						case 0:
							altaCategoria();
							break;
						case 1:
							altaProducto();
							break;
						case 2:
							altaVariante();
							break;
						}
						break;

					case 2: // ELIMINAR
						String[] opElim = { "Categoría", "Producto", "Variante", "← Salir" };
						int opElimSel = JOptionPane.showOptionDialog(null, "Elija qué eliminar:", "Eliminar", 0, 0,
								null, opElim, opElim[0]);

						switch (opElimSel) {
						case 0:
							eliminarCategoria();
							break;
						case 1:
							eliminarProducto();
							break;
						case 2:
							eliminarVariante();
							break;
						}
						break;

					case 3: // MODIFICAR
						String[] opMod = { "Categoría", "Producto", "Variante", "← Salir" };
						int opModSel = JOptionPane.showOptionDialog(null, "Elija qué modificar:", "Modificar", 0, 0,
								null, opMod, opMod[0]);

						switch (opModSel) {
						case 0:
							modificarCategoria();
							break;
						case 1:
							modificarProducto();
							break;
						case 2:
							modificarVariante();
							break;
						}
						break;

					case 4:
						moverProducto();
						break;
					}
				} while (opGestionSel != 5 && opGestionSel != -1);
				break;

			case 1:
				String[] opcionespedido = { "Ver pedidos", "Modificar pedido", "Eliminar pedido", "Enviar pedido",
						"Ver cupos diarios", "← Salir" };
				int opcionpedido;

				do {
					opcionpedido = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Pedidos", 0,
							0, null, opcionespedido, opcionespedido[0]);

					switch (opcionpedido) {
					case 0:
						verPedidos();
						break;
					case 1:
						modificarEnvio();
						break;
					case 2:
						eliminarEnvio();
						break;
					case 3:
						enviarPedidoMenu();
						break;
					case 4:
						verCupoDiario();
						break;
					case 5:
						break;
					}

				} while (opcionpedido != 5 && opcionpedido != -1);
				break;
			case 2:
				String[] opcionesStock = { "Ver estado del stock", "Modificar stock", "← Salir" };
				int opcionStockSel;

				do {
					opcionStockSel = JOptionPane.showOptionDialog(null, "Gestión de Inventario", "Stock", 0, 0, null,
							opcionesStock, opcionesStock[0]);

					switch (opcionStockSel) {
					case 0:
						verInventario();
						break;
					case 1:
						modificarStockMenu();
						break;
					}
				} while (opcionStockSel != 2 && opcionStockSel != -1);
				break;

			case 3:
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

		} while (opcion != 4 && opcion != -1);
	}
}