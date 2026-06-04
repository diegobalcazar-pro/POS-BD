package BLL;
import repository.*;

import DLL.ControllerProducto;

public class Producto {
	protected int id_producto;
	protected String nombre_producto;
	protected String descripcion_producto;
	protected Categoria categoria;
	protected Proveedor proveedor;
	private static ControllerProducto controller = new ControllerProducto();

	public Producto(int id_producto, String nombre_producto, String descripcion_producto, Categoria categoria,
			Proveedor proveedor) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion_producto = descripcion_producto;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public int getid_producto() {
		return id_producto;
	}

	public void setid_producto(int id_producto) {
		this.id_producto = id_producto;
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
	
	public static String MostrarProductosMasVendidos() {
	    return controller.MostrarProductosMasVendidos();
	}

	public static String MostrarProductosMenosVendidos() {
	    return controller.MostrarProductosMenosVendidos();
	}

}
