package BLL;

import javax.swing.JOptionPane;

public class Repositor extends Usuario {

    
    public Repositor(int id_usuario, String nombre, String apellido, String email, String contrasenia, String rol) {
		super(id_usuario, nombre, apellido, email, contrasenia, rol);
	}
    public Repositor( String nombre_usuario, String apellido_usuario, String email, String rol, String contrasenia) {
		super(0, nombre_usuario, apellido_usuario, email, contrasenia, rol);
	}
	public Repositor() {
        super();
    }
	@Override
	public String toString() {
		return "Repositor [toString()=" + super.toString() + "]";
	}
	@Override
	public void Menu() {

		String[] opciones = { "Ver usuarios", "Salir" };
		int opcion;
		do {

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				JOptionPane.showMessageDialog(null, this.getController().mostrarUsuarios());

			default:
				break;
			}
		} while (opcion != 2);
		
	}
    
    
   
}
