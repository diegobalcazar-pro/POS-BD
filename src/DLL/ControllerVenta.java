package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Cliente;
import BLL.ItemVenta;
import repository.VentaRepository;

public class ControllerVenta implements VentaRepository {

    private static Connection con = Conexion.getInstance().getConnection();

    private static final int DEPOSITO_LOCAL = 1;

    @Override
    public String mostrarClientesTexto() {
        String texto = "";

        try {
            PreparedStatement consultaClientes = con.prepareStatement("SELECT * FROM clientes");

            ResultSet resultadoClientes = consultaClientes.executeQuery();

            while (resultadoClientes.next()) {
                texto += "ID Cliente: " + resultadoClientes.getInt("id_cliente") + "\n";
                texto += "Nombre: " + resultadoClientes.getString("nombre_cliente") + " " + resultadoClientes.getString("apellido_cliente") + "\n";
                texto += "Email: " + resultadoClientes.getString("email") + "\n";
                texto += "Teléfono: " + resultadoClientes.getString("telefono") + "\n";
                texto += "Tipo: " + resultadoClientes.getString("tipo") + "\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "No hay clientes cargados.";
        }

        return texto;
    }

    @Override
    public Cliente buscarClientePorId(int idCliente) {
        Cliente cliente = null;

        try {
            PreparedStatement consultaCliente = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?");
            consultaCliente.setInt(1, idCliente);

            ResultSet resultadoCliente = consultaCliente.executeQuery();

            if (resultadoCliente.next()) {
                cliente = new Cliente(
                    resultadoCliente.getInt("id_cliente"),
                    resultadoCliente.getString("nombre_cliente"),
                    resultadoCliente.getString("apellido_cliente"),
                    resultadoCliente.getString("email"),
                    resultadoCliente.getString("telefono"),
                    resultadoCliente.getString("direccion"),
                    resultadoCliente.getString("tipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public String mostrarProductosConStock() {
        String texto = "";

        try {
            PreparedStatement consultaStock = con.prepareStatement("SELECT * FROM stocks WHERE fk_deposito = ?");
            consultaStock.setInt(1, DEPOSITO_LOCAL);

            ResultSet resultadoStock = consultaStock.executeQuery();

            while (resultadoStock.next()) {
                int idVarianteProducto = resultadoStock.getInt("fk_variante_producto");
                int cantidadStock = resultadoStock.getInt("cantidad");

                String nombreProducto = buscarNombreProductoPorVariante(idVarianteProducto);
                String talle = buscarTallePorVariante(idVarianteProducto);
                String color = buscarColorPorVariante(idVarianteProducto);
                double precioVenta = buscarPrecioPorVariante(idVarianteProducto);

                texto += "ID Variante: " + idVarianteProducto + "\n";
                texto += "Producto: " + nombreProducto + "\n";
                texto += "Talle: " + talle + "\n";
                texto += "Color: " + color + "\n";
                texto += "Precio: $" + precioVenta + "\n";
                texto += "Stock Local: " + cantidadStock + "\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "No hay productos con stock en el local.";
        }

        return texto;
    }

    @Override
    public ItemVenta buscarItemVenta(int idVarianteProducto, int cantidad) {
        ItemVenta item = null;

        try {
            PreparedStatement consultaStock = con.prepareStatement("SELECT * FROM stocks WHERE fk_variante_producto = ? AND fk_deposito = ?");
            consultaStock.setInt(1, idVarianteProducto);
            consultaStock.setInt(2, DEPOSITO_LOCAL);

            ResultSet resultadoStock = consultaStock.executeQuery();

            if (resultadoStock.next()) {
                int stockActual = resultadoStock.getInt("cantidad");

                if (stockActual >= cantidad) {
                    String nombreProducto = buscarNombreProductoPorVariante(idVarianteProducto);
                    String talle = buscarTallePorVariante(idVarianteProducto);
                    String color = buscarColorPorVariante(idVarianteProducto);
                    double precioVenta = buscarPrecioPorVariante(idVarianteProducto);

                    item = new ItemVenta(
                        idVarianteProducto,
                        nombreProducto,
                        talle,
                        color,
                        precioVenta,
                        cantidad
                    );
                } else {
                    String texto = "";

                    texto += "No hay stock suficiente.\n";
                    texto += "Stock actual: " + stockActual;

                    JOptionPane.showMessageDialog(null, texto);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró stock para esa variante en el local.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public String mostrarMetodosPagoTexto() {
        String texto = "";

        try {
            PreparedStatement consultaMetodosPago = con.prepareStatement("SELECT * FROM metodos_de_pagos");

            ResultSet resultadoMetodosPago = consultaMetodosPago.executeQuery();

            while (resultadoMetodosPago.next()) {
                texto += "ID Método: " + resultadoMetodosPago.getInt("id_metodo_de_pago") + "\n";
                texto += "Tipo: " + resultadoMetodosPago.getString("tipo") + "\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "No hay métodos de pago cargados.";
        }

        return texto;
    }

    @Override
    public String mostrarDescuentosTexto() {
        String texto = "";

        try {
            PreparedStatement consultaDescuentos = con.prepareStatement("SELECT * FROM descuentos");

            ResultSet resultadoDescuentos = consultaDescuentos.executeQuery();

            while (resultadoDescuentos.next()) {
                texto += "ID Descuento: " + resultadoDescuentos.getInt("id_descuento") + "\n";
                texto += "Nombre: " + resultadoDescuentos.getString("nombre_descuento") + "\n";
                texto += "Porcentaje: " + resultadoDescuentos.getDouble("porcentaje_descuento") + "%\n";
                texto += "-----------------------------\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (texto.isEmpty()) {
            texto = "No hay descuentos cargados.";
        }

        return texto;
    }

    @Override
    public double obtenerPorcentajeDescuento(int idDescuento) {
        double porcentajeDescuento = 0;

        try {
            PreparedStatement consultaDescuento = con.prepareStatement("SELECT * FROM descuentos WHERE id_descuento = ?");
            consultaDescuento.setInt(1, idDescuento);

            ResultSet resultadoDescuento = consultaDescuento.executeQuery();

            if (resultadoDescuento.next()) {
                porcentajeDescuento = resultadoDescuento.getDouble("porcentaje_descuento");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return porcentajeDescuento;
    }

    @Override
    public boolean hayStockSuficiente(int idVarianteProducto, int cantidad) {
        boolean hayStock = false;

        try {
            PreparedStatement consultaStock = con.prepareStatement("SELECT * FROM stocks WHERE fk_variante_producto = ? AND fk_deposito = ?");
            consultaStock.setInt(1, idVarianteProducto);
            consultaStock.setInt(2, DEPOSITO_LOCAL);

            ResultSet resultadoStock = consultaStock.executeQuery();

            if (resultadoStock.next()) {
                int stockActual = resultadoStock.getInt("cantidad");

                if (stockActual >= cantidad) {
                    hayStock = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hayStock;
    }

    @Override
    public boolean procesarVenta(int idUsuario, int idCliente, int idMetodoPago, int idDescuento, double totalBruto, double totalNeto, LinkedList<ItemVenta> carrito) {
        try {
            for (ItemVenta item : carrito) {
                if (!hayStockSuficiente(item.getId_variante_producto(), item.getCantidad())) {
                    String texto = "";

                    texto += "No hay stock suficiente para:\n";
                    texto += item.getNombre_producto();

                    JOptionPane.showMessageDialog(null, texto);

                    return false;
                }
            }

            PreparedStatement insertarVenta = con.prepareStatement("INSERT INTO ventas (fecha, total_neto, total_bruto, fk_usuario, fk_cliente, fk_metodo_de_pago, fk_descuento) VALUES (NOW(), ?, ?, ?, ?, ?, ?)");

            insertarVenta.setDouble(1, totalNeto);
            insertarVenta.setDouble(2, totalBruto);
            insertarVenta.setInt(3, idUsuario);
            insertarVenta.setInt(4, idCliente);
            insertarVenta.setInt(5, idMetodoPago);

            if (idDescuento == 0) {
                insertarVenta.setNull(6, Types.INTEGER);
            } else {
                insertarVenta.setInt(6, idDescuento);
            }

            int filasVenta = insertarVenta.executeUpdate();

            if (filasVenta == 0) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la venta.");
                return false;
            }

            int idVenta = obtenerUltimaVentaUsuario(idUsuario);

            if (idVenta == 0) {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID de la venta.");
                return false;
            }

            for (ItemVenta item : carrito) {
                PreparedStatement insertarDetalleVenta = con.prepareStatement("INSERT INTO detalles_ventas (cantidad, fk_venta, fk_variante_producto) VALUES (?, ?, ?)");

                insertarDetalleVenta.setInt(1, item.getCantidad());
                insertarDetalleVenta.setInt(2, idVenta);
                insertarDetalleVenta.setInt(3, item.getId_variante_producto());

                insertarDetalleVenta.executeUpdate();

                PreparedStatement actualizarStock = con.prepareStatement("UPDATE stocks SET cantidad = cantidad - ? WHERE fk_variante_producto = ? AND fk_deposito = ?");

                actualizarStock.setInt(1, item.getCantidad());
                actualizarStock.setInt(2, item.getId_variante_producto());
                actualizarStock.setInt(3, DEPOSITO_LOCAL);

                actualizarStock.executeUpdate();

                PreparedStatement insertarAuditoriaStock = con.prepareStatement("INSERT INTO auditorias_stocks (tipo_movimiento, cantidad, fecha, fk_variante_producto, fk_usuario, fk_deposito_origen, fk_deposito_destino) VALUES ('venta', ?, NOW(), ?, ?, ?, NULL)");

                insertarAuditoriaStock.setInt(1, item.getCantidad());
                insertarAuditoriaStock.setInt(2, item.getId_variante_producto());
                insertarAuditoriaStock.setInt(3, idUsuario);
                insertarAuditoriaStock.setInt(4, DEPOSITO_LOCAL);

                insertarAuditoriaStock.executeUpdate();
            }

            String texto = "";

            texto += "Venta procesada correctamente.\n";
            texto += "N° Venta: " + idVenta;

            JOptionPane.showMessageDialog(null, texto);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String buscarNombreProductoPorVariante(int idVarianteProducto) {
        String nombreProducto = "";

        try {
            PreparedStatement consultaVarianteProducto = con.prepareStatement("SELECT * FROM variantes_productos WHERE id_variante_producto = ?");
            consultaVarianteProducto.setInt(1, idVarianteProducto);

            ResultSet resultadoVarianteProducto = consultaVarianteProducto.executeQuery();

            if (resultadoVarianteProducto.next()) {
                int idProducto = resultadoVarianteProducto.getInt("fk_producto");

                PreparedStatement consultaProducto = con.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
                consultaProducto.setInt(1, idProducto);

                ResultSet resultadoProducto = consultaProducto.executeQuery();

                if (resultadoProducto.next()) {
                    nombreProducto = resultadoProducto.getString("nombre_producto");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nombreProducto;
    }

    public String buscarTallePorVariante(int idVarianteProducto) {
        String talle = "";

        try {
            PreparedStatement consultaVarianteProducto = con.prepareStatement("SELECT * FROM variantes_productos WHERE id_variante_producto = ?");
            consultaVarianteProducto.setInt(1, idVarianteProducto);

            ResultSet resultadoVarianteProducto = consultaVarianteProducto.executeQuery();

            if (resultadoVarianteProducto.next()) {
                talle = resultadoVarianteProducto.getString("talle");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return talle;
    }

    public String buscarColorPorVariante(int idVarianteProducto) {
        String color = "";

        try {
            PreparedStatement consultaVarianteProducto = con.prepareStatement("SELECT * FROM variantes_productos WHERE id_variante_producto = ?");
            consultaVarianteProducto.setInt(1, idVarianteProducto);

            ResultSet resultadoVarianteProducto = consultaVarianteProducto.executeQuery();

            if (resultadoVarianteProducto.next()) {
                color = resultadoVarianteProducto.getString("color");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return color;
    }

    public double buscarPrecioPorVariante(int idVarianteProducto) {
        double precioVenta = 0;

        try {
            PreparedStatement consultaVarianteProducto = con.prepareStatement("SELECT * FROM variantes_productos WHERE id_variante_producto = ?");
            consultaVarianteProducto.setInt(1, idVarianteProducto);

            ResultSet resultadoVarianteProducto = consultaVarianteProducto.executeQuery();

            if (resultadoVarianteProducto.next()) {
                precioVenta = resultadoVarianteProducto.getDouble("precio_venta");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return precioVenta;
    }

    private int obtenerUltimaVentaUsuario(int idUsuario) {
        int idVenta = 0;

        try {
            PreparedStatement consultaVenta = con.prepareStatement("SELECT MAX(id_venta) FROM ventas WHERE fk_usuario = ?");
            consultaVenta.setInt(1, idUsuario);

            ResultSet resultadoVenta = consultaVenta.executeQuery();

            if (resultadoVenta.next()) {
                idVenta = resultadoVenta.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idVenta;
    }
}