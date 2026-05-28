package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import BLL.Descuento;
import repository.DescuentoRepository;

public class ControllerDescuento<T extends Descuento> implements DescuentoRepository{

private static Connection con = Conexion.getInstance().getConnection();
	
	
	
	public void agregarDescuento(Descuento descuento) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO descuentos (nombre_descuento, porcentaje_descuento) VALUES (?,?)"
            		);
            statement.setString(1, descuento.getNombre_descuento());
            statement.setDouble(2, descuento.getPorcentaje_descuento());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Descuento agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	public LinkedList<Descuento> mostrarDescuentos() {
        LinkedList<Descuento> descuentos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM descuentos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_descuento = rs.getInt("id_descuento");
                String nombre_descuento= rs.getString("nombre_descuento");
                double porcentaje_descuento = rs.getDouble("porcentaje_descuento");
                
                 descuentos.add(new Descuento(id_descuento, nombre_descuento, porcentaje_descuento));
          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return descuentos;
    }



	
	
}
