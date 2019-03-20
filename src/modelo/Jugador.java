package modelo;

public class Jugador extends Persona{
	//campos
	private int id;
	private int dorsal;
	private int idEquipo;
	//constructor
	public Jugador(String nif, String nombre, String apellidos, char sexo, int id, int dorsal, int idEquipo) {
		super(nif, nombre, apellidos, sexo);
		this.id = id;
		this.dorsal = dorsal;
		this.idEquipo = idEquipo;
	}
	//constructor vacio
	public Jugador(String nif, String nombre, String apellidos, char sexo) {
		super(nif, nombre, apellidos, sexo);
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	
}
