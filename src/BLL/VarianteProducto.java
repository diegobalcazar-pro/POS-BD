package BLL;

public class VarianteProducto {
	protected int id_variante_producto;
	protected String talle;
	protected String color;
	protected double precio_venta;
	protected Producto producto;

	public VarianteProducto(int id_variante_producto, String talle, String color, double precio_venta,
			Producto producto) {
		super();
		this.id_variante_producto = id_variante_producto;
		this.talle = talle;
		this.color = color;
		this.precio_venta = precio_venta;
		this.producto = producto;
	}

	public int getid_variante_producto() {
		return id_variante_producto;
	}

	public void setid_variante_producto(int id_variante_producto) {
		this.id_variante_producto = id_variante_producto;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
