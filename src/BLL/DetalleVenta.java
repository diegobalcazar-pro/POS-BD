package BLL;

public class DetalleVenta {
	protected int id_detalleventa;
	protected String cantidad;
	protected Venta venta;
	protected VarianteProducto varianteproducto;

	public DetalleVenta(int id_detalleventa, String cantidad, Venta venta, VarianteProducto varianteproducto) {
		super();
		this.id_detalleventa = id_detalleventa;
		this.cantidad = cantidad;
		this.venta = venta;
		this.varianteproducto = varianteproducto;
	}

	public int getid_detalleventa() {
		return id_detalleventa;
	}

	public void setid_detalleventa(int id_detalleventa) {
		this.id_detalleventa = id_detalleventa;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public VarianteProducto getVarianteproducto() {
		return varianteproducto;
	}

	public void setVarianteproducto(VarianteProducto varianteproducto) {
		this.varianteproducto = varianteproducto;
	}

}
