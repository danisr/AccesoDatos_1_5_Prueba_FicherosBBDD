import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

public class Fichero {
	FileWriter fichero = null;
	PrintWriter pw = null;
	Properties propiedades = new Properties();
	InputStream entrada = null;
	
	// Para que salga ordenado el hashmap de Partidos (de stackoverflow)
	/*
	SortedSet<Integer> keys = new TreeSet<Integer>(hmPart.keySet());
	for (int key : keys) {
		auxPart = (Partido) hmPart.get(key);
	*/

	public void escribirClasificacion(HashMap<String, Integer> equipos) {
		System.out.println("Escritura de Clasificación");
		try {
			entrada = new FileInputStream("configfichero.ini");
			propiedades.load(entrada);

			String ruta = propiedades.getProperty("ruta");
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);

			int puesto = 1;
			Iterator<Map.Entry<String, Integer>> entries = equipos.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<String, Integer> entry = entries.next();
				String nombre = entry.getKey();
				int puntos = entry.getValue();

				pw.println(puesto + ": " + nombre + " = " + puntos);
				puesto++;
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirJugadores(ArrayList<Jugador> jugadores) {
		System.out.println("Escritura de Jugadores");
		try {
			entrada = new FileInputStream("configfichero.ini");
			propiedades.load(entrada);

			String ruta = propiedades.getProperty("ruta");
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < jugadores.size(); i++) {
				pw.print("Nombre:" + jugadores.get(i).getNombre() + " Apellido:" + jugadores.get(i).getApellido()
						+ " Puesto:" + jugadores.get(i).getPuesto() + " Altura:" + jugadores.get(i).getAltura()
						+ " Equipo:" + jugadores.get(i).getNombreEquipo());
				pw.println();
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirSalarios(ArrayList<Integer> salarios) {
		System.out.println("Escritura de Salarios");
		try {
			entrada = new FileInputStream("configfichero.ini");
			propiedades.load(entrada);

			String ruta = propiedades.getProperty("ruta");
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < salarios.size(); i++) {
				pw.print("Salario Máximo:" + salarios.get(i) + " Salario Mínimo:" + salarios.get(++i)
						+ " Salario Medio:" + salarios.get(++i));
				pw.println();
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}