package BLL;

public class Deposito {
	protected int idDeposito;
	protected String lugar_deposito;

	public Deposito(int idDeposito, String lugar_deposito) {
		super();
		this.idDeposito = idDeposito;
		this.lugar_deposito = lugar_deposito;
	}

	public int getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}

	public String getLugar_deposito() {
		return lugar_deposito;
	}

	public void setLugar_deposito(String lugar_deposito) {
		this.lugar_deposito = lugar_deposito;
	}

}
