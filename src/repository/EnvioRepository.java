package repository;

public interface EnvioRepository {
    
    String obtenerListaPedidos();
    String[] obtenerOpcionesEnvios();
    void modificarSeguimiento(int idEnvio, String nuevoSeguimiento);
    void eliminarEnvio(int idEnvio);
    String[] obtenerOpcionesPendientes();
    void enviarPedido(int idEnvio);
	int obtenerCantidadDespachosHoy();
	boolean verificarCupoDiario();
	
}