package BLL;

import javax.swing.JOptionPane;

public class Cajero extends Usuario {

    
    public Cajero(int id, String nombre, String apellido, String email, String rol, String contrasenia) {
		super(id, nombre, apellido, email, rol, contrasenia);
	}
    public Cajero( String nombre, String apellido, String email, String rol, String contrasenia) {
		super(0, nombre, apellido, email, rol, contrasenia);
	}
	public Cajero() {
        super();
    }
	@Override
	public String toString() {
		return "Cajero [toString()=" + super.toString() + "]";
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
