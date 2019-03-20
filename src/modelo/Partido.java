package modelo;

public class Partido {
	//campo
	private int id;
	private int jornada;
	private String equipoLoval;
	private int golesLocal;
	private String equipoVisitante;
	private int golesVisitante;
	//constructor
	public Partido(int id, int jornada, String equipoLoval, int golesLocal, String equipoVisitante,
			int golesVisitante) {
		super();
		this.id = id;
		this.jornada = jornada;
		this.equipoLoval = equipoLoval;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
	}

	//constructor vacio
	public Partido() {
		super();
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public String getEquipoLoval() {
		return equipoLoval;
	}

	public void setEquipoLoval(String equipoLoval) {
		this.equipoLoval = equipoLoval;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
		
}
