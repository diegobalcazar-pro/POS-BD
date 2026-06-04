package repository;

import BLL.Categoria;
import java.util.List;

public interface CategoriaRepository {
	void agregarCategoria(Categoria c);
    void eliminarCategoria(int id);
    void modificarCategoria(Categoria c);
    List<Categoria> obtenerCategorias();
    String categoriaMasVendida();
}