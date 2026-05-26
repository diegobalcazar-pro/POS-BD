package DLL;

import BLL.Proveedor;
import java.sql.*;
import java.util.LinkedList;

public class ControllerProveedor {
    private static Connection con = Conexion.getInstance().getConnection();

    public void agregarProveedor(Proveedor p) {
        String sql = "INSERT INTO proveedores (nombreEmpresa, nombreContacto, telefono, correo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getNombreEmpresa());
            stmt.setString(2, p.getNombreContacto());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Proveedor> mostrarProveedores() {
        LinkedList<Proveedor> lista = new LinkedList<>();
        String sql = "SELECT * FROM proveedores";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombreEmpresa"),
                    rs.getString("nombreContacto"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarProveedor(Proveedor p) {
        String sql = "UPDATE proveedores SET nombreEmpresa=?, nombreContacto=?, telefono=?, correo=? WHERE id_proveedor=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getNombreEmpresa());
            stmt.setString(2, p.getNombreContacto());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getCorreo());
            stmt.setInt(5, p.getIdProveedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}