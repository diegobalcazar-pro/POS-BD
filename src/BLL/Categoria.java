package BLL;

import DLL.ControllerCategoria;

public class Categoria {
	protected int id_categoria;
	protected String nombre_categoria;
	private static ControllerCategoria controller = new ControllerCategoria();

	public Categoria(int id_categoria, String nombre_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
	}

	public int getid_categoria() {
		return id_categoria;
	}

	public void setid_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	
	
	//METODO CATEGORIA MAS VENDIDA
	public static String categoriaMasVendida() {
	    return controller.categoriaMasVendida();
	}

}