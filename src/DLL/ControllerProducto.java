package DLL;

import BLL.Producto;
import BLL.Categoria;
import BLL.Proveedor;
import repository.ProductoRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
	
	public static LinkedList<Producto> mostrarProductos() {
		LinkedList<Producto> productos = new LinkedList<>();
		String sql = "SELECT p.*, c.nombre_categoria, prov.nombreEmpresa " + "FROM productos p "
				+ "JOIN categorias c ON p.fk_categoria = c.id_categoria "
				+ "JOIN proveedores prov ON p.fk_proveedor = prov.id_proveedor";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Categoria cat = new Categoria(rs.getInt("fk_categoria"), rs.getString("nombre_categoria"));

				Proveedor prov = new Proveedor(rs.getInt("fk_proveedor"), rs.getString("nombreEmpresa"), "", "", "");

				productos.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre_producto"),
						rs.getString("descripcion_producto"), cat, prov));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
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
	public String MostrarProductosMasVendidos() {
	    StringBuilder resultado = new StringBuilder();
	    try {
	        PreparedStatement statement = con.prepareStatement(
	       "SELECT productos.nombre_producto, SUM(detalles_ventas.cantidad) AS total_vendido FROM detalles_ventas "
	       + "INNER JOIN variantes_productos ON detalles_ventas.fk_variante_producto = variantes_productos.id_variante_producto"
	       + " INNER JOIN productos ON variantes_productos.fk_producto = productos.id_producto GROUP BY productos.id_producto, productos.nombre_producto ORDER BY total_vendido DESC");

            ResultSet resultSet = statement.executeQuery();

            int posicion = 1;

            while (resultSet.next()) {

             resultado.append(posicion)
                      .append("° ")
                      .append(resultSet.getString("nombre_producto"))
                      .append(" - ")
                      .append(resultSet.getInt("total_vendido"))
                      .append(" unidades vendidas\n");

             posicion++;
                         }

            } catch (Exception e) {
                e.printStackTrace();
            }
	    if (resultado.length() == 0) {
	        return "No existen ventas registradas.";
	    }
           return resultado.toString();
         }
	
	
	
	
	
	public String MostrarProductosMenosVendidos() {
		StringBuilder resultado = new StringBuilder();
	    try {
	        PreparedStatement statement = con.prepareStatement(
	        		"SELECT productos.nombre_producto, SUM(detalles_ventas.cantidad) AS total_vendido FROM detalles_ventas\r\n"
	        		+ "INNER JOIN variantes_productos ON detalles_ventas.fk_variante_producto = variantes_productos.id_variante_producto\r\n"
	        		+ "INNER JOIN productos ON variantes_productos.fk_producto = productos.id_producto GROUP BY productos.id_producto, productos.nombre_producto\r\n"
	        		+ "ORDER BY total_vendido ASC");

            ResultSet resultSet = statement.executeQuery();

            int posicion = 1;

            while (resultSet.next()) {

             resultado.append(posicion)
                      .append("° ")
                      .append(resultSet.getString("nombre_producto"))
                      .append(" - ")
                      .append(resultSet.getInt("total_vendido"))
                      .append(" unidades vendidas\n");

             posicion++;
                         }

            } catch (Exception e) {
                e.printStackTrace();
            }
	    if (resultado.length() == 0) {
	        return "No existen ventas registradas.";
	    }
           return resultado.toString();
         }
}