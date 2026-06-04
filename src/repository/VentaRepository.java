package repository;

import java.util.LinkedList;

import BLL.Cliente;
import BLL.ItemVenta;

public interface VentaRepository {

    String mostrarClientesTexto();
    Cliente buscarClientePorId(int idCliente);
    String mostrarProductosConStock();
    ItemVenta buscarItemVenta(int idVarianteProducto, int cantidad);
    String mostrarMetodosPagoTexto();
    String mostrarDescuentosTexto();
    double obtenerPorcentajeDescuento(int idDescuento);
    boolean hayStockSuficiente(int idVarianteProducto, int cantidad);
    boolean procesarVenta(int idUsuario,int idCliente,int idMetodoPago,int idDescuento,double totalBruto,double totalNeto,LinkedList<ItemVenta> carrito);
    String mostrarVentasPorFecha(String fecha);
    String mostrarVentasPorCliente(int idCliente);
    String mostrarDetalleVenta(int idVenta);
}