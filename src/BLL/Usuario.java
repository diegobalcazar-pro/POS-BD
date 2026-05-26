package BLL;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerUsuario;

public abstract class Usuario {
    protected int id_usuario;
    protected String nombre_usuario;
    protected String apellido_usuario;
    protected String email;
    protected String contrasenia;
    protected String rol;
    private static ControllerUsuario controller = new ControllerUsuario();

    public Usuario(int id_usuario, String nombre_usuario,String apellido_usuario, String email,String contrasenia, String rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol; 
    }
    public Usuario(String nombre_usuario, String apellido_usuario, String email, String contrasenia, String rol) {
    	    this.nombre_usuario = nombre_usuario;
    	    this.apellido_usuario = apellido_usuario;
    	    this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "Usuarios:\n[id=" + id_usuario + ", " + nombre_usuario +" "+ apellido_usuario + ", " + email + ","
				+ " rol=" + rol + "]\n";
	}
	
	
	public static Usuario Login() {
		  String nombre_usuario = "";
          while (nombre_usuario.isEmpty()) {
              nombre_usuario = JOptionPane.showInputDialog("Ingrese nombre");
              if (nombre_usuario.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Incorrecto");
              }
          }

          String contrasenia = "";
          while (contrasenia.isEmpty()) {
              contrasenia = JOptionPane.showInputDialog("Ingrese contraseña");
              if (contrasenia.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Incorrecto");
              }
          }
        return controller.login(nombre_usuario, contrasenia);

	}
	
	
	public abstract void Menu();
	
	public void agregarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	public Usuario BuscarUsuario() {
		LinkedList<Usuario> usuarios = this.getController().mostrarUsuarios();
		String[] mails = new String[usuarios.size()];
		for (int i = 0; i < mails.length; i++) {
			mails[i] = usuarios.get(i).getEmail();
		}
		int elegido = JOptionPane.showOptionDialog(null, "Seleccione mail", "", 0, 0, null, mails, mails[0]);
		return usuarios.get(elegido);

	}
	
}
