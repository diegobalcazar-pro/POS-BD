package BLL;

public class Deposito {
    protected int id_deposito;
    protected String lugar_deposito;

    public Deposito(int id_deposito, String lugarDeposito) {
        this.id_deposito = id_deposito;
        this.lugar_deposito = lugarDeposito;
    }

    public int getid_deposito() { return id_deposito; }
    public void setid_deposito(int id_deposito) { this.id_deposito = id_deposito; }

    public String getLugarDeposito() { return lugar_deposito; }
    public void setLugarDeposito(String lugarDeposito) { this.lugar_deposito = lugarDeposito; }

    @Override
    public String toString() {
        return lugar_deposito.substring(0, 1).toUpperCase() + lugar_deposito.substring(1);
    }
}