package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import BLL.Usuario;
import BLL.Cajero;
<<<<<<< HEAD
import BLL.Producto;
=======
>>>>>>> origin/diego
import BLL.Admin;
import BLL.Repositor;
import repository.Hashing;
import repository.UsuarioRepository;

public class ControllerUsuario<T extends Usuario> implements UsuarioRepository {

	private static Connection con = Conexion.getInstance().getConnection();

    @Override
<<<<<<< HEAD
    public T login(String nombre_usuario, String contrasenia) {
        T usuario = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `usuarios` WHERE nombre_usuario = ? AND contrasenia = ?"
            		
            		
            );
            stmt.setString(1, nombre_usuario);
            stmt.setString(2, contrasenia);
=======
    public T login(String email, String password) {
        T usuario = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email =?"
            );
            stmt.setString(1, email);
            
>>>>>>> origin/diego

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
<<<<<<< HEAD
                int id = rs.getInt("id_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                switch (rol.toLowerCase()) {
                    case "cajero":
                        usuario = (T) new Cajero(id, nombre_usuario, apellido_usuario, email, contrasenia, rol);
                        break;
                    case "admin":
                        usuario = (T) new Admin(id, nombre_usuario, apellido_usuario, email, contrasenia, rol);
                        break;
                    case "repositor":
                        usuario = (T) new Repositor(id, nombre_usuario, apellido_usuario, email, contrasenia, rol);
                        break;
                    default:
                        System.out.println("Tipo de usuario desconocido: " + rol);
                        break;
                }
=======
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String contrasenia = rs.getString("password");
                System.out.println(contrasenia);
                if (Hashing.verificar(password, contrasenia)) {
					
				
	                switch (tipo.toLowerCase()) {
	                    case "cajero":
	                        usuario = (T) new Cajero(id, nombre, email, tipo, password);
	                        break;
	                    case "repositor":
	                        usuario = (T) new Repositor(id, nombre, email, tipo, password);
	                        break;
	                    case "admin":
	                        usuario = (T) new Admin(id, nombre, email, tipo, password);
	                        break;
	                    default:
	                        System.out.println("Tipo de usuario desconocido: " + tipo);
	                        break;
	                }
                }else {
					JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
				}
>>>>>>> origin/diego
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
                "INSERT INTO usuarios (nombre_usuario, apellido_usuario, correo, contrasenia,`rol) VALUES (?,?,?,?,?)"
            );
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getRol());
            statement.setString(4, usuario.getContrasenia());

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

    @Override
    public LinkedList<Usuario> mostrarUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

                switch (rol.toLowerCase()) {
                    case "cajero":
                        usuarios.add((T) new Cajero(id, nombre, apellido, email, rol, contrasenia));
                        break;
<<<<<<< HEAD
                    case "profesor":
                        usuarios.add((T) new Admin(id, nombre, apellido, email, rol, contrasenia));
                        break;
=======
>>>>>>> origin/diego
                    case "repositor":
                        usuarios.add((T) new Repositor(id, nombre, apellido, email, rol, contrasenia));
                        break;
                    case "admin":
                        usuarios.add((T) new Admin(id, nombre, email, tipo, password));
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE tipo ='Alumno'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

              
                        usuarios.add((T) new Cajero(id, nombre, apellido, email, rol, contrasenia));
                 
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
<<<<<<< HEAD
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
                String email = rs.getString("email");
                String rol = rs.getString("rol");
                String contrasenia = rs.getString("contrasenia");

              
                        usuarios.add((T) new Repositor(id, nombre, apellido, email, rol, contrasenia));
                 
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
=======
>>>>>>> origin/diego
    
    
    
    
    
    
    /**public LinkedList<Producto> mostrarProductos() {
        LinkedList<Producto> productos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreProducto= rs.getString("nombreProducto");
                String descripcionProducto = rs.getString("descripcionProducto");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

              
                        productos.add( new Producto(id, nombreProducto, descripcionProducto, precio, stock, null));
                 
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    } **/
    
    
    public LinkedList<Producto> mostrarProductos() {
        LinkedList<Producto> productos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombreProducto= rs.getString("nombre_producto");
                String descripcionProducto = rs.getString("descripcion_producto");
                //double precio = rs.getDouble("precio");
                //int stock = rs.getInt("stock");

              
    //     productos.add( new Producto(id, nombreProducto, descripcionProducto, null, null, null));
                 productos.add(new Producto(id_producto, nombreProducto, descripcionProducto));
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }
    
    
    
    
    
    public void agregarProducto(Producto producto) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO productos (nombreProducto, descripcionProducto, precio, stock) VALUES (?,?, ?, ?)"
            );
            statement.setString(1, producto.getNombreProducto());
            statement.setString(2, producto.getDescripcionProducto());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void EliminarUsuario(Usuario usuario) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "DELETE FROM `usuario` WHERE id=?"
            );
            statement.setInt(1, usuario.getId());
          

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
                "UPDATE `usuario` SET `nombre`=?,`tipo`=?,`password`=? WHERE id =?"
            );
<<<<<<< HEAD
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getRol());
            statement.setString(3, usuario.getContrasenia());
=======
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getTipo());
            statement.setString(3,  usuario.getPassword());
>>>>>>> origin/diego
            statement.setInt(4, usuario.getId());


            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario editado correctamente.");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public LinkedList<Usuario> mostrarRepositores() {
		// TODO Auto-generated method stub
		return null;
	}
}
