package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import modelo.Equipo;

public class LaLiga {

	public void crearLiga(String nombreTemporada) {
		
		LaLiga ejercicios = new LaLiga();

		// recogida de datos del fichero equipos y asignacion a una lista de objetos de
		ArrayList<Equipo> listaEquipos = ejercicios.equiposDeFutbol("ficheros/equipos.txt", "#");
		System.out.println("lista de equipos creado");

		// Creacion de dos grupos de 10 de los equipos para luego generar la temporada
		ArrayList<String> grupo1 = ejercicios.primerGrupo(listaEquipos);
		ArrayList<String> grupo2 = ejercicios.segundoGrupo(listaEquipos);
		System.out.println("grupos creados");

		HashMap<Integer, ArrayList<String>> jornadasDeLaTemporada = new HashMap<>();
		
		jornadasDeLaTemporada = ejercicios.primeraVuelta(grupo1, grupo2);
		jornadasDeLaTemporada = ejercicios.segundaVuelta(grupo1, grupo2, jornadasDeLaTemporada);
		
		String ruta = "ficheros/temporadas/" + nombreTemporada;
		ejercicios.escribirTemporada(jornadasDeLaTemporada, ruta);

		System.out.println("FIN DEL PROGRAMA");
	}
	
	public ArrayList<Equipo> equiposDeFutbol(String rutaFichero, String separador) {
		BufferedReader fichero;
		try {
			fichero = new BufferedReader(new FileReader(rutaFichero));

			// declarar la lista de equipos
			ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();

			String registro;

			while ((registro = fichero.readLine()) != null) {

				String[] campos = registro.split(separador);
				Equipo equipo = new Equipo(Integer.parseInt(campos[0]), campos[1], campos[2]);
				listaEquipos.add(equipo);

			}
			fichero.close();
			System.out.println("Creada la lista de equipos...");
			return listaEquipos;

		} catch (FileNotFoundException e) {
			System.out.println("NO SE HA ENCONTRADO EL ARCHIVO");
		} catch (IOException e) {
			System.out.println("otra cosa");
		}
		return null;
	}
	
	public ArrayList<String> primerGrupo(ArrayList<Equipo> equiposDeFutbol) {
		
		Random rnd = new Random();
		int aleatorio;
		int control = equiposDeFutbol.size() / 2;

		ArrayList<String> grupoEquipos1 = new ArrayList<>();

		for (int i = 0; i < control; i++) {
			aleatorio = rnd.nextInt(equiposDeFutbol.size() - 1);
			grupoEquipos1.add(equiposDeFutbol.get(aleatorio).getNombreCorto());
			equiposDeFutbol.remove(aleatorio);
		}
		System.out.println("Fin de primer grupo");
		return grupoEquipos1;
	}

	public ArrayList<String> segundoGrupo(ArrayList<Equipo> equiposDeFutbol) {

		ArrayList<String> grupoEquipos2 = new ArrayList<>();

		for (int i = 0; i < equiposDeFutbol.size(); i++) {
			grupoEquipos2.add(equiposDeFutbol.get(i).getNombreCorto());
		}
		System.out.println("Fin de segundo grupo");
		return grupoEquipos2;
	}
	
	public ArrayList<String> copiarLista (ArrayList<String> lista) {

		ArrayList<String> copiaLista = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) 
			copiaLista.add(lista.get(i));
		
		return copiaLista;
	}
	
	public HashMap<Integer, ArrayList<String>> primeraVuelta (ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {
		
		String local;
		String visitante;
		String partido;
		
		HashMap<Integer, ArrayList<String>> jornadasPrimeraVuelta = new HashMap<Integer, ArrayList<String>>();
		
		for (int i = 0; i < primerGrupo.size() + segundoGrupo.size() - 1; i++) {
			
			ArrayList<String> jornada = new ArrayList<String>();
			
			for (int j = 0; j < segundoGrupo.size(); j++) {
				if (j != 0) {
					
					if (j % 2 != 0) {
						local = primerGrupo.get(j);
						visitante = segundoGrupo.get(j);
					} else {
						local = segundoGrupo.get(j);
						visitante = primerGrupo.get(j);
					}
					partido = local + "#" + visitante;
					jornada.add(partido);
				} else {
					
					if (i % 2 == 0) {
						local = primerGrupo.get(j);
						visitante = segundoGrupo.get(j);
					} else  {
						local = segundoGrupo.get(j);
						visitante = primerGrupo.get(j);
					}
					
					partido = local + "#" + visitante;
					jornada.add(partido);
				}
			}
			jornadasPrimeraVuelta.put(i, jornada);
			rodarEquiposDePosicion(primerGrupo, segundoGrupo);
		}
		
		return jornadasPrimeraVuelta;
	}
	
public HashMap<Integer, ArrayList<String>> segundaVuelta (ArrayList<String> primerGrupo, 
														  ArrayList<String> segundoGrupo,
														  HashMap<Integer, ArrayList<String>> jornadasDeLaTemporada) {
		
		String local;
		String visitante;
		String partido;
		
		for (int i = 0; i < primerGrupo.size() + segundoGrupo.size() - 1; i++) {
			
			ArrayList<String> jornada = new ArrayList<String>();
			
			for (int j = 0; j < segundoGrupo.size(); j++) {
				if (j != 0) {
					
					if (j % 2 == 0) {
						local = primerGrupo.get(j);
						visitante = segundoGrupo.get(j);
					} else {
						local = segundoGrupo.get(j);
						visitante = primerGrupo.get(j);
					}
					partido = local + "#" + visitante;
					jornada.add(partido);
				} else {
					
					if (i % 2 != 0) {
						local = primerGrupo.get(j);
						visitante = segundoGrupo.get(j);
					} else  {
						local = segundoGrupo.get(j);
						visitante = primerGrupo.get(j);
					}
					
					partido = local + "#" + visitante;
					jornada.add(partido);
				}
			}
			jornadasDeLaTemporada.put(jornadasDeLaTemporada.size(), jornada);
			rodarEquiposDePosicion(primerGrupo, segundoGrupo);
		}
		
		return jornadasDeLaTemporada;
	}
	
	public void rodarEquiposDePosicion (ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {

		ArrayList<String> aux = new ArrayList<String>();
		
		primerGrupo.add(segundoGrupo.get(segundoGrupo.size() - 1));
		segundoGrupo.remove(segundoGrupo.size() - 1);
		
		aux.add(segundoGrupo.get(0));
		aux.add(primerGrupo.get(0));
		
		segundoGrupo.remove(0);
		segundoGrupo.addAll(0, aux);
		primerGrupo.remove(0);
		
	}
	
	public void escribirTemporada (HashMap<Integer, ArrayList<String>> jornadasDeLaTemporada, String ruta) {

		File escribirPartidos = new File(ruta);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(escribirPartidos, true));
			for (Integer clave : jornadasDeLaTemporada.keySet()) {
				
				bw.write("JORNADA: " + (clave + 1) + "\n");
				
				ArrayList<String> jornada = new ArrayList<String>();
				jornada = jornadasDeLaTemporada.get(clave);

				for (int i = 0; i < jornada.size(); i++) 
					bw.write(jornada.get(i) + "\n");
				
			}
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}