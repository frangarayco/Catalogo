package tpfinal;

public class Discos {
	
	private String titulo;
	private String genero;
	private int duracion;
	private String disponible; 
	private String comentario;
	private String id;
	
	public Discos(String titulo, String genero, int duracion, String disponible, String comentario, String id) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.disponible = disponible;
		this.comentario = comentario;
		this.id = id;
	}
	
	public Discos() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
