package repository;

import java.util.LinkedList;
import java.util.List;
import BLL.Usuario;

public interface UsuarioRepository {
    void agregarUsuario(Usuario usuario);
    List<Usuario> mostrarUsuarios();
	<T> T login(String nombre, String password);
	LinkedList<Usuario> mostrarCajeros();
	LinkedList<Usuario> mostrarRepositores();
	void EliminarUsuario(String correo);
	
}
