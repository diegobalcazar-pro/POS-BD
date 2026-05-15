package BLL;

import java.util.LinkedList;

import DLL.ControllerProducto;

public class Producto {

	//atriubtos
	protected int id_producto;
	protected String nombreProducto;
	protected String descripcionProducto;
	protected double precio;
	protected int stock;
	protected LinkedList <Proveedor> proveedores;
	private static ControllerProducto controller = new ControllerProducto();
	//constructores
	public Producto(int id_producto, String nombreProducto, String descripcionProducto, double precio, int stock,
			LinkedList<Proveedor> proveedores) {
		super();
		this.id_producto = id_producto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
		this.stock = stock;
		this.proveedores = proveedores;
	}
	
	public Producto(String nombreProducto, String descripcionProducto, double precio, int stock
			) {
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
		this.stock = stock;
		
	}
	//gettersysetters
	
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LinkedList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(LinkedList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	//tostring

	@Override
	public String toString() {
	    return nombreProducto + " | $" + precio + " | Stock: " + stock;
	}
	
	
	
	
}
