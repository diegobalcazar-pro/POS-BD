package DLL;

import BLL.Categoria;
import repository.CategoriaRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerCategoria implements CategoriaRepository {

	private static Connection con = Conexion.getInstance().getConnection();

	@Override
	public void agregarCategoria(Categoria c) {
		String sql = "INSERT INTO categorias (nombre_categoria) VALUES (?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getNombre_categoria());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		List<Categoria> lista = new ArrayList<>();
		String sql = "SELECT * FROM categorias";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				lista.add(new Categoria(rs.getInt("id_categoria"), rs.getString("nombre_categoria")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void eliminarCategoria(int id) {
		String sql = "DELETE FROM categorias WHERE id_categoria = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificarCategoria(Categoria c) {
		String sql = "UPDATE categorias SET nombre_categoria = ? WHERE id_categoria = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getNombre_categoria());
			stmt.setInt(2, c.getid_categoria());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String categoriaMasVendida() {

	    StringBuilder resultado = new StringBuilder();

	    try {
	        PreparedStatement statement = con.prepareStatement(
	           "SELECT categorias.nombre_categoria, SUM(detalles_ventas.cantidad) AS total_vendido FROM detalles_ventas INNER JOIN variantes_productos " +
	           "ON detalles_ventas.fk_variante_producto = variantes_productos.id_variante_producto INNER JOIN productos ON variantes_productos.fk_producto = productos.id_producto " +
	           "INNER JOIN categorias ON productos.fk_categoria = categorias.id_categoria GROUP BY categorias.id_categoria, categorias.nombre_categoria ORDER BY total_vendido DESC LIMIT 1"
	        );

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {

	            resultado.append("Categoría más vendida: ")
	                     .append(rs.getString("nombre_categoria"))
	                     .append("\nTotal vendido: ")
	                     .append(rs.getInt("total_vendido"))
	                     .append(" unidades");
	        } else {
	            resultado.append("No hay ventas registradas.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return resultado.toString();
	}
}