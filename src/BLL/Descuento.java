package BLL;

public class Descuento {
	protected int id_descuento;
	protected String nombre_descuento;
	protected double porcentaje_descuento;

	public Descuento(int id_descuento, String nombre_descuento, double porcentaje_descuento) {
		super();
		this.id_descuento = id_descuento;
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public int getid_descuento() {
		return id_descuento;
	}

	public void setid_descuento(int id_descuento) {
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

}
