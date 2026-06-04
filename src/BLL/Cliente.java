package BLL;

public class Cliente {
	protected int id_cliente;
	protected String nombre_cliente;
	protected String apellido_cliente;
	protected String correo;
	protected String telefono;
	protected String direccion;
	protected String tipo;

	public Cliente(int id_cliente, String nombre_cliente, String apellido_cliente, String correo, String telefono,
			String direccion, String tipo) {
		super();
		this.id_cliente = id_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public int getid_cliente() {
		return id_cliente;
	}

	public void setid_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente\nNombre:" + nombre_cliente
				+ "\napellido:"+ apellido_cliente;
	}
	
	

}
