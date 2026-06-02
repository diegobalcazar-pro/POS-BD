package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import BLL.Usuario;
import BLL.Cajero;
import BLL.Admin;
import BLL.Repositor;
import repository.Hashing;
import repository.UsuarioRepository;

public class ControllerUsuario<T extends Usuario> implements UsuarioRepository {

	private static Connection con = Conexion.getInstance().getConnection();

	@Override
	public T login(String correo, String contraseniaInput) {
		T usuario = null;
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE correo = ?");
			stmt.setString(1, correo);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id_usuario");
				String nombre = rs.getString("nombre_usuario");
				String apellido = rs.getString("apellido_usuario");
				String correoDb = rs.getString("correo");
				String rol = rs.getString("rol");
				String contraseniaDb = rs.getString("contrasenia");

				System.out.println("Hash en DB: " + contraseniaDb);

				if (Hashing.verificar(contraseniaInput, contraseniaDb)) {
					switch (rol.toLowerCase()) {
					case "cajero":
						usuario = (T) new Cajero(id, nombre, apellido, correoDb, contraseniaDb, rol);
						break;
					case "repositor":
						usuario = (T) new Repositor(id, nombre, apellido, correoDb, contraseniaDb, rol);
						break;
					case "admin":
						usuario = (T) new Admin(id, nombre, apellido, correoDb, contraseniaDb, rol);
						break;
					default:
						System.out.println("Rol de usuario desconocido: " + rol);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuarios (nombre_usuario, apellido_usuario, correo, rol, contrasenia) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, usuario.getnombre_usuario());
			statement.setString(2, usuario.getapellido_usuario());
			statement.setString(3, usuario.getCorreo());
			statement.setString(4, usuario.getRol());
			statement.setString(5, usuario.getContrasenia());

			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario agregado correctamente.");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "No se puede crear usuario con un correo ya existente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<Usuario> mostrarUsuarios() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_usuario");
				String nombre = rs.getString("nombre_usuario");
				String apellido = rs.getString("apellido_usuario");
				String correo = rs.getString("correo");
				String rol = rs.getString("rol");
				String contrasenia = rs.getString("contrasenia");

				switch (rol.toLowerCase()) {
				case "cajero":
					usuarios.add(new Cajero(id, nombre, apellido, correo, contrasenia, rol));
					break;
				case "repositor":
					usuarios.add(new Repositor(id, nombre, apellido, correo, contrasenia, rol));
					break;
				case "admin":
					usuarios.add(new Admin(id, nombre, apellido, correo, contrasenia, rol));
					break;
				default:
					System.out.println("Rol desconocido: " + rol);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public LinkedList<Usuario> mostrarCajeros() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE rol = 'cajero'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_usuario");
				String nombre = rs.getString("nombre_usuario");
				String apellido = rs.getString("apellido_usuario");
				String correo = rs.getString("correo");
				String rol = rs.getString("rol");
				String contrasenia = rs.getString("contrasenia");

				usuarios.add(new Cajero(id, nombre, apellido, correo, contrasenia, rol));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void EliminarUsuario(Usuario usuario) {
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
			statement.setInt(1, usuario.getid_usuario());

			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario eliminado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void EditarUsuario(Usuario usuario) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"UPDATE usuarios SET nombre_usuario = ?, apellido_usuario = ?, correo = ?, rol = ?, contrasenia = ? WHERE id_usuario = ?");
			statement.setString(1, usuario.getnombre_usuario());
			statement.setString(2, usuario.getapellido_usuario());
			statement.setString(3, usuario.getCorreo());
			statement.setString(4, usuario.getRol());
			statement.setString(5, usuario.getContrasenia());
			statement.setInt(6, usuario.getid_usuario());

			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario editado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<Usuario> mostrarRepositores() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE rol = 'repositor'");
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				int id = rs.getInt("id_usuario");
				String nombre = rs.getString("nombre_usuario");
				String apellido = rs.getString("apellido_usuario");
				String correo = rs.getString("correo");
				String rol = rs.getString("rol");
				String contrasenia = rs.getString("contrasenia");

				usuarios.add(new Repositor(id, nombre, apellido, correo, contrasenia, rol));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
