package BLL;

public class MetodoDePago {
	protected int id_metodo_de_pago;
	protected String tipo;

	public MetodoDePago(int id_metodo_de_pago, String tipo) {
		super();
		this.id_metodo_de_pago = id_metodo_de_pago;
		this.tipo = tipo;
	}

	public int getid_metodo_de_pago() {
		return id_metodo_de_pago;
	}

	public void setid_metodo_de_pago(int id_metodo_de_pago) {
		this.id_metodo_de_pago = id_metodo_de_pago;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
