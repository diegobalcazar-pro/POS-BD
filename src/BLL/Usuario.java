package BLL;

import javax.swing.JOptionPane;

import DLL.ControllerUsuario;

public abstract class Usuario {
    protected int id;
    protected String nombre_usuario;
    protected String apellido_usuario;
    protected String email;
    protected String contrasenia;
    protected String rol;
    private static ControllerUsuario controller = new ControllerUsuario();

    public Usuario(int id, String nombre_usuario,String apellido_usuario, String email,String rol,String contrasenia) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email = email;
        this.rol = rol;
        this.contrasenia = contrasenia;
        
    }
    public Usuario() {
      
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", nombre=" + nombre_usuario + ", apellido=" + apellido_usuario + ", email=" + email + ","
				+ " rol=" + rol + ", contraseña=" + contrasenia + "]";
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
	
	
    

}
