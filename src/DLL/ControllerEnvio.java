package DLL;

import repository.EnvioRepository;
import java.sql.*;

public class ControllerEnvio implements EnvioRepository {
	private Connection con = Conexion.getInstance().getConnection();

	@Override
	public String obtenerListaPedidos() {
		StringBuilder sb = new StringBuilder();

		String sql = "SELECT e.id_envio, e.numero_seguimiento, e.estado, e.fecha_despacho, "
				+ "v.id_venta, v.fecha AS fecha_venta, c.nombre_cliente, c.apellido_cliente " + "FROM envios e "
				+ "JOIN ventas v ON e.fk_venta = v.id_venta " + "JOIN clientes c ON v.fk_cliente = c.id_cliente "
				+ "ORDER BY e.estado, v.fecha";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			boolean hayDatos = false;

			while (rs.next()) {
				hayDatos = true;
				sb.append("Pedido (Envío #").append(rs.getInt("id_envio")).append(") - ");
				sb.append("Venta #").append(rs.getInt("id_venta")).append("\n");

				sb.append("Cliente: ").append(rs.getString("nombre_cliente")).append(" ")
						.append(rs.getString("apellido_cliente")).append("\n");

				sb.append("Estado: ").append(rs.getString("estado").toUpperCase()).append("\n");
				sb.append("Seguimiento: ").append(rs.getString("numero_seguimiento")).append("\n");

				java.sql.Date fechaDespacho = rs.getDate("fecha_despacho");
				if (fechaDespacho != null) {
					sb.append("Fecha Despacho: ").append(fechaDespacho).append("\n");
				} else {
					sb.append("Fecha Despacho: Aún no despachado\n");
				}

				sb.append("--------------------------------------------------\n");
			}

			if (!hayDatos) {
				return "No hay pedidos/envíos registrados.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error al cargar los pedidos.";
		}

		return sb.toString();
	}

	@Override
	public String[] obtenerOpcionesEnvios() {
		java.util.List<String> opciones = new java.util.ArrayList<>();
		String sql = "SELECT id_envio, numero_seguimiento, estado FROM envios";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String item = rs.getInt("id_envio") + " - Seg: " + rs.getString("numero_seguimiento") + " ("
						+ rs.getString("estado") + ")";
				opciones.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (opciones.isEmpty()) {
			return new String[] { "No hay envíos" };
		}

		return opciones.toArray(new String[0]);
	}

	@Override
	public void modificarSeguimiento(int idEnvio, String nuevoSeguimiento) {
		String sql = "UPDATE envios SET numero_seguimiento = ? WHERE id_envio = ?";

		try (java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, nuevoSeguimiento);
			stmt.setInt(2, idEnvio);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas == 0) {
				System.out.println("No se encontró un envío con ese ID.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarEnvio(int idEnvio) {
		String sql = "DELETE FROM envios WHERE id_envio = ?";

		try (java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, idEnvio);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Envío eliminado correctamente de la base de datos.");
			} else {
				System.out.println("No se encontró el envío para eliminar.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] obtenerOpcionesPendientes() {
		java.util.List<String> opciones = new java.util.ArrayList<>();
		String sql = "SELECT id_envio, numero_seguimiento FROM envios WHERE estado = 'pendiente'";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				opciones.add(rs.getInt("id_envio") + " - Seg: " + rs.getString("numero_seguimiento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return opciones.isEmpty() ? new String[] { "No hay pedidos pendientes" } : opciones.toArray(new String[0]);
	}

	@Override
	public void enviarPedido(int idEnvio) {
		String sql = "UPDATE envios SET estado = 'despachado', fecha_despacho = CURDATE() WHERE id_envio = ?";

		try (java.sql.PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, idEnvio);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public int obtenerCantidadDespachosHoy() {
        String sql = "SELECT COUNT(*) FROM envios WHERE estado = 'despachado' AND fecha_despacho = CURDATE()";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    @Override
    public boolean verificarCupoDiario() {
        return obtenerCantidadDespachosHoy() < 10;
    }
}
