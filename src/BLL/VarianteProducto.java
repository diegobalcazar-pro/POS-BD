package BLL;

public class VarianteProducto {

	private int id_variante_producto;
    private String talle;
    private String color;
    private double precio_venta;
    private int fk_producto;
    
	public VarianteProducto(int id_variante_producto, String talle, String color, double precio_venta, int fk_producto) {
		super();
		this.id_variante_producto = id_variante_producto;
		this.talle = talle;
		this.color = color;
		this.precio_venta = precio_venta;
		this.fk_producto = fk_producto;
	}

	public VarianteProducto(String talle, String color, double precio_venta, int fk_producto) {
        this(0, talle, color, precio_venta, fk_producto);
    }
	
	public int getId_variante_producto() {
        return id_variante_producto;
    }

    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public int getFk_producto() {
        return fk_producto;
    }

    @Override
    public String toString() {
        return id_variante_producto + " - Talle: " + talle + " | Color: " + color + " | Precio: $" + precio_venta;
    }
    
}
