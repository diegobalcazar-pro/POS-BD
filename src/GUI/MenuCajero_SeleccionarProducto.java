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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerVarianteProducto;

public class MenuCajero_SeleccionarProducto extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JTextField inpCantidad;
    private JLabel lblNombreProductoSeleccionado;

    private MenuCajero menuCajero;

    public static void main(String[] args) {
        try {
        	MenuCajero_SeleccionarProducto frame = new MenuCajero_SeleccionarProducto(null);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MenuCajero_SeleccionarProducto(MenuCajero menuCajero) {

        this.menuCajero = menuCajero;

        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\\\logo4.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 620, 484);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("SELECCIONAR PRODUCTO");
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

        JLabel lblProductoSeleccionado = new JLabel("PRODUCTOS DISPONIBLES");
        lblProductoSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductoSeleccionado.setFont(new Font("Verdana", Font.BOLD, 11));
        lblProductoSeleccionado.setBounds(10, 82, 201, 22);
        contentPane.add(lblProductoSeleccionado);
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 111, 584, 229);
        contentPane.add(scrollPane);

        model = new DefaultTableModel(new String[] {"ID Variante", "Producto", "Talle", "Color", "Precio", "Depósito"}, 0);

        table = new JTable(model);
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        scrollPane.setViewportView(table);

        JLabel lblCantidad = new JLabel("CANTIDAD:");
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidad.setFont(new Font("Verdana", Font.BOLD, 11));
        lblCantidad.setBounds(20, 364, 110, 22);
        contentPane.add(lblCantidad);

        inpCantidad = new JTextField();
        inpCantidad.setBounds(126, 363, 86, 27);
        contentPane.add(inpCantidad);
        inpCantidad.setColumns(10);

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFont(new Font("Dialog", Font.BOLD, 15));
        btnAgregar.setBackground(new Color(64, 0, 0));
        btnAgregar.setBounds(401, 366, 86, 60);
        contentPane.add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProductoSeleccionado();
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

        cargarProductos();
    }

    private void cargarProductos() {

        model.setRowCount(0);

        List<Object[]> productos = ControllerVarianteProducto.obtenerInventarioParaTabla();

        for (Object[] fila : productos) {
            model.addRow(fila);
        }
    }

    private void agregarProductoSeleccionado() {

        int filaSeleccionada = table.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
            return;
        }

        String cantidadTexto = inpCantidad.getText().trim();

        if (cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad.");
            return;
        }

        int cantidad = 0;

        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número.");
            return;
        }

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
            return;
        }

        int idVariante = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());

        if (menuCajero == null) {
            JOptionPane.showMessageDialog(null, "No se puede agregar porque no hay menú cajero conectado.");
            return;
        }

        menuCajero.agregarProductoDesdeVentana(idVariante, cantidad);

        dispose();
    }
}