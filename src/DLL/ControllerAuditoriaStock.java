package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerAuditoriaStock {

    private static Connection con = Conexion.getInstance().getConnection();

    public String mostrarMovimientosStock() {

        StringBuilder resultado = new StringBuilder();

        try {

            PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM auditorias_stocks ORDER BY fecha DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                resultado.append("Numero de movimiento(ID): ")
                         .append(resultSet.getInt("id_auditoria_stock"))
                         .append("\nTipo de movimiento: ")
                         .append(resultSet.getString("tipo_movimiento"))
                         .append("\nCantidad: ")
                         .append(resultSet.getInt("cantidad"))
                         .append("\nFecha: ")
                         .append(resultSet.getDate("fecha"))
                         .append("\nVariante: ")
                         .append(resultSet.getInt("fk_variante_producto"))
                         .append("\nUsuario: ")
                         .append(resultSet.getInt("fk_usuario"))
                         .append("\nDepósito origen: ")
                         .append(resultSet.getInt("fk_deposito_origen"))
                         .append("\nDepósito destino: ")
                         .append(resultSet.getInt("fk_deposito_destino"))
                         .append("\n---------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado.toString();
    }
}