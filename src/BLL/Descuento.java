package BLL;

public class Descuento {
	protected int idDescuento;
	protected String nombre_descuento;
	protected double porcentaje_descuento;

	public Descuento(int idDescuento, String nombre_descuento, double porcentaje_descuento) {
		super();
		this.idDescuento = idDescuento;
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
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
