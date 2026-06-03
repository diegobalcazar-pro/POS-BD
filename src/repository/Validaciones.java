package repository;

import javax.swing.JOptionPane;

public interface Validaciones {

	default String validarIngresoString(String mensaje) {
		 
		String dato;
		do {
			dato= JOptionPane.showInputDialog(mensaje);
		} while (dato.isEmpty());
		
		return dato;
	}
	
	
	default double validarIngresoDouble(String mensaje) {
		
		double dato = Double.parseDouble(validarIngresoString(mensaje));
	return dato;
    }
	
   default int validarIngresoInt(String mensaje) {
		
		int dato = Integer.parseInt(validarIngresoString(mensaje));
	return dato;
    }
	
}