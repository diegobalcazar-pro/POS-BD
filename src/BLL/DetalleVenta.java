package BLL;

public class DetalleVenta {
	protected int idDetalleVenta;
	protected String cantidad;
	protected Venta venta;
	protected VarianteProducto varianteproducto;

	public DetalleVenta(int idDetalleVenta, String cantidad, Venta venta, VarianteProducto varianteproducto) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.cantidad = cantidad;
		this.venta = venta;
		this.varianteproducto = varianteproducto;
	}

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
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
