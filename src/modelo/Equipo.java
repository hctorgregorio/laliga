package modelo;

public class Equipo {
	//campos
	private int id;
	private String nombreCorto;
	private String nombre;
	//constructor
	public Equipo(int id, String nombreCorto, String nombre) {
		super();
		this.id = id;
		this.nombreCorto = nombreCorto;
		this.nombre = nombre;
	}
	//constructor vacio
	public Equipo() {
		super();
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
