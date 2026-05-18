package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import BLL.Repositor;
import BLL.Usuario;
import BLL.VarianteProducto;
import repository.RepositorRepository;

//public class ControllerRepositor<T extends Repositor> implements RepositorRepository {

//	private static Connection con = Conexion.getInstance().getConnection();
//	
//	@Override
//    public void agregarProducto(VarianteProducto varianteproducto) {
//        try {
//            PreparedStatement statement = con.prepareStatement(
//                "INSERT INTO variantes_productos (talle, color, precio_venta) VALUES (?,?, ?, ?)"
//            );
//            statement.setString(1, varianteproducto.getTalle());
//            statement.setString(2, varianteproducto.getColor();
            //statement.(3, varianteproducto.getPrecio_venta());  

//            int filas = statement.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Usuario agregado correctamente.");
//            }
//        } catch (MySQLIntegrityConstraintViolationException e) {
//            JOptionPane.showMessageDialog(null, "No se puede crear usuario con mail existente");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    