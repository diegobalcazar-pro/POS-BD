package BLL;

import javax.swing.JOptionPane;

import DLL.ControllerUsuario;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected String tipo;
    protected String password;
    private static ControllerUsuario controller = new ControllerUsuario();

    public Usuario(int id, String nombre, String email,String tipo,String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
        this.password = password;
        
    }
    public Usuario() {
      
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static ControllerUsuario getController() {
		return controller;
	}
	public static void setController(ControllerUsuario controller) {
		Usuario.controller = controller;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", tipo=" + tipo + ", password="
				+ password + "]";
	}
	public static Usuario Login() {
		  String nombre = "";
          while (nombre.isEmpty()) {
              nombre = JOptionPane.showInputDialog("Ingrese nombre");
              if (nombre.isEmpty()) {
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
        return controller.login(nombre, contrasenia);

	}
	
	
	public abstract void Menu();
	
	
    

}
