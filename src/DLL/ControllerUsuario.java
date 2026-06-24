package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

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
				int id_usuario = rs.getInt("id_usuario");
				String nombre_usuario = rs.getString("nombre_usuario");
				String apellido_usuario = rs.getString("apellido_usuario");
				String correoDb = rs.getString("correo");
				String contraseniaDb = rs.getString("contrasenia");
				String rol = rs.getString("rol");
				

				System.out.println("Hash en DB: " + contraseniaDb);

				if (Hashing.verificar(contraseniaInput, contraseniaDb)) {
					switch (rol.toLowerCase()) {
					case "cajero":
						usuario = (T) new Cajero(id_usuario, nombre_usuario, apellido_usuario, correoDb, contraseniaDb, rol);
						break;
					case "repositor":
						usuario = (T) new Repositor(id_usuario, nombre_usuario, apellido_usuario, correoDb, contraseniaDb, rol);
						break;
					case "admin":
						usuario = (T) new Admin(id_usuario, nombre_usuario, apellido_usuario, correoDb, contraseniaDb, rol);
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

	public void agregarUsuario(Usuario usuario) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuarios (nombre_usuario, apellido_usuario, correo, contrasenia, rol) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getApellido_usuario());
            statement.setString(3, usuario.getCorreo());
            
            String hash = BCrypt.hashpw(usuario.getContrasenia(),BCrypt.gensalt());

            statement.setString(4, hash);
            statement.setString(5, usuario.getRol());

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

	
	public LinkedList<Usuario> mostrarUsuarios() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id_usuario = rs.getInt("id_usuario");
				String nombre_usuario = rs.getString("nombre_usuario");
				String apellido_usuario = rs.getString("apellido_usuario");
				String correo = rs.getString("correo");
				String rol = rs.getString("rol");
				String contrasenia = rs.getString("contrasenia");

				switch (rol.toLowerCase()) {
				case "cajero":
					usuarios.add(new Cajero(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol));
					break;
				case "repositor":
					usuarios.add(new Repositor(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol));
					break;
				case "admin":
					usuarios.add(new Admin(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol));
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
				int id_usuario = rs.getInt("id_usuario");
				String nombre_usuario = rs.getString("nombre_usuario");
				String apellido_usuario = rs.getString("apellido_usuario");
				String correo = rs.getString("correo");
				String rol = rs.getString("rol");
				String contrasenia = rs.getString("contrasenia");

				usuarios.add(new Cajero(id_usuario, nombre_usuario, apellido_usuario, correo, contrasenia, rol));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	@Override
    public LinkedList<Usuario> mostrarRepositores() {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE tipo ='Repositor'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

              
                        usuarios.add((T) new Repositor(id_usuario, nombre_usuario, apellido_usuario, correo, rol, contrasenia));
                 
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

	public static void EliminarUsuario(String correo) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM usuarios WHERE correo = ?");
            statement.setString(1, correo);
          

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario elinado correctamente.");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void EditarUsuario(Usuario usuario) {	
        try {
            PreparedStatement statement = con.prepareStatement(
            		"UPDATE usuarios SET nombre_usuario=?, apellido_usuario=?, correo=?, contrasenia=?, rol=? WHERE id_usuario=?"
            	 );
            
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getApellido_usuario());
            statement.setString(3, usuario.getCorreo());
            
            String hash = BCrypt.hashpw(usuario.getContrasenia(),BCrypt.gensalt());

            statement.setString(4, hash);
            statement.setString(5, usuario.getRol());
            statement.setInt(6, usuario.getId_usuario());


            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario editado correctamente.");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
	public void EliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	
}
