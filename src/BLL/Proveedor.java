package BLL;

public class Proveedor extends Persona{
	protected String direccionProveedor;
	protected String localidadProveedor;
	protected String descripcionProveedor;
	
	
	//Constructor
	public Proveedor(String nombre, String apellido, String dni, String telefono, String mail,
			String direccionProveedor, String localidadProveedor, String descripcionProveedor) {
		super(nombre, apellido, dni, telefono, mail);
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
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}



	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}



	@Override
	public String getApellido() {
		// TODO Auto-generated method stub
		return super.getApellido();
	}



	@Override
	public void setApellido(String apellido) {
		// TODO Auto-generated method stub
		super.setApellido(apellido);
	}



	@Override
	public String getDni() {
		// TODO Auto-generated method stub
		return super.getDni();
	}



	@Override
	public void setDni(String dni) {
		// TODO Auto-generated method stub
		super.setDni(dni);
	}



	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}



	@Override
	public void setTelefono(String telefono) {
		// TODO Auto-generated method stub
		super.setTelefono(telefono);
	}



	@Override
	public String getMail() {
		// TODO Auto-generated method stub
		return super.getMail();
	}



	@Override
	public void setMail(String mail) {
		// TODO Auto-generated method stub
		super.setMail(mail);
	}



	@Override
	public String toString() {
		return "Proveedor: " + getNombre()+" "+getApellido()+" | "+getDescripcionProveedor();
	}
	
}
