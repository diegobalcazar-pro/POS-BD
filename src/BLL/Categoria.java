package BLL;

public class Categoria {
	protected int idCategoria;
	protected String nombre_categoria;

	public Categoria(int idCategoria, String nombre_categoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombre_categoria = nombre_categoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

}
