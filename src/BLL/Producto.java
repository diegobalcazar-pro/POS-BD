package BLL;

public class Producto {
	protected int idProducto;
	protected String nombre_producto;
	protected String descripcion_producto;
	protected Categoria categoria;
	protected Proveedor proveedor;

	public Producto(int idProducto, String nombre_producto, String descripcion_producto, Categoria categoria,
			Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.nombre_producto = nombre_producto;
		this.descripcion_producto = descripcion_producto;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}
