package BLL;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import DLL.ControllerDescuento;

public class Descuento {
	protected int id_descuento;
	protected String nombre_descuento;
	protected double porcentaje_descuento;
	private static ControllerDescuento<Descuento> controller = new ControllerDescuento();

	public Descuento(int id_descuento, String nombre_descuento, double porcentaje_descuento) {
		super();
		this.id_descuento = id_descuento;
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}
	public Descuento(String nombre_descuento, double porcentaje_descuento) {
		super();
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}
	public Descuento() {
	}

	public int getId_descuento() {
		return id_descuento;
	}
	public void setId_descuento(int id_descuento) {
		this.id_descuento = id_descuento;
	}

	public String getNombre_descuento() {
		return nombre_descuento;
	}
	public void setNombre_descuento(String nombre_descuento) {
		this.nombre_descuento = nombre_descuento;
	}

	public double getPorcentaje_descuento() {
		return porcentaje_descuento;
	}
	public void setPorcentaje_descuento(double porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	
	public static ControllerDescuento getController() {
		return controller;
	}
	public static void setController(ControllerDescuento controller) {
		Descuento.controller = controller;
	}
	
	@Override
	public String toString() {
		return "Descuentos:\n" +  nombre_descuento + ". Porcentaje" + porcentaje_descuento + "%\n";
	}
	
	public static LinkedList<Descuento> mostrarDescuentos() {
	    return controller.mostrarDescuentos();
	}
	
	public static void agregarDescuento(Descuento descuento) {
	    controller.agregarDescuento(descuento);
	}
	public static void EliminarDescuento(String nombre_descuento) {
		controller.EliminarDescuento(nombre_descuento);
	}
	
	
	public Descuento BuscarDescuento() {
	    LinkedList<Descuento> descuentos = this.getController().mostrarDescuentos();
	    if (descuentos.isEmpty()) {JOptionPane.showMessageDialog(null, "No hay descuentos registrados.");
	        return null;
	    }

	    String[] nombre_descuentos = new String[descuentos.size()];
	    for (int i = 0; i < descuentos.size(); i++) {
	        nombre_descuentos[i] = descuentos.get(i).getNombre_descuento();
	    }
	    int elegido = JOptionPane.showOptionDialog(null,"Seleccione el descuento a eliminar", "Eliminar descuento",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,nombre_descuentos,nombre_descuentos[0]);

	    if (elegido == JOptionPane.CLOSED_OPTION) {
	        return null;
	    }
	    return descuentos.get(elegido);
	}

}
