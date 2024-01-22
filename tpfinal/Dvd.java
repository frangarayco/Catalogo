package tpfinal;

public class Dvd extends Discos {

	private String director;

	public Dvd(String titulo, String genero, int duracion, String disponible, String comentario, String id) {
		super(titulo, genero, duracion, disponible, comentario, id);
		this.director = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
}
