package BLL;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerUsuario;

public abstract class Usuario {
    protected int id_usuario;
    protected String nombre_usuario;
    protected String apellido_usuario;
    protected String correo;
    protected String contrasenia;
    protected String rol;
    private static ControllerUsuario controller = new ControllerUsuario();

    public Usuario(int id_usuario, String nombre_usuario,String apellido_usuario, String correo,String contrasenia, String rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol; 
    }
    public Usuario(String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
    	    this.nombre_usuario = nombre_usuario;
    	    this.apellido_usuario = apellido_usuario;
    	    this.correo = correo;
    	    this.contrasenia = contrasenia;
    	    this.rol = rol;
    	}
    public Usuario() {
    	
    };
    
    
    
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellido_usuario() {
		return apellido_usuario;
	}
	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public static ControllerUsuario getController() {
		return controller;
	}
	public static void setController(ControllerUsuario controller) {
		Usuario.controller = controller;
	}
	
	@Override
	public String toString() {
		return "Usuario:\n" + nombre_usuario +" "+ apellido_usuario + ", " + correo + ", rol= " + rol + "\n------------------------\n";
	}
	
	
	public static Usuario Login() {
		  String correo = "";
          while (correo.isEmpty()) {
              correo = JOptionPane.showInputDialog("Ingrese Correo");
              if (correo == null ||correo.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Incorrecto");
              }
          }

          String contrasenia = "";
          while (contrasenia.isEmpty()) {
              contrasenia = JOptionPane.showInputDialog("Ingrese contraseña");
              if (contrasenia == null ||contrasenia.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Incorrecto");
              }
          }
        return controller.login(correo, contrasenia);

	}
	
	
	public abstract void Menu();
	
	public void agregarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	public Usuario BuscarUsuario() {
		LinkedList<Usuario> usuarios = this.getController().mostrarUsuarios();
		String[] correos = new String[usuarios.size()];
		for (int i = 0; i < correos.length; i++) {
			correos[i] = usuarios.get(i).getCorreo();
		}
		int elegido = JOptionPane.showOptionDialog(null, "Seleccione Correo", "", 0, 0, null, correos, correos[0]);
		return usuarios.get(elegido);

	}
	
	
	
}
