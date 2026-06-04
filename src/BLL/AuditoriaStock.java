package BLL;

import java.time.LocalDate;

public class AuditoriaStock {
	protected int id_auditoria_stock;
	protected String tipo_movimiento;
	protected int cantidad;
	protected LocalDate fecha;
	protected VarianteProducto varianteproducto;
	protected Usuario usuario;
	protected Deposito depositoOrigen;
	protected Deposito depositoDestino;

	public AuditoriaStock(int id_auditoria_stock, String tipo_movimiento, int cantidad, LocalDate fecha,
			VarianteProducto varianteproducto, Usuario usuario, Deposito depositoOrigen, Deposito depositoDestino) {
		super();
		this.id_auditoria_stock = id_auditoria_stock;
		this.tipo_movimiento = tipo_movimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.varianteproducto = varianteproducto;
		this.usuario = usuario;
		this.depositoOrigen = depositoOrigen;
		this.depositoDestino = depositoDestino;
	}

	public int getid_auditoria_stock() {
		return id_auditoria_stock;
	}

	public void setid_auditoria_stock(int id_auditoria_stock) {
		this.id_auditoria_stock = id_auditoria_stock;
	}

	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public VarianteProducto getVarianteproducto() {
		return varianteproducto;
	}

	public void setVarianteproducto(VarianteProducto varianteproducto) {
		this.varianteproducto = varianteproducto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Deposito getDepositoOrigen() {
		return depositoOrigen;
	}

	public void setDepositoOrigen(Deposito depositoOrigen) {
		this.depositoOrigen = depositoOrigen;
	}

	public Deposito getDepositoDestino() {
		return depositoDestino;
	}

	public void setDepositoDestino(Deposito depositoDestino) {
		this.depositoDestino = depositoDestino;
	}

}
