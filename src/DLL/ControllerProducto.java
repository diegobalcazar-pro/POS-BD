package DLL;

import BLL.Producto;
import BLL.Categoria;
import BLL.Proveedor;
import repository.ProductoRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerProducto implements ProductoRepository {
	private static Connection con = Conexion.getInstance().getConnection();

	@Override
	public void agregarProducto(Producto p) {
		String sql = "INSERT INTO productos (nombre_producto, descripcion_producto, fk_categoria, fk_proveedor) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, p.getNombre_producto());
			stmt.setString(2, p.getDescripcion_producto());
			stmt.setInt(3, p.getCategoria().getid_categoria()); 
			stmt.setInt(4, p.getProveedor().getid_proveedor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Producto> obtenerProductos() {
		List<Producto> lista = new ArrayList<>();
		String sql = "SELECT p.*, c.nombre_categoria, prov.nombreEmpresa " + "FROM productos p "
				+ "JOIN categorias c ON p.fk_categoria = c.id_categoria "
				+ "JOIN proveedores prov ON p.fk_proveedor = prov.id_proveedor";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Categoria cat = new Categoria(rs.getInt("fk_categoria"), rs.getString("nombre_categoria"));

				Proveedor prov = new Proveedor(rs.getInt("fk_proveedor"), rs.getString("nombreEmpresa"), "", "", "");

				lista.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre_producto"),
						rs.getString("descripcion_producto"), cat, prov));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void eliminarProducto(int id) {
		String sql = "DELETE FROM productos WHERE id_producto = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificarProducto(Producto p) {
		String sql = "UPDATE productos SET nombre_producto=?, descripcion_producto=?, fk_categoria=?, fk_proveedor=? WHERE id_producto=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, p.getNombre_producto());
			stmt.setString(2, p.getDescripcion_producto());
			stmt.setInt(3, p.getCategoria().getid_categoria());
			stmt.setInt(4, p.getProveedor().getid_proveedor());
			stmt.setInt(5, p.getid_producto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}