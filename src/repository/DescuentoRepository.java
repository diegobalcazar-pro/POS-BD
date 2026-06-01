package repository;

import java.util.LinkedList;
import BLL.Descuento;

public interface DescuentoRepository {
	LinkedList<Descuento> mostrarDescuentos();
	void agregarDescuento(Descuento descuento);

}
