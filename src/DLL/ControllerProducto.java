package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Categoria;
import BLL.Producto;
import BLL.Proveedor;
import BLL.VarianteProducto;
import repository.ProductoRepository;

public class ControllerProducto implements ProductoRepository {

    private static Connection con = Conexion.getInstance().getConnection();

    @Override
    public LinkedList<Categoria> mostrarCategorias() {
        LinkedList<Categoria> categorias = new LinkedList<Categoria>();

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM categorias"
            );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre_categoria")
                );

                categorias.add(categoria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categorias;
    }

    @Override
    public String mostrarCategoriasTexto() {
        LinkedList<Categoria> categorias = mostrarCategorias();

        if (categorias.isEmpty()) {
            return "No hay categorías cargadas.";
        }

        String texto = "";

        for (Categoria c : categorias) {
            texto += c.toString() + "\n";
        }

        return texto;
    }

    @Override
    public LinkedList<Proveedor> mostrarProveedores() {
        LinkedList<Proveedor> proveedores = new LinkedList<Proveedor>();

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM proveedores"
            );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombreEmpresa"),
                    rs.getString("nombreContacto"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                );

                proveedores.add(proveedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return proveedores;
    }

    @Override
    public String mostrarProveedoresTexto() {
        LinkedList<Proveedor> proveedores = mostrarProveedores();

        if (proveedores.isEmpty()) {
            return "No hay proveedores cargados.";
        }

        String texto = "";

        for (Proveedor p : proveedores) {
            texto += p.toString() + "\n";
        }

        return texto;
    }

    @Override
    public void agregarProducto(Producto producto) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO productos (nombre_producto, descripcion_producto, fk_categoria, fk_proveedor) VALUES (?, ?, ?, ?)"
            );

            stmt.setString(1, producto.getNombre_producto());
            stmt.setString(2, producto.getDescripcion_producto());
            stmt.setInt(3, producto.getFk_categoria());
            stmt.setInt(4, producto.getFk_proveedor());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void agregarVariante(VarianteProducto variante) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO variantes_productos (talle, color, precio_venta, fk_producto) VALUES (?, ?, ?, ?)"
            );

            stmt.setString(1, variante.getTalle());
            stmt.setString(2, variante.getColor());
            stmt.setDouble(3, variante.getPrecio_venta());
            stmt.setInt(4, variante.getFk_producto());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Variante agregada correctamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<Producto> mostrarProductos() {
        LinkedList<Producto> productos = new LinkedList<Producto>();

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM productos"
            );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("descripcion_producto"),
                    rs.getInt("fk_categoria"),
                    rs.getInt("fk_proveedor")
                );

                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public String mostrarProductosCompleto() {
        String texto = "";

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT p.id_producto, p.nombre_producto, p.descripcion_producto, " +
                "c.nombre_categoria, pr.nombreEmpresa " +
                "FROM productos p " +
                "INNER JOIN categorias c ON p.fk_categoria = c.id_categoria " +
                "INNER JOIN proveedores pr ON p.fk_proveedor = pr.id_proveedor " +
                "ORDER BY p.id_producto ASC"
            );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                texto += "ID Producto: " + rs.getInt("id_producto") + "\n";
                texto += "Nombre: " + rs.getString("nombre_producto") + "\n";
                texto += "Descripción: " + rs.getString("descripcion_producto") + "\n";
                texto += "Categoría: " + rs.getString("nombre_categoria") + "\n";
                texto += "Proveedor: " + rs.getString("nombreEmpresa") + "\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "No hay productos cargados.";
        }

        return texto;
    }

    @Override
    public String mostrarVariantesProducto(int idProducto) {
        String texto = "";

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM variantes_productos WHERE fk_producto = ?"
            );

            stmt.setInt(1, idProducto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                texto += "ID Variante: " + rs.getInt("id_variante_producto") + "\n";
                texto += "Talle: " + rs.getString("talle") + "\n";
                texto += "Color: " + rs.getString("color") + "\n";
                texto += "Precio: $" + rs.getDouble("precio_venta") + "\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "Este producto no tiene variantes.";
        }

        return texto;
    }

    @Override
    public void modificarProducto(Producto producto) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE productos SET nombre_producto = ?, descripcion_producto = ?, fk_categoria = ?, fk_proveedor = ? WHERE id_producto = ?"
            );

            stmt.setString(1, producto.getNombre_producto());
            stmt.setString(2, producto.getDescripcion_producto());
            stmt.setInt(3, producto.getFk_categoria());
            stmt.setInt(4, producto.getFk_proveedor());
            stmt.setInt(5, producto.getId_producto());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int idProducto) {
        try {
            PreparedStatement verificar = con.prepareStatement(
                "SELECT COUNT(*) AS cantidad FROM variantes_productos WHERE fk_producto = ?"
            );

            verificar.setInt(1, idProducto);

            ResultSet rs = verificar.executeQuery();

            if (rs.next()) {
                int cantidadVariantes = rs.getInt("cantidad");

                if (cantidadVariantes > 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "No se puede eliminar este producto porque tiene variantes cargadas. Primero habría que eliminar sus variantes"
                    );
                    return;
                }
            }

            PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM productos WHERE id_producto = ?"
            );

            stmt.setInt(1, idProducto);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}