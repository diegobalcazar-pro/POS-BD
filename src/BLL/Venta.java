package BLL;

import java.time.LocalDate;

public class Venta {
	protected int id_venta;
	protected LocalDate fecha;
	protected double total_neto;
	protected double total_bruto;
	protected Usuario usuario;
	protected Cliente cliente;
	protected MetodoDePago metododepago;
	protected Descuento descuento;

	public Venta(int id_venta, LocalDate fecha, double total_neto, double total_bruto, Usuario usuario,
			Cliente cliente, MetodoDePago metododepago, Descuento descuento) {
		super();
		this.id_venta = id_venta;
		this.fecha = fecha;
		this.total_neto = total_neto;
		this.total_bruto = total_bruto;
		this.usuario = usuario;
		this.cliente = cliente;
		this.metododepago = metododepago;
		this.descuento = descuento;
	}

	public int getid_venta() {
		return id_venta;
	}

	public void setid_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal_neto() {
		return total_neto;
	}

	public void setTotal_neto(double total_neto) {
		this.total_neto = total_neto;
	}

	public double getTotal_bruto() {
		return total_bruto;
	}

	public void setTotal_bruto(double total_bruto) {
		this.total_bruto = total_bruto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public MetodoDePago getMetododepago() {
		return metododepago;
	}

	public void setMetododepago(MetodoDePago metododepago) {
		this.metododepago = metododepago;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

}
