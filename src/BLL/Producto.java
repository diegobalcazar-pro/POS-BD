package BLL;

public class Producto {
	
	private int id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private int fk_categoria;
    private int fk_proveedor;
    
	public Producto(int id_producto, String nombre_producto, String descripcion_producto, int fk_categoria,
			int fk_proveedor) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion_producto = descripcion_producto;
		this.fk_categoria = fk_categoria;
		this.fk_proveedor = fk_proveedor;
	}
    
	public Producto(String nombre_producto, String descripcion_producto, int fk_categoria, int fk_proveedor) {
        this(0, nombre_producto, descripcion_producto, fk_categoria, fk_proveedor);
    }
	
	public int getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public int getFk_categoria() {
        return fk_categoria;
    }

    public int getFk_proveedor() {
        return fk_proveedor;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public void setFk_categoria(int fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public void setFk_proveedor(int fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
    }

    @Override
    public String toString() {
        return id_producto + " - " + nombre_producto + " | " + descripcion_producto;
    }

}
