package DLL;

import BLL.VarianteProducto;
import BLL.Producto;
import repository.VarianteProductoRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerVarianteProducto implements VarianteProductoRepository {
	private static Connection con = Conexion.getInstance().getConnection();

	@Override
	public String obtenerInventarioCompleto() {
		StringBuilder sb = new StringBuilder();

		String sql = "SELECT p.nombre_producto, c.nombre_categoria, v.talle, v.color, v.precio_venta, "
				+ "s.cantidad, d.lugar_deposito " + "FROM productos p "
				+ "JOIN categorias c ON p.fk_categoria = c.id_categoria "
				+ "JOIN variantes_productos v ON p.id_producto = v.fk_producto "
				+ "JOIN stocks s ON v.id_variante_producto = s.fk_variante_producto "
				+ "JOIN depositos d ON s.fk_deposito = d.id_deposito " + "ORDER BY p.nombre_producto, v.talle";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			boolean hayDatos = false;

			while (rs.next()) {
				hayDatos = true;
				sb.append("Producto: ").append(rs.getString("nombre_producto")).append(" (")
						.append(rs.getString("nombre_categoria")).append(")\n");

				sb.append("Variante: Talle ").append(rs.getString("talle")).append(" | Color ")
						.append(rs.getString("color")).append(" | Precio: $").append(rs.getDouble("precio_venta"))
						.append("\n");

				sb.append("Stock: ").append(rs.getInt("cantidad")).append(" unid. en ")
						.append(rs.getString("lugar_deposito").toUpperCase()).append("\n");

				sb.append("--------------------------------------------------\n");
			}

			if (!hayDatos) {
				return "No hay productos en el inventario.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error al cargar el inventario.";
		}

		return sb.toString();
	}

	@Override
	public List<BLL.Deposito> obtenerDepositos() {
		List<BLL.Deposito> lista = new ArrayList<>();
		String sql = "SELECT * FROM depositos";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				lista.add(new BLL.Deposito(rs.getInt("id_deposito"), rs.getString("lugar_deposito")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void agregarVarianteConStock(VarianteProducto v, int cantidad, int idDeposito) {
		try {
			con.setAutoCommit(false);

			String sqlVar = "INSERT INTO variantes_productos (talle, color, precio_venta, fk_producto) VALUES (?, ?, ?, ?)";
			PreparedStatement stmtVar = con.prepareStatement(sqlVar, Statement.RETURN_GENERATED_KEYS);
			stmtVar.setString(1, v.getTalle());
			stmtVar.setString(2, v.getColor());
			stmtVar.setDouble(3, v.getPrecio_venta());
			stmtVar.setInt(4, v.getProducto().getid_producto());
			stmtVar.executeUpdate();

			ResultSet rsKeys = stmtVar.getGeneratedKeys();
			int idVarianteGenerada = 0;
			if (rsKeys.next()) {
				idVarianteGenerada = rsKeys.getInt(1);
			}

			String sqlStock = "INSERT INTO stocks (cantidad, fk_deposito, fk_variante_producto) VALUES (?, ?, ?)";
			PreparedStatement stmtStock = con.prepareStatement(sqlStock);
			stmtStock.setInt(1, cantidad);
			stmtStock.setInt(2, idDeposito);
			stmtStock.setInt(3, idVarianteGenerada);
			stmtStock.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public List<VarianteProducto> obtenerVariantes() {
		List<VarianteProducto> lista = new ArrayList<>();
		String sql = "SELECT v.*, p.nombre_producto FROM variantes_productos v "
				+ "JOIN productos p ON v.fk_producto = p.id_producto";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Producto prod = new Producto(rs.getInt("fk_producto"), rs.getString("nombre_producto"), "", null, null);

				lista.add(new VarianteProducto(rs.getInt("id_variante_producto"), rs.getString("talle"),
						rs.getString("color"), rs.getDouble("precio_venta"), prod));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void eliminarVariante(int id) {
		String sql = "DELETE FROM variantes_productos WHERE id_variante_producto = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificarVariante(VarianteProducto v) {
		String sql = "UPDATE variantes_productos SET talle=?, color=?, precio_venta=?, fk_producto=? WHERE id_variante_producto=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, v.getTalle());
			stmt.setString(2, v.getColor());
			stmt.setDouble(3, v.getPrecio_venta());
			stmt.setInt(4, v.getProducto().getid_producto());
			stmt.setInt(5, v.getid_variante_producto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public void moverVariante(int idVariante, int idNuevoDeposito, int
	 * idUsuario) { String sql =
	 * "UPDATE stocks SET fk_deposito = ? WHERE fk_variante_producto = ?"; try
	 * (PreparedStatement stmt = con.prepareStatement(sql)) { stmt.setInt(1,
	 * idNuevoDeposito); stmt.setInt(2, idVariante);
	 * 
	 * int filasAfectadas = stmt.executeUpdate(); if (filasAfectadas == 0) {
	 * System.out.
	 * println("No se encontró stock asociado a esta variante para mover."); } }
	 * catch (SQLException e) { e.printStackTrace(); } }
	 */
	@Override
	public void moverVariante(int idVariante, int idNuevoDeposito, int idUsuario) {

		try {

			// Obtener datos actuales del stock
			PreparedStatement consulta = con
					.prepareStatement("SELECT cantidad, fk_deposito FROM stocks WHERE fk_variante_producto = ?");

			consulta.setInt(1, idVariante);

			ResultSet resultado = consulta.executeQuery();

			if (!resultado.next()) {
				System.out.println("No se encontró stock asociado a esta variante para mover.");
				return;
			}

			int cantidad = resultado.getInt("cantidad");
			int depositoOrigen = resultado.getInt("fk_deposito");

			// Actualizar depósito
			PreparedStatement actualizar = con
					.prepareStatement("UPDATE stocks SET fk_deposito = ? WHERE fk_variante_producto = ?");

			actualizar.setInt(1, idNuevoDeposito);
			actualizar.setInt(2, idVariante);

			int filasAfectadas = actualizar.executeUpdate();

			if (filasAfectadas > 0) {

				// Registrar auditoría
				PreparedStatement auditoria = con.prepareStatement("INSERT INTO auditorias_stocks "
						+ "(tipo_movimiento, cantidad, fecha, fk_variante_producto, fk_usuario, fk_deposito_origen, fk_deposito_destino) "
						+ "VALUES (?, ?, NOW(), ?, ?, ?, ?)");

				auditoria.setString(1, "traslado");
				auditoria.setInt(2, cantidad);
				auditoria.setInt(3, idVariante);
				auditoria.setInt(4, idUsuario);
				auditoria.setInt(5, depositoOrigen);
				auditoria.setInt(6, idNuevoDeposito);

				auditoria.executeUpdate();

				System.out.println("Movimiento registrado en auditoría.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] obtenerOpcionesStock() {
		java.util.List<String> opciones = new java.util.ArrayList<>();

		String sql = "SELECT v.id_variante_producto, p.nombre_producto, v.talle, v.color, s.cantidad "
				+ "FROM variantes_productos v " + "JOIN productos p ON v.fk_producto = p.id_producto "
				+ "JOIN stocks s ON s.fk_variante_producto = v.id_variante_producto";

		try (java.sql.Statement stmt = con.createStatement(); java.sql.ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String item = rs.getInt("id_variante_producto") + " - " + rs.getString("nombre_producto") + " (Talle: "
						+ rs.getString("talle") + " | Color: " + rs.getString("color") + ") -> Stock actual: "
						+ rs.getInt("cantidad");
				opciones.add(item);
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}

		return opciones.isEmpty() ? new String[] { "No hay stock registrado" } : opciones.toArray(new String[0]);
	}

	@Override
	public void actualizarCantidadStock(int idVariante, int nuevaCantidad) {
		String sql = "UPDATE stocks SET cantidad = ? WHERE fk_variante_producto = ?";

		try (java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, nuevaCantidad);
			stmt.setInt(2, idVariante);
			stmt.executeUpdate();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	public VarianteProducto buscarPorId(int id) {
		VarianteProducto variante = null;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT v.*, p.nombre_producto FROM variantes_productos v JOIN productos p ON v.fk_producto = p.id_producto WHERE v.id_variante_producto = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Producto producto = new Producto(rs.getInt("fk_producto"), rs.getString("nombre_producto"), "", null,
						null);
				variante = new VarianteProducto(rs.getInt("id_variante_producto"), rs.getString("talle"),
						rs.getString("color"), rs.getDouble("precio_venta"), producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return variante;
	}

	public int obtenerCantidadStock(int idVariante) {
		int cantidad = 0;
		String sql = "SELECT cantidad FROM stocks WHERE fk_variante_producto = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, idVariante);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					cantidad = rs.getInt("cantidad");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cantidad;
	}
	
	public static List<Object[]> obtenerInventarioParaTabla() {
	    List<Object[]> lista = new ArrayList<>();

	    String sql =
	        "SELECT v.id_variante_producto, p.nombre_producto, " +
	        "v.talle, v.color, v.precio_venta, d.lugar_deposito " +
	        "FROM productos p " +
	        "JOIN variantes_productos v ON p.id_producto = v.fk_producto " +
	        "JOIN stocks s ON v.id_variante_producto = s.fk_variante_producto " +
	        "JOIN depositos d ON s.fk_deposito = d.id_deposito";

	    try (Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            lista.add(new Object[] {
	                rs.getInt("id_variante_producto"),
	                rs.getString("nombre_producto"),
	                rs.getString("talle"),
	                rs.getString("color"),
	                rs.getDouble("precio_venta"),
	                rs.getString("lugar_deposito")
	            });
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
}