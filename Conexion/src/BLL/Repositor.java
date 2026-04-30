package BLL;

import javax.swing.JOptionPane;

public class Repositor extends Usuario {

    
    public Repositor(int id, String nombre, String email, String tipo, String password) {
		super(id, nombre, email, tipo, password);
	}
    public Repositor( String nombre, String email, String tipo, String password) {
		super(0, nombre, email, tipo, password);
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
