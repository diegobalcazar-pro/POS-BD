package BLL;

import java.time.LocalDate;

public class Envio {

	protected int id_envio;
	protected String numero_seguimiento;
	protected String estado;
	protected LocalDate fecha_despacho;
	protected int fkVenta;

	// Constructor
	public Envio(int id_envio, String numero_seguimiento, String estado, LocalDate fecha_despacho, int fkVenta) {
		this.id_envio = id_envio;
		this.numero_seguimiento = numero_seguimiento;
		this.estado = estado;
		this.fecha_despacho = fecha_despacho;
		this.fkVenta = fkVenta;
	}

	// Constructor para INSERTAR
	public Envio(String numero_seguimiento, String estado, int fkVenta) {
		this.numero_seguimiento = numero_seguimiento;
		this.estado = estado;
		this.fkVenta = fkVenta;
		this.fecha_despacho = null;
	}

	public int getid_envio() {
		return id_envio;
	}

	public void setid_envio(int id_envio) {
		this.id_envio = id_envio;
	}

	public String getnumero_seguimiento() {
		return numero_seguimiento;
	}

	public void setnumero_seguimiento(String numero_seguimiento) {
		this.numero_seguimiento = numero_seguimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getfecha_despacho() {
		return fecha_despacho;
	}

	public void setfecha_despacho(LocalDate fecha_despacho) {
		this.fecha_despacho = fecha_despacho;
	}

	public int getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(int fkVenta) {
		this.fkVenta = fkVenta;
	}

	@Override
	public String toString() {
		String fechaStr = (fecha_despacho != null) ? fecha_despacho.toString() : "Aún no despachado";

		return "Envio [ID=" + id_envio + ", Seguimiento=" + numero_seguimiento + ", Estado=" + estado.toUpperCase()
				+ ", Despacho=" + fechaStr + ", Venta N°=" + fkVenta + "]";
	}
}
