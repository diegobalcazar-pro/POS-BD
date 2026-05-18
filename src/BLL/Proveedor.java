package BLL;

import javax.swing.JOptionPane;
import repository.Hashing;
import repository.Validaciones;

public class Proveedor {
	protected int IdProveedor;
	protected String nombreEmpresa;
	protected String nombreContacto;
	protected String telefono;
	protected String correo;

	public Proveedor(int idProveedor, String nombreEmpresa, String nombreContacto, String telefono, String correo) {
		super();
		IdProveedor = idProveedor;
		this.nombreEmpresa = nombreEmpresa;
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
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
