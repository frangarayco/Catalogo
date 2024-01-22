package tpfinal;

public class Cd extends Discos {

	private String interprete;
	private int cantTemas;
	
	
	public Cd(String titulo, String genero, int duracion, String disponible, String comentario, String id, int cantTemas) {
		super(titulo, genero, duracion, disponible, comentario, id);
		this.interprete = id;
		this.cantTemas = cantTemas;
	}


	public String getInterprete() {
		return interprete;
	}


	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}


	public int getCantTemas() {
		return cantTemas;
	}


	public void setCantTemas(int cantTemas) {
		this.cantTemas = cantTemas;
	}
	
	
	
	
}
