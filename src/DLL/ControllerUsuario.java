package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import repository.Hashing;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import BLL.Usuario;
import BLL.Cajero;
import BLL.Admin;
import BLL.Repositor;
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
                "INSERT INTO usuarios (nombre_usuario, apellido_usuario, correo, contrasenia, rol) VALUES (?,?,?,?,?)"
            	 );
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getApellido_usuario());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContrasenia());
            statement.setString(5, usuario.getRol());
            

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario agregado correctamente.");
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No se puede crear usuario con mail existente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void EliminarUsuario(String correo) {
        try {
            PreparedStatement statement = con.prepareStatement(
            		"DELETE FROM usuarios WHERE correo = ?"
            );
            statement.setString(1, correo);
          

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario elinado correctamente.");
            }
        }  catch (Exception e) {
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
                int id_usuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre_usuario");
                String apellido = rs.getString("apellido_usuario");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

                switch (rol.toLowerCase()) {
                    case "cajero":
                        usuarios.add((T) new Cajero(id_usuario, nombre, apellido, correo, rol, contrasenia));
                        break;
                    case "admin":
                        usuarios.add((T) new Admin(id_usuario, nombre, apellido, correo, rol, contrasenia));
                        break;
                    case "repositor":
                        usuarios.add((T) new Repositor(id_usuario, nombre, apellido, correo, rol, contrasenia));
                        break;
                    default:
                        System.out.println("Tipo desconocido: " + rol);
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE rol ='Cajero'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

              
                        usuarios.add((T) new Cajero(id_usuario, nombre_usuario, apellido_usuario, correo, rol, contrasenia));
                 
          
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
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

              
                        usuarios.add((T) new Repositor(id, nombre, apellido, correo, rol, contrasenia));
                 
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    
    public void EditarUsuario(Usuario usuario) {	
        try {
            PreparedStatement statement = con.prepareStatement(
            		"UPDATE usuarios SET nombre_usuario=?, apellido_usuario=?, correo=?, contrasenia=?, rol=? WHERE id_usuario=?"
            	 );
            
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getApellido_usuario());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContrasenia());
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
