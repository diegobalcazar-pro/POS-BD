package BLL;

public class Deposito {
    protected int idDeposito;
    protected String lugar_deposito;

    public Deposito(int idDeposito, String lugarDeposito) {
        this.idDeposito = idDeposito;
        this.lugar_deposito = lugarDeposito;
    }

    public int getIdDeposito() { return idDeposito; }
    public void setIdDeposito(int idDeposito) { this.idDeposito = idDeposito; }

    public String getLugarDeposito() { return lugar_deposito; }
    public void setLugarDeposito(String lugarDeposito) { this.lugar_deposito = lugarDeposito; }

    @Override
    public String toString() {
        return lugar_deposito.substring(0, 1).toUpperCase() + lugar_deposito.substring(1);
    }
}