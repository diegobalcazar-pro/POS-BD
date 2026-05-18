package BLL;

public class Stock {
	protected int idStock;
	protected int cantidad;
	protected Deposito deposito;
	protected VarianteProducto varianteproducto;

	public Stock(int idStock, int cantidad, Deposito deposito, VarianteProducto varianteproducto) {
		super();
		this.idStock = idStock;
		this.cantidad = cantidad;
		this.deposito = deposito;
		this.varianteproducto = varianteproducto;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public VarianteProducto getVarianteproducto() {
		return varianteproducto;
	}

	public void setVarianteproducto(VarianteProducto varianteproducto) {
		this.varianteproducto = varianteproducto;
	}

}
