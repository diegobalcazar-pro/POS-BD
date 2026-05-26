package BLL;

import java.time.LocalDate;

public class Envio {

	protected int idEnvio;
	protected String numeroSeguimiento;
	protected String estado;
	protected LocalDate fechaDespacho;
	protected int fkVenta;

	// Constructor
	public Envio(int idEnvio, String numeroSeguimiento, String estado, LocalDate fechaDespacho, int fkVenta) {
		this.idEnvio = idEnvio;
		this.numeroSeguimiento = numeroSeguimiento;
		this.estado = estado;
		this.fechaDespacho = fechaDespacho;
		this.fkVenta = fkVenta;
	}

	// Constructor para INSERTAR
	public Envio(String numeroSeguimiento, String estado, int fkVenta) {
		this.numeroSeguimiento = numeroSeguimiento;
		this.estado = estado;
		this.fkVenta = fkVenta;
		this.fechaDespacho = null;
	}

	public int getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getNumeroSeguimiento() {
		return numeroSeguimiento;
	}

	public void setNumeroSeguimiento(String numeroSeguimiento) {
		this.numeroSeguimiento = numeroSeguimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(LocalDate fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public int getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(int fkVenta) {
		this.fkVenta = fkVenta;
	}

	@Override
	public String toString() {
		String fechaStr = (fechaDespacho != null) ? fechaDespacho.toString() : "Aún no despachado";

		return "Envio [ID=" + idEnvio + ", Seguimiento=" + numeroSeguimiento + ", Estado=" + estado.toUpperCase()
				+ ", Despacho=" + fechaStr + ", Venta N°=" + fkVenta + "]";
	}
}
