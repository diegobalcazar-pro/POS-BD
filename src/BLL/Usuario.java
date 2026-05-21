package BLL;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import repository.Hashing;
import repository.Validaciones;

public abstract class Usuario {
<<<<<<< HEAD
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
=======
	protected int id;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String contrasenia;
	protected String rol;
	private static ControllerUsuario controller = new ControllerUsuario();

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.rol = rol;

	}

>>>>>>> origin/diego
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD
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
=======

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
>>>>>>> origin/diego
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
<<<<<<< HEAD
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
=======

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
>>>>>>> origin/diego
	}

	public static ControllerUsuario getController() {
		return controller;
	}

	public static void setController(ControllerUsuario controller) {
		Usuario.controller = controller;
	}
<<<<<<< HEAD
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
=======
	
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
>>>>>>> origin/diego

	}
	
	
	public abstract void Menu();
	
 public static void registrarse() {
	   
 /*  int flag=0;
	   
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
				
				} while (flag==1);
		System.out.println("fin de registro");
			   */
			
			    String nombre = Validaciones.validarIngresoString("Ingrese nombre");			    
			    String mail = Validaciones.validarIngresoString("Ingrese mail");
				String contrasenia = Validaciones.validarIngresoString("Ingrese contraseña");
				String contraseniaOculta = Hashing.hash(contrasenia);
				getController().agregarUsuario(new Cajero(nombre,mail,"Cajero",contraseniaOculta));
			
				
			
		
		
	}

}
