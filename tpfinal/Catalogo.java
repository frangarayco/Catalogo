package tpfinal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;

import java.sql.PreparedStatement;

import BaseDatos.Bd;
public class Catalogo{
	
	
	
	private int produ;
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null; 
	private PreparedStatement ps = null; 
	
	Bd bd = new Bd();
	
	public Catalogo() {
		
		
	}
	
	
	public void agregar(String titulo, String genero, int duracion, String disponible, String comentario, String id,
			int cantTemas, int produ){
			int idprodu = 0;
		try {
			con = bd.conectar();
			ps = con.prepareStatement("INSERT INTO `discos`(`idprodu`, `titulo`, `genero`, `duracion`, `disponible`, `comentario`, `id`, `cant_temas`, `produ`) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, idprodu);
			ps.setString(2, titulo);
			ps.setString(3, genero);
			ps.setInt(4, duracion);
			ps.setString(5, disponible);
			ps.setString(6, comentario);
			ps.setString(7, id);
			ps.setInt(8, cantTemas);
			ps.setInt(9, produ);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error no guardo bien");
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
		
	}
	
	
	public void mostrar(JTextArea mostrar) {
		String tipo;
		
		try {
			con = bd.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM discos");
			while(rs.next()) {
				int idprodu = rs.getInt(1);
				String titulo = rs.getString(2);
				String genero = rs.getString(3);
				int duracion = rs.getInt(4);
				String disponible = rs.getString(5);
				String comentario = rs.getString(6);
				String id = rs.getString(7);
				int temas = rs.getInt(8);
				int produ = rs.getInt(9);
				if(produ == 1) {
					tipo = "Cd";
				}else {
					tipo = "Dvd";
				}
				mostrar.append(titulo +"			"+ genero +"			"+ temas +"		"+tipo+"		"+id+"\n");
			}
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	
	public void eliminar(String titulo)  {
		con = bd.conectar();
		try {
			ps = con.prepareStatement("DELETE FROM `discos` WHERE titulo = ?");
			ps.setString(1, titulo);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error para eliminar");
		}
		
	}
	
	public void mostrarCd(JTextArea mostrar) {
		String tipo; 
		try {
			con = bd.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM `discos` WHERE produ = 1 ");
			while(rs.next()) {
				int idprodu = rs.getInt(1);
				String titulo = rs.getString(2);
				String genero = rs.getString(3);
				int duracion = rs.getInt(4);
				String disponible = rs.getString(5);
				String comentario = rs.getString(6);
				String id = rs.getString(7);
				int temas = rs.getInt(8);
				int produ = rs.getInt(9);
				
				if(produ == 1) {
					tipo = "Cd";
				}else {
					tipo = "Dvd";
				}

				mostrar.append(titulo +"			"+ genero +"			"+ temas +"		"+tipo+"		"+id+"\n");
			}
			
		} catch (SQLException e) {
			System.out.println("Error al mostrar los cd");
			e.printStackTrace();
		}
		
	}
	
	public void mostrarDVd(JTextArea mostrar) {
		String tipo; 
		try {
			con = bd.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM `discos` WHERE produ = 0 ");
			while(rs.next()) {
				int idprodu = rs.getInt(1);
				String titulo = rs.getString(2);
				String genero = rs.getString(3);
				int duracion = rs.getInt(4);
				String disponible = rs.getString(5);
				String comentario = rs.getString(6);
				String id = rs.getString(7);
				int temas = rs.getInt(8);
				int produ = rs.getInt(9);
				
				if(produ == 1) {
					tipo = "Cd";
				}else {
					tipo = "Dvd";
				}
				mostrar.append(titulo +"			"+ genero +"			"+ temas +"		"+tipo+"		"+id+"\n");
			}
			
		} catch (SQLException e) {
			System.out.println("Error al mostrar los dvd");
			e.printStackTrace();
		}
	}
	
	
	public void mostrarDisponibles(JTextArea mostrar) {
			String tipo; 
			try {
				con = bd.conectar();
				stm = con.createStatement();
				rs = stm.executeQuery("SELECT * FROM `discos` WHERE disponible = 'verdadero' ");
				while(rs.next()) {
					int idprodu = rs.getInt(1);
					String titulo = rs.getString(2);
					String genero = rs.getString(3);
					int duracion = rs.getInt(4);
					String disponible = rs.getString(5);
					String comentario = rs.getString(6);
					String id = rs.getString(7);
					int temas = rs.getInt(8);
					int produ = rs.getInt(9);
					
					if(produ == 1) {
						tipo = "Cd";
					}else {
						tipo = "Dvd";
					}
					mostrar.append(titulo +"			"+ genero +"			"+ temas +"		"+tipo+"		"+id+"\n");
				}
				
			} catch (SQLException e) {
				System.out.println("Error al mostrar los disponibles");
				e.printStackTrace();
			}
	}
	
	public void mostrarId(String nombre,JTextArea mostrar) {
		String tipo; 
		try {
			con = bd.conectar();
			ps = con.prepareStatement("SELECT * FROM `discos` WHERE id = ?");
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			while(rs.next()) {
				int idprodu = rs.getInt(1);
				String titulo = rs.getString(2);
				String genero = rs.getString(3);
				int duracion = rs.getInt(4);
				String disponible = rs.getString(5);
				String comentario = rs.getString(6);
				String id = rs.getString(7);
				int temas = rs.getInt(8);
				int produ = rs.getInt(9);
				
				if(produ == 1) {
					tipo = "Cd";
				}else {
					tipo = "Dvd";
				}
				mostrar.append(titulo +"			"+ genero +"			"+ temas +"		"+tipo+"		"+id+"\n");
			}
			
		} catch (SQLException e) {
			System.out.println("Error al mostrar los disponibles");
			e.printStackTrace();
		}
	}

	public int getProdu() {
		return produ;
	}

	public void setProdu(int produ) {
		this.produ = produ;
	}

}
