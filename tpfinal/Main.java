package tpfinal;
import BaseDatos.Bd;
import gui.Pantalla;

public class Main {

 
	public static void main(String[] args) {
		
		Catalogo cat = new Catalogo();
		Pantalla pantalla = new Pantalla(cat);
		pantalla.setVisible(true);
		pantalla.setLocationRelativeTo(null);

	}
}
