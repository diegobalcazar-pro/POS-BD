package BLL;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import repository.Hashing;
import repository.Validaciones;

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
	
   public static void registrarse() {
	   
	   int flag=0;
	   
		do {
			
			String hola = JOptionPane.showInputDialog("ingrese NOMBRE");
			   
			   if (hola == null) {		
				   //presiona Cancelar
				   JOptionPane.showMessageDialog(null, "Registro Cancelado");
				   return;
				   
				   //presiona aceptar
		     	}else if (hola.isEmpty()) {
				JOptionPane.showMessageDialog(null, "error de texto: campo Vacio");
				flag=1;
				
				}
			   
			   
			/*
			    String nombre = Validaciones.validarIngresoString("Ingrese nombre");			    
			    String mail = Validaciones.validarIngresoString("Ingrese mail");
				String contrasenia = Validaciones.validarIngresoString("Ingrese contraseña");
				String contraseniaOculta = Hashing.hash(contrasenia);
				getController().agregarUsuario(new Cajero(nombre,mail,"Cajero",contraseniaOculta));
			*/	
				
			
		} while (flag==1);
		System.out.println("fin de registro");
		
	}
	
	
    

}
