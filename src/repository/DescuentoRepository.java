package repository;

import java.util.LinkedList;
import java.util.List;
import BLL.Descuento;

public interface DescuentoRepository {
	LinkedList<Descuento> mostrarDescuentos();
	void agregarDescuento(Descuento descuento);

}
