public class Jugador {
	private String nombre;
	private String apellido;
	private String puesto;
	private String altura;
	private String salario;
	private String nombreEquipo;
	
	public Jugador(String nombre, String apellido, String puesto, String altura, String salario, String nombreEquipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.altura = altura;
		this.salario = salario;
		this.nombreEquipo = nombreEquipo;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
}