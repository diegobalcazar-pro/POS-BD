package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerVenta;
import BLL.Cliente;
import java.util.LinkedList;

public class MenuCajero_SeleccionarCliente extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private MenuCajero menuCajero;
    private ControllerVenta controllerVenta = new ControllerVenta();

    public static void main(String[] args) {
        try {
        	MenuCajero_SeleccionarCliente frame = new MenuCajero_SeleccionarCliente(null);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MenuCajero_SeleccionarCliente(MenuCajero menuCajero) {

        this.menuCajero = menuCajero;

        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 620, 484);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("SELECCIONAR CLIENTE");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 17));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 604, 42);
        contentPane.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 0, 0));
        panel.setBounds(0, 1, 604, 75);
        contentPane.add(panel);

        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGap(0, 604, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGap(0, 75, Short.MAX_VALUE)
        );
        panel.setLayout(gl_panel);
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 87, 584, 253);
        contentPane.add(scrollPane);

        model = new DefaultTableModel(new String[] {"ID", "Nombre", "Apellido", "Correo", "Teléfono", "Dirección", "Tipo"}, 0);

        table = new JTable(model);
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        scrollPane.setViewportView(table);

        Button btnSelecciondeCliente = new Button("Seleccionar");
        btnSelecciondeCliente.setForeground(Color.WHITE);
        btnSelecciondeCliente.setFont(new Font("Dialog", Font.BOLD, 15));
        btnSelecciondeCliente.setBackground(new Color(64, 0, 0));
        btnSelecciondeCliente.setBounds(378, 366, 109, 60);
        contentPane.add(btnSelecciondeCliente);
        btnSelecciondeCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarCliente();
            }
        });

        Button btnSalir = new Button("Salir");
        btnSalir.setBackground(new Color(64, 0, 0));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setFont(new Font("Dialog", Font.BOLD, 15));
        btnSalir.setBounds(499, 366, 62, 60);
        contentPane.add(btnSalir);

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cargarClientes();
    }

    private void cargarClientes() {

        model.setRowCount(0);

        LinkedList<Object[]> clientes = controllerVenta.mostrarClientesParaTabla();

        for (Object[] fila : clientes) {
            model.addRow(fila);
        }
    }

    private void seleccionarCliente() {

        int filaSeleccionada = table.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente.");
            return;
        }

        int idCliente = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());

        Cliente cliente = controllerVenta.buscarClientePorId(idCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el cliente.");
            return;
        }

        if (menuCajero == null) {
            JOptionPane.showMessageDialog(null, "No se puede seleccionar porque no hay menú cajero conectado.");
            return;
        }

        menuCajero.cambiarClienteDesdeVentana(cliente);

        dispose();
    }


}