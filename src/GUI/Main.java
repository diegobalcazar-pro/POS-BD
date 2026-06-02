package GUI;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import repository.Hashing;
import BLL.Usuario;
import BLL.Cajero;
import BLL.Admin;
import BLL.Repositor;

public class Main {
    public static void main(String[] args) {
        
        String[] acciones = { "Login", "Registrar", "Salir" };
        int menu = 0;
        
        do {
            menu = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, acciones, acciones[0]);

            switch (menu) {
                case 0:
                  
                    Usuario usuario = Usuario.Login();
                    
                    if (usuario != null) {
                        if (usuario instanceof Admin) {
                            JOptionPane.showMessageDialog(null, "Bienvenido Admin " + usuario.getNombre_usuario());
                            // Ir a menu de admin
                            usuario.Menu();
                        } else if (usuario instanceof Cajero) {
                            JOptionPane.showMessageDialog(null, "Bienvenido Cajero " + usuario.getNombre_usuario());
                            // Ir a menu de cajero
                            usuario.Menu();
                        } else if (usuario instanceof Repositor) {
                        	JOptionPane.showMessageDialog(null, "Bienvenido Repositor " + usuario.getNombre_usuario());
                            // Ir a menu de repositor
                        	usuario.Menu();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    break;

                case 1: 
                	
                	Usuario.registrarse();
                    
                    break;
            }
        } while (menu != 2);
    }
}
