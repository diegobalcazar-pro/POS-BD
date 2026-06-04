package BLL;

public class Cliente {

    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String correo;
    private String telefono;
    private String direccion;
    private String tipo;

    public Cliente(int id_cliente, String nombre_cliente, String apellido_cliente, String correo, String telefono, String direccion, String tipo) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ID Cliente: " + id_cliente +
               "\nNombre: " + nombre_cliente + " " + apellido_cliente +
               "\nCorreo: " + correo +
               "\nTeléfono: " + telefono +
               "\nDirección: " + direccion +
               "\nTipo: " + tipo;
    }
}