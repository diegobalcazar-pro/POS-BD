package BLL;

public class MetodoDePago {
	protected int idMetodoDePago;
	protected String tipo;

	public MetodoDePago(int idMetodoDePago, String tipo) {
		super();
		this.idMetodoDePago = idMetodoDePago;
		this.tipo = tipo;
	}

	public int getIdMetodoDePago() {
		return idMetodoDePago;
	}

	public void setIdMetodoDePago(int idMetodoDePago) {
		this.idMetodoDePago = idMetodoDePago;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
