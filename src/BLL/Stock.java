package BLL;

public class Stock {
	protected int id_stock;
	protected int cantidad;
	protected Deposito deposito;
	protected VarianteProducto varianteproducto;

	public Stock(int id_stock, int cantidad, Deposito deposito, VarianteProducto varianteproducto) {
		super();
		this.id_stock = id_stock;
		this.cantidad = cantidad;
		this.deposito = deposito;
		this.varianteproducto = varianteproducto;
	}

	public int getid_stock() {
		return id_stock;
	}

	public void setid_stock(int id_stock) {
		this.id_stock = id_stock;
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
