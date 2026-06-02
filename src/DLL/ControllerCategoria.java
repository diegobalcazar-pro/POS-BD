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
}