package BLL;

import javax.swing.JOptionPane;

public class Repositor extends Usuario {

	public Repositor(int id, String nombre, String email, String tipo, String password) {
		super(id, nombre, email, tipo, password);
	}

	public Repositor(String nombre, String email, String tipo, String password) {
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
	public void Menu() {

		String[] opciones = { "Gestion producto", "Gestion pedido", "Gestion proveedor", "Cerrar sesion" };
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				String[] opcionesproducto = { "Cargar producto", "Eliminar producto", "Modificar producto",
						"Mover producto", "Salir" };
				int opcionproducto;
				do {
					opcionproducto = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null,
							opcionesproducto, opcionesproducto);
					switch (opcionproducto) {
					case 0:
						//AGREGAR PRODUCTOS
						// String nombre_producto, String descripcion_producto, Categoria categoria, Proveedor proveedor

						break;
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}

				} while (opcionproducto != 4);

				break;
			case 1:
				String[] opcionesopedido = { "Ver pedidos", "Ver cupos diarios", "Enviar pedido", "Salir" };
				int opcionpedido;
				do {
					opcionpedido = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null,
							opcionesopedido, opcionesopedido);
					switch (opcionpedido) {
					case 0:

						break;
					case 1:

						break;
					case 2:

						break;
					}

				} while (opcionpedido != 3);

				break;
			case 2:

				break;
			}
		} while (opcion != 3);

	}

}
