package BLL;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import repository.Hashing;
import repository.Validaciones;

public abstract class Usuario {

	protected int id;
	protected String nombre;
	protected String apellido;
	protected String correo;
	protected String contrasenia;
	protected String rol;

	private static ControllerUsuario controller = new ControllerUsuario();

	// --- CONSTRUCTORES ---
	public Usuario(int id, String nombre, String apellido, String correo, String contrasenia, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	public Usuario() {
	}

	// --- GETTERS Y SETTERS ---
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		String nombre = Validaciones.validarIngresoString("Ingrese nombre");
		String apellido = Validaciones.validarIngresoString("Ingrese apellido");
		String correo = Validaciones.validarIngresoString("Ingrese correo");
		String contraseniaInput = Validaciones.validarIngresoString("Ingrese contraseña");

		String contraseniaOculta = Hashing.hash(contraseniaInput);

		getController().agregarUsuario(new Cajero(0, nombre, apellido, correo, contraseniaOculta, "cajero"));
	}

	public abstract void Menu();

	// --- TO STRING ---
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", rol="
				+ rol + ", contrasenia=" + contrasenia + "]";
	}
}