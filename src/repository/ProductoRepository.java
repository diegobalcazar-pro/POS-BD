package repository;

import BLL.Producto;
import java.util.List;

public interface ProductoRepository {
    void agregarProducto(Producto p);
    void eliminarProducto(int id);
    void modificarProducto(Producto p);
    List<Producto> obtenerProductos();
    
}