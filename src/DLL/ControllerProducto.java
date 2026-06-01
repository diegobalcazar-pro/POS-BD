package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


import BLL.Producto;

import repository.ProductoRepository;

public class ControllerProducto<T extends Producto> implements ProductoRepository{
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	
	public void agregarProducto(Producto producto) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO productos (nombreProducto, descripcionProducto, precio, stock) VALUES (?,?, ?, ?)"
            	
            		);
            statement.setString(1, producto.getNombreProducto());
            statement.setString(2, producto.getDescripcionProducto());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	 public LinkedList<Producto> mostrarProductos() {
	        LinkedList<Producto> productos = new LinkedList<>();
	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos");
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id_producto = rs.getInt("id_producto");
	                String nombreProducto= rs.getString("nombre_producto");
	                String descripcionProducto = rs.getString("descripcion_producto");
	                //double precio = rs.getDouble("precio");
	                //int stock = rs.getInt("stock");

	                 productos.add(new Producto(id_producto, nombreProducto, descripcionProducto));
	          
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productos;
	    }
	
	
	
	
}