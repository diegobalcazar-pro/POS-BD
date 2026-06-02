package BLL;

public class Proveedor {
	protected int id_proveedor;
	protected String nombreEmpresa;
	protected String nombreContacto;
	protected String telefono;
	protected String correo;

	public Proveedor(int id_proveedor, String nombreEmpresa, String nombreContacto, String telefono, String correo) {
		super();
		id_proveedor = id_proveedor;
		this.nombreEmpresa = nombreEmpresa;
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getid_proveedor() {
		return id_proveedor;
	}

	public void setid_proveedor(int id_proveedor) {
		id_proveedor = id_proveedor;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
