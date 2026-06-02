package repository;

import java.util.LinkedList;
import BLL.Categoria;
import BLL.Producto;
import BLL.Proveedor;
import BLL.VarianteProducto;

public interface ProductoRepository {
    LinkedList<Categoria> mostrarCategorias();
    String mostrarCategoriasTexto();
    LinkedList<Proveedor> mostrarProveedores();
    String mostrarProveedoresTexto();
    void agregarProducto(Producto producto);
    void agregarVariante(VarianteProducto variante);
    LinkedList<Producto> mostrarProductos();
    String mostrarProductosCompleto();
    String mostrarVariantesProducto(int idProducto);
    void modificarProducto(Producto producto);
    void eliminarProducto(int idProducto);
}