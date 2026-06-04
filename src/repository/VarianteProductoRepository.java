package repository;

import BLL.Deposito;
import BLL.VarianteProducto;
import java.util.List;

public interface VarianteProductoRepository {
	String obtenerInventarioCompleto();
    List<Deposito> obtenerDepositos();
	void agregarVarianteConStock(VarianteProducto v, int cantidad, int idDeposito);
	List<VarianteProducto> obtenerVariantes();
    void eliminarVariante(int id);
    void modificarVariante(VarianteProducto v);
    /*void moverVariante(int idVariante, int idNuevoDeposito);*/
    void moverVariante(int idVariante, int idNuevoDeposito, int idUsuario);
    String[] obtenerOpcionesStock();
    void actualizarCantidadStock(int idVariante, int nuevaCantidad);
	
}