package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.AuditoriaStock;
import BLL.Deposito;
import BLL.Usuario;
import BLL.VarianteProducto;

public class ControllerAuditoriaStock {

    private static Connection con = Conexion.getInstance().getConnection();
    private ControllerUsuario controllerUsuario = new ControllerUsuario();
    private ControllerDeposito controllerDeposito = new ControllerDeposito();
    private ControllerVarianteProducto controllerVariante = new ControllerVarianteProducto();
    
    public LinkedList<AuditoriaStock> mostrarMovimientosStock() {
        LinkedList<AuditoriaStock> lista = new LinkedList<>();

        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM auditorias_stocks ORDER BY fecha DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {


                Usuario usuario = controllerUsuario.buscarUsuarioPorId(
                        resultSet.getInt("fk_usuario")
                );
                

                VarianteProducto variante = controllerVariante.buscarPorId(
                        resultSet.getInt("fk_variante_producto")
                );

                Deposito origen = controllerDeposito.buscarPorId(
                        resultSet.getInt("fk_deposito_origen")
                );

                Deposito destino = controllerDeposito.buscarPorId(
                        resultSet.getInt("fk_deposito_destino")
                );


                AuditoriaStock a = new AuditoriaStock(
                        resultSet.getInt("id_auditoria_stock"),
                        resultSet.getString("tipo_movimiento"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDate("fecha").toLocalDate(),
                        variante,
                        usuario,
                        origen,
                        destino
                );

                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}