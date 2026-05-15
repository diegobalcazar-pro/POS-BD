package BLL;

import java.util.LinkedList;

public class Producto {

	//atriubtos
	protected int codigo;
	protected String nombreProducto;
	protected String descripcionProducto;
	protected double precio;
	protected int stock;
	protected LinkedList <Proveedor> proveedores;	
	//constructores
	public Producto(int codigo, String nombreProducto, String descripcionProducto, double precio, int stock,
			LinkedList<Proveedor> proveedores) {
		super();
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
		this.stock = stock;
		this.proveedores = proveedores;
	}
	//gettersysetters
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
