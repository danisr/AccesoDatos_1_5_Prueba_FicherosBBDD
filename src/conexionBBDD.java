import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class conexionBBDD {
	Connection conexion;

	public void conexion() {
		System.out.println("Conectando...");
		Properties propiedades = new Properties();
		InputStream entrada = null;

		try {
			entrada = new FileInputStream("configbbdd.ini");
			propiedades.load(entrada);

			String bbdd = propiedades.getProperty("bbdd");
			String user = propiedades.getProperty("user");
			String pwd = propiedades.getProperty("pass");
			String url = "jdbc:mysql://localhost/" + bbdd;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conexion = DriverManager.getConnection(url, user, pwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Conexion establecida");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("No tengo el driver cargado");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public HashMap<String, Integer> selectEquipos() {
		System.out.println("Lectura de tabla equipos");
		HashMap<String, Integer> equipos = new HashMap<String, Integer>();

		try {
			if (conexion != null) {
				String query = "SELECT nombre, puntos FROM equipos ORDER BY puntos DESC";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();

				while (rset.next()) {
					String nombre = rset.getString("nombre");
					int puntos = rset.getInt("puntos");

					equipos.put(nombre, puntos);
				}
				pstmt.close();
				rset.close();
			} else {
				System.out.println("Conexion nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipos;
	}

	public ArrayList<Jugador> selectJugadores(int numeroEquipo) {
		System.out.println("Lectura de tabla jugadores");
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

		try {
			if (conexion != null) {
				String query = "SELECT J.nombre, J.apellido, J.puesto, J.altura, E.nombre "
						+ "FROM liga.jugadores J, liga.equipos E WHERE J.equipo = E.id_equipo";

				if (numeroEquipo > 0) { //Jugadores de UN EQUIPO EN CONCRETO
					query += " AND E.id_equipo = " + numeroEquipo;
				}

				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();

				while (rset.next()) {
					String nombre = rset.getString("J.nombre");
					String apellido = rset.getString("J.apellido");
					String puesto = rset.getString("J.puesto");
					String altura = rset.getString("J.altura");
					String nombreEqu = rset.getString("E.nombre");

					jugadores.add(new Jugador(nombre, apellido, puesto, altura, null, nombreEqu));
				}
				pstmt.close();
				rset.close();
			} else {
				System.out.println("Conexion nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadores;
	}

	public ArrayList<Integer> selectSalarios() {
		System.out.println("Lectura de salarios");
		ArrayList<Integer> salarios = new ArrayList();

		try {
			if (conexion != null) {
				String query = "SELECT MAX(salario), MIN(salario), ROUND(AVG(salario)) FROM liga.jugadores";

				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();

				while (rset.next()) {
					int maxSalario = rset.getInt("MAX(salario)");
					int minSalario = rset.getInt("MIN(salario)");
					int mediaSalario = rset.getInt("ROUND(AVG(salario))");
					
					salarios.add(maxSalario);
					salarios.add(minSalario);
					salarios.add(mediaSalario);
				}				
				pstmt.close();
				rset.close();
			} else {
				System.out.println("Conexion nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salarios;
	}
}