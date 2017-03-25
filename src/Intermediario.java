import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Intermediario {
	Scanner teclado;
	conexionBBDD conexion;
	Fichero fichero;

	public Intermediario() {
		teclado = new Scanner(System.in);
		conexion = new conexionBBDD();
		fichero = new Fichero();
	}

	public void ejecucion() {
		conexion.conexion();
		int op = 0;
		boolean salir = false;

		while (!salir) {
			System.out.println(".......................... \n" + ".  1 Clasificacion\n"
					+ ".  2 Listado de todos los jugadores\n" + ".  3 Jugadores de un Equipo\n"
					+ ".  4 Informe de Salarios\n" + ".  5 Salir \n" + "..........................");
			try {
				System.out.print("Opción: ");
				op = teclado.nextInt();
				System.out.println("OPCION SELECCIONADA: " + op);

				switch (op) {
				case 1:
					clasificacion();
					break;
				case 2:
					int equip = 0;
					listadoJugadores(equip);
					break;
				case 3:
					int equipo = 0;
					teclado.nextLine(); // limpiar buffer

					while (!salir) {
						System.out.print(
								"Escriba el nombre de su Equipo (Barcelona; Real Madrid; Valencia; Caja Laboral; Gran Canaria; Zaragoza; (Salir): ");
						try {
							String equipoElegido = teclado.nextLine();
							if (equipoElegido.equals("Salir") || equipoElegido.equals("salir")) {
								System.out.println("Saliendo al menú principal...");
							} else {
								System.out.println("EQUIPO ELEGIDO: " + equipoElegido);
							}

							switch (equipoElegido) {
							case "Barcelona":
								equipo = 1;
								listadoJugadores(equipo);
								break;
							case "Real Madrid":
								equipo = 2;
								listadoJugadores(equipo);
								break;
							case "Valencia":
								equipo = 3;
								listadoJugadores(equipo);
								break;
							case "Caja Laboral":
								equipo = 4;
								listadoJugadores(equipo);
								break;
							case "Gran Canaria":
								equipo = 5;
								listadoJugadores(equipo);
								break;
							case "Zaragoza":
								equipo = 6;
								listadoJugadores(equipo);
								break;
							case "Salir":
								salir = true;
								break;
							case "salir":
								salir = true;
								break;
							default:
								System.out.println("ERROR: Tienes que introducir el nombre correctamente");
								break;
							}
						} catch (Exception e) {
							System.out.println("Excepcion por opcion invalida: Tienes que introducir el nombre correctamente");
							e.printStackTrace();
							teclado.next();
						}
					}
					salir = false;
					break;
				case 4:
					salarios();
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Opcion invalida: marque un numero de 1 a 5");
					break;
				}
			} catch (Exception e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 1 a 5");
				e.printStackTrace();
				teclado.next();
			}
		}
	}

	public void clasificacion() {
		HashMap<String, Integer> equipos = conexion.selectEquipos();
		fichero.escribirClasificacion(equipos);
	}

	public void listadoJugadores(int equipo) {
		ArrayList<Jugador> jugadores = conexion.selectJugadores(equipo);
		fichero.escribirJugadores(jugadores);
	}

	public void salarios() {
		ArrayList<Integer> salarios = conexion.selectSalarios();
		fichero.escribirSalarios(salarios);
	}
}