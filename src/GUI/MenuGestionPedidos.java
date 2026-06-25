package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import BLL.Usuario;
import BLL.Envio;
import DLL.ControllerEnvio;

public class MenuGestionPedidos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel modeloTabla;
    private ControllerEnvio controllerEnvio = new ControllerEnvio();
    private Usuario usuarioLogueado;

    public MenuGestionPedidos(Usuario logueado) {
        this.usuarioLogueado = logueado;

        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo3.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 740, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- HEADER ---
        JPanel header = new JPanel();
        header.setBounds(0, 1, 726, 75);
        header.setBackground(new Color(64, 0, 0));
        contentPane.add(header);
        header.setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(621, 0, 95, 75);
        header.add(lblLogo);
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon imagenOriginal = new ImageIcon("src\\\\img\\\\logo.png");
        Image imgEscalada = imagenOriginal.getImage().getScaledInstance(95, 75, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(imgEscalada));

        JLabel lblLogo1 = new JLabel("");
        lblLogo1.setBounds(10, 0, 169, 76);
        header.add(lblLogo1);
        lblLogo1.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo1.setIcon(new ImageIcon("src\\\\img\\\\logo1.png"));

        JLabel lblBienvenida = new JLabel("Gestión Pedidos - Repositor " + usuarioLogueado.getNombre_usuario());
        lblBienvenida.setForeground(Color.WHITE);
        lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBienvenida.setBounds(225, 11, 350, 52);
        header.add(lblBienvenida);

        // --- NAV LATERAL ---
        JPanel nav = new JPanel();
        nav.setBounds(0, 76, 190, 437);
        nav.setBackground(new Color(90, 0, 0));
        nav.setLayout(null);
        contentPane.add(nav);

        JButton btnModificar = crearBotonNav("Modificar", 15);
        btnModificar.addActionListener(e -> accionModificar());
        nav.add(btnModificar);

        JButton btnEnviar = crearBotonNav("Enviar Pedido", 65);
        btnEnviar.addActionListener(e -> accionEnviar());
        nav.add(btnEnviar);

        JButton btnEliminar = crearBotonNav("Eliminar", 115);
        btnEliminar.addActionListener(e -> accionEliminar());
        nav.add(btnEliminar);

        JButton btnCupo = crearBotonNav("Cupo Diario", 165);
        btnCupo.addActionListener(e -> accionCupo());
        nav.add(btnCupo);

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("Ebrima", Font.BOLD, 13));
        btnAtras.setBounds(10, 380, 170, 45);
        btnAtras.addActionListener(e -> dispose());
        nav.add(btnAtras);
        
        btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRepositor menu = new MenuRepositor(usuarioLogueado);
				menu.setVisible(true);
				dispose();
			}
		});

        // --- TABLA ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 87, 516, 415);
        contentPane.add(scrollPane);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Seguimiento", "Estado", "F. Despacho"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(modeloTabla);
        scrollPane.setViewportView(table);

        cargarEnviosEnTabla();
    }

    private JButton crearBotonNav(String texto, int y) {
        JButton btn = new JButton(texto);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Ebrima", Font.BOLD, 13));
        btn.setBackground(new Color(128, 0, 0));
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBounds(10, y, 170, 45);
        return btn;
    }

    private void cargarEnviosEnTabla() {
        modeloTabla.setRowCount(0);
        List<Envio> lista = controllerEnvio.listarEnvios();
        if (lista != null) {
            for (Envio env : lista) {
                modeloTabla.addRow(new Object[]{
                    env.getid_envio(),
                    env.getnumero_seguimiento(),
                    env.getEstado().toUpperCase(),
                    (env.getfecha_despacho() != null ? env.getfecha_despacho() : "Pendiente")
                });
            }
        }
    }

    private void accionModificar() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un envío de la tabla para modificar.");
            return;
        }

        int id = (int) table.getValueAt(fila, 0);
        String seguimientoActual = (String) table.getValueAt(fila, 1);

        // Pedir el nuevo número de seguimiento
        String nuevoSeguimiento = JOptionPane.showInputDialog(this, 
                "Ingrese el nuevo número de seguimiento:", 
                seguimientoActual);

        if (nuevoSeguimiento != null && !nuevoSeguimiento.trim().isEmpty()) {
            // Llamada al método de tu controlador
            controllerEnvio.modificarSeguimiento(id, nuevoSeguimiento.trim());
            
            // Recargar tabla para ver cambios
            cargarEnviosEnTabla();
            JOptionPane.showMessageDialog(this, "Seguimiento actualizado correctamente.");
        }
    }

    private void accionEnviar() {
        int fila = table.getSelectedRow();
        if (fila != -1) {
            int id = (int) table.getValueAt(fila, 0);
            // Asegúrate de que el controlador tenga este método
            controllerEnvio.enviarPedido(id);
            cargarEnviosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un envío.");
        }
    }

    private void accionEliminar() {
        int fila = table.getSelectedRow();
        if (fila != -1) {
            controllerEnvio.eliminarEnvio((int) table.getValueAt(fila, 0));
            cargarEnviosEnTabla();
        }
    }

    private void accionCupo() {
        JOptionPane.showMessageDialog(this, "Cupo utilizado hoy: " + controllerEnvio.obtenerCantidadDespachosHoy() + "/10");
    }
}