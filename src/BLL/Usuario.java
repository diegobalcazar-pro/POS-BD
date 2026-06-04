package BLL;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import repository.Hashing;
import repository.Validaciones;

public abstract class Usuario {
	protected int id_usuario;
	protected String nombre_usuario;
	protected String apellido_usuario;
	protected String correo;
	protected String contrasenia;
	protected String rol;
	private static ControllerUsuario controller = new ControllerUsuario();

	public Usuario(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.rol = rol;

	}

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
	}

	public static ControllerUsuario getController() {
		return controller;
	}

	public static void setController(ControllerUsuario controller) {
		Usuario.controller = controller;
	}
	
	@Override
	public String toString() {
		return "ID: " + id_usuario +
		           "\nNombre: " + nombre_usuario +
		           "\nApellido: " + apellido_usuario +
		           "\nEmail: " + correo +
		           "\nRol: " + rol +
		           "\n-------------------------\n";
	}

	public static Usuario Login() {
		  String email = "";
        while (email.isEmpty()) {
        	email = JOptionPane.showInputDialog("Ingrese correo");
            if (email.isEmpty()) {
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
      return controller.login(email, contrasenia);

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
			    String apellido = Validaciones.validarIngresoString("Ingrese apellido");
			    String email = Validaciones.validarIngresoString("Ingrese mail");
				String contrasenia = Validaciones.validarIngresoString("Ingrese contraseña");
				String contraseniaOculta = Hashing.hash(contrasenia);
				
				String[] roles = {"admin", "cajero", "repositor"};
				
				int opcionRol = JOptionPane.showOptionDialog(
				        null,
				        "Seleccione el rol del usuario",
				        "Rol",
				        0,
				        0,
				        null,
				        roles,
				        roles[1]
				    );

				    if (opcionRol == -1) {
				        JOptionPane.showMessageDialog(null, "Registro cancelado");
				        return;
				    }

				    String rol = roles[opcionRol];
				    
				    Usuario nuevoUsuario;

				    if (rol.equals("admin")) {
				        nuevoUsuario = new Admin(0, nombre, apellido, email, contraseniaOculta, rol);
				    } else if (rol.equals("repositor")) {
				        nuevoUsuario = new Repositor(nombre, apellido, email, contraseniaOculta, rol);
				    } else {
				        nuevoUsuario = new Cajero(nombre, apellido, email, contraseniaOculta, rol);
				    }

				    getController().agregarUsuario(nuevoUsuario);
			
				
			
		
		
	}

}
