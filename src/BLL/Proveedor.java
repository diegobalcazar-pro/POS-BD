package BLL;

public class Proveedor {
	protected String direccionProveedor;
	protected String localidadProveedor;
	protected String descripcionProveedor;
	
	
	//Constructor
	public Proveedor(String nombre, String apellido, String dni, String telefono, String mail,
			String direccionProveedor, String localidadProveedor, String descripcionProveedor) {
		super();
		this.direccionProveedor = direccionProveedor;
		this.localidadProveedor = localidadProveedor;
		this.descripcionProveedor = descripcionProveedor;
	}


	
	//getters y setters
	public String getDireccionProveedor() {
		return direccionProveedor;
	}
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}


	public String getLocalidadProveedor() {
		return localidadProveedor;
	}
	public void setLocalidadProveedor(String localidadProveedor) {
		this.localidadProveedor = localidadProveedor;
	}


	public String getDescripcionProveedor() {
		return descripcionProveedor;
	}
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcionProveedor = descripcionProveedor;
	}
	
	  



	
	
}
