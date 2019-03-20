package modelo;

public class Persona {
	//campos
	private String nif;
	private String nombre;
	private String apellidos;
	private char sexo;
	//constructor
	public Persona(String nif, String nombre, String apellidos, char sexo) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
	}
	//constructor vacio
	public Persona() {
		super();
	}
	//getters and setters
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
