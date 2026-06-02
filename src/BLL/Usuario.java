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

	// --- CONSTRUCTORES ---
	public Usuario(int id_usuario, String nombre_usuario, String apellido_usuario, String correo, String contrasenia, String rol) {
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
	}

	// --- GETTERS Y SETTERS ---
	public int getid_usuario() {
		return id_usuario;
	}

	public void setid_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getnombre_usuario() {
		return nombre_usuario;
	}

	public void setnombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getapellido_usuario() {
		return apellido_usuario;
	}

	public void setapellido_usuario(String apellido_usuario) {
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

	// --- MÉTODOS ---
	public static Usuario Login() {
		String correo = "";
		while (correo.isEmpty()) {
			correo = JOptionPane.showInputDialog("Ingrese correo");
			if (correo == null || correo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Incorrecto");
			}
		}

		String contraseniaInput = "";
		while (contraseniaInput.isEmpty()) {
			contraseniaInput = JOptionPane.showInputDialog("Ingrese Contraseña");
			if (contraseniaInput == null || contraseniaInput.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Incorrecto");
			}
		}
		return controller.login(correo, contraseniaInput);
	}

	public static void registrarse() {
		String nombre_usuario = Validaciones.validarIngresoString("Ingrese nombre_usuario");
		String apellido_usuario = Validaciones.validarIngresoString("Ingrese apellid_usuarioo");
		String correo = Validaciones.validarIngresoString("Ingrese correo");
		String contraseniaInput = Validaciones.validarIngresoString("Ingrese contraseña");

		String contraseniaOculta = Hashing.hash(contraseniaInput);

		getController().agregarUsuario(new Cajero(0, nombre_usuario, apellido_usuario, correo, contraseniaOculta, "cajero"));
	}

	public abstract void Menu();

	// --- TO STRING ---
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", correo=" + correo + ", rol="
				+ rol + ", contrasenia=" + contrasenia + "]";
	}
}