package BLL;

public class ItemVenta {

    private int id_variante_producto;
    private String nombre_producto;
    private String talle;
    private String color;
    private double precio_unitario;
    private int cantidad;

    public ItemVenta(int id_variante_producto, String nombre_producto, String talle, String color, double precio_unitario, int cantidad) {
        this.id_variante_producto = id_variante_producto;
        this.nombre_producto = nombre_producto;
        this.talle = talle;
        this.color = color;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
    }

    public int getId_variante_producto() {
        return id_variante_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return precio_unitario * cantidad;
    }

    @Override
    public String toString() {
        return "ID Variante: " + id_variante_producto +
               "\nProducto: " + nombre_producto +
               "\nTalle: " + talle +
               "\nColor: " + color +
               "\nPrecio Unitario: $" + precio_unitario +
               "\nCantidad: " + cantidad +
               "\nSubtotal: $" + getSubtotal() +
               "\n-----------------------------";
    }
}