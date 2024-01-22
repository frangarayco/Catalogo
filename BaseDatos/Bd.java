package BaseDatos;

import java.sql.*;

public class Bd {

		private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3308/discos?useSSL=false";
		private static final String USUARIO = "root";
		private static final String CONTRASEÑA = "";
		
		
		private Connection conexion = null;
		
		static {
			try {
				Class.forName(CONTROLADOR);
			} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar los drivers");
				e.printStackTrace();
			}
		}
		
		
		public Connection conectar()  {
			try {
				conexion = DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
				
			}catch (SQLException e){
				System.out.println("Error al cargar la base de datos");
				e.printStackTrace();
			}
			return conexion;
		}

}
