package repository;

import java.util.LinkedList;
import BLL.Proveedor;

public interface ProveedorRepository {
	void agregarProveedor(Proveedor proveedor);
    LinkedList<Proveedor> mostrarProveedores();
    void eliminarProveedor(int id);
    void editarProveedor(Proveedor proveedor);

}