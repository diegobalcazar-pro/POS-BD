package repository;
import java.util.LinkedList;
import BLL.Producto;

public interface ProductoRepository {
	void agregarProducto(Producto producto);
	LinkedList<Producto> mostrarProductos();

}
