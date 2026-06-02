package BLL;

public class Proveedor {

	private int id_proveedor;
    private String nombreEmpresa;
    private String nombreContacto;
    private String telefono;
    private String correo;
    
    
	public Proveedor(int id_proveedor, String nombreEmpresa, String nombreContacto, String telefono, String correo) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombreEmpresa = nombreEmpresa;
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public Proveedor(String nombreEmpresa, String nombreContacto, String telefono, String correo) {
        this(0, nombreEmpresa, nombreContacto, telefono, correo);
    }
	
	public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return id_proveedor + " - " + nombreEmpresa + " | Contacto: " + nombreContacto;
    }
    
    
}
