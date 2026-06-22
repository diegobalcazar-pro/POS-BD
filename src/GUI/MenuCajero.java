package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import BLL.Cajero;
import DLL.ControllerVenta;

public class MenuCajero extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Cajero cajero;
    private ControllerVenta controllerVenta = new ControllerVenta();

    private JLabel lblTitulo;
    private JLabel lblUsuario;

    private JButton btnRealizarVenta;
    private JButton btnVerCaja;
    private JButton btnImprimirTicket;
    private JButton btnVerVentasFecha;
    private JButton btnVerVentasHoy;
    private JButton btnCerrarCaja;
    private JButton btnCerrarSesion;

    public MenuCajero(Cajero cajero) {
        this.cajero = cajero;

        setTitle("Menú Cajero");
        setBounds(100, 100, 500, 430);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblTitulo = new JLabel("MENÚ CAJERO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(90, 20, 300, 40);
        add(lblTitulo);

        lblUsuario = new JLabel("Usuario: " + cajero.getNombre_usuario() + " " + cajero.getApellido_usuario());
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario.setBounds(50, 65, 380, 30);
        add(lblUsuario);

        btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setBounds(150, 110, 180, 35);
        btnRealizarVenta.addActionListener(this);
        add(btnRealizarVenta);

        btnVerCaja = new JButton("Ver Caja del Día");
        btnVerCaja.setBounds(150, 155, 180, 35);
        btnVerCaja.addActionListener(this);
        add(btnVerCaja);

        btnImprimirTicket = new JButton("Imprimir Ticket del Día");
        btnImprimirTicket.setBounds(150, 200, 180, 35);
        btnImprimirTicket.addActionListener(this);
        add(btnImprimirTicket);

        btnVerVentasFecha = new JButton("Ver Ventas por Fecha");
        btnVerVentasFecha.setBounds(150, 245, 180, 35);
        btnVerVentasFecha.addActionListener(this);
        add(btnVerVentasFecha);

        btnVerVentasHoy = new JButton("Ver Ventas Hoy");
        btnVerVentasHoy.setBounds(150, 290, 180, 35);
        btnVerVentasHoy.addActionListener(this);
        add(btnVerVentasHoy);

        btnCerrarCaja = new JButton("Cerrar Caja");
        btnCerrarCaja.setBounds(50, 345, 170, 35);
        btnCerrarCaja.addActionListener(this);
        add(btnCerrarCaja);

        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setBounds(260, 345, 170, 35);
        btnCerrarSesion.addActionListener(this);
        add(btnCerrarSesion);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == btnRealizarVenta) {
            JOptionPane.showMessageDialog(null, "Después acá abrimos la ventana RealizarVentaCajero.");
            // RealizarVentaCajero ventana = new RealizarVentaCajero(cajero);
            // ventana.setVisible(true);
        }

        if (evento.getSource() == btnVerCaja) {
            String fechaHoy = LocalDate.now().toString();
            JOptionPane.showMessageDialog(null, controllerVenta.mostrarCajaDelDia(fechaHoy));
        }

        if (evento.getSource() == btnImprimirTicket) {
            String fechaHoy = LocalDate.now().toString();
            JOptionPane.showMessageDialog(null, controllerVenta.imprimirTicketDelDia(fechaHoy));
        }

        if (evento.getSource() == btnVerVentasFecha) {
            String fecha = JOptionPane.showInputDialog("Ingrese fecha con formato AAAA-MM-DD");

            if (fecha != null && !fecha.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, controllerVenta.mostrarVentasPorFecha(fecha));
            }
        }

        if (evento.getSource() == btnVerVentasHoy) {
            String fechaHoy = LocalDate.now().toString();
            JOptionPane.showMessageDialog(null, controllerVenta.mostrarVentasPorFecha(fechaHoy));
        }

        if (evento.getSource() == btnCerrarCaja) {
            int confirmar = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro que desea cerrar la caja?",
                    "Cerrar Caja",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmar == JOptionPane.YES_OPTION) {
                String fechaHoy = LocalDate.now().toString();
                JOptionPane.showMessageDialog(null, controllerVenta.mostrarCajaDelDia(fechaHoy));
                JOptionPane.showMessageDialog(null, "Caja cerrada correctamente.");

                dispose();

                Login login = new Login();
                login.setVisible(true);
            }
        }

        if (evento.getSource() == btnCerrarSesion) {
            dispose();

            Login login = new Login();
            login.setVisible(true);
        }
    }
}
