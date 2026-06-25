package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.Descuento;
import repository.DescuentoRepository;

public class ControllerDescuento<T extends Descuento> implements DescuentoRepository{

private static Connection con = Conexion.getInstance().getConnection();
	
	
	//Agregar Descuentos
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
	
	
	//Mostrar Descuentos lista
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
	
	//Eliminar por nombre Seleccionado
	public void EliminarDescuento(String nombre_descuento) {
        try {
            PreparedStatement statement = con.prepareStatement(
            		"DELETE FROM descuentos WHERE nombre_descuento = ?"
            );
            statement.setString(1, nombre_descuento);

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Descuento eliminado correctamente.");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//Editar por nombre seleccionado
	public void EditarDescuento(Descuento descuento) {
	    try {
	        PreparedStatement statement = con.prepareStatement(
	            "UPDATE descuentos SET nombre_descuento=?, porcentaje_descuento=? WHERE id_descuento=?"
	        );
	        statement.setString(1, descuento.getNombre_descuento());
	        statement.setDouble(2, descuento.getPorcentaje_descuento());
	        statement.setInt(3, descuento.getId_descuento());

	        int filas = statement.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Descuento editado correctamente.");
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}