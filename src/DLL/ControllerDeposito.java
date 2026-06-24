package DLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BLL.Deposito;
public class ControllerDeposito {

    private static Connection con = Conexion.getInstance().getConnection();

    public Deposito buscarPorId(int id) {

        Deposito deposito = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM depositos WHERE id_deposito = ?"
            );
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                deposito = new Deposito(
                    rs.getInt("id_deposito"),
                    rs.getString("lugar_deposito")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deposito;
    }
}