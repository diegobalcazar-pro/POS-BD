package repository;

import javax.swing.JOptionPane;

public interface Validaciones {

	static String validarIngresoString(String mensaje) {
		 
		String dato;
		do {
			dato= JOptionPane.showInputDialog(mensaje);
		} while (dato.isEmpty());
		
		return dato;
	}
}
